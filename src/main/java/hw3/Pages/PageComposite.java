package hw3.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public abstract class PageComposite {

    protected WebDriver driver;


    public PageComposite(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
