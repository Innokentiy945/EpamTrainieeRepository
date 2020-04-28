package hw6.Steps;

import hw6.Pages.DifferentElementPage;
import hw6.Pages.UserTablePage;
import hw6.Entity.UserTable;
import hw6.utils.WebDriverSingleton;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class ThenSteps {

    private DifferentElementPage differentElementPage = new DifferentElementPage(WebDriverSingleton.INSTANCE.getDriver());
    private UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());

    @Then("For each checkboxes there is an individual log row and value is corresponded to the status of checkbox")
    public void assertingCheckBoxesLog(List<String> checkboxes) {
        assertFalse(differentElementPage.isElementInLogDisplayed(checkboxes));
    }
    @Then("For radio button {string} there is a log row and value is corresponded to the status of radio button")
    public void assertingRadioButtonLog(String radio) {
        assertTrue(differentElementPage.isRadioInLogDisplaeyd(radio));
    }

    @Then("For dropdown value {string} there is a log row and value is corresponded to the selected value")
    public void assertingDropDownColors(String color) {
        assertTrue(differentElementPage.isDropdownLogDisplayed(color));
    }

    @Then("User Table page should be opened")
    public void userTablePageIsOpened() {
        assertTrue(userTablePage.isUserTableDisplayed());
    }


    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertingDropdownsOnUserTablePage(int expectedDropdownsAmount) {
        assertEquals(userTablePage.getUsersSelects().size(), expectedDropdownsAmount);
        assertTrue(userTablePage.isUsersDropdownsDisplayed());
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void assertingUsernamesOnUserTablePage(int expectedUsernamesAmount) {
        assertEquals(userTablePage.getUsersNames().size(), expectedUsernamesAmount);
        assertTrue(userTablePage.isUsersSelectsDisplayed());
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void assertingDescriptionsUnderImagesOnUserTablePage(int expectedDescriptionsAmount) {
        assertEquals(userTablePage.getUsersImagesDescriptions().size(), expectedDescriptionsAmount);
        assertTrue(userTablePage.isUsersImagesDescriptionDisplayed());
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void assertingCheckboxesOnUserTablePage(int expectedCheckboxesAmount) {
        assertEquals(userTablePage.getUsersCheckboxes().size(), expectedCheckboxesAmount);
        assertTrue(userTablePage.isUsersCheckboxesDisplayed());
    }


    @Then("1 log row has {string} {string} text in log section")
    public void isLogForSelectedCheckBOxIsDisplayed(String logString, String status) {
        assertFalse(userTablePage.isLogVipDisplayed(logString, status));
    }

    @DataTableType
    public UserTable UserItems(Map<String, String> item) {
        return new UserTable(
                item.get("Number"),
                item.get("User"),
                item.get("Description"));
    }

    @Then("User table should contain following values:")
    public void assertingItemsOnUserTablePage(List<UserTable> users) {
        ArrayList<UserTable> actualUserTable = new ArrayList<>();
        List<String> numbers = userTablePage.getUsersIds();
        List<String> usernames = userTablePage.getUsersNames();
        List<String> description = userTablePage.getUsersImagesDescriptions();
        for (int i = 0; i < numbers.size(); i++) {
            actualUserTable.add(new UserTable(numbers.get(i), usernames.get(i), description.get(i)));
        }
        assertNotEquals(actualUserTable,users);

    }

    @Then("Droplist should contain values in column Type for user Roman:")
    public void assertingRolesOfUser(List<String> args) {
        List<String> actualUserRoles = userTablePage.getUserRole("Roman");
        List<String> expectedUserRoles = args.subList(1, args.size());
        assertThat(actualUserRoles).isEqualTo(expectedUserRoles);
    }


}
