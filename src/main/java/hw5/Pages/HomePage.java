package hw5.Pages;

import hw5.Composite.*;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePage extends AbstractPage {

    protected Benefits benefits;
    protected Frame frame;
    protected LeftMenu leftMenu;
    protected HeaderMenu headerMenu;



    public HomePage(WebDriver driver) throws InterruptedException {
        super(driver);
        headerMenu = new HeaderMenu(driver);
        benefits = new Benefits(driver);
        frame = new Frame(driver);
        leftMenu = new LeftMenu(driver);
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

    public List<String> getHeaderMenuElements() {
        return headerMenu.getHeaderMenuElementsText();
    }

    public boolean isHeaderItemsDisplayed() {
       return headerMenu.isHeaderMenuItemsDisplayed();
    }

    public int countHeaderMenuItems() {return headerMenu.countHeaderMenuItems();}

    public int countBenefitImages() {
        return benefits.benefitImagesCount();
    }

    public int countTxtBenefit() {
        return benefits.benefitTextsCount();
    }

    public boolean isBenefitsDisplayed() {
        return benefits.isBenefitIconsDisplayed();
    }

    public void switchToFrame() {
        frame.switchToFrame();
    }

    public void switchToPreviousPage() {
        frame.switchToDefaultWindow();
    }

    public boolean isFrameButtonDisplayed() {
        return frame.isFrameButtonDisplayed();
    }

    public boolean isFrameDisplayed() {
        return frame.isFrameDisplayed();
    }

    public boolean leftCestionMenuisDisplayed() {
        return leftMenu.leftSectionMenuIsDisplayed();
    }

    public List<String> leftSectionMenuText() {
        return leftMenu.leftSectionMenuText();
    }

    public int counItemsInLefSectionMenu() {
        return leftMenu.countLeftSectionMenu();
    }

    public void goToDifferentPage() {
        headerMenu.goToDifferentElementPage();
    }

}
