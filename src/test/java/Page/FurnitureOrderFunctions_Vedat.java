package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class FurnitureOrderFunctions_Vedat extends HomePageBase_Vedat {
    FurnitureCartPage_Vedat furnitureCartPage = new FurnitureCartPage_Vedat();

    public FurnitureOrderFunctions_Vedat() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button//span[.='plus']")
    public WebElement plusQuantity;
    @FindBy(xpath = "//button//span[.='minus']")
    public WebElement minusQuantity;
    @FindBy(xpath = "//span[contains(.,'pieces')]")
    public WebElement availableAmount; //TODO basindaki sayi alinacak
    @FindBy(xpath = "//span[contains(.,'Item')]")
    public WebElement numberOfItem;
    @FindBy(xpath = "//div[contains(@class,'text-heading rounded-full')]")
    List<WebElement> minusPlusButtons;


    public void hasItemOnLazyBar() {
        int number = Integer.parseInt(numberOfItem.getText().substring(0, numberOfItem.getText().indexOf(" ")));
        if (number > 0) {
            Assert.assertTrue(true);
        } else if (number ==0){
          ReusableMethods.clickButtonWithJSE(  Driver.getDriver().findElement(By.xpath("//span[.='close']")),Driver.getDriver());
            click(furnitureCartPage.addToCartButton);
            click(furnitureCartPage.lazyBar);
        }
    }


    private double getAmount() {
        return Double.parseDouble(availableAmount.getText().replaceAll("\\D", ""));

    }

    public void increaseQuantity(){
        increaseAmount();
    }
    public void decreaseQuantity(){
        decreaseAmount();
    }

    public void increaseAmount() {
        for (int i = 1; i < (int) getAmount(); i++) { //First click count as 1
            ReusableMethods.clickButtonWithJSE(plusQuantity, Driver.getDriver());
        }
        ReusableMethods.waitFor(2);

    }

    public void checkPriceIsCorrect() {
        double price = Double.parseDouble(furnitureCartPage.priceAtCartPage.getText().substring(1));
        double expected = getAmount() * price;
        String actualPrice = (furnitureCartPage.lazyBar.getText().substring(0, furnitureCartPage.lazyBar.getText().indexOf(".")));
        double sonHali = Double.valueOf(actualPrice.replaceAll("\\W", ""));
        Assert.assertEquals(expected, sonHali);
    }

    public void decreaseAmount() {
        for (int i = (int) getAmount(); i >= 1; i--) {
            ReusableMethods.clickButtonWithJSE(minusQuantity, Driver.getDriver());
        }

    }


}





