package hw4.Ex1;

import hw4.utils.DataOpener;
import hw4.BaseTest.TestBase;
import hw4.Pages.HomePage;
import hw4.Pages.TableWithPagesPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class PageObjectTest1 extends TestBase {



    @Test
    public void functionalTest() {
        HomePage homePage = new HomePage(driver);
        TableWithPagesPage tablePage = new TableWithPagesPage(driver);

        baseTest();

        //5. Open through the header menu Service -&gt; Table with pages
        homePage.goToTableWithPagesPage();

        //6. Check that default value for “Show entries” dropdown is 5
        assertEquals(tablePage.gettingDropdownValue(), DataOpener.read("dropDownValue"));

        //7.Select new value for the entries in the dropdown list
        tablePage.settingDropdownValue(DataOpener.read("entriesDropDown"));

        //8. Assert that in the table displayed corrected amount of rows
        assertEquals(tablePage.gettingTableRowsCount(), 10);

        //9. Type in “Search” field text "junit"
        tablePage.searchFor(DataOpener.read("searchValue"));

        //10. Assert the table contains only records with Search field value
        assertTrue(tablePage.isSearchCorrect(DataOpener.read("searchValue")));

    }

}
