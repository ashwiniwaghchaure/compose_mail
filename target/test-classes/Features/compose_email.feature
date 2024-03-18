Feature: test login functionality

  Background: check login is successful with valid credentials
    Given user is on login page
    When user enters email as "aashutestemail@gmail.com"
    And user click on Next button
    And user enters encoded password as "RW1haWxAMTIz"
    When user click on Next button
    Then verify user is logged in successfully
    Then user verifies compose button is displayed
    When user click on compose button

  Scenario: verify compose window is displayed
    Then verify compose window is open

  Scenario: verify email get composed successfully
    When user enter subject in subject field
    When user enter recepient email id
    And user enter mail message in message body
    And user click on Send button
    Then verify mail get send successfully.

  Scenario: verify user able to save draft
    When user enter subject in subject field
    When user enter recepient email id
    And user enter mail message in message body
    And user click on cancle button
    Then verify mail get saved as a draft

  Scenario: verify error message on entering invalid emailid
    When user enter invalid recepient email id
    And user click on Send button
    Then verify Error message for invalid emailid.

  Scenario: verify error message while clicking on Send btn without entering any credentials
    When user click on Send button
    Then verify Error message for clicking on Send btn without entering credentials.
