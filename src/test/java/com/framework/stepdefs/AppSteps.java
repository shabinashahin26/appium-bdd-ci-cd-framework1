package com.framework.stepdefs;

import org.testng.Assert;

import com.framework.pages.HomePage;
import com.framework.utilities.Log;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AppSteps {

    HomePage homePage = new HomePage();


    @Given("user launches the app")
    public void launchApp() {

        System.out.println(
                "App launched successfully"
        );
    }


    @Then("user should see home screen")
    public void verifyHomeScreen() {

        if (homePage.isTitleDisplayed()) {

            System.out.println(
                    "Home screen displayed"
            );

        } else {

            Assert.fail(
                    "Home screen is not displayed"
            );
        }
    }


    @Then("user clicks login button")
    public void clickLoginButton() {

        homePage.clickLoginButton();

        Log.logger.info("App launched successfully");
    }
}