package hw3.Pages;


import hw3.Composite.Services;
import org.openqa.selenium.WebDriver;

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

    public void defineColorDropDown(String color) {
        services.defineColorDropDown(color);
    }

    public boolean isElementInLogDisplayed(List<String> logString) {
        return services.isElementInLogDisplayed(logString);
    }

}