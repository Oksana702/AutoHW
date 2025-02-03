package lesson14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Page URL: " + driver.getCurrentUrl());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

    }
}
