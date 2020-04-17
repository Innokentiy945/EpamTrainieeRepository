Feature: Test functionality in DifferentElementPage

  @Test1
  Scenario: Testing checkboxes, radio buttons, dropdown
    Given: Home page is open
    And: Adding username 'Roman' and password 'Jdi1234' to login window
    And: Go through the header menu Service to Different Elements Page
    When: Select checkboxes 'Water', 'Wind', 'Selen'
    And: Select dropdown 'Yellow'
    Then: For each checkboxes 'Water', 'Wind' and radio button 'Selen' there is an individual log row and value is corresponded to the status of checkbox
    And: For dropdown value 'Yellow' there is a log row and value is corresponded to the selected value

