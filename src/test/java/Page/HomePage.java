package Page;

import Utilities.Driver;
import org.openqa.selenium.support.PageFactory;






import com.sun.source.tree.AssertTree;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;

public class HomePage {
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/header/div/div/div/div/button/span[2]")
    WebElement groceryButton;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/header/div/div/div/div/ul/div/div[4]/div/div/div[1]/a/span[2]")
    WebElement grocery;


    @FindBy(xpath = "/html/body/div[1]/div/div[1]/header/div/div/div/div/ul/div/div[4]/div/div/div[2]/a/span[2]")
    WebElement bakery;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/header/div/div/div/div/ul/div/div[4]/div/div/div[3]/a/span[2]")
    WebElement makeUp;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/header/div/div/div/div/ul/div/div[4]/div/div/div[4]/a/span[2]")
    WebElement bags;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/header/div/div/div/div/ul/div/div[4]/div/div/div[5]/a/span[2]")
    WebElement clothing;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/header/div/div/div/div/ul/div/div[4]/div/div/div[6]/a/span[2]")
    WebElement furniture;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/header/div/div/div/div/ul/div/div[4]/div/div/div[7]/a/span[2]")
    WebElement dailyNeeds;

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void groceryButtonClick() {
        Driver.getDriver().get("http://pickbazar.fullstack.clarusway.com/");
        groceryButton.click();

    }

    public void groceryVerify() {
        grocery.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Grocery"));
    }

    public void bakeryVerify() {
        bakery.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Bakery"));
    }

    public void makeUpVerify() {
        makeUp.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Makeup"));
    }

    public void bagsVerify() {
        bags.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Bags"));
    }

    public void clothingVerify() {
        clothing.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Clothing"));
    }

    public void furnitureVerify() {
        furniture.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Furniture"));
    }

    public void dailyNeedsVerify() {
        dailyNeeds.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Daily Needs"));
    }

    public void dailyNeedsVerify1() {
        dailyNeeds.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Daily Needs"));
    }

    public void groceryButtonClickOther(){
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        groceryButton.click();

    }


}