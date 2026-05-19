package com.framework.drivermanager;

import com.framework.utilities.ConfigReader;
import com.framework.utilities.Log;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DriverManager {

	/*
	 * ThreadLocal Driver Helps support parallel execution safely
	 */
	private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

	// Global driver getter
	public static AndroidDriver getDriver() {

		if (driver.get() == null) {

			throw new IllegalStateException("Driver is not initialized. Call initDriver() first.");
		}

		return driver.get();
	}

	// Driver initialization method
	public static void initDriver() {

		try {

			Log.logger.info("=== Initializing Appium Driver ===");

			/*
			 * Read active environment dynamically Example: qa / uat / prod
			 */
			String env = ConfigReader.get("env");

			Log.logger.info("Running Environment: " + env.toUpperCase());

			/*
			 * Read environment-specific values from config.properties
			 */
			String platform = ConfigReader.get(env + ".platformName");

			String device = ConfigReader.get(env + ".deviceName");

			String platformVersion = ConfigReader.get(env + ".platformVersion");

			String automationName = ConfigReader.get(env + ".automationName");

			String appiumURL = ConfigReader.get(env + ".appiumURL");

			String apkRelativePath = ConfigReader.get(env + ".apkPath");

			/*
			 * Build complete APK absolute path
			 */
			String appPath = System.getProperty("user.dir") + "/" + apkRelativePath;

			/*
			 * Validate APK existence
			 */
			if (!Files.exists(Paths.get(appPath))) {

				throw new RuntimeException("APK not found at path: " + appPath);
			}

			// Desired Capabilities
			DesiredCapabilities caps = new DesiredCapabilities();

			// Platform capabilities
			caps.setCapability("platformName", platform);

			caps.setCapability("deviceName", device);

			caps.setCapability("platformVersion", platformVersion);

			caps.setCapability("automationName", automationName);
			
			caps.setCapability("uiautomator2ServerInstallTimeout", 60000);

			caps.setCapability("adbExecTimeout", 60000);
			
			caps.setCapability("newCommandTimeout", 300);

			// Application capability
			caps.setCapability("app", appPath);

			/*
			 * Automatically grant permissions
			 */
			caps.setCapability("autoGrantPermissions", true);

			/*
			 * Reuse existing app session Improves execution speed
			 */
			caps.setCapability("noReset", true);

			/*
			 * Keep Appium session alive
			 */
			caps.setCapability("newCommandTimeout", 300);

			// Execution logs
			Log.logger.info("Platform: " + platform);

			Log.logger.info("Device: " + device);

			Log.logger.info("Platform Version: " + platformVersion);

			Log.logger.info("Automation Name: " + automationName);

			Log.logger.info("APK Path: " + appPath);

			Log.logger.info("Appium URL: " + appiumURL);

			// Create Appium server URL
			URL url = new URL(appiumURL);

			/*
			 * Future scalable architecture for Android and iOS support
			 */

			AndroidDriver driverInstance = new AndroidDriver(url, caps);

			// Store driver inside ThreadLocal
			driver.set(driverInstance);

			Log.logger.info("=== Driver Initialized Successfully ===");

		} catch (Exception e) {

			Log.logger.error("Driver Initialization Failed: " + e.getMessage());

			throw new RuntimeException("Failed to initialize driver: " + e.getMessage(), e);
		}
	}

	// Driver quit method
	public static void quitDriver() {

		if (driver.get() != null) {

			Log.logger.info("=== Quitting Driver ===");

			driver.get().quit();

			// Remove ThreadLocal instance
			driver.remove();

			Log.logger.info("Driver Closed Successfully");
		}
	}
}

/*
 * if (mobilePlatform.equalsIgnoreCase("android")) {
 * 
 * // AndroidDriver initialization } else if
 * (mobilePlatform.equalsIgnoreCase("ios")) {
 * 
 * // IOSDriver initialization }
 * 
 * ================================================= String mobilePlatform =
 * ConfigReader.get( env + ".platform" );
 */