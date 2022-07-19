package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class loginSteps {
    @Steps
    langkah.login login;

    @Given("admin Post API endpoint")
    public void setPostApiEndpoints(){
    login.setPostApiEndpoints();
    }

    @When("admin send POST HTTP request")
    public void sendPostHTTPrequest(){
    login.sendPostHTTPrequest();
    }
    @Then("admin receive valid HTTP response code 200")
    public void adminReceiveValidHTTPResponseCode200(){
    login.receiveValidHttpResponseCode200();
    }

    @When("admin send POST HTTP request with invalid id")
    public void adminSendPostHTTPrequestwithInvalidid(){
    login.sendPostHTTPrequestWithInvalidId();
    }

    @Then("admin receive HTTP response code 404")
    public void adminReceiveHTTPresponseCode404(){
    login.receiveHTTPResponseCode404();
    }

    @When("admin send POST HTTP request with invalid password")
    public void adminSendPostHTTPrequestwithInvalidPassword(){
    login.sendPostHTTPRequestwithInvalidPassword();
    }

    @Then("admin receive HTTP response code 400")
    public void adminReceiveHTTPResponseCode400(){
    login.receiveHTTPResponseCode400();
    }

    @When("admin send POST HTTP request with invalid id and invalid password")
    public void adminSendPostHTTPrequestWithinvalidIdandInvalidPassword(){
        login.sendPostHTTPRequestwithInvalidIdAndInvalidPassword();
    }


}
