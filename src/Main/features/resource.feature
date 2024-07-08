@E2E
Feature: Swag Labs application

  Background:
    Given User click on the Login Link

  @reg
  Scenario Outline: Login should be success
    And User enters the username as "<username>"
    And User enters the Password as "<password>"
    When User click on the login button
    Then Login should be success
    @dev
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | visual_user   | secret_sauce |
#@QA
    #Examples:
      #| username      | password     |
      #| standard_user | secret_sauce |
      #| visual_user   | secret_sauce |

  @smoke @reg
  Scenario: Login should fail
    And User enters the username as "sathishkumarsekar1995@gmail.com"
    And User enters the Password as "1208@Sa"
    When User click on the login button
    But Login should be fail
