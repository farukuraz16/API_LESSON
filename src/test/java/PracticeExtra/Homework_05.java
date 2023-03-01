package PracticeExtra;

import BaseURLs.SwapiBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.SwapiDevTestData_05;
import testData.SwapiDevTestData_05;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Homework_05 extends SwapiBaseURL {
    /*
    Given
             https://swapi.dev/api/vehicles/7
        When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
             Response body nin bu şekilde olduğunu doğrular
{
    "name": "X-34 landspeeder",
    "model": "X-34 landspeeder",
    "manufacturer": "SoroSuub Corporation",
    "cost_in_credits": "10550",
    "length": "3.4 ",
    "max_atmosphering_speed": "250",
    "crew": "1",
    "passengers": "1",
    "cargo_capacity": "5",
    "consumables": "unknown",
    "vehicle_class": "repulsorcraft",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/"
    ],
    "created": "2014-12-10T16:13:52.586000Z",
    "edited": "2014-12-20T21:30:21.668000Z",
    "url": "https://swapi.dev/api/vehicles/7/"
}
     */
    @Test
    public void homework05() {
        specification.pathParams("vehiclesPath", "vehicles", "idPath", 7);
        Response response = given().spec(specification).when().get("/{vehiclesPath}/{idPath}");
        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();

        SwapiDevTestData_05 swapiDevTestData = new SwapiDevTestData_05();
        Map<String, Object> expextedDataMap = swapiDevTestData.setUpExpectedData();
        System.out.println("expextedDataMap = " + expextedDataMap);

        assertEquals(expextedDataMap.get("name"), jsonPath.getString("name"));
        assertEquals(expextedDataMap.get("model"), jsonPath.getString("model"));
        assertEquals(expextedDataMap.get("manufacturer"), jsonPath.getString("manufacturer"));
        assertEquals(expextedDataMap.get("cost_in_credits"), jsonPath.getString("cost_in_credits"));
        assertEquals(expextedDataMap.get("length"), jsonPath.getString("length"));
        assertEquals(expextedDataMap.get("max_atmosphering_speed"), jsonPath.getString("max_atmosphering_speed"));
        assertEquals(expextedDataMap.get("crew"), jsonPath.getString("crew"));
        assertEquals(expextedDataMap.get("cargo_capacity"), jsonPath.getString("cargo_capacity"));
        assertEquals(expextedDataMap.get("consumables"), jsonPath.getString("consumables"));
        assertEquals(expextedDataMap.get("vehicle_class"), jsonPath.getString("vehicle_class"));
        assertEquals(expextedDataMap.get("pilots"), jsonPath.getList("pilots"));
        assertEquals(expextedDataMap.get("films"), jsonPath.getList("films"));
        assertEquals(expextedDataMap.get("created"), jsonPath.getString("created"));
        assertEquals(expextedDataMap.get("edited"), jsonPath.getString("edited"));
        assertEquals(expextedDataMap.get("url"), jsonPath.getString("url"));


    }


}
