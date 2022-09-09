@smoke
Feature:Create Virtual Account Api Verification

  Scenario Outline: Authorized user can not able to create virtual account without mandatory Field
    Given create virtual account post api '<path>'
    And as request body provided '<external_id>' '<bank_code>' '<name>'
    When user  calls post api with body
    Then can not create a virtual account successfully


    Examples:
      |    path       |         external_id | bank_code | name|
      | /callback_virtual_accounts | va_fixed-123    |  | tasnim |
      | /callback_virtual_accounts | va_fixed-123    | MANDIRI |  |
      | /callback_virtual_accounts |     | MANDIRI | tasnim |


  Scenario Outline: Authorized user can create virtual account post request
    Given create virtual account post api '<path>'
    And as request body provided '<external_id>' '<bank_code>' '<name>'
    When user  calls post api with body
    Then create a virtual account successfully


    Examples:
      |    path       |         external_id | bank_code | name|
      | /callback_virtual_accounts | va_fixed-124    | MANDIRI | tasnim |






