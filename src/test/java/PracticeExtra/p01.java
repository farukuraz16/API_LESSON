package PracticeExtra;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class p01 {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/7
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
        Content Type ın "application/json" olduğunu assert et
    And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.
     */

    @Test
    public void p01(){
        String URL = "https://restful-booker.herokuapp.com/booking/7";
        Response response = given().when().get(URL);
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        System.out.println("response.statusCode() = " + response.statusCode());

        response.then().assertThat().contentType("application/json");
        System.out.println("response.getContentType() = " + response.getContentType());

        response.then().assertThat().statusLine("HTTP/1.1 200 OK");
        System.out.println("response.getStatusLine() = " + response.getStatusLine());
    }




}
