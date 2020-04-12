package hw4.Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }
}
