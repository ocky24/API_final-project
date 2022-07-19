package langkah;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class login {
    protected String url ="https://shaggy-badger-99.a276.dcdg.xyz";
    public String accesstoken;
    public String refreshtoken;

    @Step("admin Post API endpoint")
    public String setPostApiEndpoints(){return url + "/login";}

    @Step("admin send POST HTTP request")
    public void sendPostHTTPrequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id","admin-1");
        requestBody.put("password","root");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setPostApiEndpoints());
//        Response resp = SerenityRest.lastResponse();
//        accesstoken = resp.getBody().jsonPath().get("data.accessToken");
//        refreshtoken = resp.getBody().jsonPath().get("data.refreshToken");
//        System.out.println(accesstoken);
//        System.out.println(refreshtoken);
    }



//untuk logout
//    @Step("admin set API endpoint for logout")
//    public String setApiEndpointsforLogout(){return url + "/logout";}


//
//    @Step("admin receive HTTP response code 401")
//    public void adminReceinveHTTPResponseCode401(){
//        restAssuredThat(response -> response.statusCode(401));
//    }

    @Step("admin receive valid HTTP response code 200")
    public void receiveValidHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("admin send POST HTTP request with invalid id")
    public void sendPostHTTPrequestWithInvalidId(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id","admin");
        requestBody.put("password","root");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setPostApiEndpoints());
    }

    @Step("admin receive HTTP response code 404")
    public void receiveHTTPResponseCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("admin send POST HTTP request with invalid password")
    public void sendPostHTTPRequestwithInvalidPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id","admin-1");
        requestBody.put("password","rot");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setPostApiEndpoints());
    }

    @Step("admin receive HTTP response code 400")
    public void receiveHTTPResponseCode400(){restAssuredThat(response -> response.statusCode(400));
    }

    @Step("admin send POST HTTP request with invalid id and invalid password")
    public void sendPostHTTPRequestwithInvalidIdAndInvalidPassword(){
            JSONObject requestBody = new JSONObject();
            requestBody.put("id","admin");
            requestBody.put("password","rotss");

            SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setPostApiEndpoints());
    }

//    @Step("accesstoken and refresh token for login")
//    public void accessRefreshTokenForLogin(){
//        Response response = SerenityRest.lastResponse();
//        int accesstoken = response.getBody().jsonPath().get("data.accessToken");
//        int refreshtoken = response.getBody().jsonPath().get("data.refreshToken");
//    }

}
