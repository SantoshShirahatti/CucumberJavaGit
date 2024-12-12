package Stepdefn;

import Pages.Loginpage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class EndtoEndloginpom {

    WebDriver driver;
    Loginpage login;

    @Before
    public void setUp() {
        // Set up WebDriver before each scenario
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver(); // Initialize WebDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        
        // Initialize Loginpage with WebDriver
        login = PageFactory.initElements(driver, Loginpage.class);
    }

    @Given("the user opens the browser and navigates to the login page")
    public void open_browser_and_navigate_to_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters username {string} and password {string}")
    public void user_enters_valid_credentials(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @And("the user clicks on login button")
    public void user_clicks_login_button() {
        login.clickLoginButton();
    }

    @Then("the user should be navigated to the dashboard")
    public void user_is_navigated_to_dashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains("OrangeHRM"));
        
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        
        // Assert that the title matches to confirm successful login
        assert expectedTitle.equals(actualTitle) : "Login failed!";
    }

    @After
    public void tearDown() {
        // Quit WebDriver after each scenario
        if (driver != null) {
            driver.quit();
        }
    }
}
