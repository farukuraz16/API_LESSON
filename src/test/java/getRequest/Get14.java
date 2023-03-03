package getRequest;

import BaseURLs.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get14 extends JsonPlaceHolderBaseURL {
     /*
       Given
            https://jsonplaceholder.typicode.com/todos/198
       When
			Kullanıcı GET Methodu ile Request Gönderir
	   Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular
  {
"userId": 10,
"id": 198,
"title": "quis eius est sint explicabo",
"completed": true
}

     */


    @Test
    public void get14() {
        //Step 1: Set URL
        specification.pathParams("todosPATH", "todos", "idPATH", "198");

        //Step 2: set expected data
        String expectedData = "{\n" +
                "\"userId\": 10,\n" +
                "\"id\": 198,\n" +
                "\"title\": \"quis eius est sint explicabo\",\n" +
                "\"completed\": true\n" +
                "}";
        System.out.println("expectedData = " + expectedData);
        //HOMEWORK:   expected data yı JSONPLACEHOLDERTESTDATA classın da bir tane metot create ediniz.

        /*
         JsonPlaceHolderBaseURL jsonPlaceHolderBaseURL = new JsonPlaceHolderBaseURL();

        String ex = jsonPlaceHolderBaseURL.createEdilen(userId);
         */

        //Step 3: send a request
        Response response = given().spec(specification).when().get("/{todosPATH}/{idPATH}");
        System.out.println("Response: ");
        response.prettyPrint();

        HashMap<String, Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("expectedDataMap = " + expectedDataMap);


        //Step 4: Assertion
        //Response ile actual data oluşturuyoruz. birden fazla yol var.

        //1) reponse'u direket MAP'a atama yaparız.
        // HashMap<String, Object> actualDataMap = response.as(HashMap.class);

        //2) jsonpath classınada atama yaparız.
        // JsonPath jsonPath = response.jsonPath();

        //3) hardassert ile yaparız
        // response.then().assertThat().body("");

        //4) json'dan javaya convert eden utilities  classını kullanarak MAP oluştururuz.
        HashMap<String, Object> actualDataMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(expectedDataMap.get("id"),actualDataMap.get("id"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));

    }
}
