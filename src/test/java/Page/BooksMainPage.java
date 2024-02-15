package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BooksMainPage {

    public BooksMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='relative mb-6 flex h-44 w-44 items-center justify-center overflow-hidden rounded-full border-4 border-white bg-gray-100 shadow-350']")
    List<WebElement> autors;



    @FindBy(xpath = "(//div[@class='author-slider-next w-8 h-8 flex items-center justify-center text-heading bg-light shadow-300 outline-none rounded-full absolute top-1/2 -mt-4 z-[5] cursor-pointer ltr:-right-3 rtl:-left-3 ltr:lg:-right-4 rtl:lg:-left-4 focus:outline-none transition-colors hover:text-orange-500'])[1]")
    WebElement nextautorBtn;

    @FindBy(xpath = "//a[@href='/authors']")
    WebElement seeMoreAuthors;

    @FindBy(id = "search")
    WebElement searchTab;

    @FindBy(xpath = "//span[@class='block text-center font-semibold text-heading transition-colors group-hover:text-orange-500']")
    WebElement divSearchItem;

    private String keysearch;

    public void autorsCheck(){
        int count = 0;
        for (WebElement each: autors){
            if (each.isDisplayed()) count++;
        }
        if (count != 8) Assert.fail("Amount of autor is wrong!");
    }

    public void clickNext(){
        nextautorBtn.click();


    }

    public void clickSeeMore(){
        String url = Driver.getDriver().getCurrentUrl();
        seeMoreAuthors.click();
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),url);
    }

    public void setSearchTab(String key ){
        keysearch = key;
        searchTab.sendKeys(key);
        searchTab.submit();

    }

    public void  checkAuthor() throws InterruptedException {
        Thread.sleep(1500);
        Assert.assertTrue(divSearchItem.getText().contains(keysearch));
    }
}
