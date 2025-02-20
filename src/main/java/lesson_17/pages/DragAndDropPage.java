package lesson_17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    private WebDriver driver;
    private Actions actions;

    // Локаторы
    private By aqaPracticeMenu = By.xpath("//div[contains(text(),'AQA Practice')]");
    private By dragAndDropOption = By.xpath("//div[normalize-space()='Drag & Drop']");

    private By manual1 = By.xpath("//span[@id='manual1']");
    private By targetManual1 = By.xpath("//div[@id='target-manual1']");

    private By manual2 = By.xpath("//span[@id='manual2']");
    private By targetManual2 = By.xpath("//div[@id='target-manual2']");

    private By auto1 = By.xpath("//span[@id='auto1']");
    private By targetAuto1 = By.xpath("//div[@id='target-auto1']");

    private By auto2 = By.xpath("//span[@id='auto2']");
    private By targetAuto2 = By.xpath("//div[@id='target-auto2']");

    private By finishButton = By.xpath("//button[@id='DragNDropPageFinishButton']");
    private By successMessage = By.xpath("//*[text()=\"Congratulations! Let's test for the best!\"]");

    // Конструктор
    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void openDragAndDrop() throws InterruptedException {
        driver.findElement(aqaPracticeMenu).click();
        Thread.sleep(3000);
        driver.findElement(dragAndDropOption).click();
        Thread.sleep(3000);
    }

    public void dragAndDrop(By sourceLocator, By targetLocator) throws InterruptedException {
        WebElement source = driver.findElement(sourceLocator);
        WebElement target = driver.findElement(targetLocator);
        actions.clickAndHold(source).moveToElement(target).release().build().perform();
        Thread.sleep(3000);
    }

    public void performDragAndDrop() throws InterruptedException {
        dragAndDrop(manual1, targetManual1);
        dragAndDrop(manual2, targetManual2);
        dragAndDrop(auto1, targetAuto1);
        dragAndDrop(auto2, targetAuto2);
    }

    public void clickFinish() throws InterruptedException {
        driver.findElement(finishButton).click();
        Thread.sleep(3000);
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
