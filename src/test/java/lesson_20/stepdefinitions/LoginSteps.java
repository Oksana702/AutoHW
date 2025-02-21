package lesson_20.stepdefinitions;

import lesson_20.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("пользователь находится на странице входа")
    public void пользователь_находится_на_странице_входа() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("он вводит {string} в поле Email")
    public void он_вводит_в_поле_email(String email) {
        loginPage.enterEmail(email);
    }

    @When("вводит {string} в поле Password")
    public void вводит_в_поле_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("нажимает на кнопку Sign in")
    public void нажимает_на_кнопку_sign_in() {
        loginPage.clickSignIn();
    }

    @Then("он должен успешно войти в систему")
    public void он_должен_успешно_войти_в_систему() {
        // Здесь можно добавить проверку перехода на главную страницу
        System.out.println("Пользователь успешно вошел в систему!");
        driver.quit();
    }

    @Then("он должен увидеть сообщение об ошибке {string}")
    public void он_должен_увидеть_сообщение_об_ошибке(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Сообщение об ошибке не совпадает!");
        driver.quit();
    }
}
