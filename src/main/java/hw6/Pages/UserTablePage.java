package hw6.Pages;

import hw6.Composite.MainContent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserTablePage extends AbstractPage{


    protected MainContent mainContent;



    public UserTablePage(WebDriver driver) {
        super(driver);
        mainContent = new MainContent(driver);
    }

    public void clickOnVipCheckbox() {
        mainContent.clickToCheckBox();
    }

    public boolean isLogVipDisplayed(String logString) {
        return mainContent.isElementInLogDisplayed(logString);
    }

    public void setVipCheckbox(String username) {
        mainContent.setVipCheckbox(username);
    }

    public List<WebElement> getUserRoles(String username){
        return mainContent.getUserRoles(username);
    }

    public boolean isUserTableDisplayed() {
        return mainContent.isUsersNamesDisplayed();
    }

    public boolean isUsersDropdownsDisplayed() {
        return mainContent.isUsersDropdownsDisplayed();
    }

    public boolean isUsersImagesDescriptionDisplayed() {
        return mainContent.isUsersImagesDescriptionDisplayed();
    }

    public boolean isUsersCheckboxesDisplayed() {
        return mainContent.isUsersCheckboxesDisplayed();
    }

    public boolean isUsersSelectsDisplayed() {
        return mainContent.isUsersSelectsDisplayed();
    }

    public List<String> getUsersIds() {
        return mainContent.getUsersIds();
    }

    public List<String> getUsersNames() {
        return mainContent.getUsersNames();
    }

    public List<String> getUsersImagesDescriptions() {
        return mainContent.getUsersImagesDescriptions();
    }

    public List<WebElement> getUsersSelects() {
        return mainContent.getUsersSelects();
    }

    public List<WebElement> getUsersCheckboxes() {
        return getUsersCheckboxes();
    }


}

