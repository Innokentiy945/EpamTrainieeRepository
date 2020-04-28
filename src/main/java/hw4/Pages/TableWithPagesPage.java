package hw4.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TableWithPagesPage extends AbstractPage{


    public TableWithPagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "select")
    private WebElement showDropdown;

    @FindBy(css = "tbody > tr")
    private List<WebElement> tableRows;

    @FindBy(css = "#table-with-pages_filter input")
    private WebElement searchField;


    public String gettingDropdownValue() {
        wait.until(ExpectedConditions.visibilityOf(showDropdown));
        return new Select(showDropdown).getFirstSelectedOption().getText();
    }

    public void settingDropdownValue(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(showDropdown));
        new Select(showDropdown).selectByValue(value);
    }

    public int gettingTableRowsCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(tableRows)).size();
    }

    public void searchFor(String search) {
        wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(search);
    }

    public boolean isSearchCorrect(String search) {
        wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
        boolean isSearchCorrect = false;
        for (WebElement tableRow : tableRows) {
            if (tableRow.getText().toLowerCase().contains(search.toLowerCase()))
                isSearchCorrect = true;
        }
        return isSearchCorrect;
    }


}
