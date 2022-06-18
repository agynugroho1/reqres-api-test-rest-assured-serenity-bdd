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
    @When("I send GET Single User with id {int}")
    public void iSendGETSingleUserWithId(int id) {
        Reqres.userID = id;
        reqres.getSingleUser();
    }

    @Then("The response status code is {int}")
    public void theResponseStatusCodeIs(int status) {
        restAssuredThat(validatableResponse -> validatableResponse.statusCode(status));
    }

    @And("response body with jsonPath {string} should be equal {int}")
    public void responseBodyWithJsonPathShouldBeEqual(String dataID, int expectedID) {
        restAssuredThat(validatableResponse -> validatableResponse.body(dataID, equalTo(expectedID)));
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

    @When("I send DELETE by selecting id {int}")
    public void iSendDELETEBySelectingId(int id) {
        Reqres.userID = id;
        reqres.deleteSingleUser();
    }

    @When("I send PUT Request with body {string}")
    public void iSendPUTRequestWithBody(String fileObj) {
        String path = "src/test/resources/payload/"+fileObj;
        File file = new File(String.format(path));
        reqres.putUpdateUser(file);
    }

    @Given("Set user id is {int}")
    public void setUserIdIs(int id) {
        Reqres.userID = id;
    }

    @When("I send POST Request for {string} with body {string}")
    public void iSendPOSTRequestForWithBody(String action, String fileObj) {
        String path = "src/test/resources/payload/"+fileObj;
        File file = new File(String.format(path));
        switch (action){
            case "Register" :
                reqres.postRegister(file);
                break;
            case "Create" :
                reqres.postCreateUser(file);
                break;
            case "Login" :
                reqres.postLogin(file);
                break;
            default: throw new RuntimeException();
        }
    }
}
