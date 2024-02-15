package Page;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class HomePage_Selin {

    public HomePage_Selin() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='headlessui-menu-button-:R3kkm:']")
    public WebElement productsMenuButton;
    @FindBy(xpath = "//button[text()='Join']")
    public WebElement joinButton;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//span[text()='Bags']")
    public WebElement bagsButton;
    @FindBy(xpath = "//a[text()='Offers']")
    public WebElement offersButton;
    @FindBy(xpath = "//img[@alt='user name']")
    public WebElement userMenu;
    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutButton;
    @FindBy(xpath = "//button[text()='Checkout']")
    public WebElement checkoutButton;
    @FindBy(xpath = "//button//span[text()='Copy']")
    public List<WebElement> offersCopyList;

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("alternative_Url"));
        Driver.getDriver().manage().window().maximize();
        implicitWait();
        joinButton.click();
        emailInput.clear();
        passwordInput.clear();
        emailInput.sendKeys(ConfigurationReader.getProperty("selinEmail"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("selinPassword"));
        loginButton.click();
    }

    public void implicitWait(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void goToBagsPage() throws InterruptedException {   //  Login ile
        Driver.getDriver().get(ConfigurationReader.getProperty("alternative_Url"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().manage().window().maximize();
        joinButton.click();
        emailInput.clear();
        passwordInput.clear();
        emailInput.sendKeys(ConfigurationReader.getProperty("selinEmail"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("selinPassword"));
        loginButton.click();
        Thread.sleep(1500);
        productsMenuButton.click();
        Thread.sleep(1500);
        bagsButton.click();
        ReusableMethods.waitFor(2);
    }

    public void logoutMethod(){
        implicitWait();
        userMenu.click();
        logoutButton.click();
    }

    public void goCheckout(){
        userMenu.click();
       checkoutButton.click();
    }

    public void goToUrl(){
        Driver.getDriver().get(ConfigurationReader.getProperty("alternative_Url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void goBagsPage() throws InterruptedException {  //login olmadan
        Driver.getDriver().get(ConfigurationReader.getProperty("alternative_Url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        productsMenuButton.click();
        Thread.sleep(1000);
        bagsButton.click();
        Thread.sleep(2000);

    }
    public void offersCopy(){
        offersCopyList.get(0).click();
    }

    public void clickOffers(){
        offersButton.click();
    }

    public void jsScroll() throws InterruptedException {
        JavascriptExecutor jsExecutor= (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("window.scrollBy(0, 200)");
        Thread.sleep(1000);
    }



}
