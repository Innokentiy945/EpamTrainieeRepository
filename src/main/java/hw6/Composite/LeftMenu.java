package hw6.Composite;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class LeftMenu extends AbstractPageComposite {

    public LeftMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftSectionMenuItems;


    public List<String> leftSectionMenuText(){
        waitForleftSectionMenuToBeVisible();

        return leftSectionMenuItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public int countLeftSectionMenu(){
        return wait.until(ExpectedConditions.visibilityOfAllElements(leftSectionMenuItems)).size();
    }




}
