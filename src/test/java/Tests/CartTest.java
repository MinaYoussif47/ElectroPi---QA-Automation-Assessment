package Tests;
import CustomsListneres.TestNGListenrs;
import Logs.LogUtils;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    // Test Case
    @Test(retryAnalyzer = TestNGListenrs.class)
    public void ConfirmItemInCartTest() {

        //Login to the Website and Validate that the user is logged in successfully
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        LogUtils.info("Entered valid credentials and clicked login button");

        //Add an item to the cart and validate that the item is added to the cart successfully
        HomePage homePage = new HomePage(driver);
        homePage.addItemToCart();
        LogUtils.info("Clicked add to cart button");
        homePage.isItemAddedToCart();
        LogUtils.info("Item added to cart successfully");

        //Click on the cart button and validate that the cart page is opened successfully and the item is present in the cart
        CartPage cartPage = new CartPage(driver);
        cartPage.addToCart();
        LogUtils.info("Clicked on cart button");
        cartPage.isCartPageOpened("https://www.saucedemo.com/cart.html");
        LogUtils.info("Cart page opened successfully");
        cartPage.isItemAddedToCart("Sauce Labs Backpack");
        LogUtils.info("Item is present in the cart");
        cartPage.checkout();
    }
}
