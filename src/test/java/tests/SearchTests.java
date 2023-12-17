package tests;

import org.testng.annotations.Test;

public class SearchTests extends TestBase {

    @Test
    public void searchPositiveTest() {
        app.getSearch().fillSearchForm("Haifa","12/14/2023","03/19/2024");
        app.getSearch().submitSearchForm();
    }
}
