# Jenkins Setup Guide

## Overview

This framework is integrated with Jenkins CI/CD pipeline for automated mobile application execution using Appium.

The pipeline supports:
- GitHub webhook integration
- Automated Maven execution
- Appium mobile testing
- Extent report publishing
- APK artifact handling


---

# Jenkins Installation

1. Install Java 17
2. Install Jenkins
3. Configure Maven inside Jenkins
4. Install required Jenkins plugins


---

# Required Jenkins Plugins

- Git Plugin
- Pipeline Plugin
- HTML Publisher Plugin
- JUnit Plugin
- Workspace Cleanup Plugin


---

# GitHub Webhook Integration

GitHub webhooks are used to trigger Jenkins automatically whenever code is pushed to GitHub.

Webhook Flow:

GitHub Push
↓
Webhook Trigger
↓
Jenkins Pipeline Start
↓
Automation Execution


---

# ngrok Setup

ngrok is used to expose local Jenkins server publicly for GitHub webhook communication.

Command:

ngrok http 8080


Example Webhook URL:

https://your-ngrok-url.ngrok-free.app/github-webhook/


---

# Appium Setup

Start Appium manually before Jenkins execution.

Command:

appium


Default URL:

http://127.0.0.1:4723


---

# Emulator Setup

Start emulator before execution.

Verify device:

adb devices


Expected:

emulator-5554 device


---

# Jenkins Pipeline Flow

1. Pull latest code from GitHub
2. Verify Java and Maven
3. Verify connected device/emulator
4. Build Maven project
5. Execute Appium automation
6. Publish Extent Report
7. Archive artifacts


---

# Jenkins Execution Command

mvn test -Denv=qa -Dcucumber.filter.tags=@smoke


---

# Report Publishing

Extent Reports are automatically published in Jenkins after execution.


---

# Artifact Handling

APK files are archived automatically after successful pipeline execution.