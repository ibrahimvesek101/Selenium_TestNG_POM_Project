package Test;

import Page.DailyNeeds_AllFunctions;
import Page.ItemInterface;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MakeUp_AllFunctions {


    @BeforeTest
    public void presets() throws InterruptedException {

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Driver.getDriver().findElement(By.xpath("//button[text()='Join']")).click();
        Driver.getDriver().findElement(By.id("email")).clear();
        Driver.getDriver().findElement(By.id("email")).sendKeys(ConfigurationReader.getProperty("testemail"));
        Driver.getDriver().findElement(By.id("password")).clear();
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigurationReader.getProperty("testpassword"));
        Driver.getDriver().findElement(By.xpath("//button[text()='Login']")).click();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//button[@id='headlessui-menu-button-:R3kkm:']")).click();
        ReusableMethods.waitToBeClickableBy(By.xpath("//a[@href='/makeup']"), 10);
        Driver.getDriver().findElement(By.xpath("//a[@href='/makeup']")).click();


    }

    @Test
    public void toItem() throws InterruptedException {
        // goes to  first element of the make up for testing the items function on the main make up page
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("(//article)[1]")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Add To Shopping Cart'])[2]")));
        Driver.getDriver().findElement(By.xpath("//div[@class='flex w-full items-start justify-between space-x-8 rtl:space-x-reverse']")).click();
        ItemInterface item = new ItemInterface();

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        item.setSwipeRight();
        String value = item.cat01.getText();
        item.cat01.click();
        Thread.sleep(1000);
       String url01 =  Driver.getDriver().getCurrentUrl();
       Assert.assertTrue(url01.contains(value));
       Driver.getDriver().navigate().back();
       Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,300)");
        String value01 = item.cat02.getText();
        item.cat02.click();
        String url02 =  Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(url02.contains(value01));
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,0)");
        ReusableMethods.waitForVisibility(item.addToCartbtn,5);
        item.setAddToCarttimes(5);
        item.clickHeart();
        DailyNeeds_AllFunctions page = new DailyNeeds_AllFunctions();
        page.displayedSeller_Cat();
        page.checkDiscount(By.xpath("//ins"));
        item.seeMoreCLCK();
         item.filterToLower();
        item.filterToHigher();
        Thread.sleep(1000);
        Assert.assertTrue(item.selectFilter.getText().equals("Ratings: High to Low"));
        item.setSelectFilter("5 Star");
        Thread.sleep(1000);
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("(//div[@class=' css-1ek5eys-singleValue'])[2]")).getText(),"5 Star");
        item.likeanddislike();
        js.executeScript("window.scrollBy(0,400)");
        item.setAskQuestion("Red colour available");


    }

    @Test(dependsOnMethods = "toItem")
    public void amountManipulation(){
        ItemInterface itemInterface = new ItemInterface();
        itemInterface.check_and_Done();
        //Driver.teardown();
    }
}
