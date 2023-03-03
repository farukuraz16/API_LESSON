package postRequest;

import BaseURLs.GorestBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testData.GoRestApiTestData;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post01 extends GorestBaseURL {
    /*
    Given
        https://gorest.co.in/public/v2/users
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "422" olduğunu Assert et

   */

    @Test
    public void post01(){
        //Step 1: set URL
        specification.pathParam("usersPATH","users");

        //Step 2: set expected data
        GoRestApiTestData goRestApiTestData = new GoRestApiTestData();
        System.out.println("Expected Test Data = " + goRestApiTestData.statusCodeForPostInvalid());


        /*
        https://gorest.co.in/
        adresinde
        "Request methods PUT, POST, PATCH, DELETE needs access token, which needs to be passed with "Authorization" header as Bearer token."
        doc bize ne yapacağımızı anlatıyor. bu bilgiye göre aşağıaki request hazırlanıyor.
         */
        //Step 3: send a request
        Response response = given().spec(specification).when().
                header("Authorization","Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0").
                post("/{usersPATH}");
        System.out.println("Response: ");
        response.prettyPrint();

        //Step 4: assertion
        //assertEquals(goRestApiTestData.statusCodeForPostInvalid(),response.statusCode());
        response.then().assertThat().statusCode(422);

    }
}
