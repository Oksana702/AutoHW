package lesson_19;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test
    @Description("Test successful login with valid credentials")
    public void testValidLogin() {
        logger.info("Starting test for valid login");

        loginPage.enterEmail("mail@mail.by");
        loginPage.enterPassword("qwerty12");
        loginPage.clickLogin();

        // Log the result of the login test
        logger.info("Login was successful for user mail@mail.by");

        // Add assertions to check if login is successful
        Assert.assertTrue(isLoginSuccessful());
    }

    @Test
    @Description("Test login with invalid email")
    public void testInvalidEmail() {
        logger.info("Starting test for invalid email login");

        loginPage.enterEmail("invalid_email");
        loginPage.enterPassword("qwerty12");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        logger.error("Error message: " + errorMessage);

        Assert.assertEquals(errorMessage, "Invalid email format");
    }

    @Step("Enter email: {0}")
    public void enterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @Step("Enter password: {0}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Step("Click login button")
    public void clickLogin() {
        loginPage.clickLogin();
    }
}