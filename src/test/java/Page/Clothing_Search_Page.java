package Page;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Clothing_Search_Page {

    public Clothing_Search_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "search")
    WebElement search_Tab;

    @FindBy(xpath ="//h3[@class='cursor-pointer truncate text-xs text-body md:text-sm']")
    List<WebElement> item_Headers;

    private String keyval;
    public void setSearch_Tab(String keyvalue){
        keyval = keyvalue;
        search_Tab.sendKeys(keyvalue);
        search_Tab.submit();
    }
    public void containsKey(){
        for (WebElement each : item_Headers) {
            if (!each.getText().toLowerCase().contains(keyval))
                Assert.fail(each.getText() + " doesn't contain key value : " + keyval);
        }

    }
}
