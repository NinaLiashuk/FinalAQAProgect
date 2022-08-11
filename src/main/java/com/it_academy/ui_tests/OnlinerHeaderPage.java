package com.it_academy.ui_tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class OnlinerHeaderPage{

    private final static ElementsCollection categoriesOnHeaderPage =
            $$x("//*[contains(@class, 'b-main-navigation__text')]/ancestor::li");

    private final static  String ITEMS_INTO_DROPDOWN_LIST =
            ".//span[contains(@class, 'b-main-navigation__dropdown-advert-sign')]";

    @Step("move to category {link}")
    public OnlinerHeaderPage moveToLinkOnHeaderPage(String link){
        $$(categoriesOnHeaderPage).findBy(Condition.text(link)).hover();
        return this;
    }

    public List<SelenideElement> getDropdownList(String link){
        return $$(categoriesOnHeaderPage)
                .findBy(Condition.text(link))
                .$$x(ITEMS_INTO_DROPDOWN_LIST);
    }

    @Step("verify that all products from link {link} are visible")
    public void assertThatDropdownListIsDisplayed(String link){
        $$(getDropdownList(link)).shouldBe(CollectionCondition.allMatch(
                "category title is not displayed via link navigation", WebElement::isDisplayed));
    }

    @Step("verify that product-list from link {link} has size {size}")
    public void assertThatDropdownListHasSize(String link, int size){
        $$(getDropdownList(link)).shouldHaveSize(size);
    }

    @Step("verify that product-list from link {link} contains value {value}")
    public void assertThatDropdownListContainsValue(String link, String value){
        $$(getDropdownList(link)).findBy(Condition.text(value)).shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    @Step("navigate to catalog page")
    public OnlinerCatalogPage crossToOnlinerCatalogPage(){
        $$(categoriesOnHeaderPage).findBy(Condition.text("Каталог")).click();
        return new OnlinerCatalogPage();
    }
}
