package Test;

import Page.*;
import org.testng.annotations.Test;

public class OrderFunctionsTest_Vedat extends HomePageBase_Vedat {
    LoginPageVedatImp loginPage = new LoginPageVedatImp();
    FurnitureCartPage_Vedat furnitureCartPage = new FurnitureCartPage_Vedat();
    FurnitureOrderFunctions_Vedat orderPage = new FurnitureOrderFunctions_Vedat();

    @Test
    public void TC039(){

        loginPage.login();
        navigateToCategory("furniture");
        click(furnitureCartPage.firstProduct);
        click(furnitureCartPage.addToCartButton);
        orderPage.increaseAmount();
        orderPage.checkPriceIsCorrect();
        orderPage.decreaseAmount();
        click(furnitureCartPage.addToCartButton);
        click(furnitureCartPage.lazyBar);
        orderPage.increaseAmount();
        orderPage.decreaseAmount();
        orderPage.hasItemOnLazyBar();


    }
}
