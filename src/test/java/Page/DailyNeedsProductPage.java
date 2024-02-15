package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DailyNeedsProductPage {

    public DailyNeedsProductPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@class='relative flex h-48 w-auto cursor-pointer items-center justify-center sm:h-64']")
    public WebElement firstProductOfAllium;

    @FindBy(xpath = "//div[@class='mb-3 w-full lg:mb-0 lg:max-w-[400px]']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[.='Add'][1]")
    public WebElement add;
    @FindBy(xpath = "//span[text()='minus']")
    public WebElement minus;
    @FindBy(xpath = "//button[@class='flex h-7 w-7 shrink-0 items-center justify-center rounded-full text-muted transition-all duration-200 hover:bg-gray-100 hover:text-red-600 focus:bg-gray-100 focus:text-red-600 focus:outline-0 ltr:ml-3 ltr:-mr-2 rtl:mr-3 rtl:-ml-2']")
    public WebElement closeButton;

    @FindBy(xpath = "//div[.='1'][@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold']")
    public  WebElement productInTheCart;

    @FindBy(xpath = "//span[text()='0 Item']")
    public WebElement numberOfItems;
   @FindBy(xpath = "//p[@class='my-2.5 font-semibold text-accent']")
   public WebElement priceOfProduct ;

    public void clickFirstProductofAllium(){
        firstProductOfAllium.click();
        ReusableMethods.waitFor(3);
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
        ReusableMethods.waitFor(3);
    }
    public void clickAddButton(){
        add.click();
        ReusableMethods.waitFor(3);
    }

    public void removeTheProductFromCart(){
        closeButton.click();
        ReusableMethods.waitFor(3);
    }

 //   public void clickToMinus(){
    //    minus.click();
   //     ReusableMethods.waitFor(3);
   // }

}
