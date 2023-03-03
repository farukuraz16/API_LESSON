package BaseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestApiExamBaseUrl {

    //http://dummy.restapiexample.com/api/v1/create

    protected RequestSpecification specification;

    @Before
    public void setBaseURL(){
        specification = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1").build();
    }
}
