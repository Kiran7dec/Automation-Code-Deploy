package com.tietoevry.selenium.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tietoevry.selenium.testing.AddRemovePage;
import com.tietoevry.selenium.testing.HomePage;

public class AddRemoveTest extends HomePage {

    @Test
    public void addAndRemoveTest() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        AddRemovePage addRemovePage = new AddRemovePage(driver);

        // Click Add Element
        addRemovePage.clickAddElement();
        
        // Wait for the element to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify the element is visible after adding
        Assert.assertTrue(addRemovePage.isDeleteButtonVisible(), "Add operation failed.");

        // Perform delete operation
        addRemovePage.clickDeleteButton();

        // Wait for removal
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the delete button is no longer visible
        Assert.assertFalse(addRemovePage.isDeleteButtonVisible(), "Delete operation failed.");

        System.out.println("Add and Remove test successful.");
    }
}