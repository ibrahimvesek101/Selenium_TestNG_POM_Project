package Test;

import Page.BasePage_ali;
import Page.LoginPage_ali;
import Page.ShopsPage_ali;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.annotations.Test;

public class C03_Shopping_ali {
    LoginPage_ali lp=new LoginPage_ali();
    BasePage_ali bp=new BasePage_ali();
    ShopsPage_ali sp=new ShopsPage_ali();
    ReusableMethods ru=new ReusableMethods();
    @Test
    public void us_005_2() throws InterruptedException {

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");




        lp.joinButtonClick();
        lp.emailClick();
        lp.passwordClick();
        lp.loginButtonClick();
        bp.navigateToShop();
        sp.furnitureShop();
        sp.bedClick();
        sp.addChart();
        sp.urunArtirTikla();
        sp.checkoutClick();
        sp.checkout2Click();
        sp.addContactClick();

sp.contactNumberClick();
sp.addContact2Click();
sp.billingaddClick();
sp.titleClick();
sp.adressCountryClick();
sp.adressCityClick();
sp.adressStateClick();
sp.adressZipClick();
sp.streetAddressClick();
sp.updateAddressClick();
sp.shippingClick();
        sp.titleClick();
        sp.adressCountryClick();
        sp.adressCityClick();
        sp.adressStateClick();
        sp.adressZipClick();
        sp.streetAddressClick();
        sp.updateAddressClick();
        sp.scheduleClick();
        sp.availabilityClick();

        sp.cashOnDeliveryClick();
        sp.placeOrderClick();
        ru.waitFor(3);
        sp.orderProcessingClick();
    }
}