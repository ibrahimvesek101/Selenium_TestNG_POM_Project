package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public class BagsPage_Selin {
    public BagsPage_Selin() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//button[contains(@class,'mt-0.5 flex h-10 w-10')]")
     public WebElement myWishButton;  // Like Button

    @FindBy(xpath = "//div[@class='flex w-full flex-col']")
    public List<WebElement> myWishLists;  // beğenilen ürünler listesi

    @FindBy(xpath = "//button[contains(@class,'product-cart fixed top')]")
    public WebElement viewCartButton;  // yanda çıkan sepet ikonu

    @FindBy(xpath = "(//button//span[text()='close'])[1]")
    public WebElement viewCartClose;  // yanda çıkan sepet ikonu kapatma (x)

    @FindBy(xpath = "//article")
    public List<WebElement> allProductsList;  // Sayfadaki tüm ürünler

    @FindBy(xpath = "//button[contains(@class,'order-5 flex items-center')]")
    public List<WebElement> allCartButtonsList;  // Sayfadaki ürünlerin altındaki Cart butonu listesi (15 adet)

    @FindBy(xpath = "//ul//li[@class='rounded-md py-1']")
    public List<WebElement> allCategoriesList;  // Sayfadaki tüm kategoriler listesi (Purse,Hand bags....)

    @FindBy(xpath = "//article")
    public List<WebElement> armaniProductsList;  // Sayfadaki tüm armani ürünleri listesi

    @FindBy(xpath = "//button[.='Remove']")
    public WebElement myWishRemoveButton;  // wishlist categorisindeki beğenilen ürünü kaldırma butonu

    @FindBy(xpath = "(//button[.='Add To Shopping Cart'])[2]")
    public WebElement addToShoppingCartButton;  // ürüne tıklanınca çıkan sepete ekleme butonu

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div[4]/div/div/article[4]/header/div/div[2]/button[2]")
    public WebElement plusButton; // bags sayfasında ürünün cartına eklenince açılan (+)

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div[4]/div/div/article[4]/header/div/div[2]/button[1]")
    public WebElement minusButton; // // bags sayfasında ürünün cartına eklenince açılan (-)

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/article/article/div[1]/div[2]/div[1]/div[4]/div/div/button[2]")
    public WebElement plus; // ürüne tıklanınca açılan penceredeki (+)

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/article/article/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")
    public WebElement minus; // ürüne tıklanınca açılan penceredeki (+)

    @FindBy(xpath = "(//div[text()='50'])[3]")
    public WebElement productAmount; // ürüne tıklanınca çıkan sepete ekleme butonu (adeti gösteren)

    @FindBy(xpath = "//div[contains(@class,'grid grid-cols-1')]")
    public WebElement relativedProduts; // Relatived Produts

    @FindBy(xpath = "(//div[text()='10%'])[2]")
    public WebElement discountedAmount; // indirim oranı (2. ürün için)

    @FindBy(xpath = "//span[text()='$72.00']")
    public WebElement discountedPrice; // indirimli fiyat (2. ürün için)

    @FindBy(xpath = "(//del[text()='$80.00'])[4]")
    public WebElement noDiscountPrice; // indirimsiz-normal fiyat (2. ürün için)

    @FindBy(xpath = "//h1[text()='Givenchy Purse']")
    public WebElement thirdProductLink; // ürün ismi (3. ürün için)

    @FindBy(xpath = "//div[@class='grow pt-16 pb-20']/div")
    public List<WebElement> productListInViewCart;  // view cart içindeki  tüm ürünler listesi

    @FindBy(xpath = "//h3[text()='Sorry, No Product Found :(']")
    public WebElement noProductMessage; // ürün bulunamadı mesajı

    @FindBy(xpath = "//button//span[text()='close']")
    public List<WebElement> closeMarkListInViewCart;  // view cart içindeki  tüm ürünler listesi

    @FindBy(xpath = "(//div[contains(@class,'flex flex')])[2]")
    public WebElement amountInViewCart; // viewCart içindeki ürün miktarı (ilk ürün için)

    @FindBy(xpath = "(//button[contains(@class,'cursor-pointer')])[3]")
    public WebElement viewCartMinus;

    @FindBy(xpath = "(//button[contains(@class,'cursor-pointer')])[4]")
    public WebElement viewCartPlus;

    public void search(String search){
        searchBox.sendKeys(search);
        ReusableMethods.waitFor(1);
        searchButton.click();
    }
    public void clickCategory(int index){
      allCategoriesList.get(index).click();
        ReusableMethods.waitFor(1);
    }
    public void clickCartButton(int index){
        allCartButtonsList.get(index).click();
    }
    public void clickProduct(int index){   // bags sayfasındaki tüm ürünler
        allProductsList.get(index).click();
        ReusableMethods.waitFor(2);
    }
    public void clickViewCartButton() throws InterruptedException {
        Thread.sleep(1000);
        viewCartButton.click();
        ReusableMethods.waitFor(2);
    }
    public void clickWishButton(){
        myWishButton.click();
    }
    public void removeProductFromCart(int index){
        ReusableMethods.actionClick(closeMarkListInViewCart.get(index));
    }
    public void clickPlusInViewCart() throws InterruptedException {
        Thread.sleep(1000);
        ReusableMethods.actionClick(Driver.getDriver().findElement(By.xpath("(//button//span[text()='plus'])[2]")));
    }
    public void clickMinusInViewCart(){
        ReusableMethods.actionClick(Driver.getDriver().findElement(By.xpath("(//button//span[text()='minus'])[2]")));
    }
    public void verifyIncrementInViewCart(){
        viewCartPlus.click(); // 2 ürün oldu
        String afterPlusClick= Driver.getDriver().findElement(By.xpath("(//div[text()='2'])[2]")).getText();
        Assert.assertTrue(Integer.parseInt(afterPlusClick)>1);
    }
    public void verifyDecrementInViewCart(){
        viewCartMinus.click(); // 1 ürün kaldı
        String afterMinusClick= Driver.getDriver().findElement(By.xpath("(//div[text()='1'])[2]")).getText();
        Assert.assertTrue(Integer.parseInt(afterMinusClick)<2);
    }
    public String getText(WebElement element){
       return element.getText();
    }
    public void addToShoppingCart(){
        addToShoppingCartButton.click();
    }
    public void verifyProductsInCart(){
        Assert.assertTrue(productListInViewCart.get(0).getText().contains("Armani Leather Purse"));
        Assert.assertTrue(productListInViewCart.get(1).getText().contains("Balenciaga"));
        Assert.assertTrue(productListInViewCart.get(2).getText().contains("The Marc Jacobs"));
    }
    public void verifyNoProducts(){
        Assert.assertTrue(noProductMessage.isDisplayed());
    }
    public void verifyIncrementDecrement(){
        String ProductAmount= Driver.getDriver().findElement(By.xpath("//div[text()='1']")).getText();
        plusButton.click(); //2
        String afterPlusClick= Driver.getDriver().findElement(By.xpath("//div[text()='2']")).getText();
        minusButton.click(); //1
        String afterMinusClick= Driver.getDriver().findElement(By.xpath("//div[text()='1']")).getText();
        int firstAmount= Integer.parseInt(ProductAmount); //1
        int afterPlusAmount= Integer.parseInt(afterPlusClick); // 2
        int afterMinusAmount= Integer.parseInt(afterMinusClick); // 1
        Assert.assertTrue(afterPlusAmount>firstAmount,"Artırma sonrası ilk miktar artmadı !");
        Assert.assertTrue(afterMinusAmount<afterPlusAmount,"Azaltma sonrası miktar azalmadı !");
    }

    public void verifyProductOnProductPage(){
        ReusableMethods.waitFor(1);
        String productsUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(productsUrl.contains("products/givenchy-purse"));
    }
    public void verifyDiscountAmount(){
        if(discountedAmount.isDisplayed()) Assert.assertTrue(discountedAmount.isDisplayed());
    }
    public void verifyDiscountedPrice(){
        if(discountedAmount.isDisplayed()) Assert.assertTrue(discountedPrice.isDisplayed());
    }
    public void verifyNoDiscountPrice(){
        if(discountedAmount.isDisplayed()) Assert.assertTrue(noDiscountPrice.isDisplayed());
    }
    public void verifyRelatedProducts(){
        Assert.assertTrue(relativedProduts.isDisplayed());
    }
    public void verifyNotMoreAvailable(){
        String piecesAvailable = Driver.getDriver().findElement(By.xpath("//span[text()='50']")).getText();
        String piecesAvailableNumber = piecesAvailable.substring(0, 2);
        int availableNumber = Integer.parseInt(piecesAvailableNumber); // 50
        for (int i = 0; i < availableNumber+1; i++) {
              plus.click();
        }
        int afterPlus=Integer.parseInt(Driver.getDriver().findElement(By.xpath("(//div[text()='50'])[3]")).getText());
        Assert.assertEquals(availableNumber,afterPlus);
    }

    public void verifyAllCategories(){
        for (int i = 0; i < allCategoriesList.size(); i++) {
            Assert.assertTrue(allCategoriesList.get(i).isDisplayed());
        }
    }
    public void goWishlist(){
        ReusableMethods.waitFor(2);
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/wishlists");
        ReusableMethods.waitFor(2);
    }
    public void verifyAddedWishlist(){
        Assert.assertTrue(myWishLists.get(0).getText().contains("Armani"));
    }

    public void verifyProductAndTotalPrice(){
        String productPrice= Driver.getDriver().findElement(By.xpath("//p[.='$72.00']")).getText().substring(1);
        String totalPrice= Driver.getDriver().findElement(By.xpath("(//span[text()='$144.00'])[2]")).getText().substring(1);
        Assert.assertEquals(Double.parseDouble(productPrice)*2,Double.parseDouble(totalPrice));
    }

    public void verifyRemoveFromCart(){
        removeProductFromCart(1);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h4[text()='No products found']")).isDisplayed());
    }
    public void verifySearchedKey(){
        for (int i = 0; i < armaniProductsList.size(); i++) {
            Assert.assertTrue(armaniProductsList.get(i).getText().contains("Armani"));
        }
    }

    public void removeProductInWishlist(){
       myWishRemoveButton.click();
        ReusableMethods.waitFor(3); //kaldırınca hata veriyor!
    }




}
