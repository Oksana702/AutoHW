package lesson18;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import lesson18.RegistrationPage;

public class RegistrationTests {

    @Test
    public void testValidRegistration() {
        // Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-course-01.andersenlab.dev/registration");

        // PageObject
        lesson18.RegistrationPage registrationPage = new lesson18.RegistrationPage(driver);

        // Test data
        String validUsername = "testuser";
        String validPassword = "password123";

        // Test steps
        registrationPage.enterUsername(validUsername);
        registrationPage.enterPassword(validPassword);
        registrationPage.clickSubmit();

        // Assertions
        String successMessage = registrationPage.getSuccessMessage();
        Assert.assertEquals("Registration successful!", successMessage);

        // Teardown
        driver.quit();
    }
}

