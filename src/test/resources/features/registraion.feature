Feature: Registration

  Scenario: Register new user successfully
    Given I am on basketballengland page
    When I fill in the correct member details
    And I press confirm and join
    Then I successfully become a member

  Scenario: Missing lastName
    Given I am on basketballengland page
    When I fill in the correct member details without last name
    And I press confirm and join
    Then I see the error message for the lastname missing

  Scenario: Password didnt match
    Given I am on basketballengland page
    When I fill in the correct member details, and password dont match
    And I press confirm and join
    Then I see the error message for the not matching password

  Scenario:Terms And Conditions Not Confirm
    Given I am on basketballengland page
    When I fill in the correct member details, without confirm terms and Conditions
    And I press confirm and join
    Then I see the error message for the not confirm terms and Conditions
