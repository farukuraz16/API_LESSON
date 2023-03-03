package getRequest;

import BaseURLs.GorestBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.GoRestCoApiPojo;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get12 extends GorestBaseURL {
     /*
        Given
            https://gorest.co.in/public/v2/users/736334
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

    {
    "id": 736334,
    "name": "Mangala Shukla DO",
    "email": "do_shukla_mangala@fahey.co",
    "gender": "male",
    "status": "active"
}
     */


    @Test
    public void get12 (){

        //Step 1: set URL             https://gorest.co.in/public/v2/users/702440
        specification.pathParams("usersPath","users","idPath","736334");

        //Step 2: set expected data
        String expectedData = "{\n" +
                "    \"id\": 736334,\n" +
                "    \"name\": \"Mangala Shukla DO\",\n" +
                "    \"email\": \"do_shukla_mangala@fahey.co\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //Object Mapper: Object Mapper'ı kullanabilmek için maven projelerinde pom.xml dependency eklemem gerekiyor-->maven repo!dan..

        System.out.println("expectedData = " + expectedData);

       GoRestCoApiPojo goRestCoApiPojo = JsonToJava.convertJsonToJavaObject(expectedData, GoRestCoApiPojo.class);
        // expected datayı Json'dan Java'ya convert edip GoRestCoApiPojo'dan bir obje create edecek.
        System.out.println("goRestCoApiPojo = " + goRestCoApiPojo);

        HashMap<String,Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("expectedDataMap = " + expectedDataMap);

  //Step 3: send request
        Response response = given().spec(specification).when().get("/{usersPath}/{idPath}");
        System.out.println("Response: ");
        response.prettyPrint();


//Step 4: assertion
        HashMap<String, Object> actualDataMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(expectedDataMap.get("id"),actualDataMap.get("id"));
        assertEquals(expectedDataMap.get("name"),actualDataMap.get("name"));
        assertEquals(expectedDataMap.get("email"),actualDataMap.get("email"));
        assertEquals(expectedDataMap.get("gender"),actualDataMap.get("gender"));
        assertEquals(expectedDataMap.get("status"),actualDataMap.get("status"));


    }



}
