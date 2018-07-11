package ru.tskhozyaykina.apitest.Precondition;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class Precondition {
    @BeforeClass(description = "Включаю слушатель AllureRestAssured")
    public void beforeClass() {
        RestAssured.filters(new AllureRestAssured());
        RestAssured.baseURI = "http://localhost:8080";
    }
}
