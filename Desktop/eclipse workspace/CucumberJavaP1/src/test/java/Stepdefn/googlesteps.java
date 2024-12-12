package Stepdefn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class googlesteps {

    WebDriver driver = null;

    @SuppressWarnings("deprecation")
    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("Browser is open");

        // Set the path to the ChromeDriver executable
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is: " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Driver/chromedriver.exe");

        // Initialize the WebDriver
        driver = new ChromeDriver();

        // Set an implicit wait of 30 seconds
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Google's homepage
        driver.get("https://www.google.com");
    }

    @When("user enters a text in search box")
    public void user_enters_a_text_in_search_box() throws InterruptedException {
        System.out.println("User enters a text");

        // Locate the Google search box element and enter a search query
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");

        Thread.sleep(2000);
    }

    @And("hits enter")
    public void hits_enter() {
        System.out.println("User hits enter");

        // Simulate hitting the Enter key in the search box
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("user is navigated to search results page")
    public void user_is_navigated_to_search_results_page() {
        System.out.println("User navigated to the search results page");

        // Verify if the title of the page contains "Selenium WebDriver"
        if(driver.getTitle().contains("Selenium WebDriver")) {
            System.out.println("Search successful, user navigated to search results page.");
        } else {
            System.out.println("Search failed or user was not navigated correctly.");
        }

        // Close the browser after the test
        driver.quit();
    }
}
