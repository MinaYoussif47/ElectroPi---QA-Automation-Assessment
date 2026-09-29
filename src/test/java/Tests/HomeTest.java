package Tests;
import CustomsListneres.TestNGListenrs;
import Logs.LogUtils;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;



    public class HomeTest extends BaseTest {


    // Test Case
    @Test(retryAnalyzer = TestNGListenrs.class)
    public void AddToCartTest() {

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
    }
}
