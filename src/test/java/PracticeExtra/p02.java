package PracticeExtra;

import BaseURLs.PracticeBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class p02 extends PracticeBaseURL {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/78
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "404" olduğunu Assert et
    And
        Response Body nin "Not Found" olduğunu assert et
    And
        Via nın "1.1 vegur" olduğunu assert et.
    And
        Response body nin "Clarusway" yazmadığını assert et
    And
        Status Line "HTTP/1.1 404 Not Found" olduğunu assert et.

     */


    @Test
    public void p02(){

        baseURL.pathParams("booking","booking","id","78100");
        Response response = given().when().spec(baseURL).get("/{booking}/{id}");
        response.prettyPrint();

        response.then().assertThat().statusCode(404);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        assertTrue(response.asString().contains("Not Found"));

        //System.out.println("response.headers() = " + response.headers());
        assertTrue(response.getHeader("Via").equals("1.1 vegur"));

        assertFalse(response.asString().contains("Clarusway"));

        response.then().assertThat().statusLine("HTTP/1.1 404 Not Found");

    }

}
