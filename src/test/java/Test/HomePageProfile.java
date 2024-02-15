package Test;


import Page.ProfilePages.Order;

import Page.ProfilePages.ChangePassword;
import Page.ProfilePages.My_Orders;
import Page.ProfilePages.My_Wishlists;
import Page.ProfilePages.Profile;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import com.github.javafaker.Faker;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import java.util.List;


public class HomePageProfile {

    @BeforeTest
    public void beforehand() throws InterruptedException {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().findElement(By.xpath("//button[text()='Join']")).click();
        Driver.getDriver().findElement(By.id("email")).clear();
        Driver.getDriver().findElement(By.id("email")).sendKeys(ConfigurationReader.getProperty("testemail"));
        Driver.getDriver().findElement(By.id("password")).clear();
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigurationReader.getProperty("testpassword"));
        Driver.getDriver().findElement(By.xpath("//button[text()='Login']")).click();
        Thread.sleep(1000);

        Driver.getDriver().findElement(By.xpath("//button[@id='headlessui-menu-button-:r2:']")).click();
        Driver.getDriver().findElement(By.xpath("//button[text()='Profile']")).click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test
    public  void  updateNegative(){
        Profile profile = new Profile();
        profile.setAdressAddbtn();
        profile.setUpdateBtn();
        profile.DoesErrordisplay();
        new Actions(Driver.getDriver()).sendKeys(Keys.ESCAPE).perform();
    }

    @Test
    public void updateProfileData() throws InterruptedException {


        Profile profile = new Profile();
        profile.setName(new Faker().name().fullName());
        profile.setPhoto_input(System.getProperty("user.dir")+"\\"+"Computer-Crash.jpg");
        profile.setBio("Testing is fun");
        profile.click_save();



        Assert.assertEquals(Driver.getDriver().switchTo().alert().getText(),"This mutation doesn't work for demo purposes");
        Thread.sleep(6000);

        Driver.getDriver().switchTo().alert().accept();
        profile.setEmailInput(ConfigurationReader.getProperty("testemail"));
        int size = Driver.getDriver().findElements(By.xpath("//div[text()='Email updated Successfully']")).size();
        Assert.assertTrue(size>0);
        profile.setAddNumberBtn();
        profile.setAdressAddbtn();
        profile.setTitel("Example");
        profile.setCountryAdress("Belgium");
        profile.setCityAdress("Limburg");
        profile.setStateAdress("Hasselt");
        profile.setZipAdress("3500");
        profile.setStreetAdress("Groote baan 23");
        Thread.sleep(1000);
        Assert.assertTrue(profile.sucess.isDisplayed(),"the address couldn't set");

    }

    @Test(priority = 1)
    public void changePassword(){
        Driver.getDriver().findElement(By.xpath("//a[text()='Change Password']")).click();
        ChangePassword change = new ChangePassword();
        change.insert_old(ConfigurationReader.getProperty("testpassword"));
        change.insert_new(ConfigurationReader.getProperty("testpassword"));
        change.click();


        Assert.assertEquals(Driver.getDriver().switchTo().alert().getText(),"This mutation doesn't work for demo purposes");

        Driver.getDriver().switchTo().alert().accept();
    }
    @Test(priority = 2)
    public void changePSWDNeg(){
        Driver.getDriver().findElement(By.xpath("//a[text()='Change Password']")).click();
        ChangePassword change = new ChangePassword();
        change.click();
        change.verifyErors();
        change.insert_old(ConfigurationReader.getProperty("testpassword"));
        change.inser_newSec("213");
        change.insert_new("222");
        change.click();
        change.doesntMatch();
    }

    @Test(priority = 3)
    public void  wishlist() throws InterruptedException {

        Driver.getDriver().findElement(By.xpath("//a[text()='My Wishlists']")).click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        My_Wishlists myWishlists = new My_Wishlists();

        myWishlists.removefirst();

    }

    @Test(priority = 4)
    public void ordersCheck() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//a[text()='My Orders']")).click();
        My_Orders myOrders = new My_Orders();
       if (myOrders.checkavailable()) myOrders.details_navigate();
        Order order = new Order();
        order.checkOrder();
        Driver.getDriver().navigate().back();
    }
    @Test(priority = 5)
    public void logOUT(){

      Driver.getDriver().findElement(By.xpath("//button[text()='Logout']"));
      Driver.getDriver().quit();

    }


}
