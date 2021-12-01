package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage {
    AndroidDriver driver;
    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
    }
    public WebElement themeSwitch() {
        return driver.findElementByXPath("//android.widget.Switch");
    }
    public WebElement returningButton() {
        return driver.findElementByAccessibilityId("Navigate up");
    }
    public void darkThemeOnOff() {
//        driver.tap(1,960, 790,300);
//        /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Switch
        themeSwitch().click();
    }
    public void mailPageReturning() {
        returningButton().click();
    }

}
