package com.it_academy.pageObject.testNg;

import com.codeborne.selenide.Configuration;
import com.it_academy.driver.WebDriverFactoryStaticThreadRemote;
import com.it_academy.navigation.OpenOnlinerPage;
import com.it_academy.pageObject.OnlinerHeaderPage;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class OnlinerHeaderPageTest {

    private OnlinerHeaderPage headerPage;

    @BeforeClass
    @Parameters(value = {"browser"})
    public void testOpenBrowser(String value){

        OpenOnlinerPage.openOnlinerWithDriverLocal(value);
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