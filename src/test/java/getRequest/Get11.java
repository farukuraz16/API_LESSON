package getRequest;

import BaseURLs.ApiZippopotamBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.ZippoPotamPlaces;
import pojoDatas.ZippoPotamPojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;


public class Get11 extends ApiZippopotamBaseURL {

    /*
        Given
            http://api.zippopotam.us/TR/34010
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

            {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
        {
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
    ]
}
     */

    @Test
    public void get11() {
        // Step 1 set URL
        specification.pathParams("countryPath", "TR",
                "postcodePath", "34010");


        // Step 2 set Expected Data
        // en iç kısımdan başlayacağımız için önce ZippoPotamPlaces'dan obje create ediyoruz ve variable atıyoruz
        ZippoPotamPlaces zippoPotamPlaces = new ZippoPotamPlaces("Maltepe Mah.","32.3609","İstanbul","34","40.1589");

        // şimdi de places'ın dışında kalan datalar için hazırladığımız ZippoPotamPojos'dan obje create ediyoruz ve variable atıyoruz
        ZippoPotamPojos zippoPotamPojos = new ZippoPotamPojos("34010","Turkey","TR",zippoPotamPlaces);

        System.out.println("Expected Data = " + zippoPotamPojos);


        //Step 3: Send a request
        Response response = given().spec(specification).when().get("/{countryPath}/{postcodePath}");
       // System.out.println("REPONSE: ");
       // response.prettyPrint();

        //Step 4: assertion with GSON
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(zippoPotamPojos.getCountry(),actualDataMap.get("country"));
        assertEquals(zippoPotamPojos.getPostCode(),actualDataMap.get("post code"));
        assertEquals(zippoPotamPojos.getCountryAbbreviation(),actualDataMap.get("country abbreviation"));

        assertEquals(zippoPotamPojos.getZippoPotamPlaces().getPlaceName(),
                ((Map)
                        ((List)actualDataMap.get("places"))
                                .get(0)).get("place name"));
//places listinin aslında 1 tane elemanı var. süslü parantez içindeki tüm map'ler aslında tek bir süslü parantez içinde olduğu için tek bir eleman kabul edilir
        //bu yüzden biz bu places listinin get(0) indexini yani ilk elemanını alıyoruz.
// places=[    {place name=Maltepe Mah., longitude=32.3609, state=İstanbul, state abbreviation=34, latitude=40.1589}   ]

        //önce actualDataMap'den places kısmını list olarak almamız gerekiyordu.
        //bu yüzden alacağımız datayı list'e cast ettik. daha sonra bu listin içinden
        //alacağımız dataları Map'e cast etmemiz lazım. çünkü key,variable yapısı var.
        //places listinin içinde mapler var. cast ettikten sonra almak istediğimiz variable'ın key'ini giriyoruz.


        assertEquals(zippoPotamPojos.getZippoPotamPlaces().getLatitude(),((Map)((List)actualDataMap.get("places")).get(0)).get("latitude"));
        assertEquals(zippoPotamPojos.getZippoPotamPlaces().getLongitude(),((Map)((List)actualDataMap.get("places")).get(0)).get("longitude"));
        assertEquals(zippoPotamPojos.getZippoPotamPlaces().getState(),((Map)((List)actualDataMap.get("places")).get(0)).get("state"));
        assertEquals(zippoPotamPojos.getZippoPotamPlaces().getStateAbbreviation(),((Map)((List)actualDataMap.get("places")).get(0)).get("state abbreviation"));


    }


}
