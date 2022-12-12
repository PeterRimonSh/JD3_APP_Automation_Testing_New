package Base_Package;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class SeleniumBaseTest {

    public static WebDriver driver  = null;
  //  public static Actions builder;
  //  public static JavascriptExecutor js;
    public static WebDriverWait wait;
    public static SoftAssert softAssert;
  //  public static ElementActions elementActions;
    public SeleniumBaseTest()  {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(DriverFactory.DriverType.DESKTOP_CHROME);
           // builder = new Actions(driver);
           // js = (JavascriptExecutor) driver;
            wait = new WebDriverWait(driver, 45);
            softAssert = new SoftAssert();
           // elementActions = new ElementActions(driver);
        }
    }

}