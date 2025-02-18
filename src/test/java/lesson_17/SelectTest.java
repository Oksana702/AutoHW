package lesson_17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SelectTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://qa-course-01.andersenlab.com/");
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        emailInput.sendKeys("mail@mail.by");
        passwordInput.sendKeys("qwerty12");
        loginButton.click();
    }

    @Test
    public void testCourseSearch() {
        // 1. Нажимаем "AQA Practice"
        driver.findElement(By.xpath("//input[@name='AQA Practice']")).click();

        // 2. Нажимаем на "Select"
        driver.findElement(By.xpath("//input[//div[normalize-space()='Select']")).click();

        // 3. Выбираем "Country -> USA"
        Select countrySelect = new Select(driver.findElement(By.xpath("//select[@title='Select country']")));
        countrySelect.selectByVisibleText("USA");


        // 4. Выбираем "Language -> English"
        Select languageSelect = new Select(driver.findElement(By.xpath("//select[@id='SelectLanguage']")));
        languageSelect.selectByVisibleText("English");

        // 5. Выбираем "Type -> Testing"
        Select typeSelect = new Select(driver.findElement(By.xpath("//select[@title='Select type']")));
        typeSelect.selectByVisibleText("Testing");

        // 6. Вычисляем дату следующего понедельника
        LocalDate today = LocalDate.now();
        LocalDate nextMonday = today.plusDays((8 - today.getDayOfWeek().getValue()) % 7);
        String startDate = nextMonday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 7. Указываем "Start Date"
        WebElement startDateInput = driver.findElement(By.xpath("//input[@title='Start date']"));
        startDateInput.sendKeys(startDate);

        // 8. "Last date" -> через 2 недели после Start Date
        LocalDate lastDate = nextMonday.plusWeeks(2);
        String lastDateFormatted = lastDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        WebElement lastDateInput = driver.findElement(By.xpath("//input[@title='End date']"));
        lastDateInput.sendKeys(lastDateFormatted);

        // 9. Выбираем "AQA Java" и "AQA Python"
        WebElement coursesDropdown = driver.findElement(By.xpath("//select[@title='Select courses']"));

        // Создаём объект Select
        Select select = new Select(coursesDropdown);

        // Выбираем курсы по ID (если поддерживается) или по тексту
        select.selectByVisibleText("AQA Java");  // Выбор по тексту
        select.selectByVisibleText("AQA Python");

        // 10. Нажимаем на кнопку "Search"
        driver.findElement(By.xpath("//button[@name='SelectPageSearchButton']")).click();

        // 11. Проверяем, что появилось сообщение "Unfortunately, we did not find any courses..."
        WebElement resultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("no-results-msg"))); // Пример ID
        String actualMessage = resultMessage.getText();
        String expectedMessage = "Unfortunately, we did not find any courses matching your chosen criteria.";
        Assert.assertEquals(actualMessage, expectedMessage, "Сообщение о результате поиска не совпадает!");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

