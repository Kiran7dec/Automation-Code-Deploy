package com.tietoevry.selenium.testing;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class OpenChromeBrowser {

	public static void main(String[] args) {
	
		 WebDriverManager.chromedriver().setup();

	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        // Open Google
	        driver.get("https://www.w3schools.com/");// Open URL
	        
	        WebElement javaPageLink = driver.findElement(By.linkText("JAVA"));//href 
	        javaPageLink.click();
	        
	        //To handle accept all cookies pop-up
	        WebElement findByAcceptCookies = driver.findElement(By.id("accept-choices"));
	        findByAcceptCookies.click(); 
	        
	        WebElement javaDataTypeLink = driver.findElement(By.linkText("Java Data Types"));
	        javaDataTypeLink.click();

	        
	        WebElement FindByIDexercise = driver.findElement(By.id("exercisecontainer"));

            // Scroll to the element
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FindByIDexercise);

            WebElement FindbyXpathExcerciseQuestion = driver.findElement(By.xpath("//div[@id='exercisecontainer']/p"));
            String actualText = FindbyXpathExcerciseQuestion.getText();
            String expectedText = "What is an int in Java?";
           // System.out.print(actualText);
	        if(actualText.equals(expectedText)) {
	        	WebElement answerradioButton = driver.findElement(By.xpath("//div[@class='quizoption']//input[@id='quizoption0']"));
	        	answerradioButton.click();
	        	WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit Answer »']"));
	        //	System.out.print(submitButton.getText());
	        	submitButton.click();
	        	
	        	
	        	WebDriverWait wait = new WebDriverWait(driver,10);
	            wait.until(ExpectedConditions.numberOfWindowsToBe(2));  // Wait until there are two windows

	            // Get all window handles
	            Set<String> windowHandles = driver.getWindowHandles();
	            String currentWindowHandle = driver.getWindowHandle();  // Get the current window handle
	            String newTabHandle = null;

	            // Loop through the window handles and find the new tab's handle
	            for (String handle : windowHandles) {
	                if (!handle.equals(currentWindowHandle)) {
	                    newTabHandle = handle;
	                    break;
	                }
	            }

	            // Switch to the new tab
	            driver.switchTo().window(newTabHandle);

	            // Perform actions on the new tab (e.g., validate content)
	            WebElement parentDiv = driver.findElement(By.xpath("//div[@class='exercisewindow']"));

	         // Check if the parent <div> contains a child <div> with a specific class or other attribute
	         WebElement childDiv = parentDiv.findElement(By.xpath(".//div[@class='correctanswer']"));
	         if (childDiv != null) {
	        	 WebElement correctAnswer = childDiv.findElement(By.tagName("h2"));
	        	 System.out.println(correctAnswer.getText());
	        	 Assert.assertEquals("Correct Answer!", correctAnswer.getText());
	             System.out.println("Assertion passed: Heading text matches expected.");

	         } else {
	             System.out.println("Wrong Answer");
	         }
	         driver.switchTo().window(currentWindowHandle); 
	        }
	        
	        //Dynamic Page Testing
	        WebElement searchField = driver.findElement(By.id("tnb-google-search-input")); // Replace with the actual ID
	        searchField.sendKeys("Python");
	        List<WebElement> searchSuggestionField = driver.findElements(By.id("tnb-search-suggestions")); // Replace with the actual ID
	        for (WebElement suggestion : searchSuggestionField) {
                if (suggestion.getText().contains("Python Certificate")) { // Replace with your desired condition
                    Actions actions = new Actions(driver);
                    actions.moveToElement(suggestion).click().perform();
                    break;
                }
               
            } 
	        WebElement privacypopup = driver.findElement(By.id("shopify-pc__banner__btn-accept"));
	        privacypopup.click();
	        
        
	        // Close the browser
	    //    driver.quit();
	    }
}
