package lesson_17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class AutomationTest {

    @Test
    public void automateFormSubmission() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://qa-course-01.andersenlab.com/");

            // Выбираем страну -> USA
            Select countrySelect = new Select(driver.findElement(By.id("country")));
            countrySelect.selectByVisibleText("USA");

            // Выбираем язык -> English
            Select languageSelect = new Select(driver.findElement(By.id("language")));
            languageSelect.selectByVisibleText("English");

            // Выбираем тип -> Testing
            Select typeSelect = new Select(driver.findElement(By.id("type")));
            typeSelect.selectByVisibleText("Testing");

            // Определяем дату следующего понедельника
            Calendar calendar = Calendar.getInstance();
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            int daysUntilMonday = (Calendar.MONDAY - dayOfWeek + 7) % 7;  // Считаем до следующего понедельника
            calendar.add(Calendar.DAY_OF_YEAR, daysUntilMonday);  // Добавляем дни до понедельника

            // Форматируем дату
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String startDate = dateFormat.format(calendar.getTime());

            // Устанавливаем Start Date (следующий понедельник)
            WebElement startDateField = driver.findElement(By.id("start_date"));
            startDateField.sendKeys(startDate);

            // Вычисляем Last Date (через 2 недели)
            calendar.add(Calendar.WEEK_OF_YEAR, 2);  // Через 2 недели
            String lastDate = dateFormat.format(calendar.getTime());

            // Устанавливаем Last Date
            WebElement lastDateField = driver.findElement(By.id("last_date"));
            lastDateField.sendKeys(lastDate);

            // Выбираем курсы -> AQA Java и AQA Python
            WebElement aqaJavaCheckbox = driver.findElement(By.id("course_aqa_java"));
            WebElement aqaPythonCheckbox = driver.findElement(By.id("course_aqa_python"));
            if (!aqaJavaCheckbox.isSelected()) {
                aqaJavaCheckbox.click();
            }
            if (!aqaPythonCheckbox.isSelected()) {
                aqaPythonCheckbox.click();
            }

            // Отправляем форму (к примеру, через кнопку Submit)
            WebElement submitButton = driver.findElement(By.id("submit_button"));
            submitButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закрыть браузер
            driver.quit();
        }
    }
}
