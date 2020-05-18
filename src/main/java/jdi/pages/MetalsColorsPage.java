package jdi.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import jdi.forms.FillingDataForm;


public class MetalsColorsPage extends WebPage {

    @Css(".form")
    public FillingDataForm form;

    @Css(".results")
    public Section results;

}

