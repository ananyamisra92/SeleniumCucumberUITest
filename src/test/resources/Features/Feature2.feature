Feature: To validate create article

  Scenario Outline: To validate user is able to create an article successfully
    Given I have successfully logged in
    And New Post button is clickable
    When I click on New Post
    And I enter ArticleTitle "<ArticleTitle>" , ArticleSummary "<ArticleSummary>", Content "<Content>" and tag "<Tag>"
    And I click on Publish Article
    Then I am able to view my ArticleTitle "<ArticleTitle>"

    Examples: 
      | ArticleTitle | ArticleSummary | Content | Tag  |
      | Test1234      | Test123        | Test    | Test |
