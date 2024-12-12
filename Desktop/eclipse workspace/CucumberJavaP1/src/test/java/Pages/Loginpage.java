package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage {

    WebDriver driver;

    // Locators
    By LoginUsername = By.name("username");
    By Loginpassword = By.name("password");
    By Loginbtn = By.xpath("//button[contains(@class, 'orangehrm-login-button')]");

    // Constructor
    public Loginpage(WebDriver driver) {
        this.driver = driver;
    }

    // Wait for the username element to be visible and then enter the username
    public void enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginUsername));
        usernameField.sendKeys(username);
    }

    // Wait for the password field to be visible and then enter the password
    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(Loginpassword));
        passwordField.sendKeys(password);
    }

    // Click login button
    public void clickLoginButton() {
        driver.findElement(Loginbtn).click();
    }
}
