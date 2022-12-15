package ReqresStep;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;


public class ReqresStepdefs {

    Reqres reqres = new Reqres();
    @When("I send GET List User with page {int}")
    public void iSendGETListUserWithPage(int page) {
        Reqres.pageNumber = page;
        reqres.getListUser();
    }

    @Then("The response status code is {int}")
    public void theResponseStatusCodeIs(int status) {
        restAssuredThat(validatableResponse -> validatableResponse.statusCode(status));
    }

    @And("response body with jsonPath {string} should be equal {int}")
    public void responseBodyWithJsonPathShouldBeEqual(String data, int expected) {
        restAssuredThat(validatableResponse -> validatableResponse.body(data, equalTo(expected)));
    }

    @And("response body with jsonPath {string} should be equal {string}")
    public void responseBodyWithJsonPathShouldBeEqual(String dataEmail, String expectedEmail) {
        restAssuredThat(validatableResponse -> validatableResponse.body(dataEmail, equalTo(expectedEmail)));
    }

    @And("response body should be with jsonSchema {string}")
    public void responseBodyShouldBeWithJsonSchema(String fileData) {
        String path = "schema/"+fileData;
        restAssuredThat(validatableResponse -> validatableResponse.assertThat().body(matchesJsonSchemaInClasspath(path)));
    }

    @When("I send POST Request for {string} with body {string}")
    public void iSendPOSTRequestForWithBody(String action, String fileObj) {
        String path = "src/test/resources/payload/"+fileObj;
        File file = new File(String.format(path));
        switch (action){
            case "Create" :
                reqres.postCreateUser(file);
                break;
            default:
        }
    }
}
