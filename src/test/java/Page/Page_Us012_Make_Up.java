package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

import static Utilities.ReusableMethods.formatCurrentDate;

public class Page_Us012_Make_Up {
    public Page_Us012_Make_Up() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="(//span[.='Grocery'])[1]")
    WebElement makeUpButtonLocator;
    @FindBy(xpath="//span[.='Face']")
    WebElement FaceLocator;
    @FindBy(xpath="//span[.='Eyes']")
    WebElement EyesLocator;
    @FindBy(xpath="//span[.='Lips']")
    WebElement LipsLocator;
    @FindBy(xpath="//span[.='Accessories']")
    WebElement AccesoriesLocator;
    @FindBy(xpath="//span[.='Shaving Needs']")
    WebElement ShavingNeedsLocator;
    @FindBy(xpath="//span[.='Oral Care']")
    WebElement OralCareLocator;
    @FindBy(xpath="//span[.='Facial Care']")
    WebElement FacialCareLocator;
    @FindBy(xpath="//span[.='Deodorant']")
    WebElement DeodorantLocator;
    @FindBy(xpath="//span[.='Bath & Oil']")
    WebElement BahtOilLocator;
    @FindBy(xpath = "//button[@type='button'][1]")
    WebElement button;

    @FindBy(xpath = "//span[.='Makeup']")
    WebElement makeUpLocator;

    @FindBy(xpath = "(//span[.='Cart'])[1]")
    WebElement productCartLocator;
    @FindBy(xpath = "(//span[.='1 Item'])[1]")
    WebElement addToCartLocator;
    @FindBy(xpath ="//button[@class=\"flex h-7 w-7 shrink-0 items-center justify-center rounded-full text-muted transition-all duration-200 hover:bg-gray-100 hover:text-red-600 focus:bg-gray-100 focus:text-red-600 focus:outline-0 ltr:ml-3 ltr:-mr-2 rtl:mr-3 rtl:-ml-2\"]")
    WebElement xButtonLocator;

    @FindBy(xpath = "(//button)[29]")
    WebElement plusButton;


    @FindBy(xpath = "//span[@class=\"mt-3 w-full rounded bg-light px-2 py-2 text-accent\"]")
    WebElement cartButtonLocator;
    public void verfyAddedToCart() {
        Assert.assertTrue(addToCartLocator.getText().contains("1"),"The product is not added to cart");
    }
    public void LipsButtonClick(){
        LipsLocator.click();
        ReusableMethods.waitFor(3);
    }
    public void clickButton() {
        ReusableMethods.waitFor(1);
        button.click();
        ReusableMethods.waitFor(1);
        makeUpLocator.click();
    }
    public void EyesClick(){
        ReusableMethods.waitFor(1);
        EyesLocator.click();
        ReusableMethods.waitFor(1);
    }

    public void getDriver(){
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
    }
    public void FaceLocatorClick(){
        ReusableMethods.waitFor(1);
        FaceLocator.click();
        ReusableMethods.waitFor(1);
    }
    public void searchProductAndAddChart()  {

        ReusableMethods.waitFor(3);
        productCartLocator.click();
        ReusableMethods.waitFor(3);
    }
    public void scroolDown()  {
        ReusableMethods.waitFor(1);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("window.scrollBy(0, 600);");
        ReusableMethods.waitFor(3);
    }
    public void AccesoriesClick(){
        ReusableMethods.waitFor(1);
        AccesoriesLocator.click();
    }
   public String getScreenshot() throws IOException {
       ReusableMethods.waitFor(1);
       String date = formatCurrentDate("yyyy_MM_dd&hh_mm_ss");

       // Screenshot alip file objesine atiyoruz
       File source = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);

       // Kaydedilecek dosyanin yolunu belirliyoruz
       String target = ".\\test-output\\screenshot"  + date + ".png";

       File targetFile = new File(target);

       FileUtils.copyFile(source, targetFile);

       return target;
   }
   public void shavingNeedsClick(){
       ReusableMethods.waitFor(1);
        ShavingNeedsLocator.click();
   }
    public void oralcareClick(){
        ReusableMethods.waitFor(1);
        OralCareLocator.click();
    }
    public void facialCareClick(){
        ReusableMethods.waitFor(1);
        FacialCareLocator.click();
    }

    public void deodorantClick(){
        ReusableMethods.waitFor(1);
        DeodorantLocator.click();
    }
    public void bathOilClick(){
        ReusableMethods.waitFor(1);
        BahtOilLocator.click();
    }
    public void cartDeleted(){
        ReusableMethods.waitFor(2);
        cartButtonLocator.click();
        ReusableMethods.waitFor(2);
        xButtonLocator.click();
        ReusableMethods.waitFor(2);
    }
    public void verfyCartPiecesUp(){
        cartButtonLocator.click();
        ReusableMethods.waitFor(1);
        plusButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(checknumberlocator.getText().contains("2"));
    }
    @FindBy(xpath ="//div[@class=\"flex flex-1 items-center justify-center px-3 text-sm font-semibold !px-0 text-heading\"]")
    WebElement checknumberlocator;




}
