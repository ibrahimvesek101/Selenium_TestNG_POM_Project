package Page.ProfilePages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ChangePassword {


    public ChangePassword(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "oldPassword")
    WebElement oldPasTxt;

    @FindBy(xpath = "(//label[@for='oldPassword'])[2]")
    WebElement visible_oldPass;

    @FindBy(id = "newPassword")
    WebElement newPasTxt;

    @FindBy(xpath = "(//label[@for='newPassword'])[2]")
    WebElement visible_newPass;


    @FindBy(id = "passwordConfirmation")
    WebElement confirmPasTxt;

    @FindBy(xpath = "(//label[@for='passwordConfirmation'])[2]")
    WebElement visible_ConfPass;


    @FindBy(xpath = "//button[text()='Submit']")
    WebElement sumbit_btn;

    @FindBy(xpath = "(//p[@class='my-2 text-xs text-red-500'])[1]")
    WebElement oldError;

    @FindBy(xpath = "(//p[@class='my-2 text-xs text-red-500'])[2]")
    WebElement newFirstError;
    @FindBy(xpath = "(//p[@class='my-2 text-xs text-red-500'])[3]")
    WebElement newSecondError;

    @FindBy(xpath = "//p[@class='my-2 text-xs text-red-500']")
    WebElement doesntmatchError;

    public void insert_old(String password){

        oldPasTxt.sendKeys(password);
        visible_oldPass.click();

    }
    public void verifyErors(){
        Assert.assertEquals(oldError.getText(),"Old Password is Required!");
        Assert.assertEquals(newFirstError.getText(),"Password is Required!");
        Assert.assertEquals(newSecondError.getText(),"Please confirm password!");
    }
    public void doesntMatch(){

        Assert.assertEquals(doesntmatchError.getText(),"Passwords should match!");
    }

    public void insert_new(String password){
        newPasTxt.sendKeys(password);
        visible_newPass.click();
        inser_newSec(password);

    }

    public void inser_newSec(String password){
        confirmPasTxt.sendKeys(password);
        visible_ConfPass.click();
    }
    public void click(){
        sumbit_btn.click();
    }


}
