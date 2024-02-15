package Test;

import Page.HomePageContact;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class HomePageContactTest {

    @BeforeMethod
    public void BeforeMethod() {
        Driver.getDriver().get(ConfigurationReader.getProperty("alternative_Url"));
        Driver.getDriver().manage().window().maximize();
    }


    @Test
    public void test01() throws InterruptedException, IOException {


        HomePageContact hp = new HomePageContact();
        hp.headingContact();
        hp.fillNameEmailSubject();
        hp.description.sendKeys("Wrong item was sent.I'd like to return it");
        hp.submit();
        ReusableMethods.waitFor(7);

        Assert.assertTrue(hp.emailSent.isDisplayed());
        Driver.teardown();

    }

    @Test(dataProvider ="data")  //dataprovider ile her seferinde bir fieldi bos biraktim!!!
    public void test02(String name,String email,String subject,String description) {


        HomePageContact hp = new HomePageContact();
        hp.headingContact();

        hp.name.sendKeys(name);
        hp.email.sendKeys(email);
        hp.subject.sendKeys(subject);
        hp.description.sendKeys(description);
        hp.submit();

        Assert.assertTrue((hp.errorMessages.size()>0) || ( !hp.tellUsMoreText.getText().isEmpty()));

        Driver.teardown();
    }


    @DataProvider
    public Object[][] data() {

        Object[][] data = new Object[4][4];

        data[0] = new Object[]{"Ben","","return","wrong product"};
        data[1] = new Object[]{"","ben@gmail.com","return","wrong product"};
        data[2] = new Object[]{"Ben","ben@gmail.com","","wrong product"};
        data[3] = new Object[]{"Ben","ben@gmail.com","return",""};

        return data;

    }


    @Test
    public void test03() {

        HomePageContact hp = new HomePageContact();
        hp.headingContact();
        hp.submit();

        //name,email ve subject error hata mesaji icin for kullanildi.
        for (int i = 0; i < hp.errorMessages.size(); i++) {
            String actualResult = hp.errorMessages.get(i).getText();
            Assert.assertTrue(!actualResult.isEmpty());
        }

        //description icin hata mesaji dogrulama
        String actualResult = hp.tellUsMoreText.getText();
        Assert.assertTrue(!actualResult.isEmpty());

        Driver.teardown();

    }

}
