package Tests;
import CustomsListneres.TestNGListenrs;
import Logs.LogUtils;
import Pages.CartPage;
import Pages.CheckoutInformationPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ViewInvoiceAndConfirmOrderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEnd extends BaseTest {


    // Test Case
    @Test(retryAnalyzer = TestNGListenrs.class)
    public void validViewInvoiceAndConfirmOrderTest() {

        //Login to the Website and Validate that the user is logged in successfully
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        LogUtils.info("Entered valid credentials and clicked login button");

        //Add an item to the cart and validate that the item is added to the cart successfully
        HomePage homePage = new HomePage(driver);
        homePage.addItemToCart();
        LogUtils.info("Item is Added");
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

        //Enter checkout information and validate that the user is navigated to the Checkout: Overview page successfully
        CheckoutInformationPage checkoutInfoPage = new CheckoutInformationPage(driver);
        checkoutInfoPage.enterCheckoutInformation("Mina", "Youssif", "QA-99");
        LogUtils.info("Entered checkout information and clicked continue button");
        Assert.assertTrue(checkoutInfoPage.isLoggedIn("https://www.saucedemo.com/checkout-step-two.html"));
        LogUtils.info("Checkout information entered successfully and user is navigated to the Checkout: Overview");

        //Make sure the product and its final price appear and click the finish button
        ViewInvoiceAndConfirmOrderPage viewInvoiceAndConfirmOrderPage = new ViewInvoiceAndConfirmOrderPage(driver);
        Assert.assertTrue(viewInvoiceAndConfirmOrderPage.isItemDisplayed("Sauce Labs Backpack"),
                "Sauce Labs Backpack is not displayed in Checkout Overview");
        LogUtils.info("Item displayed in Overview successfully");
        Assert.assertTrue(viewInvoiceAndConfirmOrderPage.isTotalPriceDisplayed(),
                "Total price is not displayed");
        LogUtils.info("Total price is displayed successfully");
        viewInvoiceAndConfirmOrderPage.clickFinishButton();

        //Make Sure The Status order is Completed!!
        LogUtils.info("Clicked Finish Button successfully");
        Assert.assertTrue(
                viewInvoiceAndConfirmOrderPage.isOrderCompleted(),"Order completion message is not displayed");
        LogUtils.info("Order completed successfully");
    }
}