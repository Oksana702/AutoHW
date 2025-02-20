package lesson_17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By noCoursesMessage = By.xpath("//p[contains(text(),'Unfortunately, we did not find any courses matching')]");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public boolean isNoCoursesMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noCoursesMessage)).isDisplayed();
    }
}

