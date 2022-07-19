package langkah;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class clinic {
    protected String url = "https://shaggy-badger-99.a276.dcdg.xyz";
    protected static String accesstoken = "";
    protected static String refreshtoken = "";

    @Step("admin success authh")
    public void adminSuccessAuth() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", "admin-1");
        requestBody.put("password", "root");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(url + "/login");
        Response resp = SerenityRest.lastResponse();
        accesstoken = resp.getBody().jsonPath().get("data.accessToken");
        System.out.println(accesstoken);
    }

    @Step("admin Post API endpoint for add clinic")
    public String setPostAPIEndpointforAddclinic() {
        return url + "/clinics";
    }

    @Step("admin send POST HTTP request for kejiwaan")
    public void sendPostHTTPRequestforkejiwaan() {
        System.out.println(accesstoken);
        SerenityRest.given().header("Authorization", "Bearer " + accesstoken).post(setPostAPIEndpointforAddclinic());
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "kejiwaan");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostAPIEndpointforAddclinic());
    }

}
