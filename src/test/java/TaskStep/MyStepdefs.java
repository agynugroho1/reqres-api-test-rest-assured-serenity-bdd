package TaskStep;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.textui.TestRunner;

public class MyStepdefs {

    int angka1,angka2;
    String operator;
    @When("I want count {int} and {int}")
    public void iWantCountAnd(int arg0, int arg1) {
        angka1 = arg0;
        angka2 = arg1;
    }

    @And("Using operator {string}")
    public void usingOperator(String arg0) {
        operator = arg0;
    }

    @Then("i receive a {int} that matches the example")
    public void iReceiveAThatMatchesTheExample(int arg0) {
        switch (operator){
            case "+":
                if((angka1 + angka2) == arg0){
                    System.out.println("Hasil : "+arg0+" (sesuai)");
                } else{
                    throw new RuntimeException();
                }
                break;
            case "-":
                if((angka1 - angka2) == arg0){
                    System.out.println("Hasil : "+arg0+" (sesuai)");
                } else{
                    throw new RuntimeException();
                }
                break;
            case "*":
                if((angka1 * angka2) == arg0){
                    System.out.println("Hasil : "+arg0+" (sesuai)");
                } else{
                    throw new RuntimeException();
                }
                break;
            case "/":
                if((angka1 / angka2) == arg0){
                    System.out.println("Hasil : "+arg0+" (sesuai)");
                } else{
                    throw new RuntimeException();
                }
                break;
            default:
                throw new RuntimeException();
        }
    }
}
