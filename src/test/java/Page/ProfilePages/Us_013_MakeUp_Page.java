package Page.ProfilePages;

import Utilities.ConfigurationReader;
import Utilities.Driver;

import Utilities.ReusableMethods;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Us_013_MakeUp_Page {
    public Us_013_MakeUp_Page() {PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//button[@type='button'][1]")
    WebElement button;
    @FindBy(xpath = "//span[.='Makeup']")
    WebElement makeUpLocator;

    @FindBy(xpath="//span[.='Bath & Oil']")
    WebElement BahtOilLocator;
    @FindBy(xpath = "(//span[.='Cart'])[1]")
    WebElement productCartLocator;
    @FindBy(xpath = "(//span[.='1 Item'])[1]")
    WebElement cartButtonLocator;
    @FindBy(xpath = "//span[.='Checkout']")
    WebElement checkoutButtonLocator;

    @FindBy(xpath = "(//button)[3]")
    WebElement loginButtonLocator;
    @FindBy(xpath = "(//span[.='1'])[2]")
    WebElement pieceOfProduct;
    @FindBy(xpath = "(//span[.='$16.00'])[2]")
    WebElement priceOfProduct;
    @FindBy(xpath = "//input[@value=\"+1 (936) 514-1641\"]")
    WebElement contactNumberOldlocator;
    @FindBy(xpath = "//input[@value=\"+1 (936) 514-1641\"]")
    WebElement contactNumberNewlocator;
    @FindBy(xpath = "//button[.='Update']")
    WebElement contactNumberUpdateButtonLocator;
    @FindBy(xpath = "(//button)[29]")
    WebElement updateContactBoxLocator;
    @FindBy(xpath = "(//input)[2]")
    WebElement sentNewTelefonNumberLocator;
    @FindBy(xpath = "(//p[@class=\"text-sm text-sub-heading\"])[2]")
    WebElement billingAdresstwoLocator;
    @FindBy(xpath = "(//p[@class=\"text-sm text-sub-heading\"])[6]")
    WebElement shippingAdresstwoLocator;
    @FindBy(xpath = "//span[.='Express Delivery']")
    WebElement expressDeliveryLocator;
    @FindBy(xpath = "//span[.='Morning']")
    WebElement morningButtonLocator;
    @FindBy(xpath = "//a[.='Offers']")
    WebElement discountTicketLocator;
    @FindBy(xpath = "(//span[.='Copy'])[1]")
    WebElement findCouponLocator;
    @FindBy(xpath = "//button[.='Check Availability']")
    WebElement checkAvaliableButtonLocator;
    @FindBy(xpath = "//p[.='Do you have coupon?']")
    WebElement doYouhaveCouponButtonLocator;
    @FindBy(id = "code")
    WebElement sentCouponCopiedText;
    @FindBy(xpath = "//span[@class=\"text-base font-semibold text-heading\"]")
    WebElement oldPriceTextLocator;
    @FindBy(xpath = "//span[@class=\"text-base font-semibold text-heading\"]")
    WebElement newPriceTextLocator;

    @FindBy(xpath = "//button[.='Apply']")
    WebElement applyButtonLocator;

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButtonLocator;

    @FindBy(xpath = "//span[.='Order At Local Facility']")
    WebElement ordertextLocator;

    @FindBy(xpath = "//a[@href=\"/products/attitude-bubble-bath\"]")
    WebElement productNameLocator;

    @FindBy(xpath = "(//td[@class=\"rc-table-cell\"])[2]")
    WebElement priceValueLocator;


    public void getDriver(){
        Driver.getDriver().get(ConfigurationReader.getProperty("alternative_Url"));
    }
    public void clickButton() {
        ReusableMethods.waitFor(1);
        button.click();
        ReusableMethods.waitFor(1);
        makeUpLocator.click();

    }
    public void bathOilClick(){
        ReusableMethods.waitFor(2);
        BahtOilLocator.click();
    }
    public void searchProductAndAddChart()  {
        ReusableMethods.waitFor(3);
        productCartLocator.click();

    }
    public void cartButtonClick() {
        ReusableMethods.waitFor(2);
        cartButtonLocator.click();
    }
    public void checkoutButtonClick() {
        ReusableMethods.waitFor(2);
        checkoutButtonLocator.click();
    }
    public void loginButtonClick(){
        ReusableMethods.waitFor(2);
        loginButtonLocator.click();
        ReusableMethods.waitFor(2);
    }
    public void verfyPieceAndPrice(){
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pieceOfProduct.isDisplayed(),"Piece of Product is not dispayed");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(priceOfProduct.isDisplayed(),"Price of Product is not dispayed");
    }
    public void contactNummerUpdate(){

        String oldNumber = contactNumberOldlocator.getText();
        contactNumberUpdateButtonLocator.click();
        ReusableMethods.waitFor(2);
        sentNewTelefonNumberLocator.click();
        sentNewTelefonNumberLocator.sendKeys("12233445566");
        ReusableMethods.waitFor(1);
        updateContactBoxLocator.click();
        String newNumber = contactNumberNewlocator.getText();
        Assert.assertTrue(!oldNumber.equals(newNumber));

    }
    public void BillingAdressUpdate(){

        ReusableMethods.waitFor(2);
        billingAdresstwoLocator.click();
        System.out.println(billingAdresstwoLocator.getText());
        Assert.assertTrue(billingAdresstwoLocator.getText().contains("Gine"));

    }
    public void shippingAdressUpdate(){

        ReusableMethods.waitFor(2);
        shippingAdresstwoLocator.click();
        System.out.println(shippingAdresstwoLocator.getText());
        Assert.assertTrue(shippingAdresstwoLocator.getText().contains("Gine"));

    }
    public void deliveryUpdate(){

        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("window.scrollBy(0, 800);");

        String text1 = expressDeliveryLocator.getText();

        ReusableMethods.waitFor(4);
        morningButtonLocator.click();
        String text2 = morningButtonLocator.getText();
        Assert.assertTrue(!text1.equals(text2));

    }
    public void verfyDiscountTicket(){

        ReusableMethods.waitFor(4);
        discountTicketLocator.click();
        ReusableMethods.waitFor(4);
        findCouponLocator.click();
        ReusableMethods.waitFor(4);
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(4);
        checkAvaliableButtonLocator.click();
        ReusableMethods.waitFor(3);
        String oldprice= oldPriceTextLocator.getText();

        ReusableMethods.waitFor(3);
        doYouhaveCouponButtonLocator.click();
        ReusableMethods.waitFor(3);
        sentCouponCopiedText.sendKeys("EID2");
        ReusableMethods.waitFor(3);
        applyButtonLocator.click();
        String newprice= newPriceTextLocator.getText();

        ReusableMethods.waitFor(3);
        Assert.assertTrue(oldprice.equals(newprice));
        ReusableMethods.waitFor(3);
        placeOrderButtonLocator.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(ordertextLocator.getText().toLowerCase().contains("order"));
        System.out.println(ordertextLocator);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(productNameLocator.getText().contains("Bubble"),"Product name is not displayed");
        System.out.println(productNameLocator.getText());
        ReusableMethods.waitFor(2);
        Assert.assertTrue(priceValueLocator.getText().contains("$"),"Product price is not displayed");
        System.out.println(priceValueLocator.getText());

    }

}
