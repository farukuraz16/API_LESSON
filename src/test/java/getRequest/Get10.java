package getRequest;

import BaseURLs.DummyBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testData.DummyTestData;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

public class Get10 extends DummyBaseURL {
    /*
        Given
	   	   https://dummy.restapiexample.com/api/v1/employees
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
            Kullanıcı en son daki employee nin isminin "Doris Wilder" olduğunu dogrular
        And
            Kullanıcı 6. employee nin salary sinin 372000 olduğunu doğrular
        And
            Kullanıcı 21, 23 ve 59 yaşlarında employee olduğunu doğrular
     */

    @Test
    public void get10() {
        //Step 1--> Set URL
        //Step 2--> Set Expected Data
        //Step 3--> Send a request
        //Step 4--> Assertion


        //Step 1--> Set URL
        specification.pathParams("employeesPath", "employees");

        //Step 2--> Set Expected Data
        DummyTestData dummyTestData = new DummyTestData();
        List<Map<String, Object>> expectedData = dummyTestData.setUpDummyRestTestData();
        System.out.println("expectedData = " + expectedData);

        //Step 3--> Send a request
        Response response = given().spec(specification).when().get("/{employeesPath}");
        response.prettyPrint();

        response.then().assertThat().statusCode((Integer) expectedData.get(0).get("StatusCode")).
                body("data[-1].employee_name", equalTo (expectedData.get(1).get("EmployeeName")),
                "data[5].employee_salary", equalTo (expectedData.get(2).get("EmployeeSalary")),

                        "data.employee_age",
                        hasItems(
                                ((List)expectedData.get(3).get("EmployeeAges")).get(0),
                                ((List)expectedData.get(3).get("EmployeeAges")).get(1),
                                ((List)expectedData.get(3).get("EmployeeAges")).get(2)
                                ));

// Homeworks:

        /*
        GSON
        JsonPath

        metotoalrını kullanarak assertion işlemlerini tamamlayınız .
         */

    }
}
