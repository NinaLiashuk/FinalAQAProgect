package com.it_academy.pageObject.junit5;

import com.it_academy.navigation.OpenOnlinerPage;
import com.it_academy.pageObject.OnlinerCatalogPage;
import com.it_academy.pageObject.OnlinerHeaderPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class OnlinerCatalogPageJUnitTest {

    private OnlinerHeaderPage headerPage = new OnlinerHeaderPage();
    private OnlinerCatalogPage catalogPage = new OnlinerCatalogPage();

    @BeforeAll
    public static void openBrowser(){
        OpenOnlinerPage.openOnlinerHeaderPage();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Электроника", "Компьютеры и сети", "Бытовая техника", "Стройка и ремонт", "Дом и сад",
            "Авто и", "Красота и спорт", "Детям и мамам", "Работа и офис", "Еда"})

    public void testThatCatalogContainsElementsFromValues(String value) {
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.isItemFromHorizontalListVisible(value);

    }
    @ParameterizedTest
    @ValueSource(strings = {"Ноутбуки, компьютеры, мониторы", "Комплектующие", "Сетевое оборудование",
            "Хранение данных"})
    public void testThatComputersAndNetworksContainsElementsFromValues(String value){
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.crossToCategoryFromCatalog("Компьютеры и сети");
        catalogPage.isItemFromVerticalListVisible(value);
    }

    @Test
    public void testThatWidgetsOfProductShowTitle(){
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.crossToCategoryFromCatalog("Компьютеры и сети");
        catalogPage.crossToCategoryFromVerticalList("Комплектующие");
        catalogPage.assertThatAllItemsTitlesVisible("Комплектующие");
    }

    @Test
    public void testThatWidgetsOfProductShowQuantity(){
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.crossToCategoryFromCatalog("Компьютеры и сети");
        catalogPage.crossToCategoryFromVerticalList("Комплектующие");
        catalogPage.assertThatAllItemsQuantityVisible("Комплектующие");
    }

    @Test
    public void testThatWidgetsOfProductShowMinPrice(){
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.crossToCategoryFromCatalog("Компьютеры и сети");
        catalogPage.crossToCategoryFromVerticalList("Комплектующие");
        catalogPage.assertThatAllItemsMinPriceVisible("Комплектующие");

//        assertThat(catalogPage.getProductsFromDropdownWidgets("Комплектующие").stream())
//                .allMatch(SelenideElement::isDisplayed)
//                .allMatch(element -> Objects.requireNonNull(element.getAttribute("textContent")).contains("р."))
//                .allMatch(element -> element.getAttribute("textContent").contains("товар"))
//                .noneMatch(element -> element.getAttribute("innerText").isEmpty());
    }
}