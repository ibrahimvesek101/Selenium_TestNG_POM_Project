package Test;

import Page.Us_001_HomePage_Become_Seller;
import Utilities.Driver;
import org.testng.annotations.Test;

public class Us_001_HomePage_Test {
    Us_001_HomePage_Become_Seller hp = new Us_001_HomePage_Become_Seller();

    @Test
    public void test01() {

        hp.getBrowser();
        hp.becomeSellerButtonClick();
        hp.verifyRegisterPage();
        hp.sentInformation();
        hp.verfyLogIn();
        hp.createShopButtonClick();
        hp.createNewShop();
        hp.verifyNewShop();

    }
}
