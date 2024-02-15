package Test;

import Page.*;
import Utilities.BaseReport;
import Utilities.Driver;
import Utilities.ReusableMethods;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import jdk.jfr.Description;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestVedat extends BaseReport {
    LoginPageVedatImp loginPage = new LoginPageVedatImp();
    ExtentTest test;
    @Test
    @Description("Happy Path")
    public void login() throws IOException {
        test = extentReports.createTest("Smoke Test", "Login Smoke Test");
        test.log(Status.INFO,"Navigate to Url ");
        loginPage.navigateToUrl("url");
        test.log(Status.INFO,"Click Join Button ");
        loginPage.clickOnJoinButton();
        test.log(Status.INFO,"Enter mail");
        loginPage.enterMail("customerMail");
        test.log(Status.INFO,"Enter password ");
        loginPage.enterPassword("customerPassword");
        test.log(Status.INFO,"Click Login Button ");
        loginPage.clickOnLoginButton();
        test.log(Status.INFO,"Last Step");
        test.pass("Test completed successfully");
        ReusableMethods.getScreenshot(Driver.getDriver(),"Login Passed");

    }





}
