package lesson_19.pages;

import lesson_19.pages.LoginTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-course-01.andersenlab.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.enterEmail("mail@mail.by");
        loginPage.enterPassword("qwerty12");
        loginPage.clickLogin();
        // Assert login success, e.g., check for a dashboard element
    }

    @Test
    public void testInvalidEmail() {
        loginPage.enterEmail("invalid_email");
        loginPage.enterPassword("qwerty12");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email format");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
