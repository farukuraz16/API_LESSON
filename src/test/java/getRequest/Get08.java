package getRequest;

import BaseURLs.SwapiBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;

public class Get08 extends SwapiBaseURL {
     /*
    Given
	   	     https://swapi.dev/api/vehicles/4
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
   {
    "name": "Sand Crawler",
    "model": "Digger Crawler",
    "manufacturer": "Corellia Mining Corporation",
    "cost_in_credits": "150000",
    "length": "36.8 ",
    "max_atmosphering_speed": "30",
    "crew": "46",
    "passengers": "30",
    "cargo_capacity": "50000",
    "consumables": "2 months",
    "vehicle_class": "wheeled",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/",
        "https://swapi.dev/api/films/5/"
    ],
    "created": "2014-12-10T15:36:25.724000Z",
    "edited": "2014-12-20T21:30:21.661000Z",
    "url": "https://swapi.dev/api/vehicles/4/"
}
     */

    @Test
    public void get08() {
        specification.pathParams("vehiclesPath", "vehicles", "idPath", 4);

        // Trick 1 --> her zaman içerden dışarı doğru yapı kurulmalı
        List<String> pilotList = new ArrayList<>();
        System.out.println("pilotList = " + pilotList);

        List<String> filmsList = new ArrayList<>();
        filmsList.add("https://swapi.dev/api/films/1/");
        filmsList.add("https://swapi.dev/api/films/5/");
        System.out.println("filmsList = " + filmsList);

        Map<String, Object> expextedDataMap = new HashMap<>();
        expextedDataMap.put("name", "Sand Crawler");
        expextedDataMap.put("model", "Digger Crawler");
        expextedDataMap.put("manufacturer", "Corellia Mining Corporation");
        expextedDataMap.put("cost_in_credits", "150000");
        expextedDataMap.put("length", "36.8 ");
        expextedDataMap.put("max_atmosphering_speed", "30");
        expextedDataMap.put("crew", "46");
        expextedDataMap.put("passengers", "30");
        expextedDataMap.put("cargo_capacity", "50000");
        expextedDataMap.put("consumables", "2 months");
        expextedDataMap.put("vehicle_class", "wheeled");
        expextedDataMap.put("pilots", pilotList);
        expextedDataMap.put("films", filmsList);
        expextedDataMap.put("created", "2014-12-10T15:36:25.724000Z");
        expextedDataMap.put("edited", "2014-12-20T21:30:21.661000Z");
        expextedDataMap.put("url", "https://swapi.dev/api/vehicles/4/");

        System.out.println("expextedDataMap = " + expextedDataMap);

        Response response = given().spec(specification).when().get("/{vehiclesPath}/{idPath}");
        response.prettyPrint();

        // 1. Way
        /*
        response.then().assertThat().statusCode(200).body("name", equalTo(expextedDataMap.get("name")),
                "model", equalTo(expextedDataMap.get("model")),
                "manufacturer", equalTo(expextedDataMap.get("manufacturer")),
                "cost_in_credits", equalTo(expextedDataMap.get("cost_in_credits")),
                "length", equalTo(expextedDataMap.get("length")),
                "max_atmosphering_speed", equalTo(expextedDataMap.get("max_atmosphering_speed")),
                "crew", equalTo(expextedDataMap.get("crew")),
                "passengers", equalTo(expextedDataMap.get("passengers")),
                "cargo_capacity", equalTo(expextedDataMap.get("cargo_capacity")),
                "consumables", equalTo(expextedDataMap.get("consumables")),
                "vehicle_class", equalTo(expextedDataMap.get("vehicle_class")),
                "pilots", equalTo(expextedDataMap.get("pilots")),
                "films", equalTo(expextedDataMap.get("films")),
                "created", equalTo(expextedDataMap.get("created")),
                "edited", equalTo(expextedDataMap.get("edited")),
                "url", equalTo(expextedDataMap.get("url")));
          */

        // 2. Way

        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        /*
        GSON  ----> Deserializaiton

        Deserializaiton  ---> Json objesini, JAVA obj ne convert etmek demektir.

         */

        assertEquals(expextedDataMap.get("name"),actualData.get("name"));
        assertEquals(expextedDataMap.get("model"),actualData.get("model"));
        assertEquals(expextedDataMap.get("manufacturer"),actualData.get("manufacturer"));
        assertEquals(expextedDataMap.get("cost_in_credits"),actualData.get("cost_in_credits"));
        assertEquals(expextedDataMap.get("length"),actualData.get("length"));
        assertEquals(expextedDataMap.get("max_atmosphering_speed"),actualData.get("max_atmosphering_speed"));
        assertEquals(expextedDataMap.get("crew"),actualData.get("crew"));
        assertEquals(expextedDataMap.get("passengers"),actualData.get("passengers"));
        assertEquals(expextedDataMap.get("cargo_capacity"),actualData.get("cargo_capacity"));
        assertEquals(expextedDataMap.get("consumables"),actualData.get("consumables"));
        assertEquals(expextedDataMap.get("vehicle_class"),actualData.get("vehicle_class"));
        assertEquals(expextedDataMap.get("pilots"),actualData.get("pilots"));
        assertEquals(expextedDataMap.get("films"),actualData.get("films"));
        assertEquals(expextedDataMap.get("created"),actualData.get("created"));
        assertEquals(expextedDataMap.get("edited"),actualData.get("edited"));
        assertEquals(expextedDataMap.get("url"),actualData.get("url"));

// kısa yol:
        assertEquals(expextedDataMap,actualData);

// Homework: JsonPath -----> softAssert kullanarak yapınız...





    }
}
