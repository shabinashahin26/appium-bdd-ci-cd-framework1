# Appium BDD CI/CD Automation Framework

## Project Overview

This project is a Mobile Automation Testing Framework developed using Appium, Java, Selenium, Cucumber, TestNG, Maven, and Jenkins CI/CD integration.

The framework is designed to automate Android mobile application testing using the BDD (Behavior Driven Development) approach and follows real-time industry automation practices used in product-based environments similar to OkCredit.

The primary objective of this framework is to support scalable, maintainable, and automated mobile test execution through CI/CD pipelines.

---

# Key Features

- Android Mobile Automation using Appium
- BDD Framework using Cucumber
- Test Execution using TestNG
- Maven Build Management
- Jenkins CI/CD Integration
- APK Artifact Management
- Parameterized Pipeline Execution
- GitHub Version Control Integration
- Real Device & Emulator Support
- Reporting & Logging Support
- Reusable Framework Architecture

---

# Tech Stack

| Technology | Usage |
|------------|-------|
| Java | Programming Language |
| Appium | Mobile Automation |
| Selenium | UI Interaction |
| Cucumber | BDD Framework |
| TestNG | Test Execution |
| Maven | Dependency Management |
| Jenkins | CI/CD Pipeline |
| GitHub | Version Control |
| Android Studio | Emulator Management |
| ADB | Android Device Connection |
| Log4j | Logging |
| Extent Reports | Reporting |

---

# Framework Architecture

```text
appium-bdd-ci-cd-framework
│
├── src/test/java
│   ├── runners
│   ├── stepdefinitions
│   ├── pages
│   ├── utils
│   ├── hooks
│
├── src/test/resources
│   ├── features
│   ├── config
│   ├── app
│
├── reports
├── screenshots
├── logs
├── test-output
│
├── pom.xml
├── Jenkinsfile
├── README.md
```

---

# Framework Objective

The framework was developed to automate Android application testing and integrate execution with Jenkins CI/CD pipelines for continuous testing.

The framework is designed considering real-time automation challenges such as:

- Frequent mobile releases
- Regression execution
- APK handling
- Device compatibility
- Automated build execution
- Reporting and debugging
- CI/CD integration

---

# BDD Cucumber Framework

Feature files are written using Gherkin syntax for better readability and collaboration.

## Example Feature File

```gherkin
Feature: Login Functionality

Scenario: Verify user login
Given User launches the app
When User enters valid credentials
Then User should login successfully
```

## Benefits

- Easy to understand test scenarios
- Better collaboration between QA and business teams
- Reusable step definitions
- Easy maintenance and scalability

---

# Jenkins CI/CD Integration

The framework is integrated with Jenkins Pipeline for automated build and execution.

## Jenkins Features Implemented

- Automated Maven build execution
- Scheduled execution using cron jobs
- Parameterized pipeline execution
- APK artifact publishing
- Build history maintenance
- Console log generation
- Success/failure tracking

---

# Jenkins CI/CD Flow

```text
GitHub Push
      ↓
Jenkins Trigger
      ↓
Maven Build
      ↓
APK Execution
      ↓
Test Execution
      ↓
Report Generation
      ↓
Artifact Publishing
```

---

# APK Management

The framework supports APK handling through Jenkins artifacts.

## APK Location

```text
src/test/resources/app/ci-cd-demo-app.apk
```

Artifacts are automatically published after successful execution.

---

# Maven Commands

## Clean Project

```bash
mvn clean
```

## Install Dependencies

```bash
mvn install
```

## Run Tests

```bash
mvn test
```

## Execute Specific Tags

```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

---

# Appium Commands

## Start Appium Server

```bash
appium
```

## Verify Connected Device

```bash
adb devices
```

---

# Desired Capabilities Example

```java
DesiredCapabilities caps = new DesiredCapabilities();

