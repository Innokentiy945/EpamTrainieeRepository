package hw6.Pages;


import hw6.Composite.Services;
import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.List;


public class DifferentElementPage extends AbstractPage {

    private Services services;

    public DifferentElementPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        services = new Services(driver);
    }

    public void defineButtonElements(List<String> checkBoxName) {
        services.defineButtonElements(checkBoxName);
    }

    public void defineRadioElements(String radio) {
        services.defineRadioButton(radio);
    }

    public void defineColorDropDown(String color) {
        services.defineColorDropDown(color);
    }

    public boolean isElementInLogDisplayed(List<String> logString) {
        return services.isElementInLogDisplayed(logString);
    }

    public boolean isRadioInLogDisplaeyd(String radio) {
        return services.isRadioButtonLogDisplayed(radio);
    }

    public boolean isDropdownLogDisplayed(String color) {
        return services.isDropDownLogDisplayed(color);
    }

}