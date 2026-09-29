package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewInvoiceAndConfirmOrderPage {
    // Variables
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By finishButton = By.id("finish");

    // Constructor
    public ViewInvoiceAndConfirmOrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void clickFinishButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        driver.findElement(finishButton).click();
    }

    //Validation
    public boolean isItemDisplayed(String itemName) {
        By item = By.xpath("//div[@data-test='inventory-item-name' and normalize-space()='" + itemName + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(item));
        return driver.findElement(item).isDisplayed();
    }

    public boolean isTotalPriceDisplayed() {
        By totalPrice = By.xpath("//*[@id='checkout_summary_container']" + "//div[contains(@class,'summary_total_label')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        return driver.findElement(totalPrice).isDisplayed();
    }

    public boolean isOrderCompleted() {
        By orderMessage = By.xpath("//*[@id='checkout_complete_container']/h2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderMessage));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(orderMessage, "Thank you for your order!"));
        return driver.findElement(orderMessage).getText().trim().equals("Thank you for your order!");
    }
}