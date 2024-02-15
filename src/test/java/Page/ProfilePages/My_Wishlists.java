package Page.ProfilePages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public class My_Wishlists {

    public My_Wishlists(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindAll({@FindBy(xpath = "//button[text()='Remove']")})
    List<WebElement> all_RemoveElements;

    @FindAll({@FindBy(xpath = "//div[text()='Successfully Removed from Wishlist!']")})
    List<WebElement> remove_notifications;

    public void removeAll() throws InterruptedException {
        int origin =  all_RemoveElements.size();
        for (WebElement each: all_RemoveElements){
            each.click();
            Thread.sleep(500);
        }

    }
    public void  removefirst() {
        if (all_RemoveElements.size() == 0) return;
        all_RemoveElements.get(0).click();
        if (remove_notifications.size() == 0) Assert.fail();
    }

}
