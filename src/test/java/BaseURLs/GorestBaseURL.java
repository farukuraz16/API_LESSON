package BaseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GorestBaseURL {

    protected RequestSpecification specification;

    @Before
    public void setBaseURL(){

        specification = new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v2").build();

    }
}
