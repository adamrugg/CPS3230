Feature: login

  In order to view my alerts
  As a user or admin of markalertum
  I want to be able to login and view my alerts

  Scenario: Valid Login
    Given I am a user of marketalertum
    When I login using valid credentials
    Then I should see my alerts



