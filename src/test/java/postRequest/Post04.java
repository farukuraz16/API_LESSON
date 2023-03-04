package postRequest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import pojoDatas.CryptoCurrencyPojo;
import pojoDatas.CustomerInfoPojo;
import testData.BitPaceGetToken;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post04 {
      /*

API Doc. URL    !!---https://dev.bitpace.com/bitpace-merchant-rest-api#getDepositAddressUsingPOST--!!!

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
        "email":"drakeF@gmail.com"
    }
}
    Then
        Kullanıcı "Deposit Adress Creat" edildiğini verify eder.
        Expected message "Response Approved" içermeli

     */

    /*
    https://dev.bitpace.com/bitpace-merchant-rest-api#getDepositAddressUsingPOST adresine giderek
    customer deposit address gerçekleştiriniz. böyle bir görev geldi..
    adrese gideriz ve doc'u inceleriz. Create Deposit Address kısmını bulup ne yapacağımz ile ilgili
    yönlendirmeleri okumalıyız.
    */


    //https://api-sandbox.bitpace.com/api/v1
    String URL = "https://api-sandbox.bitpace.com/api/v1";
    public String token;

    @Before //yapılacak işlemlerin öncesinde token almamız lazım. bu yüzden before ile başlıyoruz.
    public void postForToken() {
        //bu metot işlemlerimi yapabilmek için token create eden bir metotdur.

        //Set URL
        //https://api-sandbox.bitpace.com/api/v1/auth/token
        String URLForToken = URL + "/auth/token";

        BitPaceGetToken bitPaceGetToken = new BitPaceGetToken();
        Map<String, String> reqBodyMap = bitPaceGetToken.reqTestDataBody();

        //Send a request
        Response response = given().
                contentType(ContentType.JSON).
                body(reqBodyMap).
                when().
                post(URLForToken);
        //System.out.println("RESPONSE");
        //response.prettyPrint();

        //Assertion
        //Assertion işlemi almam için response'dan token almam gerekiyor.
        //bu yüzden class seviyesinde bir string oluşturdum.

        JsonPath jsonPath = response.jsonPath();
        token = jsonPath.getString("data.token");
        // System.out.println("token = " + token);

    }


    @Test
    public void createDepositeWithPost () {
        //Step 1:  Set URL: https://api-sandbox.bitpace.com/api/v1/customer/deposit/address
    String URLforCreationDeposit = URL + "/customer/deposit/address";

        //Step 2: set req body
        /*
        Kullanılacak Request Body:
        {
    "cryptocurrency": "BTC",
    "customer": {
        "reference_id": "20625123425",
        "first_name":"",
        "last_name":"",
        "email":"drakeF@gmail.com"
                }
        }
         */
    //customer için pojo yapıyoruz.. customer'ı da kapsayacak bir pojo daha yapıyoruz.

        CustomerInfoPojo customerInfoPojo = new CustomerInfoPojo("20625123425","","","drakeF@gmail.com");

        CryptoCurrencyPojo reqBody = new CryptoCurrencyPojo("BTC",customerInfoPojo);


        //Step 3: Send a req... bu requestte token vermemiz lazım. aşağıda daha önce yaptığımız örnek var.
/*
 Response response = given().
                spec(specification).
                body(reqBodyAndExpectedDataMap).//body gönderiyoruz
                        contentType(ContentType.JSON).//Json type'ı olarak gönderiyoruz
                        when().
                header("Authorization", "Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0").//header'dan authantication almamız gerekiyor. ve TOKEN girmemiz gerkiyor. bunu bize doc'da belirtiyor.
                        post("/{usersPath}");//buraya post ediyoruz.
 */
        Response response = given().
                contentType(ContentType.JSON).
                body(reqBody).
                when().
                header("Authorization","Bearer "+token).
                post(URLforCreationDeposit);
        System.out.println("Response: ");
        response.prettyPrint();

        //Step 4: assertion
        //Kullanıcı "Deposit Adress Creat" edildiğini verify eder.
        //        Expected message "Response Approved" içermeli

        Map<String,Object> actualDatafromResponse = response.as(HashMap.class);
        System.out.println("actualDatafromResponse = " + actualDatafromResponse);

        assertEquals("Response Approved",actualDatafromResponse.get("message"));

    }

}
