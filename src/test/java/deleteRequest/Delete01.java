package deleteRequest;

import BaseURLs.RestfulBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Delete01 extends RestfulBaseURL {

    /*
        Given
            1)https://restful-booker.herokuapp.com/booking/5
            2)Auth olarak HEader da Cookie ile token=001832eb39ba0ca gönderiniz
        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 201 olduğunu
		 And
		    Response body de "Created" yazdığını verify ediniz.
     */

    /*
    http'de bazı şirketlerde POST ile delete yapan end point ile karşılaşılabilir.
    delete_bookingID :  {1,3,5,8,7} gibi birşey olabilir.
     */


    @Test
    public void delete01(){
    //Step 1: set URL
        specification.pathParams("bookingPath","booking",
                "idPath","2461");

    //Step 2: expected data and req body
       //setlememiz gerek hen hangi bir data olmadığı için ignore edilmiştir.

    //Step 3: Send a request

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
                delete("/{bookingPath}/{idPath}");

        response.prettyPrint();

        //Step 4: assertion
        response.then().assertThat().statusCode(201);
        String responseBody = response.asString();
        assertEquals(responseBody,"Created");


    }

}
