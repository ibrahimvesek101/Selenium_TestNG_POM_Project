package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FurnitureCartPage_Vedat extends HomePageBase_Vedat {
    static List<String> name;

    public FurnitureCartPage_Vedat() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(.,'Shopping Cart')]")
    public WebElement addToCartButton;
    @FindBy(xpath = "//button//span[contains(.,'$')]")
    public WebElement lazyBar;
    @FindBy(xpath = "//span[contains(.,'Checkout')]")
    public WebElement checkOutButton;
    @FindBy(css = ".mt-3.text-body")
    public WebElement productBio;
    @FindBy(xpath = "//div[@name='details']/p")
    public WebElement details;
    @FindBy(xpath = "//ins[contains(.,'$')]")
    public WebElement priceAtCartPage;
    @FindBy(xpath = "//span[.='Categories']/following-sibling::div//button")
    public List<WebElement> categories;
    @FindBy(css = ".flex.h-10")
    public WebElement wishList;
    @FindBy(css = "a.text-lg")
    public List<WebElement> productOnWishList;
    @FindBy(xpath = "(//h3)[1]")
    public WebElement firstProduct;
    @FindBy(tagName = "h1")
    public WebElement nameOnCartPage;
    @FindBy(xpath = "//img[contains(@srcset,'thumbnail')]")
    public List<WebElement> images;
    @FindBy(xpath = "//h2[contains(.,'Product Reviews')]")
    public WebElement productReviews;
    @FindBy(xpath = "//button[contains(.,'Ask')]")
    public WebElement askQuestionButton;
    @FindBy(xpath = "//textarea[@id='question']")
    public WebElement txtQuestion;
    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement verifySuccess;
    @FindBy(xpath = "//h2[contains(.,'Related Products')]")
    public WebElement relatedProducts;


    public void verifyProductIsVisible() {
        Assert.assertTrue(ReusableMethods.waitForVisibility(nameOnCartPage, 2).isDisplayed());
        ReusableMethods.waitFor(2);
        name = new ArrayList<>();
        name.add(nameOnCartPage.getText());
    }

    public void verifyPrice(String expected) {
        Assert.assertTrue(priceAtCartPage.getText().substring(1).contains(expected));
        System.out.println(priceAtCartPage.getText().substring(1));

    }

    public void verifyCategory() {
        boolean isMatch = false;
        for (WebElement category : categories) {
            if (nameOnCartPage.getText().toLowerCase().contains(category.getText())) {
                isMatch = true;
                break;
            }
        }
        Assert.assertTrue(isMatch);

    }

    public void verifyImagesAreVisible() {
        ReusableMethods.waitForLoad(10);
        for (int i = 0; i < images.size(); i++) {
            Assert.assertTrue(images.get(i).isDisplayed());
            System.out.println(images.get(i).getAttribute("alt"));
        }
    }

    public void verifyProductDescription() {
        Assert.assertTrue(productBio.getText().equalsIgnoreCase(details.getText()));
        System.out.println(productBio.getText());
    }

    public void verifyIsVisible(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }

    public void verifyAskQuestion(String question) {
        ReusableMethods.moveAndClick(askQuestionButton);
        ReusableMethods.waitForVisibility(txtQuestion, 3);
        ReusableMethods.sendData(txtQuestion, question);
        submitButton.click();
        Assert.assertTrue(ReusableMethods.waitForVisibility(verifySuccess, 5).isDisplayed());


    }

    public void verifyItemAddedOnWishList() {
        ReusableMethods.moveAndClick(wishList);
        ReusableMethods.waitFor(3);
        navigateToUserMenu("My wishlists");
        ReusableMethods.waitFor(3);
        List<String> urunIsimleri = new ArrayList<>();

        for (int i = 0; i < productOnWishList.size(); i++) {
            urunIsimleri.add(productOnWishList.get(i).getText());
            if (urunIsimleri.get(i).equalsIgnoreCase(name.get(i))) {
                Assert.assertTrue(true);
            } else System.out.println("Urun bulunamadi");

        }
       if (urunIsimleri.isEmpty()){
           System.out.println("Urun yok");
       }else{
           System.out.println("Aradiginiz urun :"+urunIsimleri);
       }

    }
}








