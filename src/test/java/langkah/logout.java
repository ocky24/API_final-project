package langkah;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class logout {
    protected String url ="https://shaggy-badger-99.a276.dcdg.xyz";
    protected static String accesstoken = "";
    protected static String refreshtoken = "";

//    public JSONObject setReqBodyforAdmin() {
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("id", "admin-1");
//        requestBody.put("password", "root");
//        return requestBody;
//    }

    @Step("admin success auth")
    public void adminSuccessAuth(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id","admin-1");
        requestBody.put("password","root");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(url+"/login");
        Response resp = SerenityRest.lastResponse();
        accesstoken = resp.getBody().jsonPath().get("data.accessToken");
        refreshtoken = resp.getBody().jsonPath().get("data.refreshToken");
        System.out.println(accesstoken);
        System.out.println(refreshtoken);
    }

    @Step("admin set API endpoint for logout")
    public String setApiEndpointsforLogout(){return url + "/logout";}

    @Step("admin send POST HTTP request for logout")
    public void sendPostHTTPRequestforLogout(){
        System.out.println(accesstoken);
        System.out.println(refreshtoken);
        SerenityRest.given().header("Authorization", "Bearer "+ accesstoken).post(setApiEndpointsforLogout());

        JSONObject requestBody = new JSONObject();
        requestBody.put("refreshToken",refreshtoken);

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setApiEndpointsforLogout());
    }

    @Step("admin receive HTTP response code 401")
    public void adminReceinveHTTPResponseCode401(){
        restAssuredThat(response -> response.statusCode(401));
    }

}
