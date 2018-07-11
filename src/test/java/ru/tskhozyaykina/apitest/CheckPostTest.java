package ru.tskhozyaykina.apitest;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.tskhozyaykina.apitest.Precondition.Precondition;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Feature("API")
@Story("/test-api/")
public class CheckPostTest extends Precondition {
    @Test(description = "POST")
    public void checkPost() {
        String url = RestAssured.baseURI + "/test-api/1";
        Map<String, Object> params = new HashMap<>();
        params.put("test", "auto");
        params.put("log", true);
        Response response = given().relaxedHTTPSValidation().body(params).post(url);
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("testId", equalTo(1))
                .body("testType", equalTo("auto"))
                .body("log", equalTo(true));

    }

    @Test(description = "POST negative")
    public void checkNegativePost() {
        String url = RestAssured.baseURI + "/test-api/2";
        Map<String, Object> params = new HashMap<>();
        params.put("test", "auto");
        params.put("log", true);
        Response response = given().relaxedHTTPSValidation().body(params).post(url);
        response.then().statusCode(400);

    }
}