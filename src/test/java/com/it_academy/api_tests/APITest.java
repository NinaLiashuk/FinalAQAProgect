package com.it_academy.api_tests;

import com.it_academy.api_tests.model.SushiVeslaProduct;
import com.it_academy.api_tests.service.SushiVeslaService;
import com.it_academy.ui_tests.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class APITest{

    @Test
    public void testThatSushiProductIdNotEmpty() {
        List<SushiVeslaProduct> products = new SushiVeslaService().getSushiProductItems();

        assertThat(products)
                .extracting(SushiVeslaProduct::getId)
                .noneMatch(Objects::isNull);
    }

    @Test
    @Description("verify that all product keys are not empty")
    public void testThatSushiProductKeyNotEmpty() {
        List<SushiVeslaProduct> products = new SushiVeslaService().getSushiProductItems();

        assertThat(products)
                .extracting(SushiVeslaProduct::getKey)
                .noneMatch(String::isEmpty);
    }

    @Test
    @Description("verify that all product names are not empty")
    public void testThatSushiProductNameNotEmpty() {
        List<SushiVeslaProduct> products = new SushiVeslaService().getSushiProductItems();

        assertThat(products)
                .extracting(SushiVeslaProduct::getName)
                .noneMatch(String::isEmpty);
    }

    @Test
    @Description("verify that all product full names are not empty")
    public void testThatSushiProductFullNameNotEmpty(){
        List<SushiVeslaProduct> products = new SushiVeslaService().getSushiProductItems();

        assertThat(products)
                .extracting(SushiVeslaProduct::getFullName)
                .noneMatch(String::isEmpty);
    }

    @Test
    @Description("verify that all products have name prefix from value")
    public void testThatAllFilteredProductsHasNamePrefixFromValue(){
        String sushiRolls = new SushiVeslaService().getSushiNamePrefix();

        assertThat(sushiRolls.split(",")).allMatch(s -> s.contains("Роллы"));
    }
}
