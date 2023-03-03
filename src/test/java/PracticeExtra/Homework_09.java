package PracticeExtra;

import BaseURLs.RestApiExamBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Homework_09 extends RestApiExamBaseUrl {
       /*

    Given
        http://dummy.restapiexample.com/api/v1/create
    And
        Request Body olarak aşağıdaki pattern de body gönderiniz
      {
  "name": "Drake F.",
  "salary": "40000",
  "age": "27"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
           {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",
        "id": 4545
    },
    "message": "Successfully! Record has been added."
}

   */

    @Test
    public void hm09() {
        specification.pathParam("createPath", "create");

        String bodyData = "      {\n" +
                "  \"name\": \"Drake F.\",\n" +
                "  \"salary\": \"40000\",\n" +
                "  \"age\": \"27\"\n" +
                "}";


        HashMap<String, Object> bodyDataMap = JsonToJava.convertJsonToJavaObject(bodyData, HashMap.class);

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                body(bodyDataMap).
                when().
                post("/{createPath}");

        response.prettyPrint();


    }
}
