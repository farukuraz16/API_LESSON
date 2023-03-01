package getRequest;

import BaseURLs.GorestBaseURL;
import org.junit.Test;

public class Get12 extends GorestBaseURL {
     /*
        Given
            https://gorest.co.in/public/v2/users/702440
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

    {
    "id": 702440,
    "name": "Adheesh Chopra",
    "email": "adheesh_chopra@schamberger-langosh.biz",
    "gender": "male",
    "status": "active"
}
     */


    @Test
    public void get12 (){

        //Step 1: set URL             https://gorest.co.in/public/v2/users/702440
        specification.pathParams("usersPath","users","idPath","702440");

        //Step 2: set expected data
        String expectedData = "{\n" +
                "    \"id\": 702440,\n" +
                "    \"name\": \"Adheesh Chopra\",\n" +
                "    \"email\": \"adheesh_chopra@schamberger-langosh.biz\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //Object Mapper: Object Mapper'ı kullanabilmek için maven projelerinde pom.xml dependency eklemem gerekiyor-->maven repo!dan..

        System.out.println("expectedData = " + expectedData);


    }



}
