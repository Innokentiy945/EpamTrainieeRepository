package hw6.Composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public abstract class AbstractPageComposite {


    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftSectionMenuItems;

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected AbstractPageComposite(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }


    public boolean leftSectionMenuIsDisplayed(){
        waitForleftSectionMenuToBeVisible();
        boolean isDisplayed = false;
        for (WebElement element : leftSectionMenuItems) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }

    protected void waitForleftSectionMenuToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfAllElements(leftSectionMenuItems));
    }


}
