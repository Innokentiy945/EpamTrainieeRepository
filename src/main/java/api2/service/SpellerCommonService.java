package api2.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import api2.utils.PropertiesReader;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class SpellerCommonService {

    public RequestSpecification requestSpec;

    public SpellerCommonService() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(PropertiesReader.read("baseUri"))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        return given(requestSpec)
                .params(params)
                .when()
                .get(uri);
    }
}
