package hw3.Composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class Benefits extends AbstractPageComposite {


    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitIconsTexts;

    public Benefits(WebDriver driver) {
        super(driver);
    }

    public int benefitImagesCount(){
        return wait.until(ExpectedConditions.visibilityOfAllElements(benefitIcons)).size();
    }

    public int benefitTextsCount(){
        return wait.until(ExpectedConditions.visibilityOfAllElements(benefitIconsTexts)).size();
    }

    public List<String> benefitTexts(){
        wait.until(ExpectedConditions.visibilityOfAllElements(benefitIconsTexts));
        return benefitIconsTexts.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isBenefitIconsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfAllElements(benefitIconsTexts));
        boolean isDisplayed = false;
        for (WebElement element : benefitIconsTexts) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }
}
