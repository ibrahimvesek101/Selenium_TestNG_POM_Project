package Test;

import Page.Page_US_033_034_035_036;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.charset.Charset;
import java.util.Random;

public class US_033_034_035_036 {

    @Test
    public void US_033_test01() throws InterruptedException {

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        Thread.sleep(3000);
        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();

        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        byte[] array = new byte[1]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        hp.searchFor(generatedString);
        Thread.sleep(3000);

        WebElement yesProducts=  Driver.getDriver().findElement(By.tagName("h3"));
        System.out.println(yesProducts.getText());
        Boolean a=  yesProducts.getText().contains(generatedString);
        boolean b = yesProducts.getText().contains("Sorry, No Product Found :(");
        System.out.println(a);
        System.out.println(b);
        Assert.assertEquals(true, a||b);

    }
    @Test
    public void US_034_test01_01() throws InterruptedException { //renk size model secme yapabildi mi

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        Thread.sleep(3000);
        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();

        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();
        hp.size();
        hp.addto();
        hp.model();

        hp.clickButtonWithJS(hp.sag,Driver.getDriver());
        Thread.sleep(3000);

        hp.clickButtonWithJS(hp.sol,Driver.getDriver());

        boolean renk1isSelected = hp.renk1isSelected();
        Assert.assertTrue(renk1isSelected);

        boolean sizeisSelected = hp.sizeisSelected();
        Assert.assertTrue(sizeisSelected);


        boolean modelisSelected = hp.modelisSelected();
        Assert.assertTrue(modelisSelected);

    }

    @Test
    public void US_034_test01_02() throws InterruptedException { //ayni katagorideki kiyafetleri acabildi mi

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        Thread.sleep(3000);
        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();

        hp.clothing();
        Thread.sleep(3000);

        hp.clothingNeeds();
        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.dress();
        Thread.sleep(3000);

        String expectedUrl = "https://shop-pickbazar-rest.vercel.app/clothing?category=women-dress";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void US_034_test01_03() throws InterruptedException { //print aldi mi

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        Thread.sleep(3000);
        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();

        hp.clothing();
        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.printed();
        Thread.sleep(3000);

        String expectedUrl = "https://shop-pickbazar-rest.vercel.app/clothing?category=printed";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

        }
    @Test
    public void US_034_test01_04() throws InterruptedException {//kiyafeti satan dikkna gecti mi

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        Thread.sleep(3000);
        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();

        hp.clothing();
        Thread.sleep(3000);

        hp.clothingNeeds();
        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.shop();
        Thread.sleep(3000);

        String expectedUrl = "https://shop-pickbazar-rest.vercel.app/shops/clothing-shop";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test
    public void US_035_test01() throws InterruptedException { //item bolumune geldi mi

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        Thread.sleep(3000);
        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();

        hp.clothing();
        Thread.sleep(3000);

        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();
        hp.size();
        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        WebElement element = Driver.getDriver().findElement(By.xpath("//h3[@class='font-bold text-heading']"));
        boolean isElementPresent = element.isDisplayed();
        Assert.assertTrue(isElementPresent);
    }

    @Test
    public void US_035_test02() throws InterruptedException { // 500 gecti mi

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        Thread.sleep(3000);
        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();

        hp.clothing();
        Thread.sleep(3000);

        hp.clothingNeeds();
        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();
        hp.size();
        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(3000);

        for (int i = 1; i <= 555; i++) {
            hp.ItemSayiGir();;
        }
        String metin = hp.ItemSayiAl();
        System.out.println(metin);

        Assert.assertEquals(metin,"500");
    }

    @Test
    public void US_036_test01() throws InterruptedException {
        //Login degil iken odeme sayfasi yerine login ekrani geldi mi

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        Thread.sleep(3000);
        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();

        hp.clothing();
        Thread.sleep(3000);

        hp.clothingNeeds();
        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();
        hp.size();
        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);

        String metin = hp.LoginekraniMi();
        System.out.println(metin);
        Assert.assertEquals(metin,"Login with your email & password");
    }

    @Test
    public void US_036_test02() throws InterruptedException {//Login iken odeme sayfasina geldi mi

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");


        Thread.sleep(3000);
        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();
        hp.size();
        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);


        String metin = hp.OdemeekraniMi();
        System.out.println(metin);
        Assert.assertEquals(metin,"Your Order");
    }

    @Test
    public void US_036_test03_1() throws InterruptedException {// odeme ekranindan adres update

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(3000);

        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();

        hp.size();

        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);

        hp.AdressUpdatesClick();
        Thread.sleep(1000);

