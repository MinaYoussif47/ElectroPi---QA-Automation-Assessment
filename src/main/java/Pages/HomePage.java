package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    // Variables
    private WebDriver driver;

    // Locators
    private final By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

    // Constructor
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    // Actions
    public void addItemToCart()
    {
        driver.findElement(addToCartButton).click();
    }

    // Validation
    public HomePage isItemAddedToCart()
    {
        String cartCount = driver.findElement(cartIcon).getText();
        Assert.assertEquals(cartCount, "1");
        return this;
    }
}