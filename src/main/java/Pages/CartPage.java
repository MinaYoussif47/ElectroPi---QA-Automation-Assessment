package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {
    // Variables
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By CartButton = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private final By CheckoutButton = By.id("checkout");

    // Constructor
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // Actions
    public void addToCart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(CartButton));
        driver.findElement(CartButton).click();
    }

    public void checkout()
    {
        wait.until(ExpectedConditions.elementToBeClickable(CheckoutButton));
        driver.findElement(CheckoutButton).click();
    }


    // Validation
    public CartPage isCartPageOpened(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        return this;
    }

    public boolean isItemAddedToCart(String itemName) {
        By item = By.xpath("//div[@data-test='inventory-item-name' and normalize-space()='" + itemName + "']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(item)).isDisplayed();
    }


}
