package hw3.Pages;


import org.openqa.selenium.WebDriver;


public class DifferentElementPage extends AbstractPage {


    public DifferentElementPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void defineCheckBox(String checkboxName) {
        servicesPageComposite.defineCheckBox(checkboxName);
    }

    public void defineRadio(String checkboxName) {
        servicesPageComposite.defineRadio(checkboxName);
    }

    public void defineColorDropDown(String color) {
        servicesPageComposite.defineColorDropDown(color);
    }

    public boolean  isCheckboxLogDisplayed(String checkboxName, String status) {
        return servicesPageComposite.isCheckboxLogDisplayed(checkboxName, status);
    }

    public boolean isRadioLogDisplayed(String radioName) {
        return servicesPageComposite.isRadioLogDisplayed(radioName);
    }

    public boolean isDropdownLogDisplayed(String dropdownValue) {
        return servicesPageComposite.isDropDownLogDisplayed(dropdownValue);
    }
}
