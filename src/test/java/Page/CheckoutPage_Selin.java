package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CheckoutPage_Selin {
    public CheckoutPage_Selin() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button[text()='Add'])[1]")
    public WebElement addContactNumberButton;
    @FindBy(xpath = "(//input[@type='tel'])[2]")
    public WebElement addContactNumberField;
    @FindBy(xpath = "(//button[@data-variant='normal'])[2]")
    public WebElement addContactButton;
    @FindBy(xpath = "(//button[text()='Add'])[2]")
    public WebElement addBillingAddressButton;
    @FindBy(xpath = "(//button[text()='Add'])[2]")
    public WebElement addShippingAddressButton;
    @FindBy(xpath = "//label[@for='billing']")
    public WebElement blinkRadioButton;
    @FindBy(xpath = "//input[@id='title']")
    public WebElement titleInput;
    @FindBy(xpath = "//input[@id='address.country']")
    public WebElement countryInput;
    @FindBy(xpath = "//input[@id='address.city']")
    public WebElement cityInput;
    @FindBy(xpath = "//input[@id='address.state']")
    public WebElement stateInput;
    @FindBy(xpath = "//input[@id='address.zip']")
    public WebElement zipInput;
    @FindBy(xpath = "//textarea[@id='address.street_address']")
    public WebElement streetInput;
    @FindBy(xpath = "(//button[@data-variant='normal'])[2]")
    public WebElement updateAdressButton;
    @FindBy(xpath = "//div//span[text()='Morning']")
    public WebElement deliveryScheduleMorning;
    @FindBy(xpath = "//button[text()='Check Availability']")
    public WebElement checkAvailabilityButton;
    @FindBy(xpath = "//p[text()='Do you have coupon?']")
    public WebElement doYouHaveCoupon;
    @FindBy(xpath = "//input[@id='code']")
    public WebElement couponField;
    @FindBy(xpath = "//button[text()='Apply']")
    public WebElement applyButton;
    @FindBy(xpath = "//span[text()='Cash On Delivery']")
    public WebElement cashOnDeliveryButton;

    public void verifyCheckout() {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div//span[text()='Your Order']")).isDisplayed());
    }

    public void verifyOrders() {
        String firstProduct = Driver.getDriver().findElement(By.xpath("//h3[text()='Armani Purse']")).getText();
        String secondProduct = Driver.getDriver().findElement(By.xpath("//h3[text()='Givenchy Mini Purse']")).getText();
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goCheckout();
        String orders1=Driver.getDriver().findElement(By.xpath("//span[text()='Armani Purse']")).getText();
        String orders2=Driver.getDriver().findElement(By.xpath("//span[text()='Givenchy Mini Purse']")).getText();
        Assert.assertTrue(orders1.contains(firstProduct));
        Assert.assertTrue(orders2.contains(secondProduct));
    }
    public void updateContactNumber() throws InterruptedException {
        Thread.sleep(500);
        addContactNumberButton.click();
        Thread.sleep(500);
        Faker faker = new Faker();
        ReusableMethods.sendData(addContactNumberField, String.valueOf(faker.phoneNumber()));
        Thread.sleep(500);
        addContactButton.click();
    }
    public void verifyContactNumberUpdated() {
        Assert.assertTrue(Driver.getDriver().findElement
                        (By.xpath("(//div[@class='bg-light p-5 shadow-700 md:p-8'])[1]"))
                .getText().contains("Update"));
        //  System.out.println(Driver.getDriver().findElement(By.xpath("(//div[@class='bg-light p-5 shadow-700 md:p-8'])[1]")).getText());
    }

    public void updateBillingAddress() throws InterruptedException {
        Thread.sleep(500);
        addBillingAddressButton.click();
        blinkRadioButton.click();
        titleInput.sendKeys("home");
        Faker faker = new Faker();
        countryInput.sendKeys(faker.address().country());
        cityInput.sendKeys(faker.address().city());
        stateInput.sendKeys(faker.address().state());
        zipInput.sendKeys(faker.address().zipCode());
        streetInput.sendKeys(faker.address().streetAddress());
        updateAdressButton.click();
    }

    public void verifyBillingAddressUpdated() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@role='alert'][@class='Toastify__toast-body']")).getText().contains("Profile Updated"));
        System.out.println(Driver.getDriver().findElement(By.xpath("//div[@class='Toastify']")).getText());
    }

    public void updateShippingAddress() throws InterruptedException {
        addShippingAddressButton.click();
        Thread.sleep(500);
        titleInput.sendKeys("home");
        Faker faker = new Faker();
        countryInput.sendKeys(faker.address().country());
        cityInput.sendKeys(faker.address().city());
        stateInput.sendKeys(faker.address().state());
        zipInput.sendKeys(faker.address().zipCode());
        streetInput.sendKeys(faker.address().streetAddress());
        updateAdressButton.click();
    }

    public void verifyShippingAddressUpdated() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@role='alert'][@class='Toastify__toast-body']")).getText().contains("Profile Updated"));
        System.out.println(Driver.getDriver().findElement(By.xpath("//div[@class='Toastify']")).getText());
    }
    public void selectDeliverySchedule() {
        deliveryScheduleMorning.click();
    }
    public void verifyDeliveryScheduleUpdated() throws InterruptedException {
        Thread.sleep(1000);
        String expressDelivery=Driver.getDriver().findElement(By.xpath("//div//span[text()='Express Delivery']")).getText();
        String morning=Driver.getDriver().findElement(By.xpath("//div[@role='alert'][@class='Toastify__toast-body']")).getText();
        Assert.assertNotEquals(morning,expressDelivery,"delivery schedule not update");
    }
    public void verifySubTotal() throws InterruptedException {
        Thread.sleep(1000);
        String armani=Driver.getDriver().findElement(By.xpath("//div//span[text()='$72.00']")).getText().substring(1);
        String givency=Driver.getDriver().findElement(By.xpath("//div//span[text()='$70.00']")).getText().substring(1);
        String subTotal=Driver.getDriver().findElement(By.xpath("//div//span[text()='$142.00']")).getText().substring(1);
        Assert.assertEquals(Double.parseDouble(subTotal),Double.parseDouble(armani)+Double.parseDouble(givency),"not sub total");
    }
    public void verifyCouponApplied(){
        String totalAmount= Driver.getDriver().findElement(By.xpath("//div//span[text()='$123.44']")).getText().substring(1);
        String couponAmount= Driver.getDriver().findElement(By.xpath("//div//span[text()='$2.00']")).getText().substring(3); //-$ silindi
        String discountedAmount= Driver.getDriver().findElement(By.xpath("//div//span[text()='$121.44']")).getText().substring(1);
        double coupon= Double.parseDouble(couponAmount);
        double total= Double.parseDouble(totalAmount);
        double discounted= Double.parseDouble(discountedAmount);
        Assert.assertEquals((total-coupon),discounted);
    }
    public void checkAvailability() {
        checkAvailabilityButton.click();
    }
    public void doYouHaveACoupon() {
        doYouHaveCoupon.click();
        Actions actions= new Actions(Driver.getDriver());
        actions.click(couponField).perform();
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        applyButton.click();
    }
    public void cashOnDelivery() {
        cashOnDeliveryButton.click();
    }
    public void verifyCashOnDeliverySelected() {
        String afterSelectedCashDelivery=Driver.getDriver().findElement(By.xpath("//div//span[text()='Please Pay After You Receive Your Goods!']")).getText();
        Assert.assertTrue(afterSelectedCashDelivery.contains("You Receive Your Goods!"));
    }
    public void placeOrder() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(2000);
    }


}
