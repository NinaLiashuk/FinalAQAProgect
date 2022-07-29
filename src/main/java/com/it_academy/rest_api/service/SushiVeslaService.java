package com.it_academy.rest_api.service;

import com.google.common.collect.ImmutableMap;
import com.it_academy.rest_api.endpoints.OnlinerEndpoints;
import com.it_academy.rest_api.model.SushiVeslaProduct;
import com.it_academy.rest_api.utils.GetRequestUtils;
import com.it_academy.rest_api.utils.ResponseBodyUtils;
import io.restassured.response.ResponseBody;

import java.util.List;
import java.util.Map;

public class SushiVeslaService {
    private static final String SUSHI_PRODUCTS_JSON_PATH = "products";
    private static final String SUSHI_NAME_PREFIX_JSON_PATH = "products.name_prefix";

    public List<SushiVeslaProduct> getSushiProductItems() {
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(
                OnlinerEndpoints.getCatalogProductSushiEndPoint(), configureHeaders(), null);

        return ResponseBodyUtils.getObjectsByJsonPath(responseBody, SUSHI_PRODUCTS_JSON_PATH,
                SushiVeslaProduct.class);
    }

    public static Map<String, Object> configureHeaders(){
        return ImmutableMap.of("User-Agent", "PostmanRuntime/7.29.0");
    }

    public String getSushiNamePrefix(){
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(
                OnlinerEndpoints.getProductSushiRollsEndPoint(), configureHeaders(), null);

        return ResponseBodyUtils.getStringJsonValue(responseBody, SUSHI_NAME_PREFIX_JSON_PATH);
    }
}
