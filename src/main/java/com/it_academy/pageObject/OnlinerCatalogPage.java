package com.it_academy.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class OnlinerCatalogPage extends OnlinerHeaderPage{

    private final static List<SelenideElement> catalogHorizontalListNavigatePattern =
            $$x("//li[contains(@class, 'catalog-navigation-classifier')]");

    private final static List<SelenideElement> categoryVerticalListNavigatePattern =
            $$x("//div[contains(@class,'catalog-navigation-list__aside-item')]");

    private static final String ITEMS_FROM_DROPDOWN_WIDGETS =
            ".//*[@class=\"catalog-navigation-list__dropdown-data\"]";


    public OnlinerCatalogPage crossToCategoryFromCatalog(String s){
        $$(catalogHorizontalListNavigatePattern).findBy(Condition.text(s)).click();
    //    sleep(700);
        return this;
    }

    public void isItemFromHorizontalListVisible(String category){
        $$(catalogHorizontalListNavigatePattern).findBy(Condition.text(category)).shouldBe(Condition.visible);
    }

    public void isItemFromVerticalListVisible(String category){
        $$(categoryVerticalListNavigatePattern).findBy(Condition.text(category)).shouldBe(Condition.visible);
    }

    public OnlinerCatalogPage crossToCategoryFromVerticalList(String s){
        $$(categoryVerticalListNavigatePattern).findBy(Condition.text(s)).click();
        return this;
    }

    public List<SelenideElement> getDropdownWidgets(String s) {
        return $$(categoryVerticalListNavigatePattern)
                .findBy(Condition.text(s))
                .$$x(ITEMS_FROM_DROPDOWN_WIDGETS);
    }

    public void assertThatAllItemsTitlesVisible(String s){
        $$(getDropdownWidgets(s))
                .as("element should be visible with title")
                .findBy(Condition.attribute("innerText"))
                .shouldBe(Condition.visible);
    }

    public void assertThatAllItemsQuantityVisible(String s){
        $$(getDropdownWidgets(s))
                .as("element should be visible with quantity of products")
                .findBy(Condition.attribute("textContent"))
                .shouldHave(Condition.text("товар"))
                .shouldBe(Condition.visible);
    }

    public void assertThatAllItemsMinPriceVisible(String s){
        $$(getDropdownWidgets(s))
                .findBy(Condition.attribute("textContent"))
                .shouldHave(Condition.text("от"))
                .shouldHave(Condition.text(" р."))
                .shouldBe(Condition.visible);
    }
}
