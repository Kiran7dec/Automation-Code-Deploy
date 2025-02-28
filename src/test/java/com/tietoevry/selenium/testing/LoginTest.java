package com.tietoevry.selenium.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tietoevry.selenium.testing.HomePage;
import com.tietoevry.selenium.testing.LoginPage;
import com.tietoevry.selenium.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends HomePage {

    @Test
    public void loginTest() {
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);

        // Perform login actions
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        // Wait to ensure the page has loaded after login
        try {
            Thread.sleep(2000); // Wait for elements to load (you can replace this with WebDriverWait)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify the URL to check if login is successful
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("secure"), "Login failed.");
        System.out.println("Login successful!");
    }
}