package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CheckOutPage_Vedat extends HomePageBase_Vedat {
    public CheckOutPage_Vedat() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    FurnitureCartPage_Vedat furnitureCartPage = new FurnitureCartPage_Vedat();

    @FindBy(xpath = "(//button[.='Add'])[1]")
    public WebElement numberAdd;
    @FindBy(xpath = "(//input[@type='tel'])[2]")
    public WebElement sendNumber;
    @FindBy(xpath = "//button[contains(.,'Add Contact')]")
    public WebElement addContactButton;
    @FindBy(xpath = "(//button[.='Add'])[2]")
    public WebElement addressAdd;

    @FindBy(xpath = "//button[.='Check Availability']")
    public WebElement checkAvailableButton;

    @FindBy(xpath = "//p[contains(.,'coupon')]")
    public WebElement couponLink;
    @FindBy(xpath = "//input[@id='code']")
    public WebElement txtCouponArea;
    @FindBy(xpath = "//p[contains(.,'Discount')]")
    public WebElement verifyDiscount;
    @FindBy(xpath = "//input[@id='title']")
    public WebElement txtTitle;
    @FindBy(xpath = "//input[@id='address.country']")
    public WebElement txtCountry;
    @FindBy(xpath = "//input[@id='address.city']")
    public WebElement txtCity;
    @FindBy(xpath = "//input[@id='address.state']")
    public WebElement txtState;
    @FindBy(xpath = "//input[@id='address.zip']")
    public WebElement txtZip;
    @FindBy(xpath = "//textarea[@id='address.street_address']")
    public WebElement txtStreetAddress;
    @FindBy(xpath = "//button[contains(.,'Update Address')]")
    public WebElement updateAddressButton;
    @FindBy(xpath = "//label[@for='billing']")
    public WebElement billingRadio;
    @FindBy(xpath = "//label[@for='shipping']")
    public WebElement shipping;

    @FindBy(xpath = "(//div[@role='none'])[2]/div")
    public List<WebElement> deliverySchedules;
    @FindBy(tagName = "textarea")
    public WebElement txtOrderNote;

    @FindBy(xpath = "//p[.='Total']/..")
    public WebElement totalPrice;

    @FindBy(xpath = "//p[.='Sub Total']/following-sibling::span")
    public WebElement price;
    @FindBy(xpath = "//p[.='Tax']/following-sibling::span")
    public WebElement taxPrice;
    @FindBy(xpath = "(//p[contains(.,'Shipping')])[2]/following-sibling::span")
    public WebElement shippingPrice;

    @FindBy(xpath = "//input[@id='use_wallet']")
    public WebElement useWallet;
    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrderButton;


    public void checkWallet(){
       try {
           useWallet.sendKeys(Keys.SPACE);
       }catch (ElementNotInteractableException e){
         System.err.println(e.getMessage());
       }
    }
    public void isPriceCorrect(){
        ReusableMethods.waitFor(4);
       int total =ReusableMethods.formatNumber(ReusableMethods.waitForVisibility(totalPrice,3).getText());
        System.out.println(total);
        int productPrice = ReusableMethods.formatNumber(ReusableMethods.waitForVisibility(price,3).getText());
        System.out.println(productPrice);
        int priceTax = ReusableMethods.formatNumber(ReusableMethods.waitForVisibility(taxPrice,3).getText());
        System.out.println(priceTax);
        int shipmentPrice = ReusableMethods.formatNumber(ReusableMethods.waitForVisibility(shippingPrice,3).getText());
        System.out.println(shipmentPrice);

        Assert.assertEquals(productPrice + shipmentPrice + priceTax, total);

    }


    public void enterOrderNote(String note){
        ReusableMethods.sendData(txtOrderNote,note);
    }

    public void selectDeliverySchedule(String schedule) {
        for (WebElement deliverySchedule : deliverySchedules) {
            if (deliverySchedule.getText().contains(schedule)) {
                deliverySchedule.click();
                break;
            }
        }
    }


    public void verifyUpdated() {
        Assert.assertTrue(ReusableMethods.waitForVisibility(furnitureCartPage.verifySuccess, 5).isDisplayed());
        ReusableMethods.waitFor(2);
    }

    public void selectType() {
        ReusableMethods.waitForVisibility(shipping,5);
        ReusableMethods.clickButtonWithJSE(shipping, Driver.getDriver());

    }

    public void enterData(String title, String country, String state, String zip, String City, String streetAddress) {
        ReusableMethods.waitForVisibility(txtTitle, 3);
        ReusableMethods.sendData(txtTitle, title);
        ReusableMethods.sendData(txtCountry, country);
        ReusableMethods.sendData(txtState, state);
        ReusableMethods.sendData(txtZip, zip);
        ReusableMethods.sendData(txtCity, City);
        ReusableMethods.sendData(txtStreetAddress, streetAddress);
        updateAddressButton.click();

    }

    public void enterNumber(String number) {
        ReusableMethods.waitFor(1);
        ReusableMethods.waitToBeClickable(sendNumber, 4);
        sendNumber.clear();
        sendNumber.sendKeys(number);
    }

    public void pasteCouponCode() {
        ReusableMethods.pasteText(txtCouponArea);
    }

    public void verifyDiscountApplied() {
        Assert.assertTrue(ReusableMethods.waitForVisibility(verifyDiscount, 3).isDisplayed());
    }

    public void click() {
        updateAddressButton.click();
        Assert.assertTrue(ReusableMethods.waitForVisibility(furnitureCartPage.verifySuccess, 3).isDisplayed());
    }


}