        hp.AdressTypeS();
        Thread.sleep(1000);

        hp.AdressTypeB();
        Thread.sleep(1000);

        hp.AdressTitle();
        Thread.sleep(1000);

        hp.AdressCountry();
        Thread.sleep(1000);

        hp.AdressUpdatesCity();
        Thread.sleep(1000);

        hp.AdressUpdatesState();
        Thread.sleep(1000);

        hp.AdressUpdatesZip();
        Thread.sleep(1000);

        hp.AdressUpdatesStreet();
        Thread.sleep(1000);

        hp.AdressUpdatesFinish();
        String metin = hp.AdressGt();
        Assert.assertEquals(metin,"Istiklal, Ist, Istanbul, 34000, Turkey");
    }

    @Test
    public void US_036_test03_2() throws InterruptedException {//// odeme ekranindan Tel update

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(3000);

        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(7000);

        hp.renk1();

        hp.size();

        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);

        hp.TelUpdatesClick();
        Thread.sleep(1000);

        hp.TelFlagUpdateClick();
        Thread.sleep(1000);

        hp.TelFlagUpdate();
        Thread.sleep(1000);

        hp.TelUpdate();
        Thread.sleep(1000);

        hp.TelUpdateFinish();
        Thread.sleep(1000);

        boolean TelGt2 = hp.TelGt2();
        Assert.assertTrue(TelGt2);
    }

    @Test
    public void US_036_test04() throws InterruptedException {//// urun ve fiyat gorunuyor
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(3000);

        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();

        hp.size();

        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);


        boolean a = hp.UrunVarMi();
        Assert.assertTrue(a);
        boolean b = hp.TutarVarMi();
        Assert.assertTrue(b);
    }

    @Test
    public void US_036_test05() throws InterruptedException {//// teslim zamani girildi
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(3000);

        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();

        hp.size();

        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);

        hp.TeslimZamani();

        boolean b = hp.TeslimZamani2();
        Assert.assertTrue(b);
    }

    @Test
    public void US_036_test06() throws InterruptedException {//// Kupon kullanildimi
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(3000);

        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();

        hp.size();

        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);

        hp.clickCheckoutAva();
        Thread.sleep(3000);

        double expectedPrice = hp.Tutar()- 20;
        System.out.println(expectedPrice);
        hp.KuponClick();
        Thread.sleep(3000);

        hp.KuponYaz();
        Thread.sleep(3000);

        double actualPrice = hp.Tutar();
        System.out.println(actualPrice);
        Assert.assertEquals(actualPrice,expectedPrice);
    }

    @Test
    public void US_036_test07_1() throws InterruptedException {//// kapida odeme
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(3000);

        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();

        hp.size();

        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);

        hp.clickCheckoutAva();
        Thread.sleep(3000);

        hp.CashDelClick();
        Thread.sleep(3000);

        boolean b = hp.CashDelClick2();
        Assert.assertTrue(b);
    }

    @Test
    public void US_036_test07_2() throws InterruptedException {//// kartla  odeme
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(3000);

        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(7000);

        hp.renk1();

        hp.size();

        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);

        hp.clickCheckoutAva();
        Thread.sleep(3000);

        hp.TelUpdatesClick();
        Thread.sleep(1000);

        hp.TelFlagUpdateClick();
        Thread.sleep(1000);

        hp.TelFlagUpdate();
        Thread.sleep(1000);

        hp.TelUpdate();
        Thread.sleep(1000);


        hp.TelUpdateFinish();
        Thread.sleep(1000);

        hp.PlaceOrderClick();
        Thread.sleep(15000);


        Boolean b = hp.PlaceOrderClickGoruntuleme();
        Assert.assertTrue(b);
    }

    @Test
    public void US_036_test08() throws InterruptedException {////  sparis ekrani
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(3000);

        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();

        hp.size();

        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);

        hp.clickCheckoutAva();
        Thread.sleep(3000);

        hp.TelUpdatesClick();
        Thread.sleep(1000);

        hp.TelFlagUpdateClick();
        Thread.sleep(1000);

        hp.TelFlagUpdate();
        Thread.sleep(1000);

        hp.TelUpdate();
        Thread.sleep(1000);

        hp.TelUpdateFinish();
        Thread.sleep(1000);

        hp.CashDelClick();
        Thread.sleep(1000);

        hp.PlaceOrderClick();
        Thread.sleep(7000);

        String metin = hp.OdemeSayfasi();
        Assert.assertEquals(metin,"Payment Status");
    }

    @Test
    public void US_036_test09() throws InterruptedException {//// Sparis ekrani (urun ve tutar)
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(3000);

        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();

        hp.size();

        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);

        hp.clickCheckoutAva();
        Thread.sleep(3000);

        hp.TelUpdatesClick();
        Thread.sleep(1000);

        hp.TelFlagUpdateClick();
        Thread.sleep(1000);

        hp.TelFlagUpdate();
        Thread.sleep(1000);

        hp.TelUpdate();
        Thread.sleep(1000);

        hp.TelUpdateFinish();
        Thread.sleep(1000);

        hp.CashDelClick();
        Thread.sleep(1000);

        hp.PlaceOrderClick();
        Thread.sleep(7000);

        String metin = hp.SeUrunGoruntuleme();
        Double Fiyat = hp.SeFiyatGoruntuleme();

        Assert.assertEquals(metin,"Magnetic Designs");
        Assert.assertEquals(Fiyat,35.0);
    }

    @Test
    public void US_036_test10() throws InterruptedException {//// order drumu  Order Processing
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(3000);

        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();

        hp.size();

        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);

        hp.clickCheckoutAva();
        Thread.sleep(3000);

        hp.TelUpdatesClick();
        Thread.sleep(1000);

        hp.TelFlagUpdateClick();
        Thread.sleep(1000);

        hp.TelFlagUpdate();
        Thread.sleep(1000);

        hp.TelUpdate();
        Thread.sleep(1000);

        hp.TelUpdateFinish();
        Thread.sleep(1000);

        hp.CashDelClick();
        Thread.sleep(1000);

        hp.PlaceOrderClick();
        Thread.sleep(7000);

        String metin = hp.SeSparisDurumu();
        Assert.assertEquals(metin,"Order Processing");
    }

    @Test
    public void US_036_test11() throws InterruptedException {//// order siparisno, tutar, tarih, odemetipi
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(3000);

        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();
        Thread.sleep(3000);

        hp.JoinClick();
        Thread.sleep(3000);

        hp.LoginEmail();
        Thread.sleep(3000);

        hp.LoginPassword();
        Thread.sleep(3000);

        hp.JoinLoginClick();
        //
        Thread.sleep(3000);
        hp.clothing();

        Thread.sleep(3000);
        hp.clothingNeeds();

        Thread.sleep(3000);

        hp.article();
        Thread.sleep(3000);

        hp.renk1();

        hp.size();

        hp.addto();

        hp.model();
        Thread.sleep(3000);

        hp.esc();
        Thread.sleep(3000);

        hp.clickItem();
        Thread.sleep(1000);

        hp.clickCheckout();
        Thread.sleep(3000);

        hp.clickCheckoutAva();
        Thread.sleep(3000);

        hp.TelUpdatesClick();
        Thread.sleep(1000);

        hp.TelFlagUpdateClick();
        Thread.sleep(1000);

        hp.TelFlagUpdate();
        Thread.sleep(1000);

        hp.TelUpdate();
        Thread.sleep(1000);

        hp.TelUpdateFinish();
        Thread.sleep(1000);

        hp.CashDelClick();
        Thread.sleep(1000);

        hp.PlaceOrderClick();
        Thread.sleep(7000);

        String Number = hp.SeOrdeNumber();
        String Date = hp.SeDate();
        Double Fiyat = hp.SeTutarGoruntuleme();
        String Tip = hp.SeOdemeTipi();


        Assert.assertEquals(Number,"2023");
        Assert.assertEquals(Date,"2023");
        Assert.assertEquals(Fiyat,85.70);
        Assert.assertEquals(Tip,"CASH_ON_DELIVERY");
    }
    @Test
    public void US_003_test01() throws InterruptedException {
        //search ekranina yazilan herhangi bir deger yazilica bu degeri iceren sonuclar geldimi
        //deger ieren kiyafet yoksa "Sorry, No Product Found :(" ifadesi ekrana geldimi

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        Thread.sleep(3000);
        Page_US_033_034_035_036 hp = new Page_US_033_034_035_036();

        hp.Faq();
        Thread.sleep(1000);
        hp.Faq2();
        Thread.sleep(1000);


        hp.Faq1();
        Thread.sleep(1000);
        Boolean a= hp.Faq1c();
        Assert.assertTrue(a);

        hp.Faq2();
        Thread.sleep(1000);
        Boolean b= hp.Faq2c();
        Assert.assertTrue(b);

        hp.Faq3();
        Thread.sleep(1000);
        Boolean c= hp.Faq3c();
        Assert.assertTrue(c);

        hp.Faq4();
        Thread.sleep(1000);
        Boolean d= hp.Faq4c();
        Assert.assertTrue(d);
    }
}