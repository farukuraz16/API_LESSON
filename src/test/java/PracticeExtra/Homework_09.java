package PracticeExtra;

import BaseURLs.DummyBaseURL;
import BaseURLs.RestApiExamBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.DummyRestApiExpextedPojo;
import pojoDatas.DummyRestApiRequestPojo;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Homework_09 extends DummyBaseURL {
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

        //Step 1: set URL
        specification.pathParam("createPath", "create");

        //Step 2: expected data
        DummyRestApiRequestPojo requestData = new DummyRestApiRequestPojo("Drake F.","40000","28");
        DummyRestApiExpextedPojo expectedData = new DummyRestApiExpextedPojo("success",requestData,"Successfully! Record has been added.");


        //Step 3: response
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                auth().basic("admin","password123").
                body(requestData).
                when().post("/{createPath}");

        System.out.println("Response: ");
        response.prettyPrint();


        //Step 4: assertion
        DummyRestApiExpextedPojo actualData = response.as(DummyRestApiExpextedPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getMessage(),actualData.getMessage());
        assertEquals(expectedData.getData().getAge(),actualData.getData().getAge());
        assertEquals(expectedData.getData().getSalary(),actualData.getData().getSalary());
        assertEquals(expectedData.getData().getName(),actualData.getData().getName());

    }
}
