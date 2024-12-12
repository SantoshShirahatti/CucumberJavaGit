package Stepdefn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;
import java.util.concurrent.TimeUnit; // Add this import

public class EndtoEndlogin {

    WebDriver driver;

//    @Before
    public void setUp() {
        // Setup WebDriver before each scenario
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is: " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Driver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);  // Increased page load timeout
        driver.manage().window().maximize();
    }

    @Given("the user is on the login page ok")
    public void browser_is_open() {
    	String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is: " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Driver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);  // Increased page load timeout
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters credentials ok username {string} and password {string}")
    public void user_enters_valid_credentials(String username, String password) {
        // Explicit wait for username field to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("the user ok clicks on the login button")
    public void user_clicks_login_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("the user is navigated to the dashboard")
    public void user_is_navigated_to_dashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));  // Assuming "welcome" element exists post-login

        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        System.out.println("Actual page title: " + actualTitle);
        Assert.assertEquals("Login successful. User is on the dashboard.", expectedTitle, actualTitle);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
