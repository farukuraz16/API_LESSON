package PracticeExtra;

import BaseURLs.Practice03BaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class p04 extends Practice03BaseURL {
    /*
        Given
            https://jsonplaceholder.typicode.com/users   --> resources farklı
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    Data uzunluğunun 10 olduğunu assert ediniz.
     */


    @Test
    public void p04(){

        baseURL.pathParams("users","users");
        Response response = given().when().spec(baseURL).get("/{users}");
        response.prettyPrint();

        response.then().assertThat().
                statusCode(200).
//                contentType("application/json").
                contentType(ContentType.JSON).
                body("data", Matchers.hasSize(10));



    }

}
