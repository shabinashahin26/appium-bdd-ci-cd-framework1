package com.framework.hooks;

import com.framework.drivermanager.DriverManager;
import com.framework.utilities.Log;
import com.framework.utilities.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    /*
     * Executes before every scenario
     * Used for driver initialization and execution logging
     */
    @Before
    public void setup(Scenario scenario) {

        Log.logger.info(
                "========================================"
        );

        Log.logger.info(
                "Starting Scenario: "
                        + scenario.getName()
        );

        // Initialize Appium driver
        DriverManager.initDriver();

        Log.logger.info(
                "Driver Initialized Successfully"
        );
    }


    /*
     * Executes after every scenario
     * Used for screenshot capture, logging, and cleanup
     */
    @After
    public void teardown(Scenario scenario) {

        try {

            // Capture failure screenshot
            if (scenario.isFailed()) {

                Log.logger.error(
                        "Scenario Failed: "
                                + scenario.getName()
                );

                String screenshotPath =
                        ScreenshotUtil.captureScreenshot(
                                scenario.getName()
                        );

                Log.logger.info(
                        "Screenshot Captured: "
                                + screenshotPath
                );
            }

            else {

                Log.logger.info(
                        "Scenario Passed: "
                                + scenario.getName()
                );
            }

        } catch (Exception e) {

            Log.logger.error(
                    "Error during teardown: "
                            + e.getMessage()
            );
        }

        finally {

            // Quit Appium driver
            DriverManager.quitDriver();

            Log.logger.info(
                    "Driver Closed Successfully"
            );

            Log.logger.info(
                    "Ending Scenario: "
                            + scenario.getName()
            );

            Log.logger.info(
                    "========================================"
            );
        }
    }
}