package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OffersPage_Vedat extends HomePageBase_Vedat {

    public OffersPage_Vedat() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='coupon-card']")
    List<WebElement> coupons;
    @FindBy(xpath = "//div[@class='coupon-card']//button/span")
    List<WebElement> copyButtons;
    @FindBy(xpath = "//div[.='Copied!']")
    WebElement verifiedCopy;

    public void isCouponDisplayed() {

        for (WebElement coupon : ReusableMethods.waitForVisibilityList(copyButtons, 10)) {
            Assert.assertTrue(coupon.isDisplayed());
        }

    }

    public void selectCoupons() {
        for (WebElement button : ReusableMethods.waitForVisibilityList(copyButtons, 10)) {
            click(button);
        }
    }

    public void isSelected() {
        Assert.assertTrue(verifiedCopy.isDisplayed());

    }
}
