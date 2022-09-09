package Core;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.apache.http.params.CoreConnectionPNames;

import java.util.HashMap;

import static Core.CoreConstrains.username;
import static io.restassured.RestAssured.given;

public class ApiCall {
    public static Response getCall(HashMap<String, Object> headers, String path) {
        System.out.println("Control here in api call");
        System.out.println(RestAssured.baseURI + path);
        Response getResponse = given().headers(headers).auth().preemptive().basic(username,"").when().get(path);

        return getResponse;

    }


    public static Response postCall(HashMap<String, Object> headers, String body, String path) {
        System.out.println(path);
        System.out.println(headers);
        //Added RestAssuredConfig ConnectionTimeout here for POC.
        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000));


        Response postResponse;
        if (body != null) {
            postResponse = given().urlEncodingEnabled(false).config(config).headers(headers).auth().preemptive().basic(username,"").when().body(body).post(path);
            return postResponse;
        } else {
            postResponse = given().config(config).headers(headers).auth().preemptive().basic(username,"").when().body(body).post(path);
            return postResponse;
        }
    }

    public static Response patchCall(HashMap<String, Object> headers, String body, String path) {
        System.out.println(RestAssured.baseURI + path);
        System.out.println(headers);
        //Added RestAssuredConfig ConnectionTimeout here for POC.
        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000));


        Response patchResponse;
        if (body != null) {
            patchResponse = given().config(config).headers(headers).auth().preemptive().basic(username,"").when().body(body).patch(path);
            return patchResponse;
        } else {
            patchResponse = given().config(config).headers(headers).auth().preemptive().basic(username,"").when().patch(path);
            return patchResponse;
        }
    }



    public static Response posParamtCall(HashMap<String, Object> headers, String body, String path) {
        System.out.println(path);
        System.out.println(headers);
        //Added RestAssuredConfig ConnectionTimeout here for POC.
        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000));


        Response postResponse;
        if (body != null) {
            postResponse = given().urlEncodingEnabled(false).config(config).headers(headers).auth().preemptive().basic(username,"").when().body(body).post("https://api.xendit.co/callback_virtual_accounts/external_id=va_fixed-124/simulate_payment");
            return postResponse;
        } else {
            postResponse = given().config(config).headers(headers).auth().preemptive().basic(username,"").when().body(body).post(path);
            return postResponse;
        }
    }



}
