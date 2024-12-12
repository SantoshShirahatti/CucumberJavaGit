package Stepdefn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;
import Pages.loginpagefactory;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import java.io.File;  // Import the File class

public class pagefactorydefn {

    WebDriver driver;
    loginpagefactory loginPage;
    

    @Before
    public void setUp() {
//        // Setup WebDriver before each scenario
//        String projectPath = System.getProperty("user.dir");
//        System.out.println("Project path is: " + projectPath);
//        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Driver/chromedriver.exe");
//
//        driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);  // Increased page load timeout
//        driver.manage().window().maximize();
    	
    	
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	driver = new ChromeDriver(options);
    	driver.manage().window().maximize();
    }

    @Given("the user is on the login page done")
    public void user_is_on_login_page() {
       
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new loginpagefactory(driver);  // Initialize the page object
    }

    @When("the user enters respective username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("the user clicks the login button done")
    public void user_clicks_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be navigated to the dashboard done")
    public void user_is_navigated_to_dashboard() {
        // Validate the user is navigated to the dashboard
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        // Close the driver
        driver.quit();
    }
    
    @When("the user enters respective username {string} and password {string} done")
    public void the_user_enters_respective_username_and_password_done(String username, String password) {
    	 loginPage.enterUsername(username);
         loginPage.enterPassword(password);
    }

}
