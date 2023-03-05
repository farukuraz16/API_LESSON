package PracticeExtra;

import BaseURLs.RestfulBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.Homework11_ReqBodyPojo;
import pojoDatas.Homework11_bookingDatesPojo;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Homework_11 extends RestfulBaseURL {
     /*
         Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Drake",
                "lastname": "F.",
                "totalprice": 4000,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2022-09-05",
                    "checkout": "2023-06-01"
                 }
                 "additionalneeds": "Full Stack Test Automation Course with API and Appium"
             }
        When
 		    Kullanıcı POST metodu ile request göderir
 	    Then
              Status Code un 200 olduğu doğrulanır
 		And
 		      Response Body nin aşağıdaki gibi olduğu verify edilir
 		    {
    "bookingid": 3844,
    "booking": {
        "firstname": "Drake",
        "lastname": "F.",
        "totalprice": 4000,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2022-09-05",
            "checkout": "2023-06-01"
        },
        "additionalneeds": "Full Stack Test Automation Course with API and Appium"
    }
}
     */

    @Test
    public void homework11() {

        specification.pathParam("pp1", "booking");

        Homework11_bookingDatesPojo bookingDatesMap =
                new Homework11_bookingDatesPojo("2022-09-05", "2023-06-01");

        Homework11_ReqBodyPojo reqBodyMap =
                new Homework11_ReqBodyPojo("Drake", "F.", 4000, true, bookingDatesMap, "Full Stack Test Automation Course with API and Appium");

        System.out.println("reqBodyMap = " + reqBodyMap);

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                body(reqBodyMap).
                when().
                post("/{pp1}");
        System.out.println("RESPONSE: ");
        response.prettyPrint();

       response.then().assertThat().statusCode(200);


       // Map<String, Object> actualData = response.as(Map.class);
       // System.out.println("actualData = " + actualData);
        JsonPath jsonPath = response.jsonPath();
        assertEquals(reqBodyMap.getFirstname(),jsonPath.getString("booking.firstname"));
        assertEquals(reqBodyMap.getLastname(),jsonPath.getString("booking.lastname"));
        assertEquals(reqBodyMap.getTotalprice(),jsonPath.getInt("booking.totalprice"));
        assertEquals(reqBodyMap.isDepositpaid(),jsonPath.getBoolean("booking.depositpaid"));
        assertEquals(reqBodyMap.getBookingdates().getCheckin(),jsonPath.getString("booking.bookingdates.checkin"));
        assertEquals(reqBodyMap.getBookingdates().getCheckout(),jsonPath.getString("booking.bookingdates.checkout"));
        assertEquals(reqBodyMap.getAdditionalneeds(),jsonPath.getString("booking.additionalneeds"));





    }
}
