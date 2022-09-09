@smoke
Feature:check payment to virtual account using external id
  Scenario Outline: Authorized user can able to do payment
    Given payment post  api '<path>'
    And as request body amount will be provided '<amount>'
    When user calls the post api with body
    Then payment will be succesfull
    Examples:
    |path | amount |
    |/callback_virtual_accounts/ | 5007 |

