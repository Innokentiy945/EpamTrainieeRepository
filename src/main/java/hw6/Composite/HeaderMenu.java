package hw6.Composite;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;


public class HeaderMenu extends AbstractPageComposite {



    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement submitLoginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerMenuElements;

    @FindBy(css = ".m-l8 .dropdown")
    private WebElement serviceMenu;

    @FindBy(className = "dropdown-toggle")
    private WebElement dropDownMenu;

    @FindBy (linkText ="User Table ")
    private WebElement userTableMenu;


    public HeaderMenu(WebDriver driver) {
        super(driver);
    }



    public void loginOperation(String user, String pass){
        wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
        wait.until(ExpectedConditions.attributeToBe(By.className("uui-profile-menu"), "class",
                "dropdown uui-profile-menu open"));
        wait.until(ExpectedConditions.elementToBeClickable(userNameInputField)).sendKeys(user);
        wait.until(ExpectedConditions.elementToBeClickable(passwordInputField)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(submitLoginButton)).click();
    }

    public void clickOnMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(dropDownMenu)).click();

    }

       public void goToUserTablePage() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userTableMenu)).click();

    }

    //Ex.2
    public void goToDifferentElementPage(){
        wait.until(ExpectedConditions.visibilityOf(serviceMenu)).click();
        wait.until(ExpectedConditions.attributeToBe(serviceMenu,"class","dropdown open"));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("DIFFERENT ELEMENTS"))).click();
    }

}


