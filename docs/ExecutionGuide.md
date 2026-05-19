# Execution Guide

## Local Execution

### Prerequisites

- Java 17
- Maven
- Appium
- Android Studio
- Emulator or Real Device


---

# Start Emulator

Verify device connection:

adb devices


Expected:

emulator-5554 device


---

# Start Appium Server

Command:

appium


Default URL:

http://127.0.0.1:4723


---

# Run Framework Locally

Command:

mvn clean test


---

# Tag-Based Execution

Smoke Execution:

mvn test -Dcucumber.filter.tags=@smoke


Regression Execution:

mvn test -Dcucumber.filter.tags=@regression


---

# Environment Execution

QA Execution:

mvn test -Denv=qa


UAT Execution:

mvn test -Denv=uat


PROD Execution:

mvn test -Denv=prod


---

# Jenkins Execution

Pipeline automatically starts when:
- code is pushed to GitHub
- webhook triggers Jenkins


---

# Generated Reports

Extent Report Location:

reports/ExtentReport.html


---

# Screenshot Handling

Failure screenshots are automatically captured and stored inside:

screenshots/


---

# Common Troubleshooting

## Device Not Detected

Run:

adb devices


---

# Appium Server Issue

Restart Appium:

appium


---

# APK Not Found

Verify APK exists inside:

src/test/resources/app/


---

# Jenkins Build Stuck

Verify:
- Appium already running
- Emulator already running
- adb device connected