import Base_Package.AppiumBaseTest;
import Login_Setup.Setup_And_Capabilties_Login_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class Login_Test_Cases extends AppiumBaseTest {

    Setup_And_Capabilties_Login_Page loginSetup =  new Setup_And_Capabilties_Login_Page();
    @BeforeClass
    public  void open_Jd3_app() throws MalformedURLException, InterruptedException {
        loginSetup.click_Get_Started();
    }

    @Test (priority = 1)
    public void valid_login() throws InterruptedException, MalformedURLException{
        loginSetup.enter_Email(loginSetup.valid_Email_data);
        loginSetup.enter_password(loginSetup.valid_Password_data);
        loginSetup.click_Sign_In();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginSetup.home_homeIcon_Xpath)));
    }

    @Test (priority = 2)
    public void invalid_login_wrong_email_format() throws InterruptedException, MalformedURLException{
        loginSetup.enter_Email("test");
        loginSetup.enter_password("000000");
        loginSetup.click_Sign_In();
        //Add Assertion Here
    }
    @Test (priority = 3)
    public void invalid_login_wrong_password() throws InterruptedException, MalformedURLException{

        loginSetup.enter_Email("Peter.rimon+0@genwin.net");
        loginSetup.enter_password("gdg1000");
        loginSetup.click_Sign_In();
        //Add Assertion Here
    }
    @Test (priority = 4)
    public void invalid_login_wrong_email() throws InterruptedException, MalformedURLException{
        loginSetup.enter_Email("Peter.rimon+0@genwin.wrong");
        loginSetup.enter_password("000000");
        loginSetup.click_Sign_In();
        //Add Assertion Here
    }
    @Test (priority = 5)
    public void invalid_login_empty_email() throws InterruptedException, MalformedURLException{

        loginSetup.enter_Email("");
        loginSetup.enter_password("000000");
        loginSetup.click_Sign_In();
        //Add Assertion Here
    }
    @Test (priority = 6)
    public void invalid_login_empty_password() throws InterruptedException, MalformedURLException{

        loginSetup.enter_Email("Peter.rimon+0@genwin.wrong");
        loginSetup.enter_password("000000");
        loginSetup.click_Sign_In();
        //Add Assertion Here
    }
    @Test (priority = 7)
    public void valid_login_remember_me_True() throws InterruptedException, MalformedURLException{

        loginSetup.enter_Email(loginSetup.valid_Email_data);
        loginSetup.enter_password(loginSetup.valid_Password_data);
        loginSetup.click_Remember_Me_chckBox_Login_Page();
        loginSetup.click_Sign_In();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginSetup.home_homeIcon_Xpath)));
        //Add Assertion Here
    }
    @AfterMethod
    public void go_to_login_if_logged_in(){
        try{
            if(appiumDriver.findElement(By.xpath(loginSetup.home_homeIcon_Xpath)).isDisplayed())
            {
                loginSetup.click_Profile();
                loginSetup.click_Sign_Out();
                loginSetup.click_OK_Btn_Sign_Out_Pop_up();
                loginSetup.clear_Login_Fields();
            }
        }
        catch(Exception e){

        }
    }
    @AfterSuite
    public void closeTest() {
        appiumDriver.closeApp();
        appiumDriver.quit();
    }
}
