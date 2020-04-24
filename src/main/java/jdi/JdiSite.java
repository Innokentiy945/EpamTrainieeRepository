package jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import jdi.pages.HomePage;
import jdi.pages.MetalsColorsPage;

@JSite("http://jdi-testing.github.io/jdi-light")
public class JdiSite {

    @Url("/index.html")
    public static HomePage homePage;
    public static MetalsColorsPage metalsColorsPage;

    public static void open() {
        homePage.open();
        metalsColorsPage.open();
    }


}
