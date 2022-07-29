package com.it_academy.rest_api;

import com.it_academy.rest_api.model.SushiVeslaProduct;
import com.it_academy.rest_api.service.SushiVeslaService;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class APITest {

    @Test
    public void testThatSushiProductIdNotEmpty() {
        List<SushiVeslaProduct> products = new SushiVeslaService().getSushiProductItems();
        System.out.println(products);

        assertThat(products)
                .extracting(SushiVeslaProduct::getId)
                .noneMatch(Objects::isNull);
    }

    @Test
    public void testThatSushiProductKeyNotEmpty() {
        List<SushiVeslaProduct> products = new SushiVeslaService().getSushiProductItems();
        System.out.println(products);

        assertThat(products)
                .extracting(SushiVeslaProduct::getKey)
                .noneMatch(String::isEmpty);
    }

    @Test
    public void testThatSushiProductNameNotEmpty() {
        List<SushiVeslaProduct> products = new SushiVeslaService().getSushiProductItems();
        System.out.println(products);

        assertThat(products)
                .extracting(SushiVeslaProduct::getName)
                .noneMatch(String::isEmpty);
    }

    @Test
    public void testThatSushiProductFullNameNotEmpty(){
        List<SushiVeslaProduct> products = new SushiVeslaService().getSushiProductItems();
        System.out.println(products);

        assertThat(products)
                .extracting(SushiVeslaProduct::getFull_name)
                .noneMatch(String::isEmpty);
    }

    @Test
    public void testThatAllFilteredProductsHasNamePrefixFromValue(){
        String sushiRolls = new SushiVeslaService().getSushiNamePrefix();
        System.out.println(sushiRolls);

        assertThat(sushiRolls.split(",")).allMatch(s -> s.contains("Роллы"));
    }
}
