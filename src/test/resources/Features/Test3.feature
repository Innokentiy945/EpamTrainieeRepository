Feature: asserting log after click on check box

  Scenario: click to vip and assert individual log
    Given I open JDI GitHub site
    And I login as user 'Roman' password: 'Jdi1234'
    And I click on Service button in Header
    And I click on 'User Table' button in Service dropdown
    When I select vip checkbox for Sergey Ivan
    Then 1 log row has 'Vip: condition changed to' 'true' text in log section