package PracticeExtra;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import pojoDatas.CryptoCurrencyPojo;
import pojoDatas.CustomerInfoPojo;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Homework_10 {
    /*
    Cucumber ile Testdataları File dan

    !!---https://dev.bitpace.com/bitpace-merchant-rest-api#getDepositAddressUsingPOST--!!!

    Given
        https://api-sandbox.bitpace.com/api/v1/auth/token adresine POST metodu  ile request atılıp token alınmalı.

       Kullanılacak Request Body:
            {
    "merchant_code":"20625123425",
    "password":"a1a82a55-8355-46f1-9a95-3cd9adce495b"
            }

    Token alındıktan sonra aşğaıdaki işlemlere geçebiliriz.
        https://api-sandbox.bitpace.com/api/v1/customer/deposit/address

        **Alınan Token Headers ta Bearer Auth. olarak gçnderilecektir.**

    When
       Kullanıcı POST metodu ile request atar

       Kullanılacak Request Body:
        {
    "cryptocurrency": "BTC",
    "customer": {
        "reference_id": "20625123425",
        "first_name":"",
        "last_name":"",
        "email":"fryteceducation@gmail.com"
    }
}
    Then
        Kullanıcı "Deposit Adress Creat" edildiğini verify eder.
        Expected message "Response Approved" içermeli

     */
    String URL = "https://api-sandbox.bitpace.com/api/v1";
    public String token;
    @Before
    public void tokenReq (){

        HashMap<String, String> getTokenBody = new HashMap<>();
        getTokenBody.put("merchant_code","20625123425");
        getTokenBody.put("password","a1a82a55-8355-46f1-9a95-3cd9adce495b");


        Response response = given().
                contentType(ContentType.JSON).
                body(getTokenBody).
                when().
                post(URL+"/auth/token");
       // response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        token = jsonPath.getString("data.token");
       // System.out.println("token = " + token);
    }


    @Test
    public void homework10(){

        /*
        "customer": {
        "reference_id": "20625123425",
        "first_name":"",
        "last_name":"",
        "email":"fryteceducation@gmail.com"
    }
         */
        CustomerInfoPojo customerInfoPojo = new CustomerInfoPojo("20625123425","","","drakeF@gmail.com");

        CryptoCurrencyPojo reqBody = new CryptoCurrencyPojo("BTC",customerInfoPojo);


        //https://api-sandbox.bitpace.com/api/v1/customer/deposit/address
        Response response = given().
                contentType(ContentType.JSON).
                body(reqBody).
                when().
                header("Authorization","Bearer "+token).
                post(URL+"/customer/deposit/address");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        assertEquals("Response Approved", jsonPath.getString("message"));


    }

}
