import api.HttpUtil;
import com.shaft.api.RestActions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static utlility.Constants.BASE_URL_STAGING;
import static utlility.Constants.FORGET_PASSWORD_STAGING_END_POINTS;

public class test {

    @Test
    public void testclass() throws IOException {
        JSONObject forgetPasswordJsonObject = new JSONObject();
        // forgetPasswordJsonObject.put("email",emailPref+"");
        forgetPasswordJsonObject.put("email", "1670870148531" + "@mailinator.com");
//        resetPasswordJsonObject = new JSONObject();
        System.out.println("forgetPasswordJsonObject  : " + forgetPasswordJsonObject.toString());


//        String post = HttpUtil.post(BASE_URL_STAGING + FORGET_PASSWORD_STAGING_END_POINTS,
//                forgetPasswordJsonObject,null);
        Response forgetPasswordResponse = RestActions
                .buildNewRequest(BASE_URL_STAGING, FORGET_PASSWORD_STAGING_END_POINTS, RestActions.RequestType.POST)
                .addHeader("source","webclient:chefjojostaging.genwin.app,organization_id:619eb2cd491b98b6c8c82f3f,fund_raiser_id:61b0ebe29dd7ea5f7af9e44f,theme:influencers")
                .setRequestBody(forgetPasswordJsonObject)
                .setContentType(ContentType.JSON)
                .performRequest();

        System.out.println(" response : " + RestActions.getResponseBody(forgetPasswordResponse));

    }
}
