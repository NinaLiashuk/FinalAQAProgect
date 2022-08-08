package com.it_academy.page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class OnlinerCatalogPage{

    private final static ElementsCollection catalogHorizontalListNavigation =
            $$x("//li[contains(@class, 'catalog-navigation-classifier')]");

    private final static ElementsCollection categoryVerticalListNavigation =
            $$x("//div[contains(@class,'catalog-navigation-list__aside-item')]");

    private static final String ITEMS_FROM_DROPDOWN_WIDGETS =
            ".//*[@class=\"catalog-navigation-list__dropdown-data\"]";

    public OnlinerCatalogPage crossToCategoryFromCatalog(String s){
        $$(catalogHorizontalListNavigation).findBy(Condition.text(s)).click();
        return this;
    }

    public void verifyThatItemFromHorizontalListVisible(String category){
        $$(catalogHorizontalListNavigation).findBy(Condition.text(category)).shouldBe(Condition.visible);
    }

    public void verifyThatItemFromVerticalListVisible(String category){
        $$(categoryVerticalListNavigation).findBy(Condition.text(category)).shouldBe(Condition.visible);
    }

    public OnlinerCatalogPage crossToCategoryFromVerticalList(String s){
        $$(categoryVerticalListNavigation).findBy(Condition.text(s)).click();
        return this;
    }

    public List<SelenideElement> getDropdownWidgets(String s) {
        return $$(categoryVerticalListNavigation)
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
