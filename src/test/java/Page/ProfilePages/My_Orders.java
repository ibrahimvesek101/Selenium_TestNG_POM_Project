package Page.ProfilePages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class My_Orders {

    public My_Orders(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Details']")
    WebElement details_btn;

    @FindBy(xpath = "//div[@class='h-[80vh] min-h-[670px] w-full ltr:pr-5 rtl:pl-5 md:w-1/3 md:shrink-0 ltr:lg:pr-8 rtl:lg:pl-8']//div[@class='flex flex-col p-5 md:p-3 lg:px-4 lg:py-5']")
    List<WebElement> availble_list;


    public  void details_navigate(){
        details_btn.click();
    }

    public boolean checkavailable() {
        if (availble_list.size() == 0) return false;
        return true;

    }
}
