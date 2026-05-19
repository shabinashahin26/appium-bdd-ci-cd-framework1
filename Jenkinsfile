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

        echo 'Pipeline Execution Completed Successfully'
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

Screenshot Capture Enabled:
${params.TAKE_SCREENSHOT_ON_FAILURE}

Build URL:
${env.BUILD_URL}

Reports Generated:
- Extent Spark Report
- Allure Report
- Cucumber XML Report

""",

                to: "shabinashahin09@gmail.com",

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
- Extent Spark Report
- Allure Report
- Screenshots
- Device/Appium Status

""",

                to: "shabinashahin09@gmail.com",

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

                to: "shabinashahin09@gmail.com",

                attachLog: true
        )
    }
}