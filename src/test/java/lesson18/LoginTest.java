package lesson18;

import pages.LoginPage;
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
        // Add assertion to verify login success (e.g., check for the presence of a logout button or dashboard)
    }

    @Test
    public void testInvalidEmailAndPassword() {
        loginPage.enterEmail("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ@bk.ru70");
        loginPage.enterPassword("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ@bk.ru70");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password");
    }

    @Test
    public void testInvalidEmailFormat1() {
        loginPage.enterEmail("User@bk.ru");
        loginPage.enterPassword("qwerty12");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email format");
    }

    @Test
    public void testInvalidEmailFormat2() {
        loginPage.enterEmail("User@bkru");
        loginPage.enterPassword("qwerty12");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email format");
    }

    @Test
    public void testInvalidEmailFormat3() {
        loginPage.enterEmail("User@bk");
        loginPage.enterPassword("qwerty12");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email format");
    }

    @Test
    public void testInvalidEmailFormat4() {
        loginPage.enterEmail("Userbk.ru");
        loginPage.enterPassword("qwerty12");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email format");
    }

    @Test
    public void testEmptyEmail() {
        loginPage.enterEmail("");
        loginPage.enterPassword("qwerty12");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Email cannot be empty");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
