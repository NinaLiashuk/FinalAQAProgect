package com.it_academy.page_object.junit5;

import com.it_academy.navigation.OnlinerNavigation;
import com.it_academy.page_object.OnlinerCatalogPage;
import com.it_academy.page_object.OnlinerHeaderPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Execution(ExecutionMode.CONCURRENT)
class OnlinerCatalogPageJUnitTest {

    private OnlinerHeaderPage headerPage = new OnlinerHeaderPage();
    private OnlinerCatalogPage catalogPage = new OnlinerCatalogPage();

    @BeforeAll
    public static void openBrowser(){
        OnlinerNavigation.openOnlinerHeaderPage();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Электроника", "Компьютеры и сети", "Бытовая техника", "Стройка и ремонт", "Дом и сад",
            "Авто и", "Красота и спорт", "Детям и мамам", "Работа и офис"})

    public void testThatCatalogContainsElementsFromValues(String value) {
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.verifyThatItemFromHorizontalListVisible(value);

    }
    @ParameterizedTest
    @ValueSource(strings = {"Ноутбуки, компьютеры, мониторы", "Комплектующие", "Сетевое оборудование",
            "Хранение данных"})
    public void testThatComputersAndNetworksContainsElementsFromValues(String value){
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.crossToCategoryFromCatalog("Компьютеры и сети");
        catalogPage.verifyThatItemFromVerticalListVisible(value);
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