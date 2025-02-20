package lesson_17.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ActionsAlertsIframesPage {
    private WebDriver driver;
    private Actions actions;

    // Локаторы
    private By aqaPracticeMenu = By.xpath("//div[contains(text(),'AQA Practice')]");
    private By actionsAlertsIframesOption = By.xpath("//div[normalize-space()='Actions, Alerts & Iframes']");

    private By alertButton = By.xpath("//button[@id='AlertButton']");
    private By discountButton = By.xpath("//button[normalize-space()='Get Discount']");
    private By promptButton = By.xpath("/html/body/div/div/div[1]/div[3]/button");
    private By resultMessage = By.xpath("//p[@id='Result']");

    // Конструктор
    public ActionsAlertsIframesPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void openActionsAlertsIframes() throws InterruptedException {
        driver.findElement(aqaPracticeMenu).click();
        Thread.sleep(3000);
        driver.findElement(actionsAlertsIframesOption).click();
        Thread.sleep(3000);
    }

    public void handleAlert(String expectedText, String expectedResult) throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String resultText = driver.findElement(resultMessage).getText();
        if (!resultText.equals(expectedResult)) {
            throw new AssertionError("Ожидалось: " + expectedResult + ", но получено: " + resultText);
        }
    }

    public void clickAlertButton() throws InterruptedException {
        driver.findElement(alertButton).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        if (!alert.getText().equals("You have called alert!")) {
            throw new AssertionError("Текст Alert не совпадает!");
        }
        handleAlert("You have called alert!", "Congratulations, you have successfully enrolled in the course!");
    }

    public void clickDiscountButton() throws InterruptedException {
        driver.findElement(discountButton).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        if (!alert.getText().equals("Are you sure you want to apply the discount?")) {
            throw new AssertionError("Текст Alert не совпадает!");
        }
        handleAlert("Are you sure you want to apply the discount?", "You received a 10% discount on the second course.");
    }

    public void handlePromptAlert(String inputText) throws InterruptedException {
        driver.findElement(promptButton).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        if (!alert.getText().contains("Here you may describe a reason why you are cancelling your registration")) {
            throw new AssertionError("Текст Alert не совпадает!");
        }
        alert.sendKeys(inputText);
        alert.accept();
        Thread.sleep(3000);
        String resultText = driver.findElement(resultMessage).getText();
        if (!resultText.contains(inputText)) {
            throw new AssertionError("Результат не содержит введенное слово!");
        }
    }
}
