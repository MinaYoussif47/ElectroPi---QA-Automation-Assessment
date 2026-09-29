package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {

    // Variables
    private WebDriver driver;


    // Locators
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");

    // Constructor
    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }


    // Actions
    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(By.id("continue")).click();
    }


    //Validation
    public boolean isLoggedIn(String expectedUrl) {
        return driver.getCurrentUrl().equals(expectedUrl);
    }
}
