package hw6.Pages;

import hw6.Composite.HeaderMenu;
import hw6.Composite.LeftMenu;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePage extends AbstractPage {

    protected LeftMenu leftMenu;
    protected HeaderMenu headerMenu;



    public HomePage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
        leftMenu = new LeftMenu(driver);
    }

    public void logInOperation(String user, String password) {
        headerMenu.loginOperation(user, password);
    }

    public void clickOnMenu() {
        headerMenu.clickOnMenu();
    }


    public void goToUserTablePage() {
        headerMenu.goToUserTablePage();
    }


    public void goToDifferentPage() {
        headerMenu.goToDifferentElementPage();
    }

}
