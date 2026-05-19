pipeline {

    agent any

    tools {

        jdk 'JDK17'
        maven 'Maven'
    }

    parameters {

        choice(
                name: 'ENV',
                choices: ['qa', 'uat', 'prod'],
                description: 'Select Environment'
        )

        choice(
                name: 'TEST_TAG',
                choices: ['@smoke', '@regression'],
                description: 'Select Test Suite'
        )

        booleanParam(
                name: 'TAKE_SCREENSHOT_ON_FAILURE',
                defaultValue: true,
                description: 'Capture screenshots on failure'
        )
    }

    options {

        buildDiscarder(logRotator(numToKeepStr: '15'))

        disableConcurrentBuilds()

        timestamps()

        timeout(time: 45, unit: 'MINUTES')

        ansiColor('xterm')
    }

    environment {

        MAVEN_OPTS = '-Xmx2048m'

        PROJECT_NAME = 'Enterprise Mobile Automation Framework'

        REPORT_PATH = 'reports'

        ALLURE_RESULTS = 'target/allure-results'
    }

    stages {

        stage('Clean Workspace') {

            steps {

                echo 'Cleaning Jenkins Workspace'

                cleanWs()
            }
        }

        stage('Checkout Framework Code') {

            steps {

                echo 'Checking out latest framework code from GitHub'

                git branch: 'main',
                        url: 'https://github.com/shabinashahin26/appium-bdd-ci-cd-framework1.git'
            }
        }

        stage('Verify Automation Environment') {

            steps {

                echo 'Verifying Java Installation'
                bat 'java -version'

                echo 'Verifying Maven Installation'
                bat 'mvn -version'

                echo 'Checking Connected Android Devices'
                bat 'adb devices'

                echo 'Checking Appium Installation'
                bat 'npx appium -v'
            }
        }

        stage('Execute Mobile Automation Tests') {

            steps {

                echo "Executing ${params.TEST_TAG} suite on ${params.ENV} environment"

                bat """
                    mvn clean test ^
                    -Denv=${params.ENV} ^
                    -Dcucumber.filter.tags=${params.TEST_TAG} ^
                    -Dscreenshot.on.failure=${params.TAKE_SCREENSHOT_ON_FAILURE}
                """
            }
        }

        stage('Publish Extent Spark Report') {

            steps {

                echo 'Publishing Extent Spark Report'

                publishHTML([

                        allowMissing: true,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'reports',
                        reportFiles: 'SparkReport.html',
                        reportName: 'Extent Spark Report'
                ])
            }
        }

        stage('Publish Allure Report') {

            steps {

                echo 'Publishing Allure Report'

                allure([
                        includeProperties: false,
                        commandline: 'Allure',
                        results: [[path: 'target/allure-results']]
                ])
            }
        }
    }

    post {

        always {

            echo 'Publishing Cucumber XML Results'

            junit allowEmptyResults: true,
                    testResults: 'target/cucumber-reports/*.xml'

            echo 'Archiving Reports, Screenshots, Logs and APK Files'

            archiveArtifacts(
                    artifacts: '''
                        reports/**/*,
                        target/allure-results/**/*,
                        target/cucumber-reports/**/*,
                        screenshots/**/*,
                        logs/**/*,
                        **/*.apk
                    ''',
                    fingerprint: true
            )

            echo 'Pipeline Execution Completed'
        }

        success {

            emailext(

                    subject: "SUCCESS: ${env.PROJECT_NAME} Build #${env.BUILD_NUMBER}",

                    body: """

Mobile Automation Execution Successful

Project Name: ${env.PROJECT_NAME}

Build Number: ${env.BUILD_NUMBER}

Environment: ${params.ENV}

Test Suite: ${params.TEST_TAG}

Build URL:
${env.BUILD_URL}

Reports Generated:
- Extent Spark Report
- Allure Report
- Cucumber XML Report

""",

                    to: "shahinshabina93@gmail.com",

                    attachLog: true
            )
        }

        failure {

            emailext(

                    subject: "FAILED: ${env.PROJECT_NAME} Build #${env.BUILD_NUMBER}",

                    body: """

Mobile Automation Execution Failed

Project Name: ${env.PROJECT_NAME}

Build Number: ${env.BUILD_NUMBER}

Environment: ${params.ENV}

Test Suite: ${params.TEST_TAG}

Build URL:
${env.BUILD_URL}

Please verify:
- Jenkins Console Logs
- Reports
- Screenshots
- Device/Appium Status

""",

                    to: "shahinshabina93@gmail.com",

                    attachLog: true
            )
        }

        unstable {

            emailext(

                    subject: "UNSTABLE: ${env.PROJECT_NAME} Build #${env.BUILD_NUMBER}",

                    body: """

Mobile Automation Execution Completed with Unstable Status

Project Name: ${env.PROJECT_NAME}

Build Number: ${env.BUILD_NUMBER}

Environment: ${params.ENV}

Build URL:
${env.BUILD_URL}

Please review failed or skipped scenarios.

""",

                    to: "shahinshabina93@gmail.com",

                    attachLog: true
            )
        }
    }
}