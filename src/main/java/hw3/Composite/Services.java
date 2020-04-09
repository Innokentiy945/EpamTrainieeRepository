package hw3.Composite;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Services extends AbstractPageComposite{

    public Services(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".logs li")
    private List<WebElement> logs;


    @FindBy(css = ".colors select")
    private WebElement colorsDropdown;


    @FindBy(className = "checkbox-row")
    private List<WebElement> checkBoxElements;



    public void defineButtonElements(List<String> checkBoxName){
        for (WebElement checkBoxElement : checkBoxElements) {
            if(!checkBoxElement.isSelected() & checkBoxElement.getText().equals(checkBoxName))
                checkBoxElement.click();
        }
    }


    public void defineColorDropDown(String color) {
        colorsDropdown = wait.until(ExpectedConditions.visibilityOf(colorsDropdown));
        Select select = new Select(colorsDropdown);
        select.selectByVisibleText(color);
    }


    public boolean isElementInLogDisplayed(List<String> logString) {
        waitForLogsToBeVisible();
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains("condition changed to " + logString)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }



    private void waitForLogsToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfAllElements(logs));
    }
}




