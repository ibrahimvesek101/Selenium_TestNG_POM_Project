package Test;

import Page.*;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DailyNeedsCategoriesTest {
    @BeforeMethod
    public void BeforeMethod(){
        Driver.getDriver().get( ConfigurationReader.getProperty("alternative_Url"));
        Driver.getDriver().manage().window().maximize();

    }
    @Test
    public void Test01(){

        HomePage_Eda hp=new HomePage_Eda();
        HomePageDailyNeeds dn = new HomePageDailyNeeds();
        DailyNeedsSubcategories sc=new DailyNeedsSubcategories();
        DailyNeedsProductPage pp=new DailyNeedsProductPage();
        DailyNeedsCheckoutPage cp=new DailyNeedsCheckoutPage();
        hp.loginToPage();
        ReusableMethods.waitFor(3);
        dn.navigateToDailyNeeds();
        ReusableMethods.waitFor(3);
        dn.vegetableClick();
        ReusableMethods.waitFor(3);
        sc.clickAllium();
        pp.clickAddButton();
        hp.clickToCartButton();
        cp.clickcheckOut();
        ReusableMethods.waitFor(3);
        cp.ClickAddButton();
        cp.addContactNumber();
        cp.addContactSubmit();
        cp.checkAvailabilityButtonClick();
        ReusableMethods.waitFor(3);
        cp.cashOnDeliveryClick();
        cp.placeOrderButtonClick();
        ReusableMethods.waitFor(5);
        WebElement orderNumber=Driver.getDriver().findElement(By.xpath("//h3[.='Order Number']"));
        Assert.assertTrue(orderNumber.isDisplayed());

        Driver.teardown();

    }

    @Test
    public void Test02(){

        HomePageDailyNeeds dn = new HomePageDailyNeeds();
        dn.navigateToDailyNeeds();

        ReusableMethods.waitFor(5);

        String textoflastProduct=dn.headersList.get(dn.headersList.size()-1).getText();
        System.out.println(textoflastProduct);

        Actions action=new Actions(Driver.getDriver());
        action.moveToElement(dn.allCategories.get(dn.allCategories.size()-1)).click().perform();

        ReusableMethods.waitFor(5);

       WebElement subcategory=Driver.getDriver().findElement(By.xpath("//span[@class='whitespace-nowrap'][.='"+textoflastProduct+"']"));

       Assert.assertEquals(textoflastProduct,subcategory.getText());

        Driver.teardown();
    }
    @Test
    public void Test03(){

        HomePageDailyNeeds dn = new HomePageDailyNeeds();
        dn.navigateToDailyNeeds();

        ReusableMethods.waitFor(2);

        for (WebElement x: dn.allCategories) {
            Assert.assertTrue(x.isDisplayed());
        }

        Driver.teardown();

   }
    @Test
    public void Test04(){

        HomePageDailyNeeds dn = new HomePageDailyNeeds();
        dn.navigateToDailyNeeds();

        ReusableMethods.waitFor(2);

        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement(dn.allCategories.get(0)).perform();
        ReusableMethods.waitFor(5);

        ReusableMethods.waitForVisibility(dn.viewMore,5);
        Assert.assertTrue(dn.viewMore.isDisplayed());

        Driver.teardown();

    }
    @Test
    public void Test05() {

        HomePageDailyNeeds dn = new HomePageDailyNeeds();
        dn.navigateToDailyNeeds();

        for (int i = 0; i <dn.allCategories.size(); i++) {
            System.out.println( dn.allCategories.get(i).getText().substring(0, 1));

            Assert.assertTrue(Character.isDigit(dn.allCategories.get(i).getText().substring(0, 1).charAt(0)));
        }
          Driver.teardown();
    }
    @Test
    public void Test06() {
        HomePageDailyNeeds dn = new HomePageDailyNeeds();
        dn.navigateToDailyNeeds();
        ReusableMethods.waitFor(5);

        int categoriesCount= dn.getCategoriesCount();

        dn.allCategories.get(0).click();
        ReusableMethods.waitFor(5);

        DailyNeedsSubcategories sc=new DailyNeedsSubcategories();
        int subcategoriesCount=sc.getSubcategoriesCount();

       System.out.println("totalCategories.size() = " + subcategoriesCount);

        Assert.assertEquals(categoriesCount, subcategoriesCount);

        Driver.teardown();

    }
}


