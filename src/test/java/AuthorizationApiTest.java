import RegisterSetup.RegisterSetup;
import com.shaft.api.RestActions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static utlility.Constants.*;

public class AuthorizationApiTest extends RegisterSetup{
    JSONObject loginBodyJsonObject,registerBodyJsonObject, forgetPasswordJsonObject, resetPasswordJsonObject;
    String emailPref;
    String password = "1212311nvn54";
    String newPassword = "33444fffsd54";

    @BeforeClass
    public void init(){
        loginBodyJsonObject = new JSONObject();
        loginBodyJsonObject.put("username", "basselghaybour@gmail.com");
        loginBodyJsonObject.put("password", "123456789");

        emailPref  = String.valueOf(System.currentTimeMillis());
        registerBodyJsonObject = new JSONObject();
        registerBodyJsonObject.put("first_name","maysara");
        registerBodyJsonObject.put("last_name","mansour");
        registerBodyJsonObject.put("email",emailPref+"@mailinator.com");
        registerBodyJsonObject.put("password",password);

        forgetPasswordJsonObject = new JSONObject();
       // forgetPasswordJsonObject.put("email",emailPref+"");
        forgetPasswordJsonObject.put("email","1670870148531"+"@mailinator.com");
        resetPasswordJsonObject = new JSONObject();

    }

    @Test
    public void loginOperation() throws JSONException {
        System.out.println(BASE_URL_STAGING+LOGIN_STAGING_END_POINTS);
        RestActions apiObject = new RestActions(BASE_URL_STAGING);
        Response response = apiObject
                .buildNewRequest(LOGIN_STAGING_END_POINTS, RestActions.RequestType.POST)
                .setRequestBody(loginBodyJsonObject)
                .setContentType(ContentType.JSON)
                .performRequest();

        org.json.JSONObject json = new org.json.JSONObject(RestActions.getResponseBody(response));
        String id = json.getJSONObject("data").getString("_id");
        String host = json.getJSONObject("data").getJSONObject("source").getString("host");
        String member_id = json.getJSONObject("data").getJSONArray("memberships").getJSONObject(0).getString("_id");
        System.out.println("response for facets  : " +  id);
        System.out.println("response for facets  : " +  host);
        System.out.println("response for facets  : " +  member_id);
    }

    @Test
    public void registerOperation() throws InterruptedException {
        System.out.println(BASE_URL_STAGING+REGISTER_STAGING_END_POINTS);
        Response registerResponse = RestActions
                .buildNewRequest(BASE_URL_STAGING,REGISTER_STAGING_END_POINTS, RestActions.RequestType.POST)
                .setRequestBody(registerBodyJsonObject)
                .setContentType(ContentType.JSON)
                .performRequest();
        System.out.println("response for facets  : " + RestActions.getResponseJSONValue(registerResponse, ""));
        softAssert.assertEquals(registerResponse.getStatusCode(),200);

        verifyEmail(emailPref);

        loginBodyJsonObject = new JSONObject();
        loginBodyJsonObject.put("username", emailPref+"@mailinator.com");
        loginBodyJsonObject.put("password", password);
        Response loginResponse = RestActions
                .buildNewRequest(BASE_URL_STAGING,LOGIN_STAGING_END_POINTS, RestActions.RequestType.POST)
                .setRequestBody(loginBodyJsonObject)
                .setContentType(ContentType.JSON)
                .performRequest();

        softAssert.assertEquals(loginResponse.getStatusCode(),200);
        softAssert.assertAll();
    }

    @Test
    public void forgetPasswordOperation() throws InterruptedException, JSONException {
       // registerOperation();


        Response forgetPasswordResponse = RestActions
                .buildNewRequest(BASE_URL_STAGING,FORGET_PASSWORD_STAGING_END_POINTS, RestActions.RequestType.POST)
                .setRequestBody(forgetPasswordJsonObject)
                .setContentType(ContentType.JSON)
                .performRequest();

        String status = assertStringJSONResponse(forgetPasswordResponse, "status");
        softAssert.assertEquals(status,"SUCCESS");


         String token = returnForgetPasswordToken(emailPref);
       System.out.println("this is the token: "+token);
      resetPasswordJsonObject.put("token", token);
        resetPasswordJsonObject.put("password", newPassword);
        Response resetPasswordResponse = RestActions
                .buildNewRequest(BASE_URL_STAGING,RESET_PASSWORD_STAGING_END_POINTS, RestActions.RequestType.POST)
                .setRequestBody(resetPasswordJsonObject)
                .setContentType(ContentType.JSON)
                .performRequest();
        softAssert.assertEquals(assertStringJSONResponse(resetPasswordResponse, "status"),"SUCCESS");

       // loginBodyJsonObject.put("username", emailPref+"@mailinator.com");
        loginBodyJsonObject.put("username", "1670861701006@mailinator.com");
        loginBodyJsonObject.put("password", newPassword);
        Response loginResponse = RestActions
                .buildNewRequest(BASE_URL_STAGING,LOGIN_STAGING_END_POINTS, RestActions.RequestType.POST)
                .setRequestBody(loginBodyJsonObject)
                .setContentType(ContentType.JSON)
                .performRequest();
        softAssert.assertEquals(assertStringJSONResponse(loginResponse, "status"),"SUCCESS");

        softAssert.assertAll();
    }
    @AfterSuite
    public void closeTest() {
        driver.quit();
    }
}