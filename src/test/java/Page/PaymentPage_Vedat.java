package Page;

import Utilities.Driver;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PaymentPage_Vedat extends HomePageBase_Vedat {

    FurnitureCartPage_Vedat furniturePage = new FurnitureCartPage_Vedat();

    public PaymentPage_Vedat() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='owner_name']")
    public WebElement name;
    @FindBy(xpath = "//input[@name='cardnumber']")
    public WebElement cardNo;
    @FindBy(xpath = "//input[@name='exp-date']")
    public WebElement date;
    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement cvc;
    @FindBy(xpath = "//input[@name='save_card']")
    public WebElement saveCard;
    @FindBy(xpath = "//button[.='Pay']")
    public WebElement payButton;
    @FindBy(xpath = "//iframe[contains(@title, 'card number')]")
    public WebElement cardIframe;
    @FindBy(xpath = "//iframe[contains(@title, 'date')]")
    public WebElement dateIframe;
    @FindBy(xpath = "//iframe[contains(@title, 'CVC')]")
    public WebElement cvcIframe;
    @FindBy(xpath = "//span[contains(.,'Payment')]")
    public List<WebElement> paymentStatus;
    @FindBy(xpath = "//h2[contains(.,'Order Details')]")
    public WebElement orderNumber;


    public void verifyOrdersMatching(){

        Assert.assertTrue(orderNumber.isDisplayed());
    }


    public void printStatus() {
        ReusableMethods.waitFor(4);
        String status ="";
        for (WebElement payment : ReusableMethods.waitForVisibilityList(paymentStatus,5)) {
            status =payment.getText()+" ";
        }

        System.out.println(status);
        Assert.assertEquals("Payment Success",status);
    }

    public void enterName(String isim) {
        ReusableMethods.waitForLoad(20);
//        ReusableMethods.sendData(name,isim);
        name.sendKeys(isim);

    }

    public void enterCardNo(String creditNo) {
        ReusableMethods.waitForLoad(20);
        Driver.getDriver().switchTo().frame(cardIframe);
        ReusableMethods.waitFor(2);
        cardNo.sendKeys(creditNo);
        //ReusableMethods.sendData(cardNo,creditNo);
        Driver.getDriver().switchTo().defaultContent();
    }

    public void enterExpDate(String expDate) {
        ReusableMethods.waitForLoad(20);
        Driver.getDriver().switchTo().frame(dateIframe);
        ReusableMethods.waitFor(2);
        date.sendKeys(expDate);
        // ReusableMethods.sendData(date,expDate);
        Driver.getDriver().switchTo().defaultContent();
    }

    public void enterCvc(String cvcNumber) {
        ReusableMethods.waitForLoad(20);
        Driver.getDriver().switchTo().frame(cvcIframe);
        ReusableMethods.waitFor(2);
        cvc.sendKeys(cvcNumber);
        //      ReusableMethods.sendData(cvc,cvcNumber);
        Driver.getDriver().switchTo().defaultContent();
    }

    public void isSelected() {
        saveCard.sendKeys(Keys.SPACE);
        Assert.assertTrue(saveCard.isSelected());
    }

    public void verifyPayment() {

        Assert.assertTrue(ReusableMethods.waitForVisibility(furniturePage.verifySuccess, 5).isDisplayed());

    }


}
