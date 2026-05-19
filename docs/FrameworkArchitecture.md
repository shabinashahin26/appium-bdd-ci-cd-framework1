# Framework Architecture

## Overview

This framework is built using:
- Java
- Appium
- Selenium
- TestNG
- Cucumber BDD
- Maven
- Jenkins


---

# Framework Design

The framework follows scalable enterprise-level architecture with:
- Page Object Model
- ThreadLocal Driver Management
- Environment-Based Execution
- Centralized Utilities
- CI/CD Integration


---

# Main Components

## DriverManager

Responsible for:
- Driver initialization
- Capability management
- ThreadLocal driver handling
- Driver cleanup


### Features

- Parallel-ready architecture
- Dynamic environment execution
- Centralized capability management


---

# ConfigReader

Reads data from:

config.properties


Supports:
- QA environment
- UAT environment
- PROD environment


---

# Hooks

Used for:
- Driver setup
- Driver teardown
- Logging
- Screenshot handling


---

# ScreenshotUtil

Captures screenshots automatically on test failure.

Screenshots are stored inside:

screenshots/


---

# Retry Mechanism

RetryAnalyzer is implemented for flaky test handling.

Benefits:
- Reduces false failures
- Improves pipeline stability


---

# Logging Framework

Log4j is used for centralized logging.

Benefits:
- Better debugging
- Structured logs
- Execution tracking


---

# Reporting

Extent Reports are integrated for:
- Execution status
- Logs
- Failure screenshots
- Step-level reporting


---

# Jenkins CI/CD Integration

Framework is integrated with Jenkins pipeline for:
- Automated execution
- GitHub webhook triggering
- Report publishing
- Artifact handling


---

# Parallel Execution

Framework uses ThreadLocal architecture for parallel execution support.

Note:
True mobile parallel execution requires multiple devices/emulators.


---

# Folder Structure

src/main/java
src/test/java
src/test/resources
reports
screenshots
docs


---

# Execution Flow

GitHub Push
↓
Jenkins Trigger
↓
Maven Build
↓
Appium Execution
↓
Report Generation