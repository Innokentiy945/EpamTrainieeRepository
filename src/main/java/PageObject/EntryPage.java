package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntryPage {

    @FindBy(id = "user-icon")
    private WebElement goToLogInPage;

    @FindBy(id = "name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement pass;

    @FindBy(id = "login-button")
    private WebElement logInButton;




    public void logInOperation(String user, String password) {
        goToLogInPage.click();
        userName.sendKeys(user);
        pass.sendKeys(password);
        logInButton.click();
    }

    @FindBy(className = "logout")
    private WebElement assertationOfLogIn;

    public boolean LogInAssertation() {
        assertationOfLogIn.isDisplayed();
        return assertationOfLogIn.isDisplayed();
    }

    @FindBy(id = "user-name")
    private WebElement checkUserName;

    public String checkingUserName(String userName) {
        return checkUserName.getText();
    }
}
