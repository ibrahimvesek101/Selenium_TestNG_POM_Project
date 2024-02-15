package Test;
import Page.HomaPage_Join_Mavi;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HomePageJoinTest_Mavi {
    @Test
    public void bakeryCattegories() {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomaPage_Join_Mavi mv= new HomaPage_Join_Mavi();
        ReusableMethods.waitForVisibility(mv.joinButton,10);
        mv.clickjoin();
        ReusableMethods.waitForVisibility(mv.email,10);
        mv.enterUsername(mv.mail);
        mv.enterPassword(mv.password);
        mv.clickLogin();
        ReusableMethods.waitForVisibility(mv.profilePicture,10);
        mv.grocery.click();
        ReusableMethods.waitForVisibility(mv.bakery,10);
        Assert.assertTrue(mv.userCategory(mv.userCategorys));
        Driver.teardown();
    }
    @Test
    public void bakeryCattegoriesProductSize(){
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomaPage_Join_Mavi mv= new HomaPage_Join_Mavi();
        ReusableMethods.waitForVisibility(mv.joinButton,10);
        mv.clickjoin();
        ReusableMethods.waitForVisibility(mv.email,10);
        mv.enterUsername(mv.mail);
        mv.enterPassword(mv.password);
        mv.clickLogin();
        ReusableMethods.waitForVisibility(mv.profilePicture,10);
        mv.grocery.click();
        ReusableMethods.waitForVisibility(mv.bakery,10);
        mv.bakery.click();
        Assert.assertTrue(mv.ProductsSize());
        Driver.teardown();
    }

    @Test
    public void bakeryCattegoriesProductSizeLoad() throws InterruptedException {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomaPage_Join_Mavi mv= new HomaPage_Join_Mavi();
        ReusableMethods.waitForVisibility(mv.joinButton,10);
        mv.clickjoin();
        ReusableMethods.waitForVisibility(mv.email,10);
        mv.enterUsername(mv.mail);
        mv.enterPassword(mv.password);
        mv.clickLogin();
        ReusableMethods.waitForVisibility(mv.profilePicture,10);
        mv.grocery.click();
        ReusableMethods.waitForVisibility(mv.bakery,10);
        mv.bakery.click();
        ReusableMethods.waitForVisibility(mv.loadMore,10);
        mv.loadMore.click();
        Thread.sleep(2000);
        ReusableMethods.waitForVisibility(mv.bakeryProduct33,5);
        Assert.assertTrue(mv.bakeryProduct33.isDisplayed());
        Driver.teardown();
    }
    @Test
    public void bakeryEasyAccessCategory (){
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomaPage_Join_Mavi mv= new HomaPage_Join_Mavi();
        ReusableMethods.waitForVisibility(mv.joinButton,10);
        mv.clickjoin();
        ReusableMethods.waitForVisibility(mv.email,10);
        mv.enterUsername(mv.mail);
        mv.enterPassword(mv.password);
        mv.clickLogin();
        ReusableMethods.waitForVisibility(mv.profilePicture,10);
        mv.grocery.click();
        ReusableMethods.waitForVisibility(mv.bakery,10);
        mv.bakery.click();
        ReusableMethods.waitForVisibility(mv.juice1,10);
        Assert.assertTrue(mv.easyAccessCategory());
        Driver.teardown();

    }
    @Test
    public void bakeryCattegories4 ()  {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomaPage_Join_Mavi mv= new HomaPage_Join_Mavi();
        ReusableMethods.waitForVisibility(mv.joinButton,10);
        mv.clickjoin();
        ReusableMethods.waitForVisibility(mv.email,10);
        mv.enterUsername(mv.mail);
        mv.enterPassword(mv.password);
        mv.clickLogin();
        ReusableMethods.waitForVisibility(mv.profilePicture,10);
        mv.grocery.click();
        ReusableMethods.waitForVisibility(mv.bakery,10);
        mv.bakery.click();
        ReusableMethods.waitForVisibility(mv.juice1,10);
        Assert.assertTrue(mv.lazzyCategoriesss(mv.lazzyCategories,mv.bakeryProduct));
        Driver.teardown();
    }
    @Test
    public void bakeryCattegories5 () {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomaPage_Join_Mavi mv = new HomaPage_Join_Mavi();
        ReusableMethods.waitForVisibility(mv.joinButton, 10);
        mv.clickjoin();
        ReusableMethods.waitForVisibility(mv.email, 10);
        mv.enterUsername(mv.mail);
        mv.enterPassword(mv.password);
        mv.clickLogin();
        ReusableMethods.waitForVisibility(mv.profilePicture, 10);
        mv.grocery.click();
        ReusableMethods.waitForVisibility(mv.bakery, 10);
        mv.bakery.click();
        ReusableMethods.waitForVisibility(mv.juice1, 10);
        ReusableMethods.waitForVisibility(mv.loadMore, 10);
        mv.loadMore.click();
        ReusableMethods.waitForVisibility(mv.bakeryProduct60, 10);
        mv.loadMore.click();
        Assert.assertTrue((mv.discountSendacount(mv.ürünFiyatı)&&mv.discountSend(mv.indirimOranı,mv.karalananİndirim)&& mv.discountSend(mv.karalananİndirim,mv.indirimOranı)));
        Driver.teardown();
    }

    @Test
    public void bakeryCattegories50 () {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        HomaPage_Join_Mavi mv= new HomaPage_Join_Mavi();
        ReusableMethods.waitForVisibility(mv.joinButton,10);
        mv.clickjoin();
        ReusableMethods.waitForVisibility(mv.email,10);
        mv.enterUsername(mv.mail);
        mv.enterPassword(mv.password);
        mv.clickLogin();
        ReusableMethods.waitForVisibility(mv.profilePicture,10);
        mv.grocery.click();
        ReusableMethods.waitForVisibility(mv.bakery,10);
        mv.bakery.click();
        jse.executeScript("window.scrollBy(0,800);");
        ReusableMethods.waitForVisibility(mv.firstProduct,10);
        mv.firstProduct.click();
        ReusableMethods.waitForVisibility(mv.buyFirstProduct,10);
        mv.buyFirstProduct.click();
        Assert.assertEquals(mv.textfee.getText(),mv.textfeeins.getText());
        Driver.teardown();
    }

}
