package com.it_academy.rest_api;

import com.google.common.collect.ImmutableMap;
import com.it_academy.rest_api.model.SushiVeslaProduct;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FirstClassApi {

    public static void main(String[] args) {
        ResponseBody responseBody = given()
                .headers(configureHeaders())
                .when()
                .get("https://catalog.onliner.by/sdapi/catalog.api/search/sushivesla")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .getBody();
        System.out.println(responseBody.asString());

        List<SushiVeslaProduct> products = responseBody
                .jsonPath()
                .getList("products", SushiVeslaProduct.class);
        System.out.println("Products " + products);
    }

    public static Map<String, String> configureHeaders(){
        return ImmutableMap.of("User-Agent", "PostmanRuntime/7.29.0");
    }

}
