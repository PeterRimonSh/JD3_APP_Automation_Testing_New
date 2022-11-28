package Base_Package;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppiumBaseTest {
    public  static AppiumDriver<MobileElement> driver;
    public static WebDriverWait wait;
    public static SoftAssert softAssert =  new SoftAssert();
    public Actions action;
    public DesiredCapabilities cap ;

    public  String udidx = "26EBB18810152892";
    public String platform_name = "Android";
    public String platform_version = "8.0.0";
    public String app_package ="com.genwin.jd3tv.staging";

    public  static int isStaging = 1;

    public AppiumBaseTest()  {
       if (driver == null) {
          set_Genric_Capabilties_Login_Page();
            wait = new WebDriverWait(driver, 45);
            softAssert = new SoftAssert();
           action = new Actions(driver);
       }
    }
    public void set_Genric_Capabilties_Login_Page(){
        cap = new DesiredCapabilities();
        cap.setCapability("udid", udidx);
        cap.setCapability("platformName", platform_name);
        cap.setCapability("platformVersion", platform_version);
        cap.setCapability("appPackage", app_package);
        open_login_Page();
        cap.setCapability("newCommandTimeout", 10000);
        cap.setCapability("autoGrantPermissions", "true");
        set_keyboard_caps();
        try {
            driver = new AndroidDriver<>(
                    new URL("http://localhost:4723/wd/hub")
                    , cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public void open_login_Page(){
        cap.setCapability("appActivity", "com.genwin.jd3tv.screens.splash.presentation.SplashActivity");
    }
    public void open_home_Page() {



//        cap = new DesiredCapabilities();
//        cap.setCapability("appActivity", "com.genwin.jd3tv.screens.splash.presentation.SplashActivity");
////        cap.setCapability("appActivity", "com.genwin.jd3tv.screens.home.presentation.MainActivity");
//        try {
//            driver = new AndroidDriver<>(
//                    new URL("http://localhost:4723/wd/hub")
//                    , cap);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

    }
    public void set_keyboard_caps(){
        cap.setCapability("unicodeKeyboard", true);
        cap.setCapability("resetKeyboard", true);
    }

    public  void takeScreenShot(String screenshotName){
        String destDir = "outputScreenshots";
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

        new File(destDir).mkdirs();
        String destFile = screenshotName + dateFormat.format(new Date()) + ".png";

        try {
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile ));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

