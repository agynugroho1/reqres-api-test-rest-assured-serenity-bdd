package ReqresStep;

import net.serenitybdd.rest.SerenityRest;

import java.io.File;

public class Reqres {
    public static int pageNumber;
    public void getListUser(){
        SerenityRest.get("api/users?page="+ pageNumber);
    }

    public void postCreateUser(File file){
        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(file)
                .post("api/users");
    }

}
