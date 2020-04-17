package hw6.Steps;

import hw6.Pages.DifferentElementPage;
import hw6.Pages.UserTablePage;
import hw6.TestData.UserTable;
import hw6.utils.Calculation;
import hw6.utils.WebDriverSingleton;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThenSteps {

    private DifferentElementPage differentElementPage = new DifferentElementPage(WebDriverSingleton.INSTANCE.getDriver());
    private UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());

    @Then("For each checkboxes 'Water', 'Wind' and radio button 'Selen' there is an individual log row and value is corresponded to the status of checkbox")
    public void assertingCheckBoxesLog(List<String> checkboxes) {
        assertTrue(differentElementPage.isElementInLogDisplayed(checkboxes));
    }

    @Then("For dropdown value 'Yellow' there is a log row and value is corresponded to the selected value")
    public void assertingDropDownColors(List<String> color) {
        assertTrue(differentElementPage.isElementInLogDisplayed(color));
    }

    @Then("\"User Table\" page should be opened")
    public void userTablePageIsOpened() {
        assertTrue(userTablePage.isUserTableDisplayed());
    }





    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertingDropdownsOnUserTablePage(int expectedDropdownsAmount) {
        assertEquals(userTablePage.getUsersSelects().size(), expectedDropdownsAmount);
        assertTrue(userTablePage.isUsersDropdownsDisplayed());
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void assertingUsernamesOnUserTablePage(int expectedUsernamesAmount) {
        assertEquals(userTablePage.getUsersNames().size(), expectedUsernamesAmount);
        assertTrue(userTablePage.isUsersSelectsDisplayed());
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void assertingDescriptionsUnderImagesOnUserTablePage(int expectedDescriptionsAmount) {
        assertEquals(userTablePage.getUsersImagesDescriptions().size(), expectedDescriptionsAmount);
        assertTrue(userTablePage.isUsersImagesDescriptionDisplayed());
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void assertingCheckboxesOnUserTablePage(int expectedCheckboxesAmount) {
        assertEquals(userTablePage.getUsersCheckboxes().size(), 6);
        assertTrue(userTablePage.isUsersCheckboxesDisplayed());
    }

    @Then("User table should contain following values:")
    public void assertingContentOfTableOnUserTablePage(DataTable dataTable) {
        List<UserTable> actualUserTable = Calculation
                .convertToUserTableRowList(userTablePage.getUsersIds(), userTablePage.getUsersNames(), userTablePage.getUsersImagesDescriptions());
        List<UserTable> expectedUserTable = Calculation.convertUserDataToList(dataTable);
        assertThat(actualUserTable).isEqualTo(expectedUserTable);
    }


    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void isLogForSelectedCheckBOxIsDisplayed(String logString) {
        assertTrue(userTablePage.isLogVipDisplayed(logString));
    }
}
