package Page;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order {

    public Order(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='w-full lg:w-auto'])[2]//span")
    WebElement order_Statu;

    public String checkOrder(){
        return order_Statu.getText();
    }
}
