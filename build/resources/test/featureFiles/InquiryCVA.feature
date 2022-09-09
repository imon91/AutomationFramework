@smoke
Feature: Get status of virtual account
  Scenario Outline:Authorized user can  able to fetch status of virtual account
    Given fetch status api '<path>'
    And as a prams provided id
    When user calls the get api
    Then will find success status '<code>'
    Examples:
    |path | code |
    |/callback_virtual_accounts/| 200|
