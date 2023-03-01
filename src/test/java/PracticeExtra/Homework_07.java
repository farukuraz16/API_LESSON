package PracticeExtra;

import BaseURLs.GorestBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.GoRestPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Homework_07 extends GorestBaseURL {
    /*
        Given
            https://gorest.co.in/public/v2/users/740375
       When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular
      {
    "id": 740375,
    "name": "Omana Nayar",
    "email": "omana_nayar@ebert-fisher.biz",
    "gender": "male",
    "status": "active"
}
*/
    @Test
    public void hm07 (){
        //1) set URL

        // https://gorest.co.in/public/v2/users/740375
        specification.pathParams("usersData","users","idPath","740375");

        //2) set expected Data;
        GoRestPojo goRestPojo = new GoRestPojo(
                740375,
                "Omana Nayar",
                "omana_nayar@ebert-fisher.biz",
                "male",
                "active");

        System.out.println("goRestPojo = " + goRestPojo);


        //Step 3: Send a request
        Response response = given().spec(specification).when().get("/{usersData}/{idPath}");
        response.prettyPrint();


        //Step 4: assertion with GSON
        Map<String, Object> actualDataMap= response.as(HashMap.class);

        assertEquals(goRestPojo.getId(),actualDataMap.get("id"));
        assertEquals(goRestPojo.getName(),actualDataMap.get("name"));
        assertEquals(goRestPojo.getEmail(),actualDataMap.get("email"));
        assertEquals(goRestPojo.getGender(),actualDataMap.get("gender"));
        assertEquals(goRestPojo.getStatus(),actualDataMap.get("status"));

    }




}
