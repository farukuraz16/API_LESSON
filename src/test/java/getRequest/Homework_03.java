package getRequest;

import BaseURLs.DummyBaseURL;
import BaseURLs.RestfulBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Homework_03 extends DummyBaseURL {
    /*
    Given
	   	    https://dummy.restapiexample.com/api/v1/employee/1
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
    {
    "status": "success",
    "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}
*/

    @Test
    public void HM_03() {
        specification.pathParams("employeePath", "employee", "idPath", 1);
        Response response = given().spec(specification).when().get("/{employeePath}/{idPath}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("data.id",Matchers.equalTo(1),
                "data.employee_name",Matchers.equalTo("Tiger Nixon"),
                "data.employee_salary",Matchers.equalTo(320800),
                "data.employee_age",Matchers.equalTo(61),
                "data.profile_image",Matchers.equalTo("")
                );

    }
}
