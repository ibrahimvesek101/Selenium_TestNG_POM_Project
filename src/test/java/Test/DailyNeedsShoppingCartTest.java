package Test;

import Page.DailyNeedsProductPage;
import Page.DailyNeedsSubcategories;
import Page.HomePageDailyNeeds;
import Page.HomePage_Eda;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DailyNeedsShoppingCartTest {


    @BeforeMethod
    public void BeforeMethod(){
        Driver.getDriver().get( ConfigurationReader.getProperty("alternative_Url"));
        Driver.getDriver().manage().window().maximize();
        HomePage_Eda hp=new HomePage_Eda();
        HomePageDailyNeeds dn = new HomePageDailyNeeds();
        hp.loginToPage();
        ReusableMethods.waitFor(3);
        dn.navigateToDailyNeeds();
        ReusableMethods.waitFor(3);
        dn.vegetableClick();
        ReusableMethods.waitFor(3);
    }

    @Test(priority = 1)
    public void Test01(){

        DailyNeedsSubcategories sc=new DailyNeedsSubcategories();
        sc.clickAllium();

        DailyNeedsProductPage pp=new DailyNeedsProductPage();
        pp.clickFirstProductofAllium();
        pp.clickAddToCartButton();

        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.ESCAPE).perform();
        ReusableMethods.waitFor(3);

        HomePage_Eda hp=new HomePage_Eda();
        hp.clickToCartButton();

        Assert.assertEquals("1",pp.productInTheCart.getText(),"product wasn't added to cart");

        Driver.teardown();
    }

    @Test(priority = 2)
    public void Test02(){

        DailyNeedsSubcategories sc=new DailyNeedsSubcategories();
        sc.clickAllium();

        DailyNeedsProductPage pp=new DailyNeedsProductPage();
        pp.clickAddButton();
        HomePage_Eda hp=new HomePage_Eda();
        hp.clickToCartButton();
        pp.removeTheProductFromCart();

        Assert.assertEquals("0",pp.numberOfItems.getText().substring(0,1), "product wasn't removed to cart");
        Driver.teardown();
    }
    @Test(priority = 3)
    public void Test03(){

        DailyNeedsSubcategories sc=new DailyNeedsSubcategories();
        sc.clickAllium();

        DailyNeedsProductPage pp=new DailyNeedsProductPage();
        pp.clickAddButton();
        HomePage_Eda hp=new HomePage_Eda();
        hp.clickToCartButton();

        Assert.assertTrue(pp.priceOfProduct.isDisplayed());

        Driver.teardown();
    }

}
