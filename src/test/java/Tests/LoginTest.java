package Tests;
import CustomsListneres.TestNGListenrs;
import Logs.LogUtils;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;



    public class LoginTest extends BaseTest {

    // Test Case
    @Test(retryAnalyzer = TestNGListenrs.class)
    public void validLoginTest() {

        //Login to the Website and Validate that the user is logged in successfully
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        LogUtils.info("Entered valid credentials and clicked login button");
        Assert.assertTrue(loginPage.isLoggedIn("https://www.saucedemo.com/inventory.html"));
    }
}