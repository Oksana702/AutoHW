package lesson_17;

import lesson_17.pages.ActionsAlertsIframesPage;
import lesson_17.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsAlertsIframesTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ActionsAlertsIframesPage actionsAlertsIframesPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");

        loginPage = new LoginPage(driver);
        actionsAlertsIframesPage = new ActionsAlertsIframesPage(driver);
    }

    @Test
    public void testActionsAlertsIframes() throws InterruptedException {
        // Авторизация
        loginPage.enterEmail("mail@mail.by");
        loginPage.enterPassword("qwerty12");
        loginPage.clickSignIn();

        // Переход к Actions, Alerts & Iframes
        actionsAlertsIframesPage.openActionsAlertsIframes();

        // Работа с алертами
        actionsAlertsIframesPage.clickAlertButton();
        actionsAlertsIframesPage.clickDiscountButton();
        actionsAlertsIframesPage.handlePromptAlert("Test");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

