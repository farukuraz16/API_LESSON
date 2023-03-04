package postRequest;

import BaseURLs.DummyBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.DummyRestApiRequestPojo;
import pojoDatas.DummyRestApiExpextedPojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post03 extends DummyBaseURL {
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
    public void post03(){
        //Step 1: set URL
        specification.pathParam("createPath","create");

        //Step 2: set expected data and req. body

        //request body-->>>> (test case'de bu verilmişti.)
        DummyRestApiRequestPojo dummyRestApiRequestPojo = new DummyRestApiRequestPojo("Drake F.","40000","28");


        /*
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
        //data kısmı için yukarıdaki dummyRestApiPojo objesi oluşturuldu. şimdi hepisini kapsayan başka bir pojo class
        //oluşturduk---> dummyRestApiReqPojo.. dummyRestApiPojo'yu bunun içine obje olarak atacağız...


        //expected data---->>>
        DummyRestApiExpextedPojo dummyRestApiExpextedPojo = new DummyRestApiExpextedPojo("success", dummyRestApiRequestPojo,"Successfully! Record has been added.");


        //Step 3: send request
        // Basic Auth.--> Kullanılacak. Doc.'da auth istemiyor. ancak biz örnek olsun diye nasıl kullanıldığını öğrenmek için basic auth. ile işlem yapacağız.
        // Bearer Token ---> header da vermiştik
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                auth().basic("admin","password123").
                body(dummyRestApiRequestPojo).
                when().post("/{createPath}");

        System.out.println("Response: ");
        response.prettyPrint();


        //Step 4: assertion

        DummyRestApiExpextedPojo actualData = response.as(DummyRestApiExpextedPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(dummyRestApiExpextedPojo.getStatus(),actualData.getStatus());
        assertEquals(dummyRestApiExpextedPojo.getMessage(),actualData.getMessage());
        assertEquals(dummyRestApiExpextedPojo.getData().getAge(),actualData.getData().getAge());
        assertEquals(dummyRestApiExpextedPojo.getData().getSalary(),actualData.getData().getSalary());
        assertEquals(dummyRestApiExpextedPojo.getData().getName(),actualData.getData().getName());
    }
}
