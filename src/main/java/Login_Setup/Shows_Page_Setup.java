package Login_Setup;

import Base_Package.AppiumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Shows_Page_Setup extends AppiumBaseTest {

   public String shows_filter_Xpath  = "//*[@text='Shows']";
    public String categories_filter_shows_page_Xpath  = "//*[@text='Categories']";
    public String show_card_shows_page_Xpath  = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View[3]";
    public String tv_shows_Type_In_TV_shows_inner_Page_Xpath  = "//*[@text='TV Shows']";
    public String tv_shows_Search_Icon_Xpath  = "//android.view.View[@content-desc='fab']";
    public String tv_shows_Search_field_Xpath  = "//*[@text='Search']";
    public String tv_shows_See_ALL_Xpath  = "//*[@text='See All']";
    public String back_btn_Xpath  = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.ImageView";

    public void click_Shows_Filter() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(shows_filter_Xpath))).click();
    }
    public void click_Categories_fitler_in_Shows() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(categories_filter_shows_page_Xpath))).click();
    }
    public void select_from_Categories_fitler_in_Shows(String selection) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='"+selection+"']"))).click();
    }
    public void assert_on_text_in_Shows_inner_page(String value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='| "+value+"']")));
    }
    public void click_Show_card() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(show_card_shows_page_Xpath))).click();
    }
    public void click_Search_Icon() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tv_shows_Search_Icon_Xpath))).click();
    }
    public void click_See_ALL() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tv_shows_See_ALL_Xpath)));
        driver.findElements(By.xpath(tv_shows_See_ALL_Xpath)).get(0).click();
    }
    public void click_back_btn() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(back_btn_Xpath))).click();
    }
    public void enter_Search_data(String value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tv_shows_Search_field_Xpath))).click();
        action = new Actions(driver);
        action.sendKeys(value).perform();
        action.sendKeys(Keys.ENTER).perform();    }
}
