package getRequest;

import BaseURLs.DummyBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Get07 extends DummyBaseURL {
    /*
        Given
	   	    https://dummy.restapiexample.com/api/v1/employees
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     employee_age i 55'ten büyük olanları konsola yazdırınız.
		     8 tane olduğunu assert ediniz.
		And
            id si 17 den büyük olanları konsola yazdırınız
            7 tane olduğunu assert ediniz.
        And
            salary si 100.000'den az olanları konsola yazdırınız.
            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
     */

    @Test
    public void get07(){
        specification.pathParam("employeesPath","employees");
        Response response = given().spec(specification).when().get("/{employeesPath}");
        //response.prettyPrint();

       // response.then().assertThat().statusCode(200);


        //Test 1      employee_age i 55'ten büyük olanları konsola yazdırınız.
        //		     8 tane olduğunu assert ediniz.

        JsonPath jsonPath = response.jsonPath();
        List<Integer> empAges = jsonPath.getList("data.employee_age");
        System.out.println("empAges = " + empAges);

       // empAges.stream().filter(x->x>55).forEach(System.out::println);

        int count =0;
        for ( Integer w: empAges ) {
            if (w>55){
                count++;
            }
        }
        System.out.println(" count = " + count);
        assertEquals(8,count);

        List<Integer> employAges = jsonPath.getList("data.findAll{(it.employee_age)>55}.employee_age");
        System.out.println("employAges = " + employAges);

        //Test 2  id si 17 den büyük olanları konsola yazdırınız
        //            7 tane olduğunu assert ediniz.
        List<Integer> idS = jsonPath.getList("data.findAll{(it.id)>17}.id");
        System.out.println("IDs: "+idS);
        System.out.println("IDs count: "+idS.size());
        assertEquals(7,idS.size());


        //Test 3   And
        //            salary si 100.000'den az olanları konsola yazdırınız.
        //            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.

        List<Integer> salary_emp = jsonPath.getList("data.findAll{(it.employee_salary)<100000}.employee_name");
        System.out.println("Salaries: "+ salary_emp);
        System.out.println("Salaries count: "+ salary_emp.size());
        assertTrue(salary_emp.contains("Doris Wilder"));
    }
}
