package Page.ProfilePages;

import Utilities.Driver;
import Utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Profile {

    public Profile(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//input)[1]")
    WebElement photo_input;

    @FindBy(id = "name")
    WebElement name;

    @FindBy(tagName = "textarea")
    WebElement bio_TextArea;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement save_btn;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(xpath = "(//div[@class='mb-5 flex items-center justify-between md:mb-8']//button)[1]")
    WebElement addNumberBtn;


    @FindBy(xpath = "//input[@class='form-control !p-0 ltr:!pr-4 rtl:!pl-4 ltr:!pl-14 rtl:!pr-14 !flex !items-center !w-full !appearance-none !transition !duration-300 !ease-in-out !text-heading !text-sm focus:!outline-none focus:!ring-0 !border !border-border-base ltr:!border-r-0 rtl:!border-l-0 !rounded ltr:!rounded-r-none rtl:!rounded-l-none focus:!border-accent !h-12']")
   WebElement numberInpt;

    @FindBy(xpath = "(//button[@class='flex items-center text-sm font-semibold text-accent transition-colors duration-200 hover:text-accent-hover focus:text-accent-hover focus:outline-0'])[2]")
    WebElement adressAddbtn;


    @FindBy(id = "title")
    WebElement titel;

    @FindBy(xpath = "//input[@id='address.country']")
    WebElement countryAdress;

    @FindBy(xpath = "//input[@id='address.city']")
    WebElement cityAdress;

    @FindBy(xpath = "//input[@id='address.state']")
    WebElement stateAdress;

    @FindBy(xpath = "//input[@id='address.zip']")
    WebElement zipAdress;

    @FindBy (xpath = "(//textarea)[2]")
    WebElement streetAdress;

    @FindBy(xpath = "//p[@class='mt-2 text-xs text-red-500']")
    List<WebElement> error;

    @FindBy(xpath = "//p[@class='my-2 text-xs text-red-500']")
    WebElement textAreaError;

    @FindBy(xpath = "//button[@class='inline-flex items-center justify-center shrink-0 font-semibold leading-none rounded outline-none transition duration-300 ease-in-out focus:outline-0 focus:shadow focus:ring-1 focus:ring-accent-700 bg-accent text-light border border-transparent hover:bg-accent-hover px-5 py-0 h-12 w-full col-span-2']")
    WebElement updateBtn;

    @FindBy(xpath = "//div[text()='Profile Updated Successfully']")
    public WebElement sucess;

    public void DoesErrordisplay(){
        SoftAssert sf = new SoftAssert();
        for (WebElement element : error){
            sf.assertTrue(element.isDisplayed(),element.getText()+": is not displayed");
        }
        sf.assertTrue(textAreaError.isDisplayed(), textAreaError.getText()+": is not displayed");
        sf.assertAll();
    }


    public void setTitel(String key){
        titel.sendKeys(key);
    }
    public void setCountryAdress(String key){
        countryAdress.sendKeys(key);
    }

    public void setCityAdress(String key){
        cityAdress.sendKeys(key);
    }

    public  void setStateAdress(String key ){
        stateAdress.sendKeys(key);
    }
    public void setZipAdress(String key ){
        zipAdress.sendKeys(key);
    }
    public void setStreetAdress(String key){
        streetAdress.sendKeys(key);
        setUpdateBtn();
    }
    public void setUpdateBtn(){
        updateBtn.click();
    }


   public void setAdressAddbtn(){
        adressAddbtn.click();
       ReusableMethods.waitToBeClickable(streetAdress,10);
   }

    public void setAddNumberBtn(){
        addNumberBtn.click();
        numberInpt.sendKeys(new Faker().phoneNumber().cellPhone());
        numberInpt.submit();
        new Actions(Driver.getDriver()).sendKeys(Keys.ESCAPE).perform();
    }
    public void setEmailInput(String emailIn) {
        emailInput.clear();
        emailInput.sendKeys(emailIn);
        emailInput.submit();
    }

    public void setPhoto_input(String path){
        photo_input.sendKeys(path);
    }
    public void setName(String name_new){
        name.clear();
        name.sendKeys(name_new);
    }

    public void setBio(String text ){
        bio_TextArea.sendKeys(text);
    }

    public void click_save(){
        save_btn.click();
    }

}
