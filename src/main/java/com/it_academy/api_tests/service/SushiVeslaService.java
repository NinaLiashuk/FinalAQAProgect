package com.it_academy.api_tests.service;

import com.google.common.collect.ImmutableMap;
import com.it_academy.api_tests.endpoints.OnlinerEndpoints;
import com.it_academy.api_tests.model.SushiVeslaProduct;
import com.it_academy.api_tests.utils.GetRequestUtils;
import com.it_academy.api_tests.utils.ResponseBodyUtils;
import io.qameta.allure.Step;
import io.restassured.response.ResponseBody;

import java.util.List;
import java.util.Map;

import static com.it_academy.api_tests.endpoints.OnlinerEndpoints.getProductSushiRollsEndPoint;

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
                getProductSushiRollsEndPoint(), configureHeaders(), null);

        return ResponseBodyUtils.getStringJsonValue(responseBody, SUSHI_NAME_PREFIX_JSON_PATH);
    }
}
