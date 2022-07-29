package com.it_academy.rest_api.service;

import com.google.common.collect.ImmutableMap;
import com.it_academy.rest_api.endpoints.OnlinerEndpoints;
import com.it_academy.rest_api.model.HeadphonesFacet;
import com.it_academy.rest_api.utils.GetRequestUtils;
import com.it_academy.rest_api.utils.ResponseBodyUtils;
import io.restassured.response.ResponseBody;

import java.util.List;
import java.util.Map;

public class HeadphonesService {
    private static final String HEADPHONES_FACETS_JSON_PATH = "facets.general.items";

    public List<HeadphonesFacet> getHeadphonesFacetItems() {
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(
                OnlinerEndpoints.getCatalogFacetEndPoint(),
                configureHeaders(), null);
        return ResponseBodyUtils.getObjectsByJsonPath(
                responseBody, HEADPHONES_FACETS_JSON_PATH, HeadphonesFacet.class);
    }

    public static Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }
}
