Feature: Test functionality in DifferentElementPage

  Scenario: Testing checkboxes, radio buttons, dropdown
    Given I open JDI GitHub site
    And I login as user "Roman" password: 'Jdi1234'

    And I go to DifferentElement Page
    When Select checkboxes
      | Water      |
      | Wind       |
    And Select radiobutton 'Selen'
    And Select dropdown 'Yellow'
    Then For each checkboxes there is an individual log row and value is corresponded to the status of checkbox
      | Water      |
      | Wind       |
    And For radio button 'Selen' there is a log row and value is corresponded to the status of radio button
    And For dropdown value 'Yellow' there is a log row and value is corresponded to the selected value


