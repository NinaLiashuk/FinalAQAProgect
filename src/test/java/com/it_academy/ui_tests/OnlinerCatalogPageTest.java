package com.it_academy.ui_tests;

import com.it_academy.framework.WebDriverFactoryStaticThreadRemote;
import com.it_academy.navigation.OnlinerNavigation;
import com.it_academy.ui_tests.BaseTest;
import com.it_academy.ui_tests.OnlinerCatalogPage;
import com.it_academy.ui_tests.OnlinerHeaderPage;
import io.qameta.allure.Step;
import org.testng.annotations.*;


public class OnlinerCatalogPageTest extends BaseTest {

    private OnlinerHeaderPage headerPage;
    private OnlinerCatalogPage catalogPage;

    @BeforeClass
    @Parameters(value = {"browser", "remote"})
    public void openBrowser(String browser, boolean remote){
        OnlinerNavigation.openOnlinerHeaderPage(browser, remote);
        headerPage = new OnlinerHeaderPage();
        catalogPage = new OnlinerCatalogPage();
    }

    @Test(dataProvider = "horizontal-categories-params")
    public void testIsItemFromHorizontalListVisible(String value) {
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.verifyThatItemFromHorizontalListVisible(value);
    }


    @Test(dataProvider = "vertical-list-params")
    public void testIsItemFromVerticalListVisible(String value) {
        headerPage.crossToOnlinerCatalogPage();
        catalogPage.crossToCategoryFromCatalog("Компьютеры и сети");
        catalogPage.verifyThatItemFromVerticalListVisible(value);
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
                {"Дом и сад",}, {"Авто и"}, {"Красота и спорт"}, {"Детям и мамам"}, {"Работа и офис"}};
    }

    @DataProvider(name = "vertical-list-params")
    public Object[][] dataProviderMethod2() {
        return new Object[][]{{"Ноутбуки, компьютеры, мониторы"}, {"Комплектующие"}, {"Сетевое оборудование"},
                {"Хранение данных"}};
    }
}