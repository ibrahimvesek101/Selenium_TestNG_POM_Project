package Test;

import Page.RegisterPage_Vedat;
import Page.RegisterPageVedatImp;
import org.testng.annotations.Test;

public class RegisterTestVedat {
    RegisterPageVedatImp register = new RegisterPageVedatImp();

    @Test
    public void register(){
        register.navigateToUrl("url");
        register.clickOnJoinButton();
        register.clickOnRegisterButton();
        register.enterName("customerName");
        register.enterMail("customerMail");
        register.enterPassword("customerPassword");
        register.clickOnRegisterButton();
        register.isProfileSectionVisible();

    }
}
