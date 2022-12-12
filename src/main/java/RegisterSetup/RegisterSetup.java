package RegisterSetup;

import Base_Package.SeleniumBaseTest;
import com.shaft.api.RestActions;
import io.restassured.response.Response;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterSetup extends SeleniumBaseTest {
    public  void verifyEmail(String email) throws InterruptedException {
        driver.navigate().to("https://www.mailinator.com/v4/public/inboxes.jsp?to="+email);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(.,'JD3-TV')]"))).click();
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'click here')]"))).click();
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

    public  String returnForgetPasswordToken(String email){
//        BrowserFactory.getBrowser().get("https://www.mailinator.com/v4/public/inboxes.jsp?to="+email);
        driver.navigate().to("https://www.mailinator.com/v4/public/inboxes.jsp?to="+email);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(.,'Reset your password')]"))).click();
        driver.switchTo().frame(0);

        //driver.switchTo().frame("html_msg_body");
        String emailContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p:nth-child(4)"))).getText();
        String firstPart[] = emailContent.split(" ");
        String secondPart[] = firstPart[0].split("token=");
        String token = secondPart[1];
        return token;
    }

    public  String assertStringJSONResponse(Response response, String stringKey) throws JSONException {
        org.json.JSONObject json = new org.json.JSONObject(RestActions.getResponseBody(response));
        String s = json.getString(stringKey);
        return s;
    }
}
