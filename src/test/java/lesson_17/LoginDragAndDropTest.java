package lesson_17;

import lesson_17.pages.DragAndDropPage;
import lesson_17.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginDragAndDropTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private DragAndDropPage dragAndDropPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");

        loginPage = new LoginPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
    }

    @Test
    public void testDragAndDropFlow() throws InterruptedException {
        // Авторизация
        loginPage.enterEmail("mail@mail.by");
        loginPage.enterPassword("qwerty12");
        loginPage.clickSignIn();

        // Переход к Drag & Drop
        dragAndDropPage.openDragAndDrop();

        // Выполнение Drag and Drop
        dragAndDropPage.performDragAndDrop();

        // Завершение теста
        dragAndDropPage.clickFinish();

        // Проверка сообщения
        Assert.assertTrue(dragAndDropPage.isSuccessMessageDisplayed(), "Сообщение не отображается!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
