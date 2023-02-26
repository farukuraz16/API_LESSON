package getRequest;

import BaseURLs.RestfulBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Homework_02 extends RestfulBaseURL {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
             Kullanıcı GET Methodu ile Request Gönderir
         And
            Kullanıcı firstname olarak Sarah i aratır
        Then
            Status Code un "200" olduğunu Assert et
		And
            Response body de "bookingid" olduğunu verify eder.

*/

    @Test
    public void HM_02(){
        specification.pathParams("bookingPath","booking");
        Response response = given().spec(specification).when().get("/{bookingPath}");
        //response.prettyPrint();
        //response.then().assertThat().body("firstname", Matchers.equalTo("Sarah"));
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body(Matchers.containsString("bookingid"));
    }
}
