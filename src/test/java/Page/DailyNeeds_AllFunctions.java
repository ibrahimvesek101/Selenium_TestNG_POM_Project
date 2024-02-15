package Page;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class DailyNeeds_AllFunctions extends ItemInterface{

    public DailyNeeds_AllFunctions(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//div[@class='rounded-full bg-yellow-500 px-3 text-xs font-semibold leading-6 text-light ltr:ml-auto rtl:mr-auto']" )
    WebElement discountValue;

    @FindBy(xpath = "(//del)[1]")
    WebElement nonDiscountedPrice;

    @FindBy(xpath = "(//ins)[2]")
    WebElement discountedPrice;

    @FindBy(xpath = "(//h1)[2]")
    WebElement titel;

    @FindBy(xpath = "//div[@class='mt-3 text-sm leading-7 text-body md:mt-4']")
    WebElement descriptionElm;

    @FindBy(xpath = "//button[@class='mb-2 whitespace-nowrap rounded border border-border-200 bg-transparent py-1 px-2.5 text-sm lowercase tracking-wider text-heading transition-colors hover:border-accent hover:text-accent focus:bg-opacity-100 focus:outline-0 ltr:mr-2 rtl:ml-2']")
    WebElement categoriesBtn;

    @FindBy(xpath = "//button[@class='text-sm tracking-wider text-accent underline transition hover:text-accent-hover hover:no-underline']")
    WebElement sellerBtn;

    @FindBy(xpath = "//button[@class='mt-1 inline-block font-bold text-accent ']")
    WebElement readMoreBtn;

    @FindBy(xpath = "//p[@class='text-sm text-body']")
    WebElement details;

    @FindBy(xpath = "//h2[@class='text-lg text-heading tracking-tight font-semibold mb-6']")
    public WebElement relatedTitel;
    public void discount(){
        Assert.assertTrue(discountValue.isDisplayed());
    }

    public void areDisplayed(){
        Assert.assertTrue(discountValue.isDisplayed());
        Assert.assertTrue(nonDiscountedPrice.isDisplayed());
        discount();
    }
    public void checkDiscount(){
        int discountedValueint = Integer.parseInt(discountValue.getText().replace("%",""));
        double non_discounted = Double.parseDouble(nonDiscountedPrice.getText().replace("$", ""));
        double discounted = Double.parseDouble(discountedPrice.getText().replace("$", ""));

        Double result = non_discounted*(1-(discountedValueint/100.0));

        Assert.assertTrue(Math.floor(result*100)/100 == discounted);
       Set<String> windows = Driver.getDriver().getWindowHandles();
        Iterator<String> it = windows.iterator();
        Driver.getDriver().switchTo().window(it.next());


    }

    public void checkDiscount(By locator){
        int discountedValueint = Integer.parseInt(discountValue.getText().replace("%",""));
        double non_discounted = Double.parseDouble(nonDiscountedPrice.getText().replace("$", ""));
        double discounted = Double.parseDouble(Driver.getDriver().findElement(locator).getText().replace("$", ""));

        double result = non_discounted*(1-(discountedValueint/100.0));


        Assert.assertTrue((int) result== (int)discounted);
        Set<String> windows = Driver.getDriver().getWindowHandles();
        Iterator<String> it = windows.iterator();
        Driver.getDriver().switchTo().window(it.next());


    }

    public void displayDesTitle(){
        Assert.assertTrue(titel.isDisplayed());
        Assert.assertTrue(descriptionElm.isDisplayed());
    }

    private String titelH1;
    public void goToPage() throws InterruptedException {
        String urlold = Driver.getDriver().getCurrentUrl();
        titelH1 = titel.getText();
        titel.click();
        Thread.sleep(1000);
        Assert.assertNotEquals(urlold,Driver.getDriver().getCurrentUrl());
        //Açılan sayfada ürünün başlık ve fiyatının önceki sayfadaki ile aynı olduğunu doğrulayabilmeli
        Assert.assertEquals(Driver.getDriver().findElement(By.tagName("h1")).getText(),titelH1);

    }

    public void readMore() throws InterruptedException {
        readMoreBtn.click();
        Thread.sleep(2000);
        Assert.assertTrue(details.isDisplayed());;
    }
    public void displayedSeller_Cat(){
        Assert.assertTrue(sellerBtn.isDisplayed());
        Assert.assertTrue(categoriesBtn.isDisplayed());
    }
    public void setRelatedTitel(){
       Assert.assertTrue(relatedTitel.isDisplayed());
    }

}
