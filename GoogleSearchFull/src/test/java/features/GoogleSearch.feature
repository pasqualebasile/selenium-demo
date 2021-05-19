# Created by paskal at 18/05/21
Feature: Google Search Basic
  Searching Google Keyword

  Scenario: Google Search Infocube
    Given Open the Google Search Engine
    When  I search for "infocube"
    Then  I should see "www.infocube.it"

