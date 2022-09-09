@smoke
Feature:Create Virtual Account date update validation
  Scenario Outline: Authorized user can not able update date with invalid date
    Given update date api patch '<path>'
    And as a body provided update date '<date>'
    When user  calls patch api with body
    Then response would be validation error
    Examples:
      |path| date|
      |/callback_virtual_accounts/| 2053-11testGoingOn-27T07:00:00.000Z|


  Scenario Outline: Authorized user can  able to update date
    Given update date api patch '<path>'
    And as a body provided update date '<date>'
    When user  calls patch api with body
    Then date update sucessfully
    Examples:
    |path| date|
    |/callback_virtual_accounts/| 2053-11-27T07:00:00.000Z|


  Scenario Outline:Authorized user check date update data
    Given fetch status api '<path>'
    And as a prams provided id
    When user calls the get api
    Then valid provided date with updateDate
    Examples:
      |path |
      |/callback_virtual_accounts/|
