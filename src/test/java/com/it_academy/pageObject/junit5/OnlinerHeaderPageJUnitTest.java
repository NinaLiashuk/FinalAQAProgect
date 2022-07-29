package com.it_academy.pageObject.junit5;

import com.it_academy.navigation.OpenOnlinerPage;
import com.it_academy.pageObject.OnlinerHeaderPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OnlinerHeaderPageJUnitTest {

    private OnlinerHeaderPage headerPage = new OnlinerHeaderPage();

    @BeforeAll
    public static void openBrowser(){
        OpenOnlinerPage.openOnlinerHeaderPage();
    }

    @Test
    @DisplayName("assert that move mouse to Car Market link show dropdown list")
    public void moveMouseToCarMarketTitleShouldShowDropdownList() {
        headerPage
                .moveToLinkOnHeaderPage("Автобарахолка")
                .assertThatDropdownListIsDisplayed("Автобарахолка");
    }

    @Test
    @DisplayName("check that Car Market dropdown list have size from value")
    public void carMarketDropdownListShouldHaveSize() {
        headerPage
                .moveToLinkOnHeaderPage("Автобарахолка")
                .assertThatDropdownListHasSize("Автобарахолка", 36);
    }

    @ParameterizedTest
    @CsvSource(value = {"Минск", "Гродно", "Брест", "Opel", "Kawasaki"})
    public void carMarketDropdownListContainsValues(String value) {
        headerPage
                .moveToLinkOnHeaderPage("Автобарахолка")
                .assertThatDropdownListContainsValue("Автобарахолка", value);
    }
    @Test
    @DisplayName("assert that move mouse to Houses And Homes link show dropdown list")
    public void moveMouseToHousesTitleShouldShowDropdownList() {
        headerPage
                .moveToLinkOnHeaderPage("Дома и квартиры")
                .assertThatDropdownListIsDisplayed("Дома и квартиры");
    }

    @Test
    @DisplayName("check that Houses And Homes dropdown list have size from value")
    public void housesAndHomesDropdownListShouldHaveSize() {
        headerPage
                .moveToLinkOnHeaderPage("Дома и квартиры")
                .assertThatDropdownListHasSize("Дома и квартиры", 28);
    }

    @ParameterizedTest
    @DisplayName("check that Houses And Homes dropdown list have values from parameters")
    @CsvSource(value = {"Минск", "Гродно", "2-комнатные", "3-комнатные", "$"})
    public void housesAndHomesDropdownListContainsValues(String value){
        headerPage
                .moveToLinkOnHeaderPage("Дома и квартиры")
                .assertThatDropdownListContainsValue("Дома и квартиры", value);
    }

}