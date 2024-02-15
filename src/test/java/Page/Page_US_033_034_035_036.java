package Page;

import Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_US_033_034_035_036 {
    public Page_US_033_034_035_036(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@type='button'][1]")
    WebElement clothing;
    public void clothing() {
        clothing.click();
    }
    @FindBy(xpath = "//span[.='Clothing']")
    public WebElement clothingNeeds;
    public void clothingNeeds() {
        clothingNeeds.click();
    }
    @FindBy(id="search")
    WebElement txtSearch;
    public void searchFor(String key){
        txtSearch.sendKeys(key + Keys.ENTER);
    }
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[4]/div/div/article[1]/div/img")
    WebElement article;
    public void article() {
        article.click();
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/article/article/div[1]/div[2]/div[1]/div[5]/div[1]/div/div/div[2]/div/div[1]")
    WebElement renk1;
    public void renk1() {
        renk1.click();
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/article/article/div[1]/div[2]/div[1]/div[5]/div[2]/div/div/div[2]/div/div[1]")
    WebElement size;
    public void size() {
        size.click();
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/article/article/div[1]/div[2]/div[1]/div[6]/div[1]/div/button")
    WebElement addto;
    public void addto() {
        addto.click();
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/article/article/div[1]/div[1]/div[2]/div/div[2]/div/div/div")
    WebElement model;
    public void model() {
        model.click();
    }
    public  Boolean renk1isSelected() {
       return  renk1.getAttribute("class").contains("border-accent");
    }
     public  Boolean sizeisSelected() {
         return  size.getAttribute("class").contains("border-accent");
    }
     public  Boolean modelisSelected() {
         return  model.getAttribute("class").contains("swiper-slide-active");
    }
    @FindBy(xpath = "//div[contains(@class,'product-gallery-prev')]")
    public WebElement  sol;
    public void sol() {
        sol.click();
    }
    @FindBy(xpath = "//div[contains(@class,'product-gallery-next')]")
    public WebElement sag;
    public void sag() {sag.click();}

    public  void clickButtonWithJS(WebElement element, WebDriver driver){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/article/article/div[1]/div[2]/div[2]/div/button[1]")
    WebElement dress;
    public void dress() {
        dress.click();
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/article/article/div[1]/div[2]/div[2]/div/button[2]")
    WebElement printed;
    public void printed() {printed.click();}
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/article/article/div[1]/div[2]/div[3]/button")
    WebElement shop;
    public void shop() {shop.click();}
    @FindBy(xpath = "/html/body")
    WebElement esc;
    public void esc(){
        esc.sendKeys(Keys.ESCAPE);
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/button")
    WebElement clickItem;
    public void clickItem(){
        clickItem.click();
    }

    public  Boolean clickItemisSelected() {
        return  ItemSayiGir.getAttribute("class").contains("grow pt-16 pb-20");
    }

    @FindBy(xpath = "/html/body/reach-portal/div/aside/div/div[2]/div/div/div/div[2]/section/div/div[1]/div[1]/div/button[2]")
    WebElement ItemSayiGir;
    public void ItemSayiGir(){
        ItemSayiGir.click();
    }
    @FindBy(xpath = "/html/body/reach-portal/div/aside/div/div[2]/div/div/div/div[2]/section/div/div[1]/div[1]/div/div")
    WebElement ItemSayiAl;
    public String ItemSayiAl(){
        return ItemSayiAl.getText();

    }
    @FindBy(xpath = "//button[contains(@class,'flex h-12 w-full justify-between rounded')]")
    WebElement clickCheckout;
    public void clickCheckout(){
        clickCheckout.click();
    }
    @FindBy(xpath = "//p[contains(., 'Login with your email & password')]")
    WebElement LoginekraniMi;
    public String LoginekraniMi(){
       return LoginekraniMi.getText();
    }
    @FindBy(xpath = "//span[contains(.,'Your Order')]")
    WebElement OdemeekraniMi;
    public String OdemeekraniMi(){
        return OdemeekraniMi.getText();
    }
    @FindBy(xpath = "//button[contains(.,'Join')]")
    WebElement JoinClick;
    public void JoinClick(){
        JoinClick.click();
    }
    @FindBy(xpath = "//input[@id='email']")
    WebElement LoginEmail;
    public void LoginEmail(){
        LoginEmail.clear();
        LoginEmail.sendKeys("customer@demo.com");
    }
    @FindBy(xpath = "//input[@id='password']")
    WebElement LoginPassword;
    public void LoginPassword(){
        LoginPassword.clear();
        LoginPassword.sendKeys("demodemo");
    }
    @FindBy(xpath = "//button[contains(.,'Login')]")
    WebElement JoinLoginClick;
    public void JoinLoginClick(){
        JoinLoginClick.click();
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[1]/div/div[1]/div[1]/div[1]/button")
    WebElement TelUpdatesClick;
    public void TelUpdatesClick(){
        TelUpdatesClick.click();
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div/div/div/div[2]")
    WebElement TelFlagUpdateClick;
    public void TelFlagUpdateClick(){
        TelFlagUpdateClick.click();
    }
    @FindBy(xpath = "//li[@data-flag-key=\"flag_no_194\"]")
    WebElement TelFlagUpdate;
    public void TelFlagUpdate(){
        TelFlagUpdate.click();
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div/div/div/input")
    WebElement TelUpdate;
    public void TelUpdate(){
        TelUpdate.click();
        for (int i = 1; i <= 15; i++) {
            TelUpdate.sendKeys(Keys.BACK_SPACE);
        }
        TelUpdate.sendKeys("902123334455");
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div/div/button")
    WebElement TelUpdateFinish;
    public void TelUpdateFinish(){
        TelUpdateFinish.click();
    }
    @FindBy(xpath = "//input[@value=\"+90 212 333 44 55\"]")
    WebElement TelGt;
    public  Boolean TelGt2() {
        return  TelGt.getAttribute("value").contains("+90 212 333 44 55");
    }
    @FindBy(xpath = "//html/body/div/div/div[1]/div/div[1]/div/div[1]/div[2]/div[2]/div/div[1]/div/div/button[1]")
    WebElement AdressUpdatesClick;
    public void AdressUpdatesClick(){
        AdressUpdatesClick.click();
    }
    @FindBy(xpath = "//label[@for=\"billing\"]")
    WebElement AdressTypeB;
    public void AdressTypeB(){
        AdressTypeB.click();
    }
    @FindBy(xpath = "//label[@for=\"shipping\"]")
    WebElement AdressTypeS;
    public void AdressTypeS(){
        AdressTypeS.click();
    }
    @FindBy(xpath = "//input[@id=\"title\"]")
    WebElement AdressTitle;
    public void AdressTitle(){
        AdressTitle.clear();
        AdressTitle.sendKeys("Turkey");
    }
    @FindBy(xpath = "//input[@id=\"address.country\"]")
    WebElement AdressCountry;
    public void AdressCountry(){
        AdressCountry.clear();
        AdressCountry.sendKeys("Turkey");
    }
    @FindBy(xpath = "//input[@id=\"address.city\"]")
    WebElement AdressUpdatesCity;
    public void AdressUpdatesCity(){
        AdressUpdatesCity.clear();
        AdressUpdatesCity.sendKeys("Istanbul");
    }
    @FindBy(xpath = "//input[@id=\"address.state\"]")
    WebElement AdressUpdatesState;
    public void AdressUpdatesState(){
        AdressUpdatesState.clear();
        AdressUpdatesState.sendKeys("Ist");
    }
    @FindBy(xpath = "//input[@id=\"address.zip\"]")
    WebElement AdressUpdatesZip;
    public void AdressUpdatesZip(){
        AdressUpdatesZip.clear();
        AdressUpdatesZip.sendKeys("34000");
    }
    @FindBy(xpath = "//textarea[@id=\"address.street_address\"]")
    WebElement AdressUpdatesStreet;
    public void AdressUpdatesStreet(){
        AdressUpdatesStreet.clear();
        AdressUpdatesStreet.sendKeys("Istiklal");
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/button")
    WebElement AdressUpdatesFinish;
    public void AdressUpdatesFinish(){
        AdressUpdatesFinish.click();
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[1]/div/div[1]/div[2]/div[2]/div/div[1]/div/p[2]")
    WebElement AdressGt;
    public String AdressGt(){
        return AdressGt.getText();
    }
    @FindBy(xpath = "//div[@class=\"flex flex-col border-b border-border-200 py-3\"]")
    WebElement UrunVarMi;
    public Boolean UrunVarMi(){
       return UrunVarMi.isDisplayed();
    }
    @FindBy(xpath = "//div[@class=\"flex justify-between\"][1]")
    WebElement TutarVarMi;
    public Boolean TutarVarMi(){
      return   TutarVarMi.isDisplayed();
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[1]/div/div[1]/div[4]/div[2]/div/div[1]")
    WebElement TeslimZamani;
    public void TeslimZamani(){
        TeslimZamani.click();
    }
    public  Boolean TeslimZamani2() {
        return  TeslimZamani.getAttribute("aria-checked").contains("true");
    }
    @FindBy(xpath = "//button[@data-variant=\"normal\"]")
    WebElement clickCheckoutAva;
    public void clickCheckoutAva(){
        clickCheckoutAva.click();
    }
    @FindBy(xpath = " //p[contains(., 'Do you have coupon?')]")
    WebElement KuponClick;
    public void KuponClick(){
        KuponClick.click();
    }
    @FindBy(xpath = "//input[@id=\"code\"]")
    WebElement KuponYaz;
    public void KuponYaz(){
        KuponYaz.sendKeys("BAZAR20");
        KuponYaz.sendKeys(Keys.ENTER);
    }
    @FindBy(xpath = "//span[@class=\"text-base font-semibold text-heading\"]")
    WebElement Tutar;
    public double Tutar(){return Double.parseDouble(Tutar.getText().substring(1,5));
    }
    @FindBy(xpath = "//div[@class='relative flex h-full w-full cursor-pointer items-center justify-center rounded border border-gray-200 bg-light p-3 text-center']")
    WebElement CashDelClick;
    public void CashDelClick(){
        CashDelClick.click();
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[1]/div/div[2]/div/div[4]/div[1]/div/div")
    WebElement CashDelClick2;
    public  Boolean CashDelClick2() {
        return  CashDelClick2.getAttribute("aria-checked").contains("true");
    }
    @FindBy(xpath = "//button[@class='inline-flex items-center justify-center shrink-0 font-semibold leading-none rounded outline-none transition duration-300 ease-in-out focus:outline-0 focus:shadow focus:ring-1 focus:ring-accent-700 bg-accent text-light border border-transparent hover:bg-accent-hover px-5 py-0 h-12 mt-5 w-full']")
    WebElement PlaceOrderClick;
    public void PlaceOrderClick(){
        PlaceOrderClick.click();
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/div/form/div[2]/label/span")
    WebElement PlaceOrderClickGoruntuleme;
    public  Boolean PlaceOrderClickGoruntuleme() {
        return  PlaceOrderClickGoruntuleme.getAttribute("class").contains("mb-2 block text-sm font-semibold text-black");
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[2]")
    WebElement OdemeSayfasi;
    public String OdemeSayfasi(){
        return OdemeSayfasi.getText().substring(0,14);
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div/div[2]/div[2]/div[4]/div/div/div[2]/table/tbody/tr[2]/td[1]/div/div[2]/div/a")
    WebElement SeUrunGoruntuleme;
    public String SeUrunGoruntuleme(){
        return SeUrunGoruntuleme.getText().substring(0,16);
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div/div[2]/div[2]/div[4]/div/div/div[2]/table/tbody/tr[2]/td[3]")
    WebElement SeFiyatGoruntuleme;
    public double SeFiyatGoruntuleme()
    {return Double.parseDouble(SeFiyatGoruntuleme.getText().substring(1,5));
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/span")
    WebElement SeSparisDurumu;
    public String SeSparisDurumu(){
        return SeSparisDurumu.getText().substring(0,16);
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div/div[2]/div[2]/div[1]/div[1]/p")
    WebElement SeOrdeNumber;
    public String SeOrdeNumber(){
        return SeOrdeNumber.getText().substring(0,4);
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div/div[2]/div[2]/div[1]/div[2]/p")
    WebElement SeDate;
    public String SeDate(){
        return SeDate.getText().substring(8,12);
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div/div[2]/div[2]/div[1]/div[3]/p")
    WebElement SeTutarGoruntuleme;
    public double SeTutarGoruntuleme()
    {return Double.parseDouble(SeTutarGoruntuleme.getText().substring(1,5));
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div/div[2]/div[2]/div[1]/div[4]/p")
    WebElement SeOdemeTipi;
    public String SeOdemeTipi(){
        return SeOdemeTipi.getText();
    }
    @FindBy(xpath = "//a[contains(., 'FAQ')]")
    WebElement Faq;
    public void Faq() {
        Faq.click();
    }
    @FindBy(xpath = "//h2[contains(., 'How to contact with Customer Service?')]")
    WebElement Faq1;
    public void Faq1() {
        Faq1.click();
    }
    @FindBy(xpath = "//h2[contains(., 'App installation failed, how to update system information?')]")
    WebElement Faq2;
    public void Faq2() {
        Faq2.click();

    }@FindBy(xpath = "//h2[contains(., 'Website response taking time, how to improve?')]")
    WebElement Faq3;
    public void Faq3() {
        Faq3.click();

    }@FindBy(xpath = "//h2[contains(., 'How do I create a account?')]")
    WebElement Faq4;
    public void Faq4() {
        Faq4.click();
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/section/div/div[1]/div")
    WebElement Faq1c;
    public Boolean Faq1c() {
        return  Faq1c.isDisplayed();
    }
    @FindBy(xpath = "/html/body/div/div/div[1]/section/div/div[2]/div")
    WebElement Faq2c;
    public Boolean Faq2c() {
        return  Faq2c.isDisplayed();

    }@FindBy(xpath = "/html/body/div/div/div[1]/section/div/div[3]/div")
    WebElement Faq3c;
    public Boolean Faq3c() {
        return Faq3c.isDisplayed();

    }@FindBy(xpath = "/html/body/div/div/div[1]/section/div/div[4]/div")
    WebElement Faq4c;
    public Boolean  Faq4c() {
      return Faq4c.isDisplayed();
    }
}
