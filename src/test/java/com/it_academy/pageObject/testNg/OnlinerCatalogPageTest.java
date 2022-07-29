package com.it_academy.pageObject.testNg;

import com.codeborne.selenide.Configuration;
import com.it_academy.driver.WebDriverFactoryStaticThreadRemote;
import com.it_academy.navigation.OpenOnlinerPage;
import com.it_academy.pageObject.OnlinerCatalogPage;
import com.it_academy.pageObject.OnlinerHeaderPage;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;

public class OnlinerCatalogPageTest {

    private OnlinerHeaderPage headerPage;
    private OnlinerCatalogPage catalogPage;

    @BeforeClass
    @Parameters(value = {"browser"})
    public void openBrowser(String value){

        OpenOnlinerPage.openOnlinerWithDriverLocal(value);
        headerPage = new OnlinerHeaderPage();
        catalogPage = new OnlinerCatalogPage();
    }

    @Test(dataProvider = "horizontal-categories-params")
    public void testIsItemFromHorizontalListVisible(String value) {
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.isItemFromHorizontalListVisible(value);
    }


    @Test(dataProvider = "vertical-list-params")
    public void testIsItemFromVerticalListVisible(String value) {
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.crossToCategoryFromCatalog("Компьютеры и сети");
        catalogPage.isItemFromVerticalListVisible(value);
    }

    @Test
    public void testAssertThatAllItemsTitlesVisible() {
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.crossToCategoryFromCatalog("Компьютеры и сети");
        catalogPage.crossToCategoryFromVerticalList("Комплектующие");
        catalogPage.assertThatAllItemsTitlesVisible("Комплектующие");
    }

    @Test
    public void testAssertThatAllItemsQuantityVisible() {
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.crossToCategoryFromCatalog("Компьютеры и сети");
        catalogPage.crossToCategoryFromVerticalList("Комплектующие");
        catalogPage.assertThatAllItemsQuantityVisible("Комплектующие");
    }

    @Test
    public void testAssertThatAllItemsMinPriceVisible() {
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.crossToCategoryFromCatalog("Компьютеры и сети");
        catalogPage.crossToCategoryFromVerticalList("Комплектующие");
        catalogPage.assertThatAllItemsMinPriceVisible("Комплектующие");
    }

    @AfterClass
    public void close(){
        WebDriverFactoryStaticThreadRemote.closeDriver();
    }

    @DataProvider(name = "horizontal-categories-params")
    public Object[][] dataProviderMethod1() {
        return new Object[][]{{"Электроника"}, {"Компьютеры и сети"}, {"Бытовая техника"}, {"Стройка и ремонт"},
                {"Дом и сад",}, {"Авто и"}, {"Красота и спорт"}, {"Детям и мамам"}, {"Работа и офис"}, {"Еда"}};
    }

    @DataProvider(name = "vertical-list-params")
    public Object[][] dataProviderMethod2() {
        return new Object[][]{{"Ноутбуки, компьютеры, мониторы"}, {"Комплектующие"}, {"Сетевое оборудование"},
                {"Хранение данных"}};
    }
}