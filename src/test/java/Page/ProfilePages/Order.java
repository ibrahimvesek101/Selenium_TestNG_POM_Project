package Page.ProfilePages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public Order(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='w-full lg:w-auto'])[1]//span")
    WebElement order_Statu;

    public void checkOrder(){
            String possiblities = "Order Pending Order Processing Order At Local Facility " +
                    "Order Out For Delivery Order Completed";
        Assert.assertTrue(possiblities.contains(order_Statu.getText()));
    }
}
