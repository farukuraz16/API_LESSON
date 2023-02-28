package getRequest;

import BaseURLs.DummyBaseURL;
import BaseURLs.SwapiBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;

public class Homework_04 extends SwapiBaseURL {
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
    public void HM_03() {
        specification.pathParams("vehiclesPath", "vehicles", "idPath", 4);
        Response response = given().spec(specification).when().get("/{vehiclesPath}/{idPath}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("name",equalTo("Sand Crawler"),
                "model",equalTo("Digger Crawler"),
                "manufacturer",equalTo("Corellia Mining Corporation"),
                "cost_in_credits",equalTo("150000"),
               // "length",equalTo("36.8"),
                "max_atmosphering_speed",equalTo("30"),
                "crew",equalTo("46"),
                "passengers",equalTo("30"),
                "cargo_capacity",equalTo("50000"),
                "consumables",equalTo("2 months"),
                "vehicle_class",equalTo("wheeled"),
                //"pilots",equalTo(""),
                "created",equalTo("2014-12-10T15:36:25.724000Z"),
                "edited",equalTo("2014-12-20T21:30:21.661000Z"),
                "url",equalTo("https://swapi.dev/api/vehicles/4/"));

        JsonPath jsonPath = response.jsonPath();
        double length = jsonPath.getDouble("length");
        List<Integer> pilots = jsonPath.getList("pilots");
        List<Integer> films = jsonPath.getList("films");
        System.out.println("pilots = " + pilots);
        System.out.println("length = " + length);
        System.out.println("films = " + films);
        assertEquals(36.8,length);
        assertEquals(0,pilots.size());
        assertEquals(2,films.size());


    }
}
