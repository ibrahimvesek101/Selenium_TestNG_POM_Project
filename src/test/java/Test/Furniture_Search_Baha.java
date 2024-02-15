package Test;

import Page.Furniture_Main_Bahadir;
import Utilities.Driver;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Furniture_Search_Baha {


    @BeforeMethod
    public void presets(){
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Driver.getDriver().findElement(By.xpath("//button[@id='headlessui-menu-button-:R3kkm:']")).click();
        Driver.getDriver().findElement(By.xpath("//a[@href='/furniture']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@id='headlessui-menu-button-:R3kkm:']")).click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    @Test
    public void _FunctionSearch(){
        Furniture_Main_Bahadir furniture = new Furniture_Main_Bahadir();
        furniture.search("Double");
        furniture.contains_key();
        Driver.teardown();
    }

    @Test
    public  void  lettersearch(){
        Furniture_Main_Bahadir furniture = new Furniture_Main_Bahadir();
        furniture.search("l");
        furniture.contains_key();
        Driver.teardown();
    }

    @Test
    public  void space_search(){
        Furniture_Main_Bahadir furniture = new Furniture_Main_Bahadir();
        furniture.search("");
        furniture.contains_key();
        Driver.teardown();
    }
    @Test
    public void random(){
        Furniture_Main_Bahadir furniture = new Furniture_Main_Bahadir();
        furniture.search("lalalla");
        furniture.contains_key();
        Driver.teardown();
    }
}
