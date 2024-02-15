package Page;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageVedatImp implements LoginPage_Vedat {
    public LoginPageVedatImp() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Join']")
    private WebElement joinButton;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement loginMail;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement loginPassword;
    @FindBy(xpath = "//button[.='Login']")
    private WebElement loginButton;
    @Override
    public void enterMail(String mail) {
        loginMail.clear();
        loginMail.sendKeys(ConfigurationReader.getProperty(mail));
    }

    @Override
    public void enterPassword(String password) {
        loginPassword.clear();
        loginPassword.sendKeys(ConfigurationReader.getProperty(password));
    }

    @Override
    public void clickOnLoginButton() {
        ReusableMethods.actionClick(loginButton);
    }

    @Override
    public void navigateToUrl(String url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(url));
    }

    @Override
    public void clickOnJoinButton() {
        ReusableMethods.waitForVisibility(joinButton,30).click();
    }
    @Override
    public void login() {
        navigateToUrl("url");
        clickOnJoinButton();
        enterMail("customerMail");
        enterPassword("customerPassword");
        clickOnLoginButton();
        ReusableMethods.waitFor(2);
    }
}
