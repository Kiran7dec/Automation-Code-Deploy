package com.tietoevry.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemovePage {
    private WebDriver driver;

    public AddRemovePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By addButton = By.xpath("//button[text()='Add Element']");
    private By deleteButtons = By.cssSelector(".added-manually");

    // Actions
    public void clickAddElement() {
        driver.findElement(addButton).click();
    }

    public boolean isDeleteButtonVisible() {
        return driver.findElements(deleteButtons).size() > 0;
    }

    public void clickDeleteButton() {
        if (isDeleteButtonVisible()) {
            driver.findElements(deleteButtons).get(0).click();
        }
    }
}