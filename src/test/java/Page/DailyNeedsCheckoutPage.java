package Page;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DailyNeedsCheckoutPage {

    public DailyNeedsCheckoutPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='mb-5 flex items-center justify-between md:mb-8']//button[@class='flex items-center text-sm font-semibold text-accent transition-colors duration-200 hover:text-accent-hover focus:text-accent-hover focus:outline-0']")
    public List<WebElement> addButton;

    @FindBy(xpath = "//div[@class=' react-tel-input '] //input[@type='tel']")
    public List<WebElement> addContactNumber;

   @FindBy(xpath = "//button[.='Add Contact']")
   public WebElement addContactSubmit;

   @FindBy(xpath = "//button[text()='Check Availability']")
   public WebElement checkAvailabilityButton;

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//span[.='Checkout']")
    public WebElement checkOut;


    public void checkAvailabilityButtonClick(){
        checkAvailabilityButton.click();
    }

    public void cashOnDeliveryClick(){
        WebElement cashOnDelivery=Driver.getDriver().findElement(By.xpath("(//*[.='Cash On Delivery'])[4]"));
        cashOnDelivery.click();
    }

    public void placeOrderButtonClick(){
        placeOrderButton.click();
    }

    public void clickcheckOut(){
        checkOut.click();
    }

    public void ClickAddButton(){
        addButton.get(0).click();
    }

    public void addContactNumber(){
        addContactNumber.get(1).sendKeys("5324567890");

    }

    public void addContactSubmit(){

        addContactSubmit.click();
    }
}
