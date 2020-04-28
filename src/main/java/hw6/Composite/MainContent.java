package hw6.Composite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class MainContent extends AbstractPageComposite{


    @FindBy(id = "ivan")
    private WebElement ivanCheckBox;


    @FindBy(css = ".logs li")
    private List<WebElement> logs;

    @FindBy(css = "#user-table tr")
    private List<WebElement> tableRows;

    @FindBy(css = "#user-table select")
    private List<WebElement> usersSelects;

    @FindBy(css = "#user-table a")
    private List<WebElement> usersNames;

    //@FindBy(css = "#user-table span")
    @FindBy(className = "user-descr")
    private List<WebElement> usersImagesDescriptions;

    @FindBy(css = "#user-table input")
    private List<WebElement> usersCheckboxes;

    @FindBy(xpath = "//td[text()=number()]")
    private List<WebElement> usersIds;



    public MainContent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    public void clickToCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(ivanCheckBox)).click();
    }


    public boolean isVipLogDisplayed(String vipLog, String status) {
        waitForLogsToBeVisible();
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains("condition changed to " + vipLog + status.equals("true"))) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }



    public boolean isUsersNamesDisplayed() {
        waitForVisibilityOf(usersNames);
        return isDisplayed(usersNames);
    }

    public boolean isUsersDropdownsDisplayed() {
        waitForVisibilityOf(usersSelects);
        return isDisplayed(usersSelects);
    }

    public boolean isUsersImagesDescriptionDisplayed() {
        waitForVisibilityOf(usersImagesDescriptions);
        return isDisplayed(usersImagesDescriptions);
    }

    public boolean isUsersCheckboxesDisplayed() {
        waitForVisibilityOf(usersCheckboxes);
        return isDisplayed(usersCheckboxes);
    }

    public boolean isUsersSelectsDisplayed() {
        waitForVisibilityOf(usersSelects);
        return isDisplayed(usersSelects);
    }

    private boolean isDisplayed(List<WebElement> elements) {
        boolean isDisplayed = false;
        for (WebElement element : elements) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }


    public List<String> getUsersIds() {
        waitForVisibilityOf(usersIds);
        return getListAsString(usersIds);
    }

    public List<String> getUsersNames() {
        waitForVisibilityOf(usersNames);
        return getListAsString(usersNames);
    }

    public List<String> getUsersImagesDescriptions() {
        waitForVisibilityOf(usersImagesDescriptions);
        return getListAsString(usersImagesDescriptions);
    }

    public List<WebElement> getUsersSelects() {
        waitForVisibilityOf(usersSelects);
        return usersSelects;
    }

    public List<WebElement> getUsersCheckboxes() {
        waitForVisibilityOf(usersCheckboxes);
        return usersCheckboxes;
    }



    private void waitForVisibilityOf(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public List<String> getUserRoles(String username) {
        waitForVisibilityOf(tableRows);
        for (WebElement webElement : tableRows) {
            if (webElement.getText().contains(username)) {
                return getListAsString(webElement.findElements(By.cssSelector("select option")));
            }
        }
        return null;
    }

    private void waitForLogsToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfAllElements(logs));
    }

    private List<String> getListAsString(List<WebElement> elements) {
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
