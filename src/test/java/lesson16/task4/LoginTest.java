package lesson16.task4;

import java.util.Random;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @DataProvider(name = "userCredentials")
    public Object[][] createUserData() {
        Random random = new Random();  // Создаём объект Random

        return new Object[][] {
                { "user" + random.nextInt(1000), "password" + random.nextInt(1000) },
                { "user" + random.nextInt(1000), "password" + random.nextInt(1000) },
                { "user" + random.nextInt(1000), "password" + random.nextInt(1000) }
        };
    }

    @Test(dataProvider = "userCredentials")
    public void testLogin(String username, String password) {
        System.out.println("Username: " + username + ", Password: " + password);

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://qa-course-01.andersenlab.com/");

            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));


            usernameField.sendKeys(username);
            passwordField.sendKeys(password);


            loginButton.click();

            WebElement userProfile = driver.findElement(By.id("userProfile"));
            assert userProfile.isDisplayed();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}