package lesson_20.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By emailField = By.xpath("//input[@placeholder='Enter email']");
    private By passwordField = By.xpath("//input[@placeholder='Enter password']");
    private By signInButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//div[@class='error-message']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
