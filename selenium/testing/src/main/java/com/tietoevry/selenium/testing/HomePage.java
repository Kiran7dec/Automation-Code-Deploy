package com.tietoevry.selenium.testing;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePage {
    protected static WebDriver driver;

    public HomePage() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void launchURL(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}