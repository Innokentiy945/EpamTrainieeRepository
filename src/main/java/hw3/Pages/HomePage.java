package hw3.Pages;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePage extends AbstractPage {



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void logInOperation(String user, String password) {
        headerMenuComposite.loginOperation(user, password);
    }

    public String getNameOfUser() {
        return headerMenuComposite.getUserName();
    }

    public boolean isUserNameDisplayed() {
        return headerMenuComposite.isUserNameDisplayed();
    }

    public List<String> getHeaderMenuElements() {
        return headerMenuComposite.getHeaderMenuElementsText();
    }

    public boolean isHeaderItemsDisplayed() {
       return headerMenuComposite.isHeaderMenuItemsDisplayed();
    }


    public int countBenefitImages() {
        return benefitsItemComposite.benefitImagesCount();
    }

    public int countTxtBenefit() {
        return benefitsItemComposite.benefitTextsCount();
    }

    public boolean isBenefitsDisplayed() {
        return benefitsItemComposite.isBenefitIconsDisplayed();
    }

    public void switchToFrame() {
        framePageComposite.switchToFrame();
    }

    public void switchToPreviousPage() {
        framePageComposite.switchToDefaultWindow();
    }

    public boolean isFrameButtonDisplayed() {
        return framePageComposite.isFrameButtonDisplayed();
    }

    public boolean isFrameDisplayed() {
        return framePageComposite.isFrameDisplayed();
    }

    public boolean leftCestionMenuisDisplayed() {
        return leftSectionOfPageComposite.leftSectionMenuIsDisplayed();
    }

    public List<String> leftSectionMenuText() {
        return leftSectionOfPageComposite.leftSectionMenuText();
    }

    public int counItemsInLefSectionMenu() {
        return leftSectionOfPageComposite.countLeftSectionMenu();
    }

    public void goToDifferentPage() {
        headerMenuComposite.goToDifferentElementPage();
    }

}
