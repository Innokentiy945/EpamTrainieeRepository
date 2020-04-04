package hw3.Composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPageComposite {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public AbstractPageComposite(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }
}
