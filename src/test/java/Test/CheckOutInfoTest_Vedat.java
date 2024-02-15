package Test;

import Page.*;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.annotations.Test;

public class CheckOutInfoTest_Vedat extends HomePageBase_Vedat {
    LoginPageVedatImp loginPage = new LoginPageVedatImp();
    FurnitureCartPage_Vedat furnitureCartPage = new FurnitureCartPage_Vedat();
    CheckOutPage_Vedat checkOutPage = new CheckOutPage_Vedat();
    PaymentPage_Vedat paymentPage = new PaymentPage_Vedat();


    @Test(testName = "User's Info")
    public void TC040() {
        loginPage.login();
        navigateToCategory("furniture");
        click(furnitureCartPage.firstProduct);
        click(furnitureCartPage.addToCartButton);
        click(furnitureCartPage.lazyBar);
        click(furnitureCartPage.checkOutButton);
        click(checkOutPage.numberAdd);
        checkOutPage.enterNumber("48722154235");
        click(checkOutPage.addContactButton);
        click(checkOutPage.addressAdd);
        checkOutPage.selectType();
        checkOutPage.enterData("Home","Poland","Masovian","02-495","Warsaw", "Ryzowa127");
        checkOutPage.verifyUpdated();
        checkOutPage.selectDeliverySchedule("Afternoon");
        checkOutPage.enterOrderNote("I need it ASAP");
        click(checkOutPage.checkAvailableButton);
        checkOutPage.isPriceCorrect();
        checkOutPage.checkWallet();
        click(checkOutPage.placeOrderButton);

    }
    @Test (testName = "Payment")
    public void TC041(){

        paymentPage.enterName("Vedat");
        paymentPage.enterCardNo("4242424242424242");
        paymentPage.enterExpDate("1234");
        paymentPage.enterCvc("444");
        paymentPage.isSelected();
        click(paymentPage.payButton);
        paymentPage.verifyPayment();
        paymentPage.printStatus();
        navigateToUserMenu("my orders");
        paymentPage.verifyOrdersMatching();


    }
}
