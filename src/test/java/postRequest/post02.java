package postRequest;

import BaseURLs.GorestBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.GoRestApiTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class post02 extends GorestBaseURL {
    /*

    Given
        https://gorest.co.in/public/v2/users
    And

           Request Body olarak aşağıdaki pattern de body gönderiniz
           {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "201" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
             {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}

   */


    @Test
    public void post02() {
        //Step 1: set URL
        specification.pathParam("usersPath", "users");

        //Step 2: set expected data and request body
        GoRestApiTestData goRestApiTestData = new GoRestApiTestData();
        HashMap<String, String> reqBodyAndExpectedDataMap = goRestApiTestData.reqBodyAndExpectedData("Enes Bera Uraz", "male", "enesuraz@enes.com", "active");
        System.out.println("reqBodyAndExpectedDataMap = " + reqBodyAndExpectedDataMap);

        //Step 3: send request response
        Response response = given().
                spec(specification).
                body(reqBodyAndExpectedDataMap).//body gönderiyoruz
                        contentType(ContentType.JSON).//Json type'ı olarak gönderiyoruz
                        when().
                header("Authorization", "Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0").//header'dan authantication almamız gerekiyor. ve TOKEN girmemiz gerkiyor. bunu bize doc'da belirtiyor.
                        post("/{usersPath}");//buraya post ediyoruz.
        response.prettyPrint();

        //Step 4: Assertion


    }

}
