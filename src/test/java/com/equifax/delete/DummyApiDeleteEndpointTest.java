package com.equifax.delete;

import com.equifax.utility.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.equifax.utility.ConfigurationReader.getProperty;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DummyApiDeleteEndpointTest {

    @BeforeAll
    public static void setUp(){

        baseURI = ConfigurationReader.getProperty("base_url");
        basePath = ConfigurationReader.getProperty("base_path");
    }

    @Test
    public void deleteEndpointTest(){

        //Response response  =

        given()
                .log().all()
                .pathParam("id", 106).
        when()
                .delete("delete/{id}")
                .prettyPeek().
        then()
                .statusCode(200)   //204
                .body("message", equalTo("Successfully! Record has been deleted"));

        // JsonPath jsonPath = response.jsonPath();
        // Assert.assertThat(jsonPath.getString("message"), equalTo("Successfully! Record has been deleted"));


    }




}
