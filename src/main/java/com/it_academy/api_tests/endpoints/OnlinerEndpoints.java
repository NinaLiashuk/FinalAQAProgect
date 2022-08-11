package com.it_academy.api_tests.endpoints;

import com.it_academy.api_tests.property.PropertiesReader;

public class OnlinerEndpoints {
    public static String getCatalogFacetEndPoint(){
        return PropertiesReader.getEndpointProperty("catalog.facets.headphones");
    }

    public static String getCatalogProductSushiEndPoint(){
        return PropertiesReader.getEndpointProperty("catalog.products");
    }

    public static String getProductSushiRollsEndPoint(){
        return PropertiesReader.getEndpointProperty("catalog.products.roll");
    }
}
