package com.equifax.get;

import com.equifax.utility.ConfigurationReader;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DummyApiGetEndpointTest {

    static RequestSpecification requestSpecification;
    static ResponseSpecification responseSpecification;

    @BeforeAll
    public static void setUp(){
        baseURI = ConfigurationReader.getProperty("base_url");
        basePath = ConfigurationReader.getProperty("base_path");

        requestSpecification =   given()
                                    .log().all()
                                    .accept(ContentType.JSON);

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

        responseSpecification = responseSpecBuilder
                                    .expectStatusCode(200)
                                    .expectContentType(ContentType.JSON)
                                    .expectBody("status", is("success"))
                                    .expectBody("data.employee_name", equalTo("Charde Marshall"))
                                    .build();
    }


    @Test
    public void getEndpointTest(){

                    given()
                            .spec(requestSpecification).
                    when()
                            .get("/employee/13").prettyPeek().
                    then()
                            .spec(responseSpecification);






    }

}
