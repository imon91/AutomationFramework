@smoke
Feature: feature to test login functionality and transection id verify

  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters '<username>' and '<password>'
    And clicks on login button
    Then user is nvaigated to home pages
    Examples:
      | username | password |
      | tasnim-hosen-60558577003@xendit.co | T@snim91    |

