package BaseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Practice03BaseURL {

    protected RequestSpecification baseURL;

@Before
    public void setBaseURL(){
    baseURL = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();

}

}
