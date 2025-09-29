Feature: Login Feature

  Scenario: Positive login Scenario

    Given I open Koel login page
    When I enter email "julia.munoz@testpro.io"
    And I enter password "Ltdan25!"
    And I click on the submit button
    Then I login into Koel home page