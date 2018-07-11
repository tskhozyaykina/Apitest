package ru.tskhozyaykina.apitest;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.tskhozyaykina.apitest.Precondition.Precondition;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@Feature("API")
@Story("/test-api")
public class CheckGetTest extends Precondition {
    @Test(description = "GET")
    public void checkGetRequest() {
        String url = RestAssured.baseURI + "/test-api";
        Response response = given().relaxedHTTPSValidation().get(url);
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("name", equalTo("testName"))
                .body("count", equalTo(1))
                .body("priority", equalTo(true));
    }
}
