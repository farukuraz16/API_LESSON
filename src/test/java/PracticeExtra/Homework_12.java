package PracticeExtra;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.*;
import utilities.JsonToJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.urlEncodingEnabled;
import static junit.framework.TestCase.assertEquals;

public class Homework_12 {
    /*
    Given
            1) "http://api.openweathermap.org/data/3.0/triggers?appid=c73a117fa646e4723bf40f2abfba56f1"
    And
           2) {
   "time_period":{
                   "start": {
                            "expression":"after",
                            "amount":132000000
                            },
                    "end":{
                            "expression":"after",
                            "amount":432000000
                           }
                   },
   "conditions":[
                {
                    "name":"temp",
                    "expression":"$gt",
                    "amount":299
                }
                ],
   "area":[
                {
                    "type":"Point",
                    "coordinates":[
                                    53,
                                    37
                                   ]
                }
           ]
}
    When
        Kullanıcı POST metodu ile request atar
    Then
        Kullanıcı status code un 201 olduğunu verify eder
    And
        Response Body nin aşağıdaki gibi olduğunu verify eder
      {
    "__v": 0,
    "_id": "630b8e79486da9000b22afcf",
    "alerts": {},
    "area": [
        {
            "type": "Point",
            "_id": "630b8e79486da9000b22afd0",
            "coordinates": [
                53,
                37
            ]
        }
    ],
    "conditions": [
        {
            "name": "temp",
            "expression": "$gt",
            "amount": 299,
            "_id": "630b8e79486da9000b22afd1"
        }
    ],
    "time_period": {
        "end": {
            "expression": "after",
            "amount": 432000000
        },
        "start": {
            "expression": "after",
            "amount": 132000000
        }
    }
}
     */

    @Test
    public void hw12 (){

        //Set URL
        String URL="http://api.openweathermap.org/data/3.0/triggers?appid=c73a117fa646e4723bf40f2abfba56f1";

        //Set req&exp data
        Homework12_startAndEndPojo startMap = new Homework12_startAndEndPojo("after",132000000);
        Homework12_startAndEndPojo endMap = new Homework12_startAndEndPojo("after",432000000);
        Homework12_timePeriodPojo timePeriodPojo = new Homework12_timePeriodPojo(startMap,endMap);
        System.out.println("timePeriodPojo = " + timePeriodPojo);

        Homework12_inConditionsPojo inConditionsMap = new Homework12_inConditionsPojo("temp","$gt",299);
        List<Object> conditionsList = new ArrayList<>();
        conditionsList.add(inConditionsMap);
        System.out.println("conditionsList = " + conditionsList);

        List<Integer> coordinatesList = new ArrayList<>();
        coordinatesList.add(53);
        coordinatesList.add(37);
        Homework12_inAreaPojo inAreaPojo = new Homework12_inAreaPojo("Point",coordinatesList);
        List<Object> areaList = new ArrayList<>();
        areaList.add(inAreaPojo);
        System.out.println("areaList = " + areaList);

        Homework12_reqBodyPojo reqBody = new Homework12_reqBodyPojo(timePeriodPojo,conditionsList,areaList);
        System.out.println("reqBody = " + reqBody);

        //send req

        Response response = given().
                contentType(ContentType.JSON).
                body(reqBody).when().post(URL);
        response.prettyPrint();
        response.then().assertThat().statusCode(201);
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        String expectedData = "{\n" +
                "    \"__v\": 0,\n" +
                "    \"_id\": \"630b8e79486da9000b22afcf\",\n" +
                "    \"alerts\": {},\n" +
                "    \"area\": [\n" +
                "        {\n" +
                "            \"type\": \"Point\",\n" +
                "            \"_id\": \"630b8e79486da9000b22afd0\",\n" +
                "            \"coordinates\": [\n" +
                "                53,\n" +
                "                37\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"conditions\": [\n" +
                "        {\n" +
                "            \"name\": \"temp\",\n" +
                "            \"expression\": \"$gt\",\n" +
                "            \"amount\": 299,\n" +
                "            \"_id\": \"630b8e79486da9000b22afd1\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"time_period\": {\n" +
                "        \"end\": {\n" +
                "            \"expression\": \"after\",\n" +
                "            \"amount\": 432000000\n" +
                "        },\n" +
                "        \"start\": {\n" +
                "            \"expression\": \"after\",\n" +
                "            \"amount\": 132000000\n" +
                "        }\n" +
                "    }\n" +
                "}";
        HashMap<String, Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("expectedDataMap = " + expectedDataMap);

        assertEquals(expectedDataMap.get("alerts"),actualDataMap.get("alerts"));
        assertEquals(expectedDataMap.get("area.type"),actualDataMap.get("area.type"));
        assertEquals(expectedDataMap.get("time_period"),actualDataMap.get("time_period"));

    }




}
