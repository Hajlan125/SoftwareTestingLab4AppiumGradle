import org.openqa.selenium.remote.DesiredCapabilities;

public class Inspector {
    DesiredCapabilities capabilities;
    public Inspector(String app, String appPackage, String appActivity) {
        capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "pixel");

        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("platformVersion", "9.0");

        capabilities.setCapability("udid", "emulator-5554");

        capabilities.setCapability("app", app);

        capabilities.setCapability("appPackage", appPackage);

        capabilities.setCapability("appActivity", appActivity);
    }
}
