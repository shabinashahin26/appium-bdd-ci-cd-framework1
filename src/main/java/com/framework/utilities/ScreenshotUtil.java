package com.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.drivermanager.DriverManager;

public class ScreenshotUtil {

    public static String captureScreenshot(String scenarioName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String screenshotPath =
                System.getProperty("user.dir")
                + "/reports/screenshots/"
                + scenarioName + "_" + timestamp + ".png";

        File srcFile = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);

        File destFile = new File(screenshotPath);

        try {

            FileUtils.copyFile(srcFile, destFile);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return screenshotPath;
    }
}