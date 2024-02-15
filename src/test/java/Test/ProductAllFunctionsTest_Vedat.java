package Test;

import Page.*;
import org.testng.annotations.Test;

public class ProductAllFunctionsTest_Vedat extends HomePageBase_Vedat {

    LoginPageVedatImp loginPage = new LoginPageVedatImp();

    FurnitureCartPage_Vedat furnitureCartPage =new FurnitureCartPage_Vedat();



    @Test(testName = "ProductFunctions")
    public void TC038() {
        loginPage.login();
        navigateToCategory("furniture");
        click(furnitureCartPage.firstProduct);
        furnitureCartPage.verifyProductIsVisible();
        furnitureCartPage.verifyPrice("250");
        furnitureCartPage.verifyCategory();
        furnitureCartPage.verifyImagesAreVisible();
        furnitureCartPage.verifyProductDescription();
        furnitureCartPage.verifyIsVisible(furnitureCartPage.productReviews);
        furnitureCartPage.verifyIsVisible(furnitureCartPage.relatedProducts);
        furnitureCartPage.verifyAskQuestion("Which type of Foam did you use ?");
        furnitureCartPage.verifyItemAddedOnWishList();




    }
}
