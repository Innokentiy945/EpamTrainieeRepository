package hw4.Components;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.lang.model.util.Elements;

public class ResultWindow extends AbstractPage{

    @FindBy(className = "summ-res")
    private WebElement summResult;

    @FindBy(className = "col-res")
    private WebElement colorResult;

    @FindBy(className = "met-res")
    private WebElement metalResult;

    @FindBy(className = "sal-res")
    private WebElement vegetablesResult;

    @FindBy(className = "elem-res")
    private WebElement elementsResult;

    public ResultWindow(WebDriver driver) {
        super(driver);
    }


    public String sumResult() {
        return getElementText(summResult);
    }

    public String colorResult() {
        return getElementText(colorResult);
    }

    public String metalResult() {
        return getElementText(metalResult);
    }

    public String vegetableResult() {
        return getElementText(vegetablesResult);
    }

    public String elementsResult() {
        return getElementText(elementsResult);
    }

    private String getElementText(WebElement webElement) {
        String elementName = wait.until(ExpectedConditions.visibilityOf(webElement)).getText();
        return elementName.substring(elementName.indexOf(":") + 1).trim().toUpperCase().replaceAll(",", "").replaceAll(" ", "");
    }

}
