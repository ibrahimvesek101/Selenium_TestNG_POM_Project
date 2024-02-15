package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Us_001_HomePage_Become_Seller {
    static Faker faker = new Faker();
    public Us_001_HomePage_Become_Seller(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public void getBrowser() {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
    }
    @FindBy(xpath = "//a[text()='Become a Seller']")
    WebElement becomeSellerButton;
    @FindBy(id ="name")
    WebElement nameSent;
    @FindBy(id ="email")
    WebElement emailSent;
    @FindBy(id ="password")
    WebElement passwordSent;

    @FindBy(xpath ="//button[@data-variant=\"normal\"]")
    WebElement registerButton;
    @FindBy(xpath="(//img)[2]")
    WebElement verfyLogInLocator;
    @FindBy( xpath= "//a[.='Create Shop']")
    WebElement createShopButtonLocator;
    @FindBy( id= "name")
    WebElement basicInfoNameLocator;
    @FindBy( id= "description")
    WebElement basicInfoDescriptionLocator;
    @FindBy( id= "balance.payment_info.name")
    WebElement paymentInfoAccountHolderNameLocator;
    @FindBy( id= "balance.payment_info.email")
    WebElement paymentInfoAccountHolderEmailLocator;
    @FindBy( id= "balance.payment_info.bank")
    WebElement paymentInfoBankNameLocator;
    @FindBy( id= "balance.payment_info.account")
    WebElement paymentInfoAccountNumberLocator;
    @FindBy( id= "address.country")
    WebElement shopAdressCountryLocator;
    @FindBy( id= "address.city")
    WebElement shopAdressCityLocator;
    @FindBy( id= "address.state")
    WebElement shopAdressStateLocator;
    @FindBy( id= "address.zip")
    WebElement shopAdressZipLocator;
    @FindBy( id= "address.street_address")
    WebElement shopAdressStreetAdressLocator;
    @FindBy( xpath= "(//input)[13]")
    WebElement setLocationFromMapLocator;
    @FindBy( xpath= "(//input)[14]")
    WebElement contactNumberLocator;

    @FindBy( xpath= "(//button[@type=\"button\"])[3]")
    WebElement addNewSocialProfileLocator;
    @FindBy( xpath="//button[.='Save']")
    WebElement saveButton;

    @FindBy( xpath="(//span)[3]")
    WebElement verifyNewShopCreated;
    public void verifyNewShop(){
        Assert.assertTrue(verifyNewShopCreated.isDisplayed(),"NewShop is not created");
    }
    public void createNewShop(){

        String basicInfoName = faker.company().name();
        String email = faker.internet().emailAddress();
        String accountNumber = faker.business().creditCardNumber();
        String country = faker.address().country();
        String city = faker.address().city();
        String state = faker.address().state();
        String zip = faker.address().zipCode();
        String address = faker.address().streetAddress();
        String location = faker.address().city();
        String contactNumber = faker.phoneNumber().cellPhone();


        basicInfoNameLocator.sendKeys(basicInfoName);
        basicInfoDescriptionLocator.sendKeys("New Campany");
        paymentInfoAccountHolderNameLocator.sendKeys("Jean Paul Belmondo");
        paymentInfoAccountHolderEmailLocator.sendKeys(email);
        paymentInfoBankNameLocator.sendKeys("ING");
        paymentInfoAccountNumberLocator.sendKeys(accountNumber);
        shopAdressCountryLocator.sendKeys(country);
        shopAdressCityLocator.sendKeys(city);
        shopAdressStateLocator.sendKeys(state);
        shopAdressZipLocator.sendKeys(zip);
        shopAdressStreetAdressLocator.sendKeys(address);
        setLocationFromMapLocator.sendKeys(location);
        contactNumberLocator.sendKeys(contactNumber);

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addNewSocialProfileLocator.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        saveButton.click();

    }

    public void createShopButtonClick(){


        ReusableMethods.waitFor(4);


        createShopButtonLocator.click();

    }
    public void verfyLogIn(){
        ReusableMethods.waitFor(3);
        Assert.assertTrue(verfyLogInLocator.isDisplayed(),"Log in is not displayed");
    }
    public void sentInformation(){

        ReusableMethods.waitFor(5);
        String name1 = faker.name().name();
        String email1 = faker.internet().emailAddress();
        String password1 = faker.internet().password();
        nameSent.sendKeys(name1);
        ReusableMethods.waitToBeClickable(emailSent,10);
        emailSent.sendKeys(email1);
        ReusableMethods.waitToBeClickable(passwordSent,10);
        passwordSent.sendKeys(password1);
        ReusableMethods.waitToBeClickable(registerButton,10);
        registerButton.click();

    }

    public void  becomeSellerButtonClick(){
        becomeSellerButton.click();
    }
    public void verifyRegisterPage(){

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        Iterator<String> i = windowHandles.iterator();
        while (i.hasNext()){
            String currentHandle = i.next();
            Driver.getDriver().switchTo().window(currentHandle);


            if (Driver.getDriver().getTitle().toLowerCase().contains("admin")){
                break;
            }

        }
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().toLowerCase().contains("admin"));
    }

}
