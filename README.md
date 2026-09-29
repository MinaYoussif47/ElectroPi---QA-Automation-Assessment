# ElectroPi---QA-Automation-Assessment


# ElectroPi QA Automation Assessment

A UI test automation project built with *Java, Selenium WebDriver, TestNG, Maven, and Allure* to automate and validate key user journeys on the [SauceDemo](https://www.saucedemo.com/) web application.

The project follows the *Page Object Model (POM)* design pattern to keep test cases maintainable, readable, and reusable.

---

## 📌 Project Overview

This project automates the main e-commerce flow on SauceDemo, including:

* User Login
* Adding products to the shopping cart
* Verifying cart contents
* Navigating to checkout
* Entering checkout information
* Verifying order summary
* Verifying total price
* Completing an order
* Verifying successful order completion

The project also includes:

* TestNG test execution
* Page Object Model
* Explicit waits
* Custom TestNG listener
* Failed-test retry mechanism
* Log4j2 logging
* Allure test reporting
* Maven build management

---

## 🛠️ Technologies & Tools

| Technology / Tool  | Version  |
| ------------------ | -------- |
| Java               | 21       |
| Selenium WebDriver | 4.49.0   |
| TestNG             | 7.12.0   |
| Maven              | 3.x      |
| Allure             | 2.35.5   |
| Log4j2             | 2.24.1   |
| Maven Surefire     | 3.5.4    |
| Chrome             | Required |

---

## 🏗️ Framework Structure

text
ElectroPi-QAAutomationAssessment/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── Logs/
│   │   │   │   └── LogUtils.java
│   │   │   │
│   │   │   └── Pages/
│   │   │       ├── LoginPage.java
│   │   │       ├── HomePage.java
│   │   │       ├── CartPage.java
│   │   │       ├── CheckoutInformationPage.java
│   │   │       └── ViewInvoiceAndConfirmOrderPage.java
│   │   │
│   │   └── resources/
│   │       ├── log4j2.properties
│   │       └── META-INF/
│   │
│   └── test/
│       └── java/
│           ├── CustomsListneres/
│           │   └── TestNGListenrs.java
│           │
│           └── Tests/
│               ├── BaseTest.java
│               ├── LoginTest.java
│               ├── HomeTest.java
│               ├── CartTest.java
│               ├── CheckoutInformationTest.java
│               ├── ViewInvoiceAndConfirmOrderTest.java
│               └── EndToEnd.java
│
├── testng.xml
├── pom.xml
└── .gitignore


---

## 🧩 Design Pattern

### Page Object Model (POM)

Each major page in the application has its own Page Object class.

For example:

text
LoginPage
HomePage
CartPage
CheckoutInformationPage
ViewInvoiceAndConfirmOrderPage


Each Page Object contains:

* Web elements / locators
* User actions
* Page-level validations

This separates test logic from UI interaction logic and makes the framework easier to maintain.

---

## 🧪 Automated Test Cases

### 1. Login Test

*Test:* validLoginTest

Validates that a user can successfully log in using valid credentials.

*Credentials:*

text
Username: standard_user
Password: secret_sauce


Expected result:

text
User is redirected to the Inventory page.


---

### 2. Add Product to Cart

*Test:* AddToCartTest

Validates that:

1. User logs in successfully.
2. Sauce Labs Backpack is added to the cart.
3. Cart counter is updated to 1.

---

### 3. Cart Validation

*Test:* ConfirmItemInCartTest

Validates that:

1. User logs in.
2. Product is added to the cart.
3. Cart page is opened.
4. Sauce Labs Backpack is displayed in the cart.
5. User can proceed to checkout.

---

### 4. Checkout Information

*Test:* validCheckoutInformationTest

Validates that the user can:

1. Login.
2. Add a product to the cart.
3. Navigate to the cart.
4. Proceed to checkout.
5. Enter first name, last name, and postal code.
6. Continue to the Checkout Overview page.

---

### 5. Order Review

*Test:* validViewInvoiceAndConfirmOrderTest

Validates that:

* The selected product is displayed.
* The total price is displayed.
* The Finish button can be clicked successfully.

---

### 6. End-to-End Order Flow

*Test:* validViewInvoiceAndConfirmOrderTest

The complete end-to-end scenario validates:

text
Login
  ↓
Add Product
  ↓
Open Cart
  ↓
Verify Product
  ↓
Checkout
  ↓
Enter Customer Information
  ↓
Verify Checkout Overview
  ↓
Verify Product
  ↓
Verify Total Price
  ↓
Complete Order
  ↓
Verify Order Confirmation


The final expected message is:

text
Thank you for your order!


---

## ⏳ Explicit Waits

The framework uses Selenium's WebDriverWait and ExpectedConditions where synchronization is required.

Example:

java
wait.until(ExpectedConditions.elementToBeClickable(CheckoutButton));


This helps reduce timing-related failures caused by elements not being ready for interaction.

---

## 🔄 Retry Mechanism

A custom TestNG retry analyzer is implemented in:

text
TestNGListenrs.java


Failed tests are retried once.

java
if (result.getStatus() == ITestResult.FAILURE && attempts == 0) {
    attempts++;
    return true;
}


This can help identify temporary or intermittent failures during test execution.

> Note: Retry should not be used to hide genuine product defects. A test that fails consistently should be investigated rather than simply relying on retries.

---

## 📝 Logging

The project uses *Log4j2* for execution logging.

Logging utility:

text
src/main/java/Logs/LogUtils.java


Example:

java
LogUtils.info("Item added to cart successfully");


Logs are useful for understanding the execution flow and troubleshooting failures.

---

## 📊 Allure Reporting

The project is integrated with *Allure Reports* to provide detailed test execution results.

Allure can provide information such as:

* Test status
* Test duration
* Test suites
* Test cases
* Execution history
* Failed tests

After running the tests, Allure results are generated under:

text
target/allure-results


If Allure CLI is installed, you can open the report with:

bash
allure serve target/allure-results


---

## 🚀 How to Run the Project

### Prerequisites

Make sure the following are installed:

* Java 21
* Maven
* Google Chrome
* Git

Verify Java:

bash
java -version


Verify Maven:

bash
mvn -version


---

### Clone the Repository

bash
git clone <YOUR_GITHUB_REPOSITORY_URL>


Navigate to the project:

bash
cd ElectroPi-QAAutomationAssessment


---

### Run All Tests

Execute:

bash
mvn clean test


Maven will use the configured TestNG suite:

text
testng.xml


---

## 🧪 TestNG Suite

The testng.xml file contains the following test classes:

xml
<class name="Tests.LoginTest"/>
<class name="Tests.HomeTest"/>
<class name="Tests.CartTest"/>
<class name="Tests.CheckoutInformationTest"/>
<class name="Tests.ViewInvoiceAndConfirmOrderTest"/>
<class name="Tests.EndToEnd"/>


Running:

bash
mvn test


will execute the configured suite.

---

## 🔐 Test Data

The project currently uses SauceDemo's standard test user:

text
Username: standard_user
Password: secret_sauce


Checkout test data:

text
First Name: Mina
Last Name: Youssif
Postal Code: QA-99


---

## 🌐 Application Under Test

*Application:* SauceDemo

text
https://www.saucedemo.com/


The application is used as the target web application for the automation assessment.

---

## 🎯 Automation Scope

The current automation scope focuses on the core successful purchase flow:

| Area                   | Coverage |
| ---------------------- | -------- |
| Login                  | ✅        |
| Product Selection      | ✅        |
| Add to Cart            | ✅        |
| Cart Validation        | ✅        |
| Checkout Information   | ✅        |
| Checkout Overview      | ✅        |
| Total Price Validation | ✅        |
| Order Completion       | ✅        |
| End-to-End Flow        | ✅        |

The current suite mainly covers *positive / happy-path scenarios*.

---

 🔧 Framework Highlights

- Maintainability

Page Objects separate UI interaction from test scenarios.

### Reusability

Common browser setup and teardown are centralized in:

text
BaseTest.java


### Synchronization

Explicit waits are used for elements that require synchronization.

 Reporting

Allure is integrated for test execution reporting.

 Debugging

Log4j2 provides execution logs.

 Reliability

A TestNG retry mechanism is available for failed tests.

---

 📈 Possible Future Improvements

The framework can be extended with:

* Data-driven testing
* Negative test scenarios
* Parameterization using TestNG
* Configuration files for environment URLs
* Centralized test data management
* Screenshot capture on failure
* Better locator abstraction
* Parallel test execution
* Cross-browser testing
* CI/CD integration
* GitHub Actions
* Dockerized test execution
* API automation
* More comprehensive Allure annotations
* Environment-specific configuration

---

 -Author

-Mina Youssif

Software Quality Control / Test Automation Engineer

---

  License

This project was created as a QA automation assessment and learning project.
