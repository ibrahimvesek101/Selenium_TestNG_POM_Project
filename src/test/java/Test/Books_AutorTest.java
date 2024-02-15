package Test;

import Page.AutorPage;
import Page.BooksMainPage;
import Page.HomePage;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Books_AutorTest {

    @BeforeTest
    public void  presets() throws InterruptedException {
        HomePage hm = new HomePage();
        hm.groceryButtonClickOther();
        Driver.getDriver().manage().window().setSize(new Dimension(1849,1589));
        Driver.getDriver().manage().window().maximize();
        Thread.sleep(4000);
        Driver.getDriver().findElement(By.xpath("//span[text()='Books']")).click();
    }

    @Test
    public void Page() throws InterruptedException {
        //verify 8 authors are displaying!
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,-800)");
        BooksMainPage book = new BooksMainPage();
        book.autorsCheck();
        book.clickNext();
        book.clickSeeMore();
        // verify search
        book.setSearchTab("Benjamin");
        book.checkAuthor();
        Driver.getDriver().findElement(By.xpath("//a[@class='group relative flex cursor-pointer flex-col items-center bg-light text-center']")).click();
        AutorPage autorPage = new AutorPage();
        autorPage.setReadMore();
        autorPage.setBooksofautor();
        js.executeScript("window.scrollBy(0,700)");
        Driver.teardown();
    }


}
