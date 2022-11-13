import Base_Package.AppiumBaseTest;
import Login_Setup.Setup_And_Capabilties_Login_Page;
import Login_Setup.Shows_Page_Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Shows_Page_Test_Cases extends AppiumBaseTest {

    Setup_And_Capabilties_Login_Page loginSetup =  new Setup_And_Capabilties_Login_Page();
    Shows_Page_Setup shows_page_setup = new Shows_Page_Setup();
    @BeforeClass
    public  void open_Jd3_app_and_Login() throws MalformedURLException, InterruptedException {
        loginSetup.click_Get_Started();
        loginSetup.enter_Email(loginSetup.valid_Email_data);
        loginSetup.enter_password(loginSetup.valid_Password_data);
        loginSetup.click_Sign_In();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginSetup.home_homeIcon_Xpath)));
    }

    @Test (priority = 1)
    public void open_shows_page_then_filter_using_categories_fitler_in_shows_page() throws InterruptedException, MalformedURLException{
        shows_page_setup.click_Shows_Filter();
        shows_page_setup.click_Categories_fitler_in_Shows();
        shows_page_setup.select_from_Categories_fitler_in_Shows("Personal Development");
        shows_page_setup.click_Show_card();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(shows_page_setup.tv_shows_Type_In_TV_shows_inner_Page_Xpath)));
        shows_page_setup.assert_on_text_in_Shows_inner_page("Personal Development");
        //assertion here
    }

    @Test (priority = 2)
    public void open_shows_page_then_search_then_open_tvshow_page() throws InterruptedException, MalformedURLException{
        shows_page_setup.click_Shows_Filter();
        shows_page_setup.click_Search_Icon();
        shows_page_setup.enter_Search_data("People think");
        shows_page_setup.click_Show_card();
        shows_page_setup.assert_on_text_in_Shows_inner_page("People think");
        shows_page_setup.click_back_btn();
        //assertion here

    }
    @Test (priority = 3)
    public void open_shows_page_then_press_See_ALL_then_open_tvshow_page() throws InterruptedException, MalformedURLException{
        shows_page_setup.click_Shows_Filter();
        shows_page_setup.click_See_ALL();
        shows_page_setup.click_Show_card();
        shows_page_setup.open_home_Page();
        //assertion here
    }
    @AfterMethod
    public void go_to_home_page()  {
       // shows_page_setup.open_home_Page();
        try{
            Thread.sleep(3000);
            while(!driver.findElement(By.xpath(loginSetup.home_homeIcon_Xpath)).isDisplayed())
            {
                shows_page_setup.click_back_btn();
            }
            loginSetup.click_home_Icon();
        }
        catch(Exception e){
        }
    }
}
