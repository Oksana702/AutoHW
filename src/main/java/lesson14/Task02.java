package lesson14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Task02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String[] urls = {
                "http://www.automationpractice.pl/index.php",
                "https://zoo.waw.pl/",
                "https://www.w3schools.com/",
                "https://www.clickspeedtester.com/click-counter/",
                "https://andersenlab.com/"
        };

        for (String url : urls) {
            driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
            driver.get(url);
            Thread.sleep(2000);
        }
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        for (String tab : tabs) {
            driver.switchTo().window(tab);
            Thread.sleep(2000);

            String title = driver.getTitle();
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Страница: " + title + " | URL: " + currentUrl);


        if (title.contains("Zoo")) {
            driver.close();
        }
        }
        for (String tab: driver.getWindowHandles()) {
        driver.switchTo().window(tab);
        break;
        }

        Thread.sleep(3000);
        driver.quit();
        }
    }




