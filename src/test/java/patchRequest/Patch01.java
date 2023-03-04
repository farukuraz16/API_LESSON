package patchRequest;

import BaseURLs.RestfulBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Patch01 extends RestfulBaseURL {
    /*
     Given
	        1) https://restful-booker.herokuapp.com/booking/33
	        2) {
    "firstname" : "Drake",
    "lastname" : "CW"
}
3) Auth olarak --> Header da Basic YWRtaW46cGFzc3dvcmQxMjM=


        When
	 		Kullanıcı PATCH Req atar
	    Then
	   	   Status code is 200
	   	   And response body de firs ve lastname değiştiğini assert ediniz.
	   	    {
    "firstname": "Drake",
    "lastname": "CW",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void patch01(){

        //Step 01: set URL
        specification.pathParams("bookingpath","booking","idpath","33");

        //Step 2: request body and expected data
        File file = new File("src/test/java/testData/FirstnameAndLastName.json");
        HashMap<String,String> expectedDataAndReqBody = JsonToJava.convertJsonToJavaObject(file, HashMap.class);

        //Step 3: send a request
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
                body(expectedDataAndReqBody).
                when().
                patch("/{bookingpath}/{idpath}");

        System.out.println("RESPONSE: ");
        response.prettyPrint();

        //Step 4: assertion

        Map<String, Object > actualData =  response.as(Map.class);

        assertEquals(actualData.get("firstname"),expectedDataAndReqBody.get("firstname"));
        assertEquals(actualData.get("lastname"),expectedDataAndReqBody.get("lastname"));


    }













}
