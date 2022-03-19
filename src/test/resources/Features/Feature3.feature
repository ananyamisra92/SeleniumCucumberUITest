Feature: To validate login feature

  Scenario: To validate user is able to logout successfully
    Given User profile button is available 
    When I click on user Profile
    And I click on logout
    Then I am successfully logged out