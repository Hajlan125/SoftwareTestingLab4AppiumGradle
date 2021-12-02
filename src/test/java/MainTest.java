import PageObjects.AutorizationPage;
import PageObjects.MailPage;
import PageObjects.SettingsPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainTest {
    private AndroidDriver driver;
    private AutorizationPage autorizationPage;
    private MailPage mailPage;
    private SettingsPage settingsPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        Inspector inspector = new Inspector("/Users/adelgaraev/Downloads/ru.yandex.mail_8.2.1_92370.apk","ru.yandex.mail", "ru.yandex.mail.ui.LoginActivity" );

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), inspector.capabilities);
        autorizationPage = new AutorizationPage(driver);
        mailPage = new MailPage(driver);
        settingsPage = new SettingsPage(driver);

    }

    @Test
    public void testAddition() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        waiting(3000);

        autorizationPage.loginInput();
        autorizationPage.passwordInput();
        autorizationPage.goToMail();
        waiting(5000);

        mailPage.sendedMailsCheck();
        waiting(2000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        mailPage.settingsPageOpening();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        settingsPage.darkThemeOnOff();
        waiting(3000);

        settingsPage.mailPageReturning();
        waiting(3000);

        mailPage.logout();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    public void waiting(int delay) throws InterruptedException {
        synchronized (driver){
            driver.wait(delay);
        }
    }


}