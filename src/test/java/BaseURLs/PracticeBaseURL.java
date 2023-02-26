package BaseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PracticeBaseURL {

     protected RequestSpecification baseURL;

     @Before
    public void setUPBaseURL(){
         baseURL = new RequestSpecBuilder().
                 setBaseUri("https://restful-booker.herokuapp.com").
                 build();

     }


}
