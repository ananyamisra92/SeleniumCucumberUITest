Feature: To validate login feature
  Scenario Outline: To validate user is able to login successfully
    Given I have navigated to website "<URL>"
    When I click on Sign In
    And I add UserName "<username>" and Password "<Password>"
    And I click on Sign In button
    Then I am successfully logged in

    Examples: 
      | URL                                      | username           | Password |
      | https://react-redux.realworld.io/#/login | testuser@iptiq.com | test1234 |
