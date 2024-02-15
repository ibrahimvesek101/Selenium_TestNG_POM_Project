package Page;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPageVedatImp implements RegisterPage_Vedat {
    public RegisterPageVedatImp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Join']")
    private WebElement joinButton;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement registerName;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement registerMail;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement registerPassword;
    @FindBy(xpath = "//button[.='Register']")
    private WebElement registerButton;
    @FindBy(xpath = "//button[.='user avatar']")
    public WebElement profileButton;
    @Override
    public void navigateToUrl(String url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(url));
    }


    public void clickOnJoinButton() {
        ReusableMethods.waitForVisibility(joinButton, 30).click();
    }


    public void enterName(String name) {
        registerName.clear();
        registerName.sendKeys(ConfigurationReader.getProperty(name));
    }


    public void enterMail(String mail) {


        registerMail.clear();
        registerMail.sendKeys(ConfigurationReader.getProperty(mail));
    }


    public void enterPassword(String password) {
        registerPassword.clear();
        registerPassword.sendKeys(ConfigurationReader.getProperty(password));
    }


    public void clickOnRegisterButton() {
        registerButton.click();
        ReusableMethods.waitForVisibility(registerName,3);
    }
    public void isProfileSectionVisible(){
        Assert.assertTrue(profileButton.isDisplayed());
    }
    @Override
    public void register(){
        navigateToUrl("url");
        clickOnJoinButton();
        clickOnRegisterButton();
        enterName("customerName");
        enterMail("customerMail");
        enterPassword("customerPassword");
        clickOnRegisterButton();
    }

}
