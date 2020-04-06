package hw3.Pages;


import hw3.Composite.Services;
import org.openqa.selenium.WebDriver;


public class DifferentElementPage extends AbstractPage {

    private Services services;

    public DifferentElementPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        services = new Services(driver);
    }

    public void defineCheckBox(String checkboxName) {
        services.defineCheckBox(checkboxName);
    }

    public void defineRadio(String checkboxName) {
        services.defineRadio(checkboxName);
    }

    public void defineColorDropDown(String color) {
        services.defineColorDropDown(color);
    }

    public boolean isElementIsDisplayedInLog(String elementName, String status) {
        return services.isCheckBoxIsDisplayedInLog(elementName, status);
    }

    public boolean isRadioAndColorLogDisplayed(String radioName, String dropdownValue) {
        return services.isRadioAndColorLogDisplayed(radioName, dropdownValue);
    }

}