package lesson_17;

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
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/");
    }

    @Test
    public void testCourseSearch() {
        // 1. Нажимаем "AQA Practice"
        WebElement aqaPracticeBtn = driver.findElement(By.xpath("//input[@name='AQA Practice']")); // Пример ID
        aqaPracticeBtn.click();

        // 2. Нажимаем на "Select"
        WebElement selectDropdown = driver.findElement(By.xpath("//input[//div[normalize-space()='Select']")); // Пример ID
        selectDropdown.click();

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
        WebElement lastDateInput = driver.findElement(By.xpath("//input[@name='start-date']"));
        lastDateInput.sendKeys(lastDateFormatted);

        // 9. Выбираем "AQA Java" и "AQA Python"
        List<WebElement> checkboxes = new Select(driver.findElement(By.xpath("//input[@title='End date']")));
        for (WebElement checkbox : checkboxes) {
            String label = checkbox.getText();
            if (label.equals("AQA Java") || label.equals("AQA Python")) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            }
        }

        // 10. Нажимаем на кнопку "Search"
        Select searchButton = new Select(driver.findElement(By.xpath("//button[@name='SelectPageSearchButton']")));
        searchButton.click();

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

