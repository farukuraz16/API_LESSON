package getRequest;

import BaseURLs.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;

public class Get09 extends JsonPlaceHolderBaseURL {

     /*

    Given
	   	     https://jsonplaceholder.typicode.com/todos/2
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
            Header da Server ın cloudflare olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
  {
    "userId": 1,
    "id": 2,
    "title": "quis ut nam facilis et officia qui",
    "completed": false
}

     */

    @Test
    public void get09(){
        //Step 1: SET URL
        specification.pathParams("todosPath","todos","idPath","2");

        //Step 2: Expected Data
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
        HashMap<String, Object> expectedData = jsonPlaceHolderTestData.setUpDataTodos();
        System.out.println("expectedData = " + expectedData);

        //Step 3: Send a request
        Response response = given().spec(specification).when().get("/{todosPath}/{idPath}");
        System.out.println("response = ");
        response.prettyPrint();

        //Step 4: Assertion

        //1. way
        HashMap<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("Server"),response.getHeader("Server"));
        assertEquals(expectedData.get("StatusCode"),response.statusCode());
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));


// HOMEWORKS:

        /*
        JsonPath + SoftAssertion
        response ile hard assertion   --->> response.then().assertThat()
         */

        JsonPath jsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedData.get("Server"),response.getHeader("Server"));
        softAssert.assertEquals(expectedData.get("StatusCode"),response.statusCode());
        softAssert.assertEquals(expectedData.get("id"),actualData.get("id"));
        softAssert.assertEquals(expectedData.get("completed"),actualData.get("completed"));
        softAssert.assertEquals(expectedData.get("title"),actualData.get("title"));
        softAssert.assertAll();

         /*

    Given
	   	     https://jsonplaceholder.typicode.com/todos/2
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
            Header da Server ın cloudflare olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
  {
    "userId": 1,
    "id": 2,
    "title": "quis ut nam facilis et officia qui",
    "completed": false
}
*/
        response.then().assertThat().statusCode(200).
                header("Server","cloudflare").
                body(
                        "userId", equalTo(1),
                        "id",equalTo(2),
                        "title",equalTo("quis ut nam facilis et officia qui"),
                        "completed",equalTo(false)
                );


    }

}
