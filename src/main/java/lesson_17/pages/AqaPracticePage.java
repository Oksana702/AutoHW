package lesson_17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AqaPracticePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By aqaPracticeButton = By.xpath("//button[contains(text(),'AQA Practice')]");
    private By selectDropdown = By.xpath("//select[@id='select-menu']");
    private By countryDropdown = By.id("country");
    private By languageDropdown = By.id("language");
    private By typeDropdown = By.id("type");
    private By startDateField = By.id("start-date");
    private By lastDateField = By.id("last-date");
    private By coursesDropdown = By.id("courses");
    private By searchButton = By.id("search-button");

    // Конструктор
    public AqaPracticePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Методы взаимодействия
    public void clickAqaPractice() {
        wait.until(ExpectedConditions.elementToBeClickable(aqaPracticeButton)).click();
    }

    public void selectOptionFromDropdown() {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(selectDropdown)));
        select.selectByVisibleText("Select");
    }

    public void selectCountry(String country) {
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
    }

    public void selectLanguage(String language) {
        new Select(driver.findElement(languageDropdown)).selectByVisibleText(language);
    }

    public void selectType(String type) {
        new Select(driver.findElement(typeDropdown)).selectByVisibleText(type);
    }

    public void setStartAndLastDates() {
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.plusDays((8 - today.getDayOfWeek().getValue()) % 7);
        LocalDate lastDate = startDate.plusWeeks(2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        driver.findElement(startDateField).sendKeys(startDate.format(formatter));
        driver.findElement(lastDateField).sendKeys(lastDate.format(formatter));
    }

    public void selectCourses(String... courses) {
        Select select = new Select(driver.findElement(coursesDropdown));
        for (String course : courses) {
            select.selectByVisibleText(course);
        }
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}
