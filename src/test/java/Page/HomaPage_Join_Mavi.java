package Page;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class HomaPage_Join_Mavi {
    public HomaPage_Join_Mavi() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String mail= "zek@gmail.com";
    public String password = "zek123";
    @FindBy(xpath = "(//h3)[33]")
    public WebElement bakeryProduct33;
    @FindBy(xpath = "//button[.='Join']")
    public WebElement joinButton ;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordi;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement LoginButton ;
    @FindBy(xpath ="//img[@alt='user name']")
    public WebElement profilePicture ;
    @FindBy(xpath ="//span[text()='Points']")
    public WebElement points;
    @FindBy(xpath ="//button[text()='Profile']")
    public WebElement profile;
    @FindBy(xpath ="//button[text()='My Orders']")
    public WebElement myOrders;
    @FindBy(xpath ="//button[text()='My Wishlists']")
    public WebElement myWishlists;
    @FindBy(xpath ="//button[text()='Checkout']")
    public WebElement checkout;
    @FindBy(xpath ="//button[text()='Logout']")
    public WebElement logout;
    @FindBy(xpath ="//button[@class=\"inline-flex items-center justify-center shrink-0 font-semibold leading-none rounded outline-none transition duration-300 ease-in-out focus:outline-0 focus:shadow focus:ring-1 focus:ring-accent-700 bg-accent text-light border border-transparent hover:bg-accent-hover px-5 py-0 h-12 text-sm font-semibold h-11 md:text-base\"]")
    public WebElement loadMore;
    @FindBy(xpath ="//span[text()='Juice']")
    public WebElement juice1;
    @FindBy(xpath ="//span[text()='Coffee & Tea']")
    public WebElement juice2;
    @FindBy(xpath ="//span[text()='Cookies']")
    public WebElement juice3;
    @FindBy(xpath ="//span[text()='Round Cake']")
    public WebElement juice4;
    @FindBy(xpath ="//span[text()='Pita Bread']")
    public WebElement juice5;
    @FindBy(xpath ="//span[text()='Sliced Cake']")
    public WebElement juice6;
    @FindBy(xpath ="//span[text()='Muffin']")
    public WebElement juice7;
    @FindBy(xpath ="//span[text()='Danish']")
    public WebElement juice8;
    @FindBy(xpath ="//span[text()='Croissants']")
    public WebElement juice9;
    @FindBy(xpath ="//span[text()='Feeter & Pies']")
    public WebElement juice10;
    @FindBy(xpath ="//span[text()='Toast & Loaf']")
    public WebElement juice11;
    @FindBy(xpath ="//span[text()='Soft Bread']")
    public WebElement juice12;
    @FindBy(xpath = "//div[@class='category-slider-next absolute top-1/2 z-10 -mt-4 flex h-8 w-8 cursor-pointer items-center justify-center rounded-full bg-light text-heading shadow-300 outline-none focus:outline-none ltr:-right-3 rtl:-left-3 ltr:lg:-right-4 rtl:lg:-left-4']")
    public WebElement nextButton;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/header/div/div/div/div/button/span[2]")
    public WebElement grocery;
    @FindBy(xpath = "//a[@href=\"/bakery\"]")
    public WebElement bakery;
    @FindBy(xpath = "(//h3)[60]")
    public WebElement bakeryProduct60;
    @FindBy(xpath = "//span[@class='mt-3 w-full rounded bg-light px-2 py-2 text-accent']")
    public WebElement basket;
    @FindBy(xpath = "(//header[@class='p-3 md:p-6'])[1]")
    public WebElement firstProduct;
    @FindBy(xpath = "(//button[@class='flex w-full items-center justify-center rounded bg-accent py-4 px-5 text-sm font-light text-light transition-colors duration-300 hover:bg-accent-hover focus:bg-accent-hover focus:outline-0 lg:text-base'])[2]")
    public WebElement buyFirstProduct;
    @FindBy(xpath = "//span[@class=\"mt-3 w-full rounded bg-light px-2 py-2 text-accent\"]")
    public WebElement textfee;
    @FindBy(xpath = "//ins[@class=\"text-2xl font-semibold text-accent no-underline md:text-3xl\"]")
    public WebElement textfeeins;
    @FindBy(xpath = "(//*[@class=\"h-4 w-4\"])[2]")
    public WebElement firstProductRelease;

    @FindBy(xpath = "//span[@class=\"block px-4 pb-4 text-center text-sm font-semibold text-heading\"]")
    public List<WebElement> lazzyCategories;
    @FindBy(xpath = "//a[@class=\"flex w-full items-center space-x-4 px-5 py-2.5 text-sm font-semibold capitalize transition duration-200 hover:text-accent focus:outline-0 focus-visible:outline-0 rtl:space-x-reverse text-body-dark\"]")
    public List<WebElement> userCategorys;
    @FindBy(xpath = "//div[@class=\"absolute top-3 rounded bg-accent px-1.5 text-xs font-semibold leading-6 text-light ltr:left-3 rtl:right-3 sm:px-2 md:top-[22px] md:px-2.5 ltr:md:left-4 rtl:md:right-4\"]")
    public List<WebElement> indirimOranı;
    @FindBy(xpath = "//header[@class='p-3 md:p-6']")
    public List<WebElement> ürüLink;
    @FindBy(xpath = "//span[@class='text-sm font-semibold text-heading md:text-base']")
    public List<WebElement> ürünFiyatı;
    @FindBy(xpath = "//del[@class=\"text-xs text-body ltr:ml-2 rtl:mr-2 md:text-sm\"]")
    public List<WebElement> karalananİndirim;
    @FindBy(xpath = "//h3")
    public List<WebElement> bakeryProduct;

    public boolean userCategory(List<WebElement> asd)  {
        boolean Az= false;
        for (WebElement arkz:asd) {
            if (arkz.isDisplayed()){
                Az=true;
            }
        }
        return Az;
    }
    public boolean profileGo(List<WebElement> poıu){
        boolean erty=false;
        for (WebElement k:poıu) {
            ReusableMethods.waitForVisibility(k,5);
            if (k.isEnabled()){
                erty=true;
            }


        }

        return erty;
    }
    public boolean lazzyCategoriesss(List<WebElement> poıu,List<WebElement> poıuz){
        boolean ret=false;
        for (int i=0; i<poıu.size(); i++){
            ReusableMethods.waitForVisibility(poıu.get(i),5);
            poıu.get(i).click();
            if (poıuz.get(i).getText().toLowerCase().contains(poıu.get(i).getText().toLowerCase())){
                if (i>5){
                    nextButton.click();
                    ret=true;
                }
            }
        }
        return ret;
    }
    public Boolean deenema( List<WebElement> arkz, String arkZs){
        boolean zjak= false;
        for (WebElement a: arkz) {
            if (a.getText().contains(arkZs)){
                zjak=true;
            }

        }
        return  zjak;


    }
    public boolean easyAccessCategory()  {
        boolean A= false;
        ReusableMethods.waitForVisibility(nextButton,10);

        if (juice1.isDisplayed()&&juice2.isDisplayed()&&juice3.isDisplayed()&&juice4.isDisplayed()&&juice5.isDisplayed()&&juice6.isDisplayed()&&juice7.isDisplayed()){
            nextButton.click();
            nextButton.click();
            nextButton.click();
            nextButton.click();
            nextButton.click();
            if(juice8.isDisplayed()&&juice9.isDisplayed()&&juice10.isDisplayed()&&juice11.isDisplayed()&&juice12.isDisplayed()){
                A = true;
            }
        }
        return A;
    }
    public boolean profilePartAccuray(){
        boolean A= false;
        if (logout.isDisplayed()&& checkout.isDisplayed()&&myOrders.isDisplayed()&&myWishlists.isDisplayed()&&profile.isDisplayed()&&points.isDisplayed()) {
            A = true;
        }
        return A;
    }
    public boolean accessTheProfile(){
        boolean B= false;
        profile.click();
        boolean a= Driver.getDriver().getCurrentUrl().contains("profile");
        Driver.getDriver().navigate().back();
        myOrders.click();
        boolean b= Driver.getDriver().getCurrentUrl().contains("ordera");
        Driver.getDriver().navigate().back();
        myWishlists.click();
        boolean c= Driver.getDriver().getCurrentUrl().contains("wishlists");
        Driver.getDriver().navigate().back();
        checkout.click();
        boolean d= Driver.getDriver().getCurrentUrl().contains("checkout");
        Driver.getDriver().navigate().back();
        logout.click();
        ReusableMethods.waitForVisibility(joinButton,3);
        boolean e= joinButton.isDisplayed();
        if(a&&b&&c&&d&&e){
            B= true;
        }
        //orders
        return B;
    }
    public void enterUsername(String username){
        email.clear();

        email.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordi.clear();
        passwordi.sendKeys(password);

    }
    public void clickLogin(){

        LoginButton.click();
    }
    public void clickjoin(){

        joinButton.click();
    }
    public boolean discountSend(List<WebElement> abst,List<WebElement> abstia){

        boolean ljkk=false;
        for (int i = 0; i < abstia.size(); i++){
            if (abstia.get(i).isDisplayed()){
                if (abstia.get(i).isDisplayed()){
                    ljkk=true;
                }

            }

        }
        return ljkk;
    }
    public boolean discountSendacount(List<WebElement> abs){

        boolean ljkki=false;
        for (WebElement a: abs){
            if(a.isDisplayed()){
                ljkki=true;


            }
        }
        return ljkki;
    }
    public double plussButtoncodeamount(List<WebElement> mon){
        double lnk=0;
        for (WebElement slk:mon) {

            lnk = Double.parseDouble(lnk + slk.getText().substring(0));
        }
        return lnk;

    }
    public String plussButtoncode(List<WebElement> lkjn) throws InterruptedException {

        for (WebElement lk:lkjn) {
            ReusableMethods.waitForVisibility(lk,10);
            lk.click();
            Thread.sleep(1000);
        }
        return basket.getText();

    }
    public boolean ProductsSize(){
        boolean xa=false;
        int s= bakeryProduct.size();
        if (s <= 30){
            xa=true;

        }
        return xa;
    }

}
