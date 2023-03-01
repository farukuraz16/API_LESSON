package PracticeExtra;

import BaseURLs.SwapiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.SwapiDevPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Homework_08 extends SwapiBaseURL {
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
    public void hm08(){
        //Step 1 set URL
        specification.pathParams("starshipsPATH","starships","idPATH","3");

        //Step 2 set expectedData
        List<String> pilotsList = new ArrayList<>();
        List<String> filmsList = new ArrayList<>(List.of( "https://swapi.dev/api/films/1/",
                "https://swapi.dev/api/films/2/",
                "https://swapi.dev/api/films/3/"));

        SwapiDevPojo expectedData = new SwapiDevPojo(
                "Star Destroyer",
                "Imperial I-class Star Destroyer",
                "Kuat Drive Yards",
                "150000000",
                "1,600",
                "975",
                "47,060",
                "n/a",
                "36000000",
                "2 years",
                "2.0",
                "60",
                "Star Destroyer",
                pilotsList,
                filmsList,
                "2014-12-10T15:08:19.848000Z",
                "2014-12-20T21:23:49.870000Z",
                "https://swapi.dev/api/starships/3/"
        );


        //Step 3: Send a request
        Response response = given().spec(specification).when().get("/{starshipsPATH}/{idPATH}");
       response.prettyPrint();

        //Step 4: assertion
        Map<String , Object > actualDataMap = response.as(HashMap.class);
        //System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(expectedData.getName(),actualDataMap.get("name"));
        assertEquals(expectedData.getModel(),actualDataMap.get("model"));
        assertEquals(expectedData.getManufacturer(),actualDataMap.get("manufacturer"));
        assertEquals(expectedData.getCost_in_credits(),actualDataMap.get("cost_in_credits"));
        assertEquals(expectedData.getLength(),actualDataMap.get("length"));
        assertEquals(expectedData.getMax_atmosphering_speed(),actualDataMap.get("max_atmosphering_speed"));
        assertEquals(expectedData.getCrew(),actualDataMap.get("crew"));
        assertEquals(expectedData.getPassengers(),actualDataMap.get("passengers"));
        assertEquals(expectedData.getCargo_capacity(),actualDataMap.get("cargo_capacity"));
        assertEquals(expectedData.getMGLT(),actualDataMap.get("MGLT"));
        assertEquals(expectedData.getPilots(),actualDataMap.get("pilots"));
        assertEquals(expectedData.getFilms(),actualDataMap.get("films"));
        assertEquals(expectedData.getCreated(),actualDataMap.get("created"));
        assertEquals(expectedData.getEdited(),actualDataMap.get("edited"));
        assertEquals(expectedData.getUrl(),actualDataMap.get("url"));


    }


}
