package PracticeExtra;

import BaseURLs.JsonPlaceHolderBaseURL;
import BaseURLs.RestfulBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.RestfulBookingdatesPojo;
import pojoDatas.RestfulExReqPojo;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Homework_13_Put01 extends RestfulBaseURL {
   /*
     Given
         1) https://restful-booker.herokuapp.com/booking/37
         2) {
 "firstname" : "Drake",
 "lastname" : "F..",
 "totalprice" : 4000,
 "depositpaid" : true,
 "bookingdates" : {
     "checkin" : "2022-01-01",
     "checkout" : "2023-01-01"
 },
 "additionalneeds" : "API and Appium"
}
     3) Kullanıcı Auth. olarak ilk olarak  Header a Cookie ile daha sonra ise Basic Autoh ile  req bulunmalı.
         Authorization ==>>  Basic YWRtaW46cGFzc3dvcmQxMjM=

         Cookie =>>> token=001832eb39ba0ca
     When
          Kullanıcı Put Reques ile request gönderir
     Then
           Status code is 200
          Response body nin aşağıdaki gibi olduğunu verify eder.
            {
 "firstname" : "Drake",
 "lastname" : "F..",
 "totalprice" : 4000,
 "depositpaid" : true,
 "bookingdates" : {
     "checkin" : "2022-01-01",
     "checkout" : "2023-01-01"
 },
 "additionalneeds" : "API and Appium"
}
  */

    @Test
    public void hm_put01(){
        specification.pathParams("pp1","booking","pp2","37");

        RestfulBookingdatesPojo bookingdatesPojo = new RestfulBookingdatesPojo("2022-01-01","2023-01-01");
        RestfulExReqPojo expextedData = new RestfulExReqPojo("Drake","F..",4000,true,bookingdatesPojo,"API and Appium");

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").
                body(expextedData).
                when().
                put("/{pp1}/{pp2}");
        System.out.println("RESPONSE: ");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getString("firstname"),expextedData.getFirstname());
        assertEquals(jsonPath.getString("lastname"),expextedData.getLastname());
        assertEquals(jsonPath.getInt("totalprice"),expextedData.getTotalprice());
        assertEquals(jsonPath.getBoolean("depositpaid"),expextedData.isDepositpaid());

        assertEquals(jsonPath.getString("bookingdates.checkin"),expextedData.getBookingdates().getCheckin());
        //assertEquals(jsonPath.getString("bookingdates.checkin"),bookingdates.getCheckin());


        assertEquals(jsonPath.getString("bookingdates.checkout"),expextedData.getBookingdates().getCheckout());
        //assertEquals(jsonPath.getString("bookingdates.checkin"),bookingdates.getCheckout());

        assertEquals(jsonPath.getString("additionalneeds"),expextedData.getAdditionalneeds());


    }
}
