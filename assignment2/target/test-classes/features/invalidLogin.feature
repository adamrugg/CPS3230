Feature: invalid login

  Scenario: : Invalid Login
    Given I am a user of marketalertum
    When I login using invalid credentials
    Then I should see the login screen again