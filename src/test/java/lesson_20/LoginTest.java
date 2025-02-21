package lesson_20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import lesson_20.pages.LoginPage;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        // Указываем путь к драйверу
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Открываем страницу логина
        driver.get("https://qa-course-01.andersenlab.com/login");

        // Инициализируем LoginPage
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.enterEmail("mail@mail.by");
        loginPage.enterPassword("qwerty12");
        loginPage.clickSignIn();

        // Проверка (пример: проверить URL после логина)
        String expectedUrl = "https://qa-course-01.andersenlab.com/dashboard"; // Укажите правильный URL
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Ошибка: URL после логина не совпадает!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}