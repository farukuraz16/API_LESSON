package PracticeExtra;

import BaseURLs.SwapiBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.SwapiDevTestData_06;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Homework_06 extends SwapiBaseURL {
    /*
        Given
            https://swapi.dev/api/starships/3
       When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular
         {
    "name": "Star Destroyer",
    "model": "Imperial I-class Star Destroyer",
    "manufacturer": "Kuat Drive Yards",
    "cost_in_credits": "150000000",
    "length": "1,600",
    "max_atmosphering_speed": "975",
    "crew": "47,060",
    "passengers": "n/a",
    "cargo_capacity": "36000000",
    "consumables": "2 years",
    "hyperdrive_rating": "2.0",
    "MGLT": "60",
    "starship_class": "Star Destroyer",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/",
        "https://swapi.dev/api/films/2/",
        "https://swapi.dev/api/films/3/"
    ],
    "created": "2014-12-10T15:08:19.848000Z",
    "edited": "2014-12-20T21:23:49.870000Z",
    "url": "https://swapi.dev/api/starships/3/"
}
     */


    @Test
    public void homework06(){
        specification.pathParams("starshipsData","starships","idPath","3");
        Response response = given().spec(specification).when().get("/{starshipsData}/{idPath}");
        JsonPath jsonPath = response.jsonPath();

        assertEquals(200,response.statusCode());

        SwapiDevTestData_06 expectedData = new SwapiDevTestData_06();
        Map<String, Object> expectedDataMap = expectedData.setUpExpectedData();
        System.out.println("expectedDataMap = " + expectedDataMap);

        assertEquals(expectedDataMap.get("name"),jsonPath.getString("name"));
        assertEquals(expectedDataMap.get("model"),jsonPath.getString("model"));
        assertEquals(expectedDataMap.get("manufacturer"),jsonPath.getString("manufacturer"));
        assertEquals(expectedDataMap.get("cost_in_credits"),jsonPath.getString("cost_in_credits"));
        assertEquals(expectedDataMap.get("length"),jsonPath.getString("length"));
        assertEquals(expectedDataMap.get("max_atmosphering_speed"),jsonPath.getString("max_atmosphering_speed"));
        assertEquals(expectedDataMap.get("crew"),jsonPath.getString("crew"));
        assertEquals(expectedDataMap.get("passengers"),jsonPath.getString("passengers"));
        assertEquals(expectedDataMap.get("cargo_capacity"),jsonPath.getString("cargo_capacity"));
        assertEquals(expectedDataMap.get("consumables"),jsonPath.getString("consumables"));
        assertEquals(expectedDataMap.get("hyperdrive_rating"),jsonPath.getString("hyperdrive_rating"));
        assertEquals(expectedDataMap.get("MGLT"),jsonPath.getString("MGLT"));
        assertEquals(expectedDataMap.get("starship_class"),jsonPath.getString("starship_class"));
        assertEquals(expectedDataMap.get("created"),jsonPath.getString("created"));
        assertEquals(expectedDataMap.get("edited"),jsonPath.getString("edited"));
        assertEquals(expectedDataMap.get("url"),jsonPath.getString("url"));
        assertEquals(expectedDataMap.get("pilots"),jsonPath.getList("pilots"));
        assertEquals(expectedDataMap.get("films"),jsonPath.getList("films"));


    }

}
