package BaseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestfulBaseURL {
    protected RequestSpecification specification;

    @Before
    public void setBaseURL(){
        specification = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
