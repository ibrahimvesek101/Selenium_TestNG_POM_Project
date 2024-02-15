package Test;

import Page.HomePage;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class DailyNeeds_AllFunctions {


    @BeforeTest
    public void presets(){

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/daily-needs?category=allium");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().findElement(By.xpath("(//article)[2]")).click();


    }

    @Test
    public void allFunctions() throws InterruptedException {

        Page.DailyNeeds_AllFunctions df = new Page.DailyNeeds_AllFunctions();
        //Kullanıcı birimini görebilmelidir
        df.areDisplayed();
        //Kullanıcı seçeceği ürünün fiyatını, indirmli fiyatını ve indirim oranı görebilmelidir
        df.checkDiscount();
        //İlglii ürün açıklaması ve title ı olmalıdır.
        df.displayDesTitle();
        // go to item page
        //Açılan sayfada ürünün başlık ve fiyatının önceki sayfadaki ile aynı olduğunu doğrulayabilmeli
        df.goToPage();
        //Kullanıcı sayfada Read More ve Less buttonlarının çalıştığını doğrulamalıdır
        df.readMore();
        //Kullanıcı açılan sayfasa scroll barın çalıştığını, Categories, Sellers başlıklarını doğrulamalı
        JavascriptExecutor js = (JavascriptExecutor)  Driver.getDriver();
        js.executeScript("window.scrollTo(0,0)");
        df.displayedSeller_Cat();
        //Kullanıcı açılan sayfada scroll yaparak Related Products başlığını doğrulamalı
        js.executeScript("window.scrollTo(3500,0)");
        ReusableMethods.waitForVisibility(df.relatedTitel,5);
        df.setRelatedTitel();
        Driver.getDriver().navigate().to("https://shop-pickbazar-rest.vercel.app/daily-needs?category=vegetables-2");
        String urlveg = Driver.getDriver().getCurrentUrl();
        Driver.getDriver().findElement(By.xpath("(//button[text()='View More'])[6]")).click();
        Thread.sleep(1500);
        String urlroot = Driver.getDriver().getCurrentUrl();
        Assert.assertNotEquals(urlveg,urlroot);
        Thread.sleep(1500);
        js.executeScript("window.scrollTo(0,0)");
        Driver.getDriver().findElement(By.xpath("(//button[@class='relative h-14 rounded-lg bg-light px-7 text-base font-semibold text-heading shadow-downfall-xs transition-shadow hover:shadow-downfall-sm ltr:pr-[5.5rem] rtl:pl-[5.5rem]'])[1]")).click();
        Thread.sleep(1500);
        Assert.assertEquals(urlveg,Driver.getDriver().getCurrentUrl());
        Driver.teardown();


    }
}
