package Test;

import Page.Page_Us012_Make_Up;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class Us012_Make_Up_Test {
    Page_Us012_Make_Up mk = new Page_Us012_Make_Up();

    @Test(priority = 1)
    public void testFace() throws InterruptedException {

        mk.getDriver();
        mk.clickButton();
        mk.scroolDown();
        mk.FaceLocatorClick();
        mk.searchProductAndAddChart();
        mk.verfyAddedToCart();
        mk.cartDeleted();
    }

    @Test(priority = 2)
    public void testEyes() throws InterruptedException {
        mk.getDriver();
        mk.clickButton();
        mk.scroolDown();
        mk.EyesClick();
        mk.searchProductAndAddChart();
        mk.verfyAddedToCart();
        mk.cartDeleted();
    }
    @Test(priority = 3)
    public void testLips() throws InterruptedException {
        mk.getDriver();
        mk.clickButton();
        mk.scroolDown();
        mk.LipsButtonClick();
        mk.searchProductAndAddChart();
        mk.verfyAddedToCart();
        mk.cartDeleted();
    }

    @Test(priority = 4)
    public void testAccesories() throws InterruptedException, IOException {

        mk.getDriver();
        mk.clickButton();
        mk.scroolDown();
        mk.AccesoriesClick();
        mk.scroolDown();
        mk.getScreenshot();

    }

    @Test(priority = 5)
    public void testShavingNeeds() throws InterruptedException, IOException {
        mk.getDriver();
        mk.clickButton();
        mk.scroolDown();
        mk.shavingNeedsClick();
        mk.scroolDown();
        mk.getScreenshot();

    }

    @Test(priority = 6)
    public void testOralCare() throws InterruptedException, IOException {
        mk.getDriver();
        mk.clickButton();
        mk.scroolDown();
        mk.oralcareClick();
        mk.scroolDown();
        mk.getScreenshot();

    }

    @Test(priority = 7)
    public void testFacialCare()  {
        mk.getDriver();
        mk.clickButton();
        mk.scroolDown();
        mk.facialCareClick();
        mk.searchProductAndAddChart();
        mk.cartDeleted();
        mk.verfyAddedToCart();

    }

    @Test(priority = 8)
    public void testDeodorant() throws IOException {
        mk.getDriver();
        mk.clickButton();
        mk.scroolDown();
        mk.deodorantClick();
        mk.scroolDown();
        mk.getScreenshot();
    }

    @Test(priority = 9)
    public void testBathOil() {
        mk.getDriver();
        mk.clickButton();
        mk.scroolDown();
        mk.bathOilClick();
        mk.searchProductAndAddChart();
        mk.cartDeleted();
        mk.verfyAddedToCart();
    }

    @Test
    public void testCardValueUp() {

        mk.getDriver();
        mk.clickButton();
        mk.scroolDown();
        mk.bathOilClick();
        mk.searchProductAndAddChart();
        mk.verfyCartPiecesUp();
    }
}
