package hw4.Pages;



import hw4.Components.*;
import hw4.Builder.*;
import hw4.Enums.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class MetalsColorsPage extends AbstractPage {

    private ResultWindow resultWindow;


    @FindBy(css = "#odds-selector > p label")
    private List<WebElement> summaryRadioOdd;

    @FindBy(css = "#even-selector > p label")
    private List<WebElement> summaryRadioEven;

    @FindBy(css = "#elements-checklist label")
    private List<WebElement> elements;

    @FindBy(css = "#colors .bootstrap-select")
    private WebElement colors;

    @FindBy(css = "#colors ul > li")
    private List<WebElement> colorsDropdownElements;

    @FindBy(css = ".metals .bootstrap-select")
    private WebElement metals;

    @FindBy(css = ".metals .caret")
    private WebElement metalsCaret;

    @FindBy(css = "#metals ul > li")
    private List<WebElement> metalsDropdownElements;

    @FindBy(id = "vegetables")
    private WebElement vegetables;

    @FindBy(css = "#vegetables .dropdown-menu li")
    private List<WebElement> vegetablesDropdownElements;

    @FindBy(id = "submit-button")
    private WebElement submitButton;


    public MetalsColorsPage(WebDriver driver) {
        super(driver);
        resultWindow = new ResultWindow(driver);
        PageFactory.initElements(driver, this);
    }

    public void addingData(TestDataModel testDataModel) {
        setColor(testDataModel.getColors());
        setMetal(testDataModel.getMetals());
        setVegetable(testDataModel.getVegetables());
        setElement(testDataModel.getElements());
        setEven(testDataModel.getEven());
        setOdd(testDataModel.getOdd());
    }

    public void setColor(String color) {
        if (!color.equalsIgnoreCase(Colors.COLORS.toString())) {
            setWebElement(colors, colorsDropdownElements, colors, color);
        }
    }

    public void setMetal(String metal) {
        if (!metal.equalsIgnoreCase(Metals.METALS.toString())) {
            setWebElement(metalsCaret, metalsDropdownElements, metals, metal);
        }
    }

    public void setVegetable(List<Vegetables> vegetable) {
        if (!vegetable.get(0).toString().equalsIgnoreCase(Vegetables.VEGETABLES.toString())) {
            vegetables.click();
            wait.until(ExpectedConditions
                    .attributeToBe(By.cssSelector("#vegetables .dropdown-menu"), "style", "display: block;"));
            driver.findElement(By.xpath("//*[@id='vegetables']//label[text()='Vegetables']")).click();
            for (Vegetables vegetableToSet : vegetable) {
                clickElement(vegetablesDropdownElements, vegetableToSet.toString());
            }
        }
    }

    public void setElement(List<Elements> element) {
        if (element != null) {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            for (Elements elemToSet : element) {
                clickElement(elements, elemToSet.toString());
            }
        }
    }

    public void setOdd(String value) {
        setNumber(value, summaryRadioOdd);
    }

    public void setEven(String value) {
        setNumber(value, summaryRadioOdd);
    }

    private void setNumber(String value, List<WebElement> whereToSet) {
        if (!value.equals("2") | !value.equals("1")) {
            wait.until(ExpectedConditions.visibilityOfAllElements(whereToSet));
            clickElement(whereToSet, value);
        }
    }

    private void setWebElement(WebElement elemToSet, List<WebElement> whatWaitToAppear, WebElement elemTocCheck, String valueToSet) {
        elemToSet.click();
        wait.until(ExpectedConditions
                .attributeToBe(elemTocCheck, "class", "btn-group bootstrap-select uui-form-element open"));
        clickElement(whatWaitToAppear, valueToSet);
    }

    private void clickElement(List<WebElement> whereToSet, String value) {
        for (WebElement element : whereToSet) {
            if (element.getText().equalsIgnoreCase(value.toString())) {
                element.click();
            }
        }
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getSumResult() {
        return resultWindow.sumResult();
    }

    public String getColorResult() {
        return resultWindow.colorResult();
    }

    public String getMetalResult() {
        return resultWindow.metalResult();
    }

    public String getVegetableResult() {
        return resultWindow.vegetableResult();
    }

    public String getElementsResult() {
        return resultWindow.elementsResult();
    }

}