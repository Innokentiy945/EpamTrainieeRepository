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

    @FindBy(className = "label-radio")
    private List<WebElement> radioElements;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxElements;



    public void defineCheckBox(String checkboxName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(checkBoxElements));
        for (WebElement checkBoxElement : checkBoxElements) {
            if(!checkBoxElement.isSelected() & checkBoxElement.getText().equals(checkboxName))
                checkBoxElement.click();
        }
    }

    public void defineRadio(String radioButtonName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(radioElements));
        for (WebElement radioElements : radioElements) {
            if(!radioElements.isSelected() &radioElements.getText().equals(radioButtonName))
                radioElements.click();
        }
    }

    public void defineColorDropDown(String color) {
        colorsDropdown = wait.until(ExpectedConditions.visibilityOf(colorsDropdown));
        Select select = new Select(colorsDropdown);
        select.selectByVisibleText(color);
    }



    public boolean isCheckBoxIsDisplayedInLog(String elementName, String status) {
        waitForLogsToBeVisible();
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains(elementName + ": condition changed to " + status)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }

    public boolean isRadioAndColorLogDisplayed(String radioName, String dropdownValue) {
        waitForLogsToBeVisible();
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains("metal: value changed to " + radioName)) {
                isDisplayed = true;
            }
            else if (log.getText().contains("Colors: value changed to " + dropdownValue)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }


    private void waitForLogsToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfAllElements(logs));
    }
}




