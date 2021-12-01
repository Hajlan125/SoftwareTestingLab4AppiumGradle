package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MailPage {
    AndroidDriver driver;
    public MailPage(AndroidDriver driver) {
        this.driver = driver;
    }
    public WebElement menuButton() {
        return driver.findElementByAccessibilityId("Open menu");
    }
    public WebElement sentButton() {
        return driver.findElementByXPath("//android.widget.LinearLayout[7]");
    }
    public void sendedMailsCheck() {
        menuButton().click();
        //"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[7]
        sentButton().click();
    }
    public void settingsPageOpening() throws InterruptedException {
        menuButton().click();
        waiting(1000);

        driver.swipe(300,1700,300,100,500);
        waiting(1000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.tap(1,200,1430, 300);
    }
    public void logout() {
        driver.tap(1,200,1680,300);
    }
    public void waiting(int delay) throws InterruptedException {
        synchronized (driver){
            driver.wait(delay);
        }
    }
}