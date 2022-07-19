package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class logoutSteps {
   @Steps
   langkah.logout logout;

    @Given("admin success auth")
    public void adminSuccessAuth(){
        logout.adminSuccessAuth();
    }

    @Given("admin set API endpoint for logout")
    public void adminSetAPIEndpointForLogout(){
        logout.setApiEndpointsforLogout();
    }

    @When("admin send POST HTTP request for logout")
    public void adminSendPostHTTPRequestforLogout(){
        logout.sendPostHTTPRequestforLogout();
    }

    @And("admin receive HTTP response code 401")
    public void adminReceiveHTTPResponseCode401(){
        logout.adminReceinveHTTPResponseCode401();
    }

}
