import com.shaft.api.RestActions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONException;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static utlility.Constants.BASE_URL_STAGING;
import static utlility.Constants.LOGIN_STAGING_END_POINTS;

public class AuthorizationApiTest {
    JSONObject loginBodyJsonObject,registerBodyJsonObject;

    @BeforeClass
    public void init() throws JSONException {
        loginBodyJsonObject = new JSONObject();
        loginBodyJsonObject.put("username", "basselghaybour@gmail.com");
        loginBodyJsonObject.put("password", "123456789");

        registerBodyJsonObject = new JSONObject();
        registerBodyJsonObject.put("first_name","maysara");
        registerBodyJsonObject.put("last_name","mansour");
        registerBodyJsonObject.put("email",System.currentTimeMillis()+"@mailinator.com");
        registerBodyJsonObject.put("password","121231135354");
    }

    @Test
    public void loginOperation() throws JSONException {
        System.out.println(BASE_URL_STAGING+LOGIN_STAGING_END_POINTS);
//        RestActions apiObject = new RestActions(BASE_URL_STAGING);
        Response response = RestActions
                .buildNewRequest(BASE_URL_STAGING,LOGIN_STAGING_END_POINTS, RestActions.RequestType.POST)
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
    public void registerOperation(){
        System.out.println(BASE_URL_STAGING+"/users");
        RestActions apiObject = new RestActions(BASE_URL_STAGING);
        Response response = apiObject
                .buildNewRequest("/users", RestActions.RequestType.POST)
                .setRequestBody(registerBodyJsonObject)
                .setContentType(ContentType.JSON)
                .performRequest();

        System.out.println("response for facets  : " + RestActions.getResponseJSONValue(response, ""));
    }

}