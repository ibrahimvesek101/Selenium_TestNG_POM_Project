package Test;

import Page.Clothing_Search_Page;
import Page.Furniture_Main_Bahadir;
import Page.HomePage;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class ClothingSearch_33 {

    @BeforeTest
    public void presets(){
        HomePage homePage = new HomePage();
        homePage.groceryButtonClickOther();
        Driver.getDriver().findElement(By.xpath("//span[text()='Clothing']")).click();
    }


    @Test
    public void search() throws InterruptedException {
        Clothing_Search_Page clothingSearchPage =  new Clothing_Search_Page();
        clothingSearchPage.setSearch_Tab("dress");
        Thread.sleep(1000);
        clothingSearchPage.containsKey();
        Driver.teardown();
    }
}
