package hw4.Pages;


import hw4.Components.HeaderMenu;
import org.openqa.selenium.WebDriver;


public class HomePage extends AbstractPage {

    private HeaderMenu headerMenu;


    public HomePage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public void logInOperation(String user, String password) {
        headerMenu.loginOperation(user, password);
    }


    public String getNameOfUser() {
        return headerMenu.getUserName();
    }

    public boolean isUserNameDisplayed() {
        return headerMenu.isUserNameDisplayed();
    }

    public void goToTableWithPagesPage() {
        headerMenu.goToTableWithPagesPage();
    }

    public void goToMetalColorPage() {
        headerMenu.goToMetalColorPage();
    }



}
