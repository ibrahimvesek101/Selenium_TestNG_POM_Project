package Test;

import Page.ProfilePages.Us_013_MakeUp_Page;

import org.testng.annotations.Test;

public class Us_013_MakeUp_Test {
    Us_013_MakeUp_Page pp = new Us_013_MakeUp_Page();

    @Test
    public void testContactNumberUpdate() {

        pp.getDriver();
        pp.clickButton();
        pp.bathOilClick();
        pp.searchProductAndAddChart();
        pp.cartButtonClick();
        pp.checkoutButtonClick();
        pp.loginButtonClick();
        pp.verfyPieceAndPrice();
        pp.contactNummerUpdate();

    }
    @Test
    public void testBillingAdress(){
        pp.getDriver();
        pp.clickButton();
        pp.bathOilClick();
        pp.searchProductAndAddChart();
        pp.cartButtonClick();
        pp.checkoutButtonClick();
        pp.loginButtonClick();
        pp.BillingAdressUpdate();
    }

    @Test
    public void testShippingAddress() {
        pp.getDriver();
        pp.clickButton();
        pp.bathOilClick();
        pp.searchProductAndAddChart();
        pp.cartButtonClick();
        pp.checkoutButtonClick();
        pp.loginButtonClick();
        pp.shippingAdressUpdate();
    }

    @Test
    public void testDeliveryAdressUpdate() {
        pp.getDriver();
        pp.clickButton();
        pp.bathOilClick();
        pp.searchProductAndAddChart();
        pp.cartButtonClick();
        pp.checkoutButtonClick();
        pp.loginButtonClick();
        pp.deliveryUpdate();

    }

    @Test
    public void testUseOfDiscountCoupon() {

        pp.getDriver();
        pp.clickButton();
        pp.bathOilClick();
        pp.searchProductAndAddChart();
        pp.cartButtonClick();
        pp.checkoutButtonClick();
        pp.loginButtonClick();
        pp.verfyDiscountTicket();

    }

}
