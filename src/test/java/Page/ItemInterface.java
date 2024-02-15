package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ItemInterface {

    public ItemInterface() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//div[@class='flex w-full items-start justify-between space-x-8 rtl:space-x-reverse']")
    WebElement titel;


    @FindBy(xpath = "inline-flex items-center justify-center text-accent font-semibold transition-colors hover:text-accent-hover focus:text-accent-hover focus:outline-none")
    WebElement nav_back_btn;

    @FindBy(xpath = "(//img)[2]")
    WebElement currentImage;

    @FindBy(xpath = "//div[@class='product-gallery-next absolute top-2/4 z-10 -mt-4 flex h-8 w-8 cursor-pointer items-center justify-center rounded-full border border-border-200 border-opacity-70 bg-light text-heading shadow-xl transition-all duration-200 hover:bg-gray-100 ltr:-right-4 rtl:-left-4 md:-mt-5 md:h-9 md:w-9 ltr:md:-right-5 rtl:md:-left-5']")
    List<WebElement> swipeRight;
    @FindBy(xpath = "//div[@class='flex w-full items-start justify-between space-x-8 rtl:space-x-reverse']//button")
    WebElement heart_btn;
    @FindBy(xpath = "(//div[@class='flex items-center space-x-6 rtl:space-x-reverse']//button)[1]")
    WebElement like;

    @FindBy(xpath = "(//div[@class='flex items-center space-x-6 rtl:space-x-reverse']//button)[2]")
    WebElement disslike;


    @FindBy(xpath = "//button[text()='See more']")
    WebElement seeMore;

    @FindBy(xpath = "//div[@class=' css-b62m3t-container']")
    public WebElement selectFilter;

    @FindBy(xpath = "//div[text()='Ratings: Low to High']")
    WebElement lowToHigh;
    @FindBy(xpath = "//div[text()='Ratings: High to Low']")
    WebElement highToLow;

    @FindBy(xpath = "//div[@class=' css-xnv90r']")
    public WebElement starsFilter;

    @FindBy(xpath = "//div[@class='mb-3 w-full lg:mb-0 lg:max-w-[400px]']//button")
    public WebElement addToCartbtn;


    @FindBy(xpath = "//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold']")
    WebElement amount;

    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-0 px-5'])[1]")
    WebElement minusAmount;

    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-0 px-5'])[2]")
    WebElement plusAmount;

    @FindBy(xpath = "//div[@class='flex flex-row flex-wrap']//button")
    public List<WebElement> sub_Catgories;

    @FindBy(xpath = "(//div[@class='flex flex-row flex-wrap']//button)[1]")
    public WebElement cat01;

    @FindBy(xpath = "(//div[@class='flex flex-row flex-wrap']//button)[2]")
    public WebElement cat02;

    @FindBy(xpath = "//button[text()='Ask seller a question']")
    WebElement askQuestionBtn;

    @FindBy(tagName = "textarea")
    WebElement textQuestionArea;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement textAreaSubmit;

    @FindBy(xpath = "//div[text()='Successfully submitted the question. Please wait for the seller to respond.'")
    List<WebElement> succes;

    @FindBy(xpath = "//div[text()='Maximum Question Limit Exceeded']")
    List<WebElement> amountExceed;

    @FindBy(xpath = "//button[@class='product-cart fixed top-1/2 z-40 -mt-12 hidden flex-col items-center justify-center rounded bg-accent p-3 pt-3.5 text-sm font-semibold text-light shadow-900 transition-colors duration-200 hover:bg-accent-hover focus:outline-0 ltr:right-0 ltr:rounded-tr-none ltr:rounded-br-none rtl:left-0 rtl:rounded-tl-none rtl:rounded-bl-none lg:flex']")
    WebElement goCart;

    @FindBy(xpath = "//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-0 hover:!bg-gray-100']")
    WebElement lower;

    @FindBy(xpath = "//p[@class='my-2.5 font-semibold text-accent']")
    WebElement priceofone;

    @FindBy(xpath = "//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold !px-0 text-heading']")
    WebElement amountCart;

    @FindBy(xpath = "//span[@class='font-bold text-heading ltr:ml-auto rtl:mr-auto']")
    WebElement totalPrice;

    @FindBy(xpath = "//span[@class='whitespace-nowrap text-base text-body ltr:lg:ml-7 rtl:lg:mr-7']")
    WebElement stock;


    public void check_and_Done(){
        goCart.click();
        ReusableMethods.waitForVisibility(priceofone,3);
        lower.click();
        lower.click();
        int price = Integer.parseInt(priceofone.getText().split("\\.")[0].substring(1));
        int amount =  Integer.parseInt(amountCart.getText());
        int total =  Integer.parseInt(totalPrice.getText().split("\\.")[0].substring(1));
        Assert.assertEquals((price*amount),total);
    }

    public String getTitel() {
        return titel.getText();
    }

    public void navtobackbtn() {
        nav_back_btn.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("http://pickbazar.fullstack.clarusway.com/makeup"));

    }

    public void setSwipeRight() throws InterruptedException {
        if (swipeRight.size() == 0) return;
        swipeRight.get(0).click();
        swipeRight.get(0).click();

    }

    public void clickHeart() throws InterruptedException {

        if (!heart_btn.getAttribute("class").contains("!border-accent")){
        Thread.sleep(1000);
        heart_btn.click();}
        else System.out.println("this element has already clicked");
        Assert.assertTrue(heart_btn.getAttribute("class").contains("!border-accent"));

    }

    public void seeMoreCLCK() throws InterruptedException {
        seeMore.click();
        Thread.sleep(1500);
        Assert.assertTrue(selectFilter.isDisplayed());
    }

    private void setSelectFilter() {
        selectFilter.click();
    }

    public void filterToLower() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=' css-1ek5eys-singleValue'])[1]")));
        setSelectFilter();
        lowToHigh.click();
    }

    public void filterToHigher() {
        setSelectFilter();
        highToLow.click();
    }

    public void clickStar() {
        starsFilter.click();
    }

    public void setSelectFilter(String starFilter) {
        clickStar();
        Driver.getDriver().findElement(By.xpath("//div[text()='" + starFilter + "']")).click();

    }

    private void setAddToCartbtn() {
        addToCartbtn.click();
    }

    public void setAddToCarttimes(int times) throws InterruptedException {
        String stock_val = stock.getText().split(" ")[0];
        if (stock_val.equalsIgnoreCase("out") || stock_val.equalsIgnoreCase("0")){
            System.out.println("No stock available!");
            return;
        }
        setAddToCartbtn();
        for (int x = 0; x < times - 1; x++) {
            plusAmount.click();
        }
        plusAmount.click();
        minusAmount.click();
        Thread.sleep(1000);
        Assert.assertEquals(times, Integer.parseInt(amount.getText()));
        System.out.println(addToCartbtn.findElement(By.xpath(".//span")).getText());
    }

    public void likeanddislike() {
        like.click();
        disslike.click();
        Assert.assertTrue(Driver.getDriver().findElements(By.xpath("//div[text()='Feedback Submitted']")).size()>0);
    }

    public void setAskQuestion(String question){
        while (amountExceed.size()==0) {
            askQuestionBtn.click();
            ReusableMethods.waitForVisibility(textAreaSubmit, 5);
            textQuestionArea.sendKeys(question);
            textAreaSubmit.click();
        }
    }



}
