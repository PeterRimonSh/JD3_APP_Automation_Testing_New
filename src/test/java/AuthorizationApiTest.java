import com.shaft.api.RestActions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static utlility.Constants.BASE_URL_STAGING;
import static utlility.Constants.LOGIN_STAGING_END_POINTS;

public class AuthorizationApiTest {
    JSONObject loginBodyJsonObject,registerBodyJsonObject;

    @BeforeClass
    public void init(){
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
    public void loginOperation(){
        System.out.println(BASE_URL_STAGING+LOGIN_STAGING_END_POINTS);
        RestActions apiObject = new RestActions(BASE_URL_STAGING);
        Response response = apiObject
                .buildNewRequest(LOGIN_STAGING_END_POINTS, RestActions.RequestType.POST)
                .setRequestBody(loginBodyJsonObject)
                .setContentType(ContentType.JSON)
                .performRequest();
        System.out.println("response for facets  : " + RestActions.getResponseJSONValue(response, ""));
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