package lesson_17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Локаторы
    private By emailField = By.xpath("//input[@placeholder='Enter email']");
    private By passwordField = By.xpath("//input[@placeholder='Enter password']");
    private By signInButton = By.xpath("//button[@type='submit']");

    // Конструктор
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) throws InterruptedException {
        driver.findElement(emailField).sendKeys(email);
        Thread.sleep(3000);
    }

    public void enterPassword(String password) throws InterruptedException {
        driver.findElement(passwordField).sendKeys(password);
        Thread.sleep(3000);
    }

    public void clickSignIn() throws InterruptedException {
        driver.findElement(signInButton).click();
        Thread.sleep(3000);
    }
}