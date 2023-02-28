package testData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyTestData {
    /*
    Then
    Status Code un "200" olduğunu Assert et
    And
    Kullanıcı en son daki employee nin isminin "Doris Wilder" olduğunu dogrular
    And
    Kullanıcı 6. employee nin salary sinin 372000 olduğunu doğrular
    And
    Kullanıcı 21, 23 ve 59 yaşlarında employee olduğunu doğrular
     */

public List<Map<String,Object>> expectedDataList = new ArrayList<>();
public List<Map<String,Object>> setUpDummyRestTestData (){

    //1. Expected Data
    HashMap<String, Object> expextedDataStatus = new HashMap<>();
    expextedDataStatus.put("StatusCode",200);

    //2. Expected Data
    HashMap<String, Object> expextedDataName = new HashMap<>();
    expextedDataName.put("EmployeeName","Doris Wilder");

    //3. Expected Data
    HashMap<String, Object> expextedDataSalary = new HashMap<>();
    expextedDataSalary.put("EmployeeSalary",372000);

    //4. Expected Data
    List<Integer> expectedDataAges = new ArrayList<>();
    expectedDataAges.add(21);
    expectedDataAges.add(23);
    expectedDataAges.add(59);
    HashMap<String, Object> expectedDataMapAges = new HashMap<>();
    expectedDataMapAges.put("EmployeeAges",expectedDataAges);

    //Expected dataları expectedDataList e ekliyoruz.
    expectedDataList.add(expextedDataStatus);
    expectedDataList.add(expextedDataName);
    expectedDataList.add(expextedDataSalary);
    expectedDataList.add(expectedDataMapAges);

    return expectedDataList;
}


}