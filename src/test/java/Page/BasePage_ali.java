package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage_ali {

    ReusableMethods ru=new ReusableMethods();

    public BasePage_ali(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@href='/shops']")
    WebElement shop;

public void navigateToShop(){
    ru.waitFor(2);
    shop.click();

}

@FindBy(xpath = "//h3[@class='mb-8 text-2xl font-bold text-heading']")
        WebElement allShops;

public void getAllShopsText(){
    ru.waitFor(2);
   Assert.assertTrue(allShops.getText().contains("All Shops"));
}


    }

