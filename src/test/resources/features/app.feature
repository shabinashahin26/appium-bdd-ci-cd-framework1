Feature: Demo App Validation


  @smoke
  Scenario: Verify app launch and login button

    Given user launches the app
    Then user should see home screen
    And user clicks login button


  @regression
  Scenario: Verify app launch second time

    Given user launches the app
    Then user should see home screen
    And user clicks login button