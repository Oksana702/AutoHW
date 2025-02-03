package lesson14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomation {
    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

    WebDriver driver = new ChromeDriver();
    driver.get("https://qa-course.andersenlab.com/");
    Thread.sleep(3000);

    // Кликаем на кнопку входа
    WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
    loginButton.click();
    Thread.sleep(2000);

    // Вводим email и пароль
    WebElement emailField = driver.findElement(By.name("email"));
    WebElement passwordField = driver.findElement(By.name("password"));

    emailField.sendKeys("your_email@example.com");
    passwordField.sendKeys("your_password");
    passwordField.sendKeys(Keys.RETURN);

    // Ожидаем загрузку
    Thread.sleep(5000);

    // Проверяем успешный вход
    try {
        WebElement logoutButton = driver.findElement(By.xpath("//button[contains(text(), 'Logout')]"));
        System.out.println("Авторизация успешна!");
    } catch (Exception e) {
        System.out.println("Ошибка авторизации!");
    }

    // Закрываем браузер
    driver.quit();

}

}
