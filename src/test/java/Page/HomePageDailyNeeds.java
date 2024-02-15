package Page;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePageDailyNeeds {


    public HomePageDailyNeeds() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "search")
    public WebElement searchText;
    @FindBy(xpath = "//h3[text()='Vegetables']")
    public WebElement vegetables;

    @FindBy(xpath = "//h3[text()='No products found']")
    public WebElement noProductsFound;

    @FindBy(xpath = "//div[@class='relative z-10 flex h-full flex-1 flex-col']")
    public List<WebElement> allCategories;

    @FindBy(xpath = "//button[.='View More']")
    public WebElement viewMore;

    @FindBy(xpath = "//h3[@class='mb-1 text-lg font-semibold text-heading']")
    public List<WebElement>  headersList;


    public void searchFor(String input) {
        searchText.sendKeys(input);
    }

    public void vegetableClick() {
        vegetables.click();
    }

    public boolean visibleNoProductsFound() {
        return noProductsFound.isDisplayed();
    }

    public void navigateToDailyNeeds(){

        HomePage_Eda hp = new HomePage_Eda();
        hp.clickButton();
        hp.clickDailyNeeds();
    }

    public int getCategoriesCount(){
        WebElement categoriesTextSpan = allCategories.get(0).findElement(By.xpath("//span[@class='text-s text-body']"));
        String categoriesText = categoriesTextSpan.getText();
        int categoriesCount = Integer.parseInt(categoriesText.substring(0, 1));

        return categoriesCount;
    }

    public List<WebElement> getSearchResult(){
        List<WebElement> searchResult = Driver.getDriver().findElements(By.xpath("//div[@class='flex w-full cursor-pointer items-center border-b border-border-100 px-5 py-2 transition-colors last:border-b-0 hover:bg-gray-100']"));
        return searchResult;
    }

    public List<WebElement>getBoxes(){

         List<WebElement> boxes=Driver.getDriver().findElements(By.xpath("//div[@class='absolute top-11 left-0 mt-2 w-full lg:top-16 lg:mt-1']"));

         return boxes;
    }



}




