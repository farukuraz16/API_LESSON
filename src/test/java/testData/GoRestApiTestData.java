package testData;

import java.util.HashMap;
import java.util.Map;

public class GoRestApiTestData {

    //422

    public int statusCodeForPostInvalid(){

        return 422;
    }

    /*
     "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
     */

    //Post işlemi yapacağımız için request Body ile expected data aynıdır.
    //bu yüzden parametreli bir method oluşturacağım ve Post02 classında parametrelerini gireceğim
    public HashMap<String, String> reqBodyAndExpectedData(String name, String gender, String email, String status){

        HashMap<String,String> reqBodyAndExpectedDataMap = new HashMap<>();

        reqBodyAndExpectedDataMap.put("name", name);
        reqBodyAndExpectedDataMap.put("gender", gender);
        reqBodyAndExpectedDataMap.put("email", email);
        reqBodyAndExpectedDataMap.put("status", status);

        return reqBodyAndExpectedDataMap;
    }
}
