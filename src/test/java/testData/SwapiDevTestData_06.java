package testData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwapiDevTestData_06 {
    /*
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
    "url": "https://swapi.dev/api/starships/3/"}
     */
    public Map<String, Object> expectedData = new HashMap<>();
    public Map<String, Object> setUpExpectedData() {
        List<String> pilotsList = new ArrayList<>();
        List<String> filmsList = new ArrayList<>();
        filmsList.add("https://swapi.dev/api/films/1/");
        filmsList.add("https://swapi.dev/api/films/2/");
        filmsList.add("https://swapi.dev/api/films/3/");

        expectedData.put("name", "Star Destroyer");
        expectedData.put("model", "Imperial I-class Star Destroyer");
        expectedData.put("manufacturer", "Kuat Drive Yards");
        expectedData.put("cost_in_credits", "150000000");
        expectedData.put("length", "1,600");
        expectedData.put("max_atmosphering_speed", "975");
        expectedData.put("crew", "47,060");
        expectedData.put("passengers", "n/a");
        expectedData.put("cargo_capacity", "36000000");
        expectedData.put("consumables", "2 years");
        expectedData.put("hyperdrive_rating", "2.0");
        expectedData.put("MGLT", "60");
        expectedData.put("starship_class", "Star Destroyer");
        expectedData.put("pilots", pilotsList);
        expectedData.put("films", filmsList);
        expectedData.put("created", "2014-12-10T15:08:19.848000Z");
        expectedData.put("edited", "2014-12-20T21:23:49.870000Z");
        expectedData.put("url", "https://swapi.dev/api/starships/3/");

        return expectedData;
    }


}
