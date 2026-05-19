package com.framework.pages;

import com.framework.drivermanager.DriverManager;
import org.openqa.selenium.By;

public class HomePage {

    // Locator for title text
    private By title =
            By.xpath("//*[contains(@text,'Hello')]");

    // Locator for LOGIN button
    private By loginButton =
            By.xpath("//*[@text='LOGIN']");

    // Verify title displayed
    public boolean isTitleDisplayed() {

        return DriverManager
                .getDriver()
                .findElement(title)
                .isDisplayed();
    }

    // Click login button
    public void clickLoginButton() {

        DriverManager
                .getDriver()
                .findElement(loginButton)
                .click();
    }
}