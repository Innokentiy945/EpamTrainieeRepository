package hw3.Composite;

import hw3.Pages.PageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class LeftSectionOfPageComposite extends AbstractPageComposite {

    public LeftSectionOfPageComposite(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftSectionMenuItems;


    public boolean leftSectionMenuIsDisplayed(){
        waitForleftSectionMenuToBeVisible();
        boolean isDisplayed = false;
        for (WebElement element : leftSectionMenuItems) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }

    public List<String> leftSectionMenuText(){
        waitForleftSectionMenuToBeVisible();
        return leftSectionMenuItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public int countLeftSectionMenu(){
        return wait.until(ExpectedConditions.visibilityOfAllElements(leftSectionMenuItems)).size();
    }

    private void waitForleftSectionMenuToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfAllElements(leftSectionMenuItems));
    }


}
