package Page;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AutorPage {

    public AutorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//button[text()='Read more']")
    WebElement readMore;

    @FindBy(xpath = "//p[@class='mt-8 text-sm text-body']")
    WebElement textCurrent;

    @FindBy(xpath = "//a[@class='text-body transition-colors hover:text-orange-500 ltr:ml-1 rtl:mr-1']")
    List<WebElement> booksofautor;

    @FindBy(xpath = "//h1[@class='mb-5 text-2xl font-bold uppercase text-heading lg:text-4xl']")
    WebElement autor;

    public void setReadMore(){
        String old = textCurrent.getText();
        readMore.click();
        String newone = textCurrent.getText();
        Assert.assertTrue(newone.length()>old.length());
    }

    public void setBooksofautor(){
        SoftAssert sf = new SoftAssert();
        for (WebElement each:booksofautor) {
           sf.assertEquals(autor.getText(), each.getText());
        }
        sf.assertAll();
    }
}
