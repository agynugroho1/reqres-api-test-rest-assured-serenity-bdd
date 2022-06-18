package ReqresStep;

import net.serenitybdd.rest.SerenityRest;

import java.io.File;

public class Reqres {
    public static int userID;
    public void getSingleUser(){
        SerenityRest.get("api/users/"+userID);
    }

    public void postLogin(File file){
        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(file)
                .post("api/login");
    }

    public void postRegister(File file){
        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(file)
                .post("api/register");
    }
    public void postCreateUser(File file){
        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(file)
                .post("api/users");
    }

    public void putUpdateUser(File file){
        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(file)
                .put("api/users/"+userID);
    }

    public void deleteSingleUser(){
        SerenityRest.delete("api/users/"+userID);
    }
}
