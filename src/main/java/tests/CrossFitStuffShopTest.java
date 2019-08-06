import base.BaseUiTest;
import org.junit.Test;
import pages.shop.*;
import pages.HomePage;

public class CrossFitStuffShopTest extends BaseUiTest {

    @Test
    public void testCrossFitStuffShopTest(){
        HomePage homePage = openSite();
        log("User opens site");

        homePage.clickToAcceptCookieButton();
        log("User clicks to 'Accept' button");

        CrossFitStuffShopPage crossFitStuffShopPage = homePage.openCrossFitStuffShopPage();
        log("CrossFit Stuff Page is opened");

        crossFitStuffShopPage.clickToUSStoreButton();
        log("Select UK and Other countries shop");

        crossFitStuffShopPage.closeDiscountOfferDialog();
        log("Close Discount Offer if it is displayed");

        MenShopPage menShopPage = crossFitStuffShopPage.openMenShopPage();
        log("Open Men Shop Page");

        menShopPage.clickToFootwearCheckbox();
        log("Footwear Checkbox is Checked");

        menShopPage.verifyAmountOfFootwear();
        log("Amount of footwear is verified");

        ProductDetailsPage productDetailsPage = menShopPage.openProductByName("Nano 8 Flexweave");
        log("Nano 8 Flexweave is opened");

        YourCartPopUp yourCartPopUp = productDetailsPage.addProductToCart();
        log("Product is added to cart");

        ShoppingCartPage shoppingCartPage = yourCartPopUp.openShoppingCartPage();
        log("Shopping Cart Page is opened from Your Cart pop-up");

        shoppingCartPage.removeProductsFromShoppingCart();
        log("All added products are removed");

        shoppingCartPage.verifyThatCartIsEmpty();
        log("Cart is empty");

        closeSite();
        log("User closes site");
    }
}
