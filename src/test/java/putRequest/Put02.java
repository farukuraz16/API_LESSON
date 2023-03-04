package putRequest;

import BaseURLs.RestfulBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.RestfulBookingdatesPojo;
import pojoDatas.RestfulExReqPojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Put02 extends RestfulBaseURL {
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
    public void put02() {
        //Step 1: set URL
        // https://restful-booker.herokuapp.com/booking/37
        specification.pathParams("bookingPath", "booking", "idPath", "37");

        //Step 2: set expected data and request body
        RestfulBookingdatesPojo bookingdates = new RestfulBookingdatesPojo("2022-01-01", "2023-01-01");
        RestfulExReqPojo expextedData = new RestfulExReqPojo("Drake", "F..", 4000, true, bookingdates, "API and Appium");

        //Step 3: send a request... doc'a göre token almammız gerekiyor. postman'den aldım.
        //    "token": "078af038480d97e"

        //doc'a göre Header'dan cookie field'inda token göndermemiz lazım.
        //  Header---> Cookie --->>> token=<token_value>

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("cookie", "token=" + "078af038480d97e").
                body(expextedData).
                when().
                put("/{bookingPath}/{idPath}");

        System.out.println("RESPONSE: ");
        response.prettyPrint();

        //Forbidden ----> bu hatayı alınca token değiştiriyoruz. yeni bir token alıyoruz.
        //401 --> unauth.. --> Auth ile ilgili herhangi bir value bulunmadığı zaman
        //403 --> Forbidden ----> token veya ilgili auth. metodu ne ise onunla ilgili olarak value var fakat yanlış veya expire olmuş olabilir.


        //Step 4: assertion

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
