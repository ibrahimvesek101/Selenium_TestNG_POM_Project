package Page;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Furniture_Main_Bahadir {

    public Furniture_Main_Bahadir(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='grocery search at header']")
    WebElement search_tab;

    @FindBy(xpath = "//h3[@class='mb-2 truncate text-sm font-semibold text-heading']")
    List<WebElement> searched_h3s;


    public void search(String key_value){
        search_tab.sendKeys(key_value);
        search_tab.submit();
    }

    public void  contains_key(){

        String key_value = search_tab.getAttribute("value");
        if (searched_h3s.size() == 0) {
            System.out.println("None item found with the searched value "+key_value);
            return;
        }
        for (WebElement each : searched_h3s) {
            if (!each.getText().contains(key_value))
                Assert.fail(each.getText() + " doesn't contain key value : " + key_value);
        }

    }
}
