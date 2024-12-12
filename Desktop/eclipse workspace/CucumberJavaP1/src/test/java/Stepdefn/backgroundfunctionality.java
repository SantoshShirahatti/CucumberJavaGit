package Stepdefn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;
import Pages.loginpagefactory;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import java.time.Duration;

public class backgroundfunctionality {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // Set implicit wait for the whole session
    }

    @Given("the user is on the OrangeHRM login page")
    public void user_is_on_orangehrm_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters valid credentials {string} and {string}")
    public void user_enters_valid_credentials(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait for the username field to be clickable and enter username
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        usernameField.sendKeys(username);
        
        // Wait for the password field to be clickable and enter password
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        passwordField.sendKeys(password);
    }

    @And("the user clicks the login button")
    public void user_clicks_login_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the login button to be clickable and click it
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();
    }

    @Then("the user should be directed to the dashboard")
    public void user_is_navigated_to_dashboard() {
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @When("the user clicks on the {string} icon")
    public void user_clicks_icon(String icon) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the icon to be clickable and click it
        WebElement iconElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + icon + "']")));
        iconElement.click();
    }

    @Then("the user should see the status dropdown with {string} option")
    public void user_sees_status_dropdown(String option) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));  // Increase wait time

        // Wait for the second status dropdown (xpath targeting the second match)
        WebElement statusDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
        ));
        
        // Click the dropdown
        statusDropdown.click();
        
        // Wait for the enabled option to be visible
        WebElement enabledOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='" + option + "']")
        ));
        
        // Check if the option is displayed
        Assert.assertTrue(enabledOption.isDisplayed());
    }


    @When("the user clicks on the {string} button")
    public void user_clicks_button(String button) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the button to be clickable and click it
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + button + "']")));
        buttonElement.click();
    }

    @Then("the {string} button should be visible on the PIM page")
    public void reports_button_is_visible(String button) {
        // Create a wait object to handle waits
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait for the 4th element matching the provided XPath
        WebElement reportsButton = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='oxd-topbar-body-nav-tab-item']"))).get(3);

        // Verify that the text of the 4th button is "Reports" (ignoring case)
        Assert.assertEquals("Reports", reportsButton.getText());
        
        // Optionally, click the Reports button if needed
        // reportsButton.click();
    }
}