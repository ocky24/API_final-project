package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class clinicSteps {
    @Steps
    langkah.clinic clinic;

    @Given("admin success authh")
    public void adminsuccesauth(){
        clinic.adminSuccessAuth();
    }
    @When("admin Post API endpoint for add clinic")
    public void adminPostAPIEndpointforAddClinic(){
        clinic.setPostAPIEndpointforAddclinic();
    }
    @And("admin send POST HTTP request for kejiwaan")
    public void adminSendPOSTHTTPRequestforKejiwaan(){
        clinic.sendPostHTTPRequestforkejiwaan();
    }



}
