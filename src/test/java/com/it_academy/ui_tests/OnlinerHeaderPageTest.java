package com.it_academy.ui_tests;

import com.it_academy.framework.WebDriverFactoryStaticThreadRemote;
import com.it_academy.navigation.OnlinerNavigation;
import com.it_academy.ui_tests.OnlinerHeaderPage;
import org.testng.annotations.*;

public class OnlinerHeaderPageTest extends BaseTest {

    private OnlinerHeaderPage headerPage;

    @BeforeClass
    @Parameters(value = {"browser", "remote"})
    public void testOpenBrowser(String browser, boolean remote){

        OnlinerNavigation.openOnlinerHeaderPage(browser, remote);
        headerPage = new OnlinerHeaderPage();
    }

    @Test
    public void testAssertThatDropdownListIsDisplayedWhenMouseOnCarMarketTitle() {
        headerPage
                .moveToLinkOnHeaderPage("Автобарахолка")
                .assertThatDropdownListIsDisplayed("Автобарахолка");
    }

    @Test
    public void testAssertThatCarMarketDropdownListHasSize() {
        headerPage
                .moveToLinkOnHeaderPage("Автобарахолка")
                .assertThatDropdownListHasSize("Автобарахолка", 36);
    }

    @Test(dataProvider = "car-market-params")
    public void testAssertThatCarMarketDropdownListContainsValue(String value) {
        headerPage
                .moveToLinkOnHeaderPage("Автобарахолка")
                .assertThatDropdownListContainsValue("Автобарахолка", value);
    }

    @Test
    public void testAssertThatDropdownListIsDisplayedWhenMouseOnHousesAndFlatsTitle() {
        headerPage
                .moveToLinkOnHeaderPage("Дома и квартиры")
                .assertThatDropdownListIsDisplayed("Дома и квартиры");
    }

    @Test
    public void testAssertThatHousesAndFlatsDropdownListHasSize() {
        headerPage
                .moveToLinkOnHeaderPage("Дома и квартиры")
                .assertThatDropdownListHasSize("Дома и квартиры", 28);
    }

    @Test(dataProvider = "houses-and-flats-params")
    public void testAssertThatHousesAndFlatsDropdownListContainsValue(String value) {
        headerPage
                .moveToLinkOnHeaderPage("Дома и квартиры")
                .assertThatDropdownListContainsValue("Дома и квартиры", value);
    }

    @AfterClass
    public void close(){
            WebDriverFactoryStaticThreadRemote.closeDriver();
    }

    @DataProvider(name = "car-market-params")
    public Object[][] dataProviderMethod1() {
        return new Object[][]{{"Минск"}, {"Гомель"}, {"Брест"}, {"Opel"}, {"Kawasaki"}};
    }

    @DataProvider(name = "houses-and-flats-params")
    public Object[][] dataProviderMethod2() { 
        return new Object[][]{{"Минск"}, {"Гомель"}, {"2-комнатные"}, {"3-комнатные"}, {"$"}};
    }
}