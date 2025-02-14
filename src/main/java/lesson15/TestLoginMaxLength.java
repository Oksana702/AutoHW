package lesson15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginMaxLength {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://qa-course-01.andersenlab.com/");
            WebElement emailInput = driver.findElement(By.name("email"));  // Проверьте name через DevTools
            WebElement passwordInput = driver.findElement(By.name("password"));

            emailInput.sendKeys("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ@bk.ru70");
            passwordInput.sendKeys("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY71");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();

            Thread.sleep(3000);

            if (driver.getCurrentUrl().contains("dashboard")) {
                System.out.println("Вход выполнен успешно!");
            } else {
                System.out.println("Ошибка входа!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
