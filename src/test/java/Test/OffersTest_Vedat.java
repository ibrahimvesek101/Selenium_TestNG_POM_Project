package Test;

import Page.*;
import org.testng.annotations.Test;

public class OffersTest_Vedat extends HomePageBase_Vedat {
    LoginPageVedatImp loginPage = new LoginPageVedatImp();
    OffersPage_Vedat offersPage = new OffersPage_Vedat();
    FurnitureCartPage_Vedat furnitureCartPage =new FurnitureCartPage_Vedat();
    CheckOutPage_Vedat checkOutPage = new CheckOutPage_Vedat();

    @Test(testName = "Offers Copy Test")
    public void TC004() {
        loginPage.login();
        waitClickOnButton(offersButton);
        offersPage.isCouponDisplayed();
        offersPage.selectCoupons();
        offersPage.isSelected();

    }
    @Test(testName = "Offers Apply Test")
    public void TC005(){
        navigateToCategory("furniture");
        click(furnitureCartPage.firstProduct);
        click(furnitureCartPage.addToCartButton);
        click(furnitureCartPage.lazyBar);
        click(furnitureCartPage.checkOutButton);

        click(checkOutPage.numberAdd);
        checkOutPage.enterNumber("+48722145393");
        click(checkOutPage.addContactButton);
        click(checkOutPage.checkAvailableButton);
        click(checkOutPage.couponLink);
        checkOutPage.pasteCouponCode();
        checkOutPage.verifyDiscountApplied();

    }
}
