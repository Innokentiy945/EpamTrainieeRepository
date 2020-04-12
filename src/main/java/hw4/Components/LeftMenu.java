package hw4.Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class LeftMenu extends AbstractPage{

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftMenuElements;

    public LeftMenu(WebDriver driver) {
        super(driver);
    }


    public boolean isLeftMenuElementsDisplayed() {
        waitForLeftMenuToBeVisible();
        boolean isDisplayed = false;
        for (WebElement element : leftMenuElements) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }

    public List<String> gettingLeftMenuElementsText() {
        waitForLeftMenuToBeVisible();
        return leftMenuElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public int gettingLeftMenuElementsCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(leftMenuElements)).size();
    }

    private void waitForLeftMenuToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfAllElements(leftMenuElements));
    }
}
