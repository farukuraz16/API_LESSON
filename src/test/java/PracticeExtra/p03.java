package PracticeExtra;

import BaseURLs.Practice03BaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class p03 extends Practice03BaseURL {

     /*
        Given
            https://jsonplaceholder.typicode.com/todos/2
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    title ın "quis ut nam facilis et officia qui" olduğunu verify et.,
		And
		    "completed" ın false olduğunu verify et.
		And
		    "userId" in 1 olduğunu verify et

{
    "userId": 1,
    "id": 2,
    "title": "quis ut nam facilis et officia qui",
    "completed": false
}
      */


  @Test
    public void p03(){
      baseURL.pathParams("todosData","todos","IdData","2");
      Response response = given().when().spec(baseURL).get("/{todosData}/{IdData}");
      //response.prettyPrint();

    response.then().assertThat().statusCode(200).contentType("application/json");

    response.then().body(
            "title", Matchers.equalTo("quis ut nam facilis et officia qui"),
            "completed", Matchers.equalTo(false),
            "userId", Matchers.equalTo(1));


  }
}
