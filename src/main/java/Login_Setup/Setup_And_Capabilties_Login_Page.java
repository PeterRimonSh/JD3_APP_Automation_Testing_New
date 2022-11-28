package Login_Setup;

import Base_Package.AppiumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Setup_And_Capabilties_Login_Page extends AppiumBaseTest {

   public String get_Started_Btn_Xpath  = "//*[@text='Get Started']";
    public String email_loginPage_ID = "emailET";
    public String password_loginPage_ID = "passwordET";
    public String sign_In_loginPage_ID  = "signInBtn";
    public String remember_Me_ChckBox_loginPage_ID  = "rememberMeCB";

    //Home Xpath
    public String home_homeIcon_Xpath  = "//*[@content-desc='Home']";
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(email_loginPage_ID))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(email_loginPage_ID))).sendKeys(emailValue);
    }

    public void enter_password(String passwordValue) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(password_loginPage_ID))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(password_loginPage_ID))).sendKeys(passwordValue);
    }
    public void click_Remember_Me_chckBox_Login_Page() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(remember_Me_ChckBox_loginPage_ID))).click();
    }
    public void click_Sign_In() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(sign_In_loginPage_ID))).click();
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(email_loginPage_ID))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(password_loginPage_ID))).clear();

    }

}
