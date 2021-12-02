package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AutorizationPage {
    AndroidDriver driver;
    public AutorizationPage(AndroidDriver driver){
        this.driver = driver;
    }
    public void waiting(int delay) throws InterruptedException {
        synchronized (driver){
            driver.wait(delay);
        }
    }

    public WebElement setYandexAuth() {
        return driver.findElementById("ru.yandex.mail:id/list_yandex");
    }
    public WebElement loginEditField() {
        return driver.findElementById("ru.yandex.mail:id/edit_login");
    }
    public WebElement nextButton() {
        return driver.findElementById("ru.yandex.mail:id/button_next");
    }
    public WebElement editPasswordField() {
        return driver.findElementById("ru.yandex.mail:id/edit_password");
    }
    public WebElement goToMailButton() {
        return driver.findElementById("ru.yandex.mail:id/go_to_mail_button");
    }

    public void loginInput() throws InterruptedException {
        setYandexAuth().click();
        loginEditField().sendKeys("AdRGaraev");
        nextButton().click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void passwordInput() {
        editPasswordField().sendKeys("zut47wt8");
        nextButton().click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void goToMail() {
        goToMailButton().click();
    }

}