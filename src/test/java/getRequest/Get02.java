package getRequest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.*;

public class Get02 {

      /*
    Given
        https://restful-booker.herokuapp.com/booking/78100
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "404" olduğunu Assert et
    And
        Response Body nin "Not Found" olduğunu assert et
    And
        Via nın "1.1 vegur" olduğunu assert et.
    And
        Response body nin "Clarusway" yazmadığını assert et
    And
        Status Line "HTTP/1.1 404 Not Found" olduğunu assert et.

     */
    /*
    1. Set URL
    2. Set Expected DATA (şimdilik ignore ediyoruz)
    3. Send request
    4. Assertion
     */


    @Test
    public void get02(){

        // Step 1
        String URL = "https://restful-booker.herokuapp.com/booking/78100";

        // Step 2 (ignored)

        // Step 3
        Response response = given().when().get(URL);
        response.prettyPrint();

        //Assertion işlemlerinde iki farklı metot kullanıyoruz
        // a) Hard Assertion
        // b) Soft Assertion

        // Step 4
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        // Test2: Status Line: exp: HTTP/1.1 404 Not Found

        // response.then().assertThat().statusLine("HTTP/1.1 404 Not Found");

        // Test 3: Response Body ---- >> Not Found
        // Response body nasıl string bir ifadeye çevrilir?

        String responseBodyStr = response.asString();
        System.out.println("Response Body: "  + responseBodyStr);

        assertTrue(responseBodyStr.contains("Not Found"));  // Eğer assertTrue() nun içerisi TRUE return oluyorsa Testimiz PASS olmuş olur.

        // Test 4: Headers dan Via nın "1.1 vegur"

        //System.out.println("Butun Headers: " + response.getHeaders()); // Bütün headersları alabiliyoruz.

        // Tek bir tane headera ulaşabilmek için ise;
        //System.out.println("Single Header: " + response.getHeader("Via"));
        assertEquals("1.1 vegur",response.getHeader("Via"));  //assertEquals()  ---> içine girilen değerler biribiri ile eşit ise TRUE döner ve böylece Testimiz PASS olmuş olur

        // Test 5: Response body nin "Clarusway" yazmadığını assert et
        assertFalse(responseBodyStr.contains("Clarusway")); //assertFalse() içine girmiş olduğum veri FALSE return oluyorsa benim testimiz PASS olur

    }

}
