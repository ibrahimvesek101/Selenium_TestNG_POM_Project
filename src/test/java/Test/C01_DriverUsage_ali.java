package Test;
import Page.BasePage_ali;
import Page.ShopsPage_ali;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.annotations.Test;

public class C01_DriverUsage_ali extends BasePage_ali {

    @Test
    public void us_005_1() throws InterruptedException {

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        BasePage_ali bp = new BasePage_ali();
        ReusableMethods ru=new ReusableMethods();
        ShopsPage_ali sp=new ShopsPage_ali();
ru.waitFor(2);
        bp.navigateToShop();

        bp.getAllShopsText();



        sp.furnitureShop();

       sp.sellerInfo();
       sp.visitWebsiteSeen();
        bp.navigateToShop();

        bp.getAllShopsText();
        sp.clothingShop();


        sp.sellerInfo();
        sp.visitWebsiteSeen();
        bp.navigateToShop();
        bp.getAllShopsText();
        sp.bagsShop();
        sp.sellerInfo();
        sp.visitWebsiteSeen();
        bp.navigateToShop();
        bp.getAllShopsText();
        sp.makeupShop();
        sp.sellerInfo();
        sp.visitWebsiteSeen();
        bp.navigateToShop();
        bp.getAllShopsText();
        sp.bakeryShop();
        sp.sellerInfo();
        sp.visitWebsiteSeen();
        bp.navigateToShop();
        bp.getAllShopsText();
        sp.groceryShop();
        sp.sellerInfo();
        sp.visitWebsiteSeen();
        bp.navigateToShop();
        bp.getAllShopsText();
        sp.booksShop();
        sp.sellerInfo();
       // sp.visitWebsiteSeen();      // books bolumunde visit veb site bolumu yok. dogrulamada hata alıyoruz.
    }
// //div[@class='grid grid-cols-1 gap-4 sm:grid-cols-2 lg:grid-cols-3']     bütün alışveriş seceneklerinin pathi

}