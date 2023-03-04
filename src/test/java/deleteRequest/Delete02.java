package deleteRequest;

import BaseURLs.DummyBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.DummyRestApiExpextedPojo;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Delete02 extends DummyBaseURL {
     /*
        Given
            1)https://dummy.restapiexample.com/api/v1/delete/2
        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 200 olduğunu
		 And
		    Response body in

		    {
    "status": "success",
    "data": "719",
    "message": "Successfully! Record has been deleted"
            }
     */

    @Test
    public void delete02(){
        //Step 1 set url
        specification.pathParams("deletepath","delete",
                "idpath","3");

        //Step 2 expected data
        HashMap<String, String> expectedDataMap = new HashMap<>();
        expectedDataMap.put("status", "success");
        expectedDataMap.put("data", "3");
        expectedDataMap.put("message", "Successfully! Record has been deleted");
        System.out.println("expectedDataMap = " + expectedDataMap);

        //Step 3: send a request
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                delete("/{deletepath}/{idpath}");
        response.prettyPrint();

        //Step 4: Assertion
        JsonPath actualData = response.jsonPath();
        assertEquals(expectedDataMap.get("status"),actualData.getString("status"));
        assertEquals(expectedDataMap.get("data"),actualData.getString("data"));
        assertEquals(expectedDataMap.get("message"),actualData.getString("message"));


    }
}
