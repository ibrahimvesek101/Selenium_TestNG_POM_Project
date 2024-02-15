package Test;

import Page.LoginPage_ali;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.annotations.Test;

public class C02_loginTest_ali {

    @Test
    public void verifyTitle() throws InterruptedException {

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app");


        LoginPage_ali lp=new LoginPage_ali();
        ReusableMethods ru=new ReusableMethods();
        lp.joinButtonClick();
        ru.waitFor(2);
lp.emailClick();
        ru.waitFor(2);
lp.passwordClick();
        ru.waitFor(2);
lp.loginButtonClick();
}





}
