package com.star.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static String generateBearerToken(String email, String password, String endpoint) {

        Response response = given()
                .accept(ContentType.JSON)
                .queryParam("email", email)
                .and()
                .queryParam("password", password)
                .when().get(ConfigurationReader.getProperty("env") + endpoint);

        String token = "Bearer " + response.path("accessToken");

        return token;
    }

    public static String generateTokenByRole(String role) {

        //returnCredentials(role);


        String token = given()
                .queryParams(returnCredentials(role))
                .when().get(ConfigurationReader.getProperty("env")  + "/sign").prettyPeek().path("accessToken");

        return "Bearer " + token;

    }

    public static Map<String, String> returnCredentials(String role) {
        String email = "";
        String password = "";

        switch (role) {
            case "role1":
                email = Environment.ROLE1_EMAIL;
                password = Environment.ROLE1_PASSWORD;
                break;

            case "role2":
                email = Environment.ROLE2_EMAIL;
                password = Environment.ROLE2_PASSWORD;
                break;
            case "role3":
                email = Environment.ROLE3_EMAIL;
                password = Environment.ROLE3_PASSWORD;
                break;

            default:

                throw new RuntimeException("Invalid Role Entry :\n>> " + role + " <<");
        }
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        credentials.put("password", password);

        return credentials;

    }


}