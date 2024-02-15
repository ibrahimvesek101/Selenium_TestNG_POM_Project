package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShopsPage_ali {
    ReusableMethods ru=new ReusableMethods();


    public ShopsPage_ali() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/a[1]")
    public WebElement furnitureShop;

    public void furnitureShop() {
        ru.waitFor(2);
        furnitureShop.click();


    }
    @FindBy(xpath = "//div[@class='p-7']")
    WebElement sellerInfo;
    public void sellerInfo() {
        ru.waitFor(2);

        Assert.assertTrue(sellerInfo.isDisplayed());
    }


@FindBy(xpath = "*//a[text()='Visit This Site']")
WebElement visitWebsite;
    public void visitWebsiteSeen() {
        ru.waitFor(2);

        Assert.assertTrue(visitWebsite.isDisplayed());


    }



    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/a[2]")
    WebElement clothingShop;
    public void clothingShop() {
        ru.waitFor(2);
     clothingShop.click();


    }
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/a[3]")
    WebElement bagsShop;
    public void bagsShop() {
        ru.waitFor(2);
bagsShop.click();


    }
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/a[4]")
   public WebElement makeupShop;
    public void makeupShop() {
        ru.waitFor(2);
        makeupShop.click();


    }
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/a[5]")
    WebElement bakeryShop;
    public void bakeryShop() {
        ru.waitFor(2);
        bakeryShop.click();


    }
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/a[6]")
    WebElement groceryShop;
    public void groceryShop() {
        ru.waitFor(2);
    groceryShop.click();


    }
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/a[7]")
    WebElement booksShop;


    public void booksShop() {
        ru.waitFor(2);
       booksShop.click();


    }
@FindBy(xpath = "//img[@class='product-image object-contain'][1]")
    WebElement bed;


    public void bedClick(){

        ru.waitFor(2);
        bed.click();
    }

    @FindBy(xpath = "//div[@class=\"mb-3 w-full lg:mb-0 lg:max-w-[400px]\"]")
    WebElement chart;

    public void addChart(){

        ru.waitFor(2);
        chart.click();
    }
    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-0 px-5'])[2]")
    WebElement urunArtir;

    public void urunArtirTikla(){

        ru.waitFor(2);
        urunArtir.click();
    }

    @FindBy(xpath = "//button[@class='product-cart fixed top-1/2 z-40 -mt-12 hidden flex-col items-center justify-center rounded bg-accent p-3 pt-3.5 text-sm font-semibold text-light shadow-900 transition-colors duration-200 hover:bg-accent-hover focus:outline-0 ltr:right-0 ltr:rounded-tr-none ltr:rounded-br-none rtl:left-0 rtl:rounded-tl-none rtl:rounded-bl-none lg:flex']")
    WebElement checkout;

    public void checkoutClick(){

        ru.waitFor(2);
        checkout.click();

    }
    @FindBy(xpath = "//span[@class='flex h-full flex-1 items-center px-5 text-light']")
    WebElement checkout2;

    public void checkout2Click(){
        ru.waitFor(2);
        checkout2.click();
    }
    @FindBy(xpath = "(*//button[text()='Add'])[1]")
    WebElement addContact;

    public void addContactClick(){

        ru.waitFor(2);
        addContact.click();

    }

    @FindBy(xpath = "(//input[@type='tel'])[2]")  //ContactNumber.click
   public WebElement contactNumber;
public void contactNumberClick(){
    ru.waitFor(2);
    contactNumber.click();
    contactNumber.sendKeys("12345");
}

    @FindBy(xpath = "*//button[text()=\"Contact\"]") // tel no gönderdikten sonra click yapılacak
    WebElement addContact2;


public void addContact2Click(){
    ru.waitFor(2);
    addContact2.click();

}


@FindBy(xpath = "(*//button[text()=\"Add\"])[1]")
    WebElement billingAdd;

public void billingaddClick() {
    ru.waitFor(2);
    billingAdd.click();
}

    @FindBy(id = "title")
    WebElement title;
public void titleClick() {
    ru.waitFor(2);
    title.click();
    title.sendKeys(" adress");

    }



    @FindBy(id = "address.country")
    WebElement adressCountry;
public void adressCountryClick() {
    ru.waitFor(2);
    adressCountry.click();
    adressCountry.sendKeys("Turkey");
}

    @FindBy(id = "address.city")
    WebElement adressCity;

public void adressCityClick() {
    ru.waitFor(2);
    adressCity.click();
    adressCity.sendKeys("istanbul");
}
    @FindBy(id = "address.state")
    WebElement adressState;
public void adressStateClick() {
    ru.waitFor(2);
    adressState.click();
    adressState.sendKeys("TR");
}
    @FindBy(id = "address.zip")
    WebElement adressZip;
public void adressZipClick() {
    ru.waitFor(2);
    adressZip.click();
    adressZip.sendKeys("34000");
}
    @FindBy(id = "address.street_address")
    WebElement street_address;
public void streetAddressClick() {
    ru.waitFor(2);
    street_address.click();
    street_address.sendKeys("atasehir");
}
    @FindBy(xpath = "(*//button[text()=\"Update\"])[2]")
    WebElement updateAddress;//

    public void updateAddressClick() {
        ru.waitFor(2);
        updateAddress.click();
    }

    @FindBy(xpath = "(//button[@class='flex items-center text-sm font-semibold text-accent transition-colors duration-200 hover:text-accent-hover focus:text-accent-hover focus:outline-0'])[3]")
            WebElement shipping;
         public void shippingClick() {
             ru.waitFor(2);
             shipping.click();
         }
@FindBy(xpath = "//div[@class='relative p-4 rounded border cursor-pointer group hover:border-accent border-accent shadow-sm']")
    WebElement schedule;
         public void scheduleClick(){
             ru.waitFor(4);
             schedule.click();
         }
        // @FindBy(xpath = "*//button[text()=\"Check Availability\"]")
    @FindBy(xpath = "*//button[text()=\"Check Availability\"]")
    WebElement availability;
         public void availabilityClick(){
            ru.waitFor(7);
             availability.click();
         }

         @FindBy(xpath = "*//span[text()=\"Cash On Delivery\"]")
         WebElement cashOnDelivery;
         public void cashOnDeliveryClick(){
             ru.waitFor(2);
             cashOnDelivery.click();


         }

         @FindBy(xpath = "*//button[text()=\"Place Order\"]")
    WebElement placeOrder;

         public void placeOrderClick(){

             placeOrder.click();
         }

    @FindBy(xpath = "(//button[@class='flex h-5 w-5 items-center justify-center rounded-full bg-accent text-light'])[1]")
    WebElement adresKalemi;
    public void adresKalemiClick() throws InterruptedException {
        Thread.sleep(2000);
        adresKalemi.click();



        // @FindBy(xpath = "*//button[text()=\"Pay Later\"]")
   // WebElement payLater;

     //    public void payLaterClick(){
     //        ru.waitFor(2);
     //        payLater.click();
     //    }

    //   (*//button[text()="Add"])[4]     ikinci add contact
}
    @FindBy(xpath = "(*//span[text()='Order Processing'])[1]")
    WebElement orderProcessing;


    public void orderProcessingClick() throws InterruptedException {
ru.waitFor(7);
        Assert.assertTrue(orderProcessing.isDisplayed());
    }









}