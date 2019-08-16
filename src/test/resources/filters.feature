@filters
Feature: Filters
  As a customer
  I want to filter search result
  So that I can view refined results

  Background:
    Given I am on sainsburys gorcery site
    And I search for product "dvd"

    @smoke
    Scenario:
      When Select price "Price - Low to High"
      Then I should see products ordered accordingly