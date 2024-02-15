package Test;

import Page.HomePageDailyNeeds;
import Page.HomePage_Eda;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class DailyNeedsSearchTest {

    @BeforeMethod
    public void BeforeMethod(){
        Driver.getDriver().get( ConfigurationReader.getProperty("alternative_Url"));
        Driver.getDriver().manage().window().maximize();
    }

    @Test()
    public void Test01()  {

        HomePageDailyNeeds dn = new HomePageDailyNeeds();
        dn.navigateToDailyNeeds();
        ReusableMethods.waitFor(1);

        dn.searchFor("milk");
        ReusableMethods.waitFor(1);

        List<WebElement> searchResult = dn.getSearchResult();

        for (int i = 0; i < searchResult.size(); i++) {

            Assert.assertTrue((searchResult.get(i).getText()).toLowerCase().contains("milk"));
        }
        Driver.teardown();
    }

        @Test
        public void Test02() throws InterruptedException {

            HomePageDailyNeeds dn = new HomePageDailyNeeds();
            dn.navigateToDailyNeeds();
            ReusableMethods.waitFor(1);

            dn.searchFor("xyz");
            ReusableMethods.waitFor(1);

            Assert.assertTrue(dn.visibleNoProductsFound());

            Driver.teardown();

        }

    @Test
    public void Test03()  {

        HomePageDailyNeeds dn = new HomePageDailyNeeds();
        dn.navigateToDailyNeeds();
        ReusableMethods.waitFor(1);

        dn.searchFor("pop");
        ReusableMethods.waitFor(1);

        List<WebElement> searchResult = dn.getSearchResult();

        for (int i = 0; i < searchResult.size(); i++) {

            Assert.assertTrue((searchResult.get(i).getText()).toLowerCase().contains("pop"));
        }
        Driver.teardown();
    }

        @Test
        public void Test04() throws InterruptedException {

            HomePageDailyNeeds dn = new HomePageDailyNeeds();
            dn.navigateToDailyNeeds();
            ReusableMethods.waitFor(1);

            dn.searchFor("ab");

            List<WebElement> boxes=dn.getBoxes();
            Assert.assertTrue(boxes.size()==0);

            Driver.teardown();

        }
        @Test
        public void Test05() throws IOException {  //bu test fail//verilen criteria uymuyor//burada bug var

            HomePageDailyNeeds dn = new HomePageDailyNeeds();
            dn.navigateToDailyNeeds();
            ReusableMethods.waitFor(1);

            dn.searchFor("123");
            ReusableMethods.waitFor(1);

            if (dn.searchText.getAttribute("value").contains("123")) {
                ReusableMethods.getScreenshot(Driver.getDriver(), "Bug_US19_numbers are allowed");
            }

            Assert.assertTrue(!dn.searchText.getAttribute("value").contains("123"));

            Driver.teardown();

        }

        @Test
        public void Test06() throws IOException {    //bu test fail//verilen criteria uymuyor//burada bug var

            HomePageDailyNeeds dn = new HomePageDailyNeeds();
            dn.navigateToDailyNeeds();
            ReusableMethods.waitFor(1);

            dn.searchFor("a2 ");
            ReusableMethods.waitFor(1);

            if (dn.searchText.getAttribute("value").contains("2")) {
                ReusableMethods.getScreenshot(Driver.getDriver(), "Bug_US19_numbers are allowed");
            }

            Assert.assertTrue(!dn.searchText.getAttribute("value").contains("2"));
            Driver.teardown();

        }

    }