caps.setCapability("platformName", "Android");
caps.setCapability("deviceName", "Android Emulator");
caps.setCapability("automationName", "UiAutomator2");
caps.setCapability("app", "src/test/resources/app/ci-cd-demo-app.apk");
```

---

# Reporting & Logging

The framework currently supports:

- Jenkins Console Logs
- HTML Report Publishing
- APK Artifact Publishing
- Log4j Logging

Future enhancements:
- Allure Reports
- Screenshot Capturing
- Email Reporting

---

# GitHub Integration

The project is integrated with GitHub for:

- Source code management
- Branch management
- Version control
- CI/CD pipeline integration

## Basic Git Commands

```bash
git init
git add .
git commit -m "Initial commit"
git push origin main
```

---

# Real-Time Project Experience Mapping (OkCredit Related)

The below activities are based on real-time project experience handled in product-based environments similar to OkCredit.

## Responsibilities Handled

- Android mobile application testing
- Regression testing execution
- Smoke testing
- Functional testing
- Jira defect tracking
- Agile sprint participation
- Automation support using Appium
- Locator fixing and script maintenance
- CI/CD execution monitoring
- GitHub code handling

---

# Real-Time API Testing Experience

As part of real-time project exposure, API testing activities were performed using Postman for backend validation and service verification.

## Activities Performed

- Request validation
- Response validation
- Error handling validation
- Multiple dataset testing
- Authentication validation
- Status code verification
- Negative scenario testing

## HTTP Methods Used

- GET
- POST
- PUT
- PATCH
- DELETE

---

# Real-Time Database Validation Experience

As part of real-time project exposure, database validation activities were performed using SQL queries for backend data verification and consistency checks.

## Database Validations Performed

- User onboarding verification
- Transaction validation
- PAN and Aadhaar verification
- Interest calculation verification
- Merchant transaction validation
- API reflected data validation
- Backend consistency verification

## Example SQL Query

```sql
SELECT * FROM transactions
WHERE merchant_id = '12345';
```

---

# Agile Methodology

Project follows Agile methodology with:

- Sprint planning
- Daily standups
- Regression cycles
- Bug tracking
- Release validation
- UAT support

## Tools Used

- Jira
- Jenkins
- GitHub
- Postman
- PostgreSQL
- Android Studio

---

# Future Enhancements

Planned improvements for the framework:

- Allure Reporting
- Parallel Device Execution
- Docker Integration
- GitHub Webhook Trigger
- Automatic Appium Server Management
- Cross-platform execution
- BrowserStack/Sauce Labs integration

---

# Execution Steps

## Clone Repository

```bash
git clone <repository-url>
```

## Navigate to Project

```bash
cd appium-bdd-ci-cd-framework
```

## Install Dependencies

```bash
mvn clean install
```

## Start Appium Server

```bash
appium
```

## Connect Device

```bash
adb devices
```

## Execute Tests

```bash
mvn test
```

---

Webhook CI/CD testing from Jenkins


This is a test ngrok 

WHAT YOU HAVE NOW

Your framework supports:

✅ Appium + Java
✅ Cucumber BDD
✅ TestNG
✅ Maven
✅ Jenkins CI/CD
✅ GitHub Webhook Trigger
✅ ngrok Integration
✅ Dynamic Environment Execution
✅ Retry Mechanism
✅ Screenshot on Failure
✅ Extent Reporting
✅ Parallel-Ready Architecture
✅ ThreadLocal Driver Management
✅ Config-Driven Framework
✅ APK-Based CI Flow
✅ Automated Report Publishing

# Interview Summary

Developed and maintained a Mobile Automation Framework using Appium, Java, Selenium, Cucumber, and TestNG with Jenkins CI/CD integration. Worked on Android automation, regression execution, GitHub integration, Jenkins pipeline execution, API validation exposure, database validation exposure, and Agile-based testing activities in product-based environments similar to OkCredit.


##### WebHook testing on jenkins
#########Webhook trigger test final
---

# Author

Shabina Shahin

QA Engineer | Mobile Automation Tester | Appium | CI/CD | API Testing | SQL | Agile Testing
