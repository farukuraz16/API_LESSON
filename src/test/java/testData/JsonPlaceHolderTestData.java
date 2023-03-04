package testData;

import BaseURLs.JsonPlaceHolderBaseURL;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
   public static HashMap<String, Object> expectedData;
    public HashMap setUpDataTodos(){
/*
{
    "userId": 1,
    "id": 2,
    "title": "quis ut nam facilis et officia qui",
    "completed": false
}
 */
        expectedData = new HashMap<>();
        expectedData.put("StatusCode",200);
        expectedData.put("Server","cloudflare");
        expectedData.put("userId",1);
        expectedData.put("id",2.0);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);


        return expectedData;
    }


    public HashMap<String,Object> setUpForPutReq(){
        /*{
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
         */
        expectedData = new HashMap<>();
        expectedData.put("userId",01);
        expectedData.put("title","CW FSQA API Tutorial");
        expectedData.put("completed",true);

    return expectedData;
        }


        /*
        {
"userId": 10,
"id": 198,
"title": "quis eius est sint explicabo",
"completed": true
}
         */
        public HashMap<String,Object> setUpExpectedData(){
        expectedData = new HashMap<>();
        expectedData.put("userId",10);
        expectedData.put("id",198);
        expectedData.put("title","quis eius est sint explicabo");
        expectedData.put("completed",true);

        return expectedData;
        }
}
