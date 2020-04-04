package hw3.Pages;

import hw3.Composite.*;
import org.openqa.selenium.WebDriver;

public class AbstractPage extends PageComposite {



    protected HeaderMenuComposite headerMenuComposite;
    protected BenefitsItemComposite benefitsItemComposite;
    protected FramePageComposite framePageComposite;
    protected LeftSectionOfPageComposite leftSectionOfPageComposite;
    protected ServicesPageComposite servicesPageComposite;


    public AbstractPage(WebDriver driver) {
        super(driver);
        headerMenuComposite = new HeaderMenuComposite(driver);
        benefitsItemComposite = new BenefitsItemComposite(driver);
        framePageComposite = new FramePageComposite(driver);
        leftSectionOfPageComposite = new LeftSectionOfPageComposite(driver);
        servicesPageComposite = new ServicesPageComposite(driver);
    }


}
