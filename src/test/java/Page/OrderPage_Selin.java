package Page;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;
public class OrderPage_Selin {
    public OrderPage_Selin() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='progress-box_progress_container___zzev']")
    public List<WebElement> orderProcessList;
    public void verifyOnOrderPage() {
        WebElement orderStatus = Driver.getDriver().findElement(By.xpath("//div//span[text()='Order Status']"));
        Assert.assertTrue(orderStatus.isDisplayed());
    }
    public void verifyOrderProcess() {
        for (int i = 0; i < orderProcessList.size(); i++) {
            Assert.assertTrue(orderProcessList.get(i).getText().contains("Order"));
        }
    }
    public void verifyProductInOrderPage() {
        String productInOrderPage = Driver.getDriver().findElement(By.xpath("//a[text()='Armani Purse']")).getText();
        Assert.assertTrue(productInOrderPage.contains("Armani Purse"));
    }
    public void verifyInOrderPage() {
        String productAmount = Driver.getDriver().findElement(By.xpath("//p[text()='1']")).getText();
        Assert.assertTrue(productAmount.contains("1"));
    }

}
