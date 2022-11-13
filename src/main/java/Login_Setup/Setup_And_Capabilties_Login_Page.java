package Login_Setup;

import Base_Package.AppiumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Setup_And_Capabilties_Login_Page extends AppiumBaseTest {

   public String get_Started_Btn_Xpath  = "//*[@text='Get Started']";
    public String email_loginPage_Xpath  = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText";
    public String password_loginPage_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText";
    public String sign_In_loginPage_Xpath  = "//*[@text='Sign in']";
    public String remember_Me_ChckBox_loginPage_Xpath  = "//*[@class='android.widget.CheckBox']";

    //Home Xpath
    public String home_homeIcon_Xpath  = "//android.view.View[@content-desc='Home']";
    public String profile_Icon_Xpath  = "//*[@text='PR']";
    public String sign_Out_Xpath  = "//*[@text='Sign out']";
    public String sign_Out_Popup_OK_Btn_Xpath  = "//*[@text='OK']";

    //Login Valid data: Email and password
    public String valid_Email_data  = "Peter.rimon+0@genwin.net";
    public String valid_Password_data  = "000000";

    public void click_Get_Started() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(get_Started_Btn_Xpath))).click();
    }

    public void enter_Email(String emailValue) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(email_loginPage_Xpath))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(email_loginPage_Xpath))).sendKeys(emailValue);
    }

    public void enter_password(String passwordValue) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(password_loginPage_Xpath))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(password_loginPage_Xpath))).sendKeys(passwordValue);
    }
    public void click_Remember_Me_chckBox_Login_Page() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(remember_Me_ChckBox_loginPage_Xpath))).click();
    }
    public void click_Sign_In() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sign_In_loginPage_Xpath))).click();
    }
    public void click_home_Icon() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(home_homeIcon_Xpath))).click();
    }
    public void click_Profile() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(profile_Icon_Xpath))).click();
    }
    public void click_Sign_Out() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sign_Out_Xpath))).click();
    }
    public void click_OK_Btn_Sign_Out_Pop_up() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sign_Out_Popup_OK_Btn_Xpath))).click();
    }
    public void clear_Login_Fields() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(email_loginPage_Xpath))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(password_loginPage_Xpath))).clear();

    }

}
