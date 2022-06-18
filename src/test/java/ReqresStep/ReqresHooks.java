package ReqresStep;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class ReqresHooks {
    @Before
    public void beforeScenario(){
        RestAssured.baseURI = "https://reqres.in/";
    }
}
