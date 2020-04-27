package jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import jdi.entity.User;
import jdi.forms.LogInForm;


public class HomePage extends WebPage {

    @Css("ul.uui-navigation.nav.navbar-nav.m-l8")
    private Button goToMetalsColorsPage;


    @Css("#user-name")
    public Text userName;

    @Css("#user-icon")
    private Button userIcon;

    private LogInForm jdiLoginForm;


    public void login(User user) {
        userIcon.click();
        jdiLoginForm.login(user);
    }

    public String getUserName() {
        return userName.getValue();
    }

    public void setGoToMetalsColorsPage() {
        goToMetalsColorsPage.click();
    }


}
