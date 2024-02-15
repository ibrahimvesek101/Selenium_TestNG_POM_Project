package Test;

import Page.BagsPage_Selin;
import Page.CheckoutPage_Selin;
import Page.HomePage_Selin;
import Page.OrderPage_Selin;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Selin {

    @Test
    public void us14_Tc1() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goToBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        ReusableMethods.sendData(bagsPage.searchBox, "Armani");
        ReusableMethods.waitFor(2);
        bagsPage.searchButton.submit();
        bagsPage.verifySearchedKey();
        Driver.teardown();
    }

    @Test (priority = -1)
    public void us15_tc01() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goToBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.clickProduct(1);
        bagsPage.clickWishButton();
        bagsPage.goWishlist();
        bagsPage.verifyAddedWishlist();
        homePage.jsScroll();
        bagsPage.removeProductInWishlist();
        Driver.teardown();
    }

    @Test
    public void us15_Tc02() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goToBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.verifyAllCategories();
        Driver.teardown();
    }

    @Test
    public void us15_Tc03() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        ReusableMethods.waitFor(3);
        bagsPage.clickProduct(1);
        bagsPage.addToShoppingCart();
        ReusableMethods.waitFor(2);
        bagsPage.verifyNotMoreAvailable();
        Driver.teardown();
    }

    @Test
    public void us15_Tc04() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.clickProduct(1);
        bagsPage.verifyRelatedProducts();
        Driver.teardown();
    }

    @Test
    public void us15_Tc05() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.clickProduct(1);
        bagsPage.verifyDiscountAmount();
        bagsPage.verifyDiscountedPrice();
        bagsPage.verifyNoDiscountPrice();
        Driver.teardown();
    }

    @Test
    public void us15_Tc06() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.clickProduct(2);
        bagsPage.thirdProductLink.click();
        bagsPage.verifyProductOnProductPage();
        Driver.teardown();
    }

    @Test
    public void us16_Tc01() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.clickCartButton(3);
        bagsPage.verifyIncrementDecrement();
        Driver.teardown();
    }

    @Test
    public void us16_Tc02() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.clickCartButton(0);
        bagsPage.clickViewCartButton();
        bagsPage.verifyIncrementInViewCart();
        bagsPage.verifyDecrementInViewCart();
        Driver.teardown();
    }

    @Test
    public void us17_Tc01() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.clickCategory(0);
        bagsPage.clickCartButton(0);
        bagsPage.clickCategory(1);
        bagsPage.clickCartButton(0);
        bagsPage.clickCategory(2);
        bagsPage.clickCartButton(0);
        bagsPage.clickCategory(3);
        bagsPage.verifyNoProducts();
        bagsPage.clickCategory(4);
        bagsPage.verifyNoProducts();
        bagsPage.clickViewCartButton();
        bagsPage.verifyProductsInCart();
        Driver.teardown();
    }
    @Test (priority =-2)
    public void us17_Tc02() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.clickCartButton(1);
        bagsPage.clickViewCartButton();
        bagsPage.clickPlusInViewCart();
        String productAmountBefore=bagsPage.getText(bagsPage.amountInViewCart);
        bagsPage.clickMinusInViewCart();
        String productAmountAfter=bagsPage.getText(bagsPage.amountInViewCart);
        Assert.assertEquals(Integer.parseInt(productAmountBefore), (Integer.parseInt(productAmountAfter)+1));
        bagsPage.clickPlusInViewCart();
        bagsPage.verifyProductAndTotalPrice();
        bagsPage.verifyRemoveFromCart();
        Driver.teardown();
    }
    @Test
    public void us18_Tc01() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.login();
        homePage.goCheckout();
        CheckoutPage_Selin checkoutPage= new CheckoutPage_Selin();
        checkoutPage.verifyCheckout();
        Driver.teardown();
    }

    @Test
    public void us18_Tc02() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goToBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.clickCartButton(1);
        bagsPage.clickCartButton(2);
        CheckoutPage_Selin checkoutPage= new CheckoutPage_Selin();
        checkoutPage.verifyOrders();
        checkoutPage.verifySubTotal();
        Driver.teardown();
    }

    @Test
    public void us18_Tc03() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.login();
        homePage.goCheckout();
        CheckoutPage_Selin checkoutPage= new CheckoutPage_Selin();
        checkoutPage.updateContactNumber();
        checkoutPage.verifyContactNumberUpdated();
        checkoutPage.updateBillingAddress();
        checkoutPage.verifyBillingAddressUpdated();
        checkoutPage.updateShippingAddress();
        checkoutPage.verifyShippingAddressUpdated();
        checkoutPage.selectDeliverySchedule();
        checkoutPage.verifyDeliveryScheduleUpdated();
        Driver.teardown();
    }

    @Test
    public void us18_Tc04() throws InterruptedException { // **
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goToBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.clickCartButton(1);
        CheckoutPage_Selin checkoutPage= new CheckoutPage_Selin();
        homePage.clickOffers();
        homePage.offersCopy();
        homePage.goCheckout();
        checkoutPage.checkAvailability();
        checkoutPage.doYouHaveACoupon();
        checkoutPage.verifyCouponApplied();
        Driver.teardown();
    }

    @Test
    public void us18_Tc05() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goToBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.clickCartButton(1);
        homePage.goCheckout();
        CheckoutPage_Selin checkoutPage= new CheckoutPage_Selin();
        checkoutPage.updateContactNumber();
        checkoutPage.checkAvailability();
        checkoutPage.cashOnDelivery();
        checkoutPage.verifyCashOnDeliverySelected();
        checkoutPage.placeOrder();
        OrderPage_Selin orderPage= new OrderPage_Selin();
        orderPage.verifyOnOrderPage();
        orderPage.verifyOrderProcess();
        orderPage.verifyProductInOrderPage();
        orderPage.verifyInOrderPage();
        Driver.teardown();
    }

    @Test
    public void us14_Negative() throws InterruptedException {
        HomePage_Selin homePage = new HomePage_Selin();
        homePage.goBagsPage();
        BagsPage_Selin bagsPage = new BagsPage_Selin();
        bagsPage.search("lipstick");
        bagsPage.verifyNoProducts();
        Driver.teardown();
    }


}
