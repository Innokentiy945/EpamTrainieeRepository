package jdi.forms;


import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;

import com.epam.jdi.light.ui.html.elements.common.TextField;
import jdi.entity.User;

public class LogInForm extends Form<User> {
    @Css("#name")
    private TextField name;

    @Css("#password")
    private TextField password;

    @XPath("//*[@id=\"login-button\"]")
    private Button submit;

}
