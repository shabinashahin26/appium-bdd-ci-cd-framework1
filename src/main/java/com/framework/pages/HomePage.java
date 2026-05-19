package com.framework.pages;

import com.framework.drivermanager.DriverManager;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;


public class HomePage {

    // Locator for home screen title
    private By title =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Hello Shabina CI/CD Demo v2\")"
            );

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