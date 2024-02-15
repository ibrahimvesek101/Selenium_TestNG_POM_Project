package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DailyNeedsSubcategories {

    public DailyNeedsSubcategories(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h3[@class='mb-1 text-lg font-semibold text-heading'][.='Allium']")
    public WebElement allium;

    public void clickAllium(){
        allium.click();
        ReusableMethods.waitFor(3);
    }

    @FindBy(xpath = "//div[@class='group relative h-80 w-full rounded-lg bg-light p-8 shadow-downfall-sm transition-shadow hover:shadow-downfall-lg']")
     public List <WebElement> allSubcategiroes;

     public int getSubcategoriesCount(){
        int numberofsubcategories  = allSubcategiroes.size();
        return numberofsubcategories;
    }
}
