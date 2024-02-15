package Page;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Eda {


    public HomePage_Eda() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@type='button'][1]")
    public WebElement button;

    public void clickButton() {
        button.click();
    }

    @FindBy(xpath = "//span[.='Daily Needs']")
    public WebElement dailyNeeds;


    public void clickDailyNeeds() {
        dailyNeeds.click();
    }

    @FindBy(xpath = "//button [text()='Join']")
    public WebElement join;

   @FindBy(id="email")
    public WebElement email;
   @FindBy(id="password")
   public WebElement password;

   @FindBy(xpath = "//button[.='Login']")
   public WebElement loginButton;

   @FindBy(xpath = "//button[@class='hidden product-cart lg:flex relative']//span[text()='1']")
   public WebElement cartButton;

    public void loginToPage(){
        join.click();
        email.clear();
        password.clear();
        email.sendKeys(ConfigurationReader.getProperty("customerMail"));
        password.sendKeys( ConfigurationReader.getProperty("customerPassword"));
        loginButton.click();

    }

    public void clickToCartButton(){
        cartButton.click();
        ReusableMethods.waitFor(3);
    }


}

