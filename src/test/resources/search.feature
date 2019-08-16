@search
Feature: search
  As a customer
  I Want to search for a product
  So that I can view respective products

  @smoke
  Scenario: search for single single product
    Given I am on sainsburys gorcery site
    When I search for product "bread"
    Then I should be able to see respective products result

  @regression
  Scenario Outline:
    Given I am on sainsburys gorcery site
    When I search for product "<product>"
    Then I should be able to see respective products result

    Examples:
      | product |
      | bread   |
      | icecream|
      | fish    |