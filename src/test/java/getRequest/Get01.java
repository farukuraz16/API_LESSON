package getRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
/*
        Bizler bu zamana kadar sizler ile birlikte POSTMAN üzerinde farklı doc. sahip olan
        çeşitli API lere request attık.
        REq atarken HTTP methodların da GET, POST; PUT, PATCH and DELETE methoslarınınkullandık.



        Bizler markete genle olarak POSTMAN i bir otomasyon toolu olarak değil manule test tool u olarka
        kullanıyoruz. Fakat dersler de işlediğimiz üsere PSTAMN ile test otomasyonu yapabiliyoruz.

        API testlerimiz bundan sonra REstAssured Lib. kullanrak yapacğaız.


        TEST leri yapabiliyor olmak içn sizlerin bir doc. ihtiyacı vardır.
        Biz test eng. bu doc. göre API leri nasıl kullanacağımız veya nasıl test edeceğimizi öğreniriz.

        Ve doc. lara göre çeşitli seneryoalr oluşturabiliriz. Tıpkı ne gibi?
        Selenium Web UI teslteri koştuğumuz gibi.

        Test Case:

         --> Expected Result


         ---> Actual Result      ====>>>>> Response dan alacağım.


        Gherkin Lang.

            Given ---> testin yapılabilmesi için ön hazırlık/ön şart
            When ---> Action --> Gerçekleştirilecek Eylemler
            Then ---> Assertion için kullanıyoruz
            And  ---> Öncesinde kullanılan keyword u etkisinin hala devame titğini zilere gösterir.

     */

    /*
    Given
        https://restful-booker.herokuapp.com/booking/7
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
        Content Type ın "application/json" olduğunu assert et
    And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.

     */

    @Test // -> it is like main method
    public void get01() {

        /*
        4 tane adımımız vardır.
        1) URL'i tanımla, set et..

        2) Expected dataları tanımla set et..
        Expected datalar, test case'den alınır. Doc.'dan alınır.

        3) Request gönder..

        4) Assertion işlemi..
         */

        // Step 1: URL'i set et...      https://restful-booker.herokuapp.com/booking/7

        String URL = "https://restful-booker.herokuapp.com/booking/7";

        // Step 2: Expected dataları set et.. (bu ders için şimdilik Ignore edilmiştir.)

        //Step 3: Request gönder...

        Response reponse = given().when().get(URL);
        System.out.println("REPONSE: ");
        reponse.prettyPrint(); //sout gibidir..

        //Step 4: Assertion işlemleri..
        /*
        Then
        Status Code un "200" olduğunu Assert et
                And
        Content Type ın "application/json" olduğunu assert et
        And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.
                */

        //Test 1: status code ===> 200

        reponse.then().assertThat().statusCode(200); // 200, Doc. TestCase'den alınmıştır.

        // Test 2: Content Type
        reponse.then().assertThat().contentType("application/json");

        reponse.then().assertThat().contentType(ContentType.JSON);


        //Test 3: Status Line
        reponse.then().assertThat().statusLine("HTTP/1.1 200 OK");



        //Status Code'u konsola nasıl yazdırabiliriz?
        System.out.println("Status Code: "+reponse.getStatusCode());

        // Content Type konsola nasıl yazdırılır
        System.out.println("Cpntent Type: "+reponse.getContentType());

        // Status Line konsola nasıl yazıdrabilirim
        System.out.println("Status Line: "+reponse.getStatusLine());


        //Response Time ı nasıl yazdırabiliriö
        System.out.println("Responsse Time: "+reponse.getTime());

        // Headers ı konsola nasıl yazdırabilirim
        System.out.println("Headers: "+ reponse.getHeaders());



    }


}
