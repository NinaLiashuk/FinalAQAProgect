package com.it_academy.rest_api.endpoints;

import com.it_academy.rest_api.property.PropertiesReader;

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
