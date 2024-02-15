package Page;

import Utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePageContact {

    public HomePageContact(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Contact']")
    public WebElement contact;
    @FindBy(id="name")
    public WebElement name;

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="subject")
    public WebElement subject;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement description;

    @FindBy(xpath = "//button[ . ='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[.='Email successfully sent']")
    public WebElement emailSent;

    @FindBy(xpath = "//p[.='Tell us more about it']")
    public WebElement tellUsMoreText;
  @FindBy(xpath = "//p[@class='mt-2 text-xs text-red-500']")
  public List<WebElement> errorMessages;
    public void headingContact() {

        contact.click();
    }

        public void submit(){
            submitButton.submit();

        }

        public void getTextTellUsMoreText(){
        tellUsMoreText.getText();
        }


        public void fillNameEmailSubject(){

            Faker faker=new Faker();
            String fakerName=faker.name().firstName();
            String fakerEmail=faker.internet().emailAddress();

            name.sendKeys(fakerName);
            email.sendKeys(fakerEmail);
            subject.sendKeys("return");
        }

    }

