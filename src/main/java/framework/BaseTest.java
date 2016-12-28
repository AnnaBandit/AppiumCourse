package framework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static framework.AppiumServer.appiumStart;
import static framework.AppiumServer.appiumStop;

public class BaseTest{
    private static Settings settings = new Settings();

    @BeforeGroups
    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() throws Exception {
        appiumStart();

        if (settings.getDebugMode()) {
            System.setProperty("appium.port", settings.getAppiumDebugPort());
        }

        AndroidBasePage.settings = settings;
        File appDir = new File(settings.getAndroidAppPath());
        File app = new File(appDir, settings.getAndroidAppName());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, settings.getAndroidDeviceName());
        capabilities.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT,"10000");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
            try {
            AndroidBasePage.androiddriver = new AndroidDriver(new URL(settings.getAppiumServerURL() + ":" + System.getProperty("appium.port") + "/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AndroidBasePage.androiddriver.manage().timeouts().implicitlyWait(settings.getAndroidActivityLoadTimeout(), TimeUnit.SECONDS);
    }

    @AfterSuite(alwaysRun = true)
    public static void afterSuite() throws Exception {
        if (AndroidBasePage.androiddriver != null) {
            AndroidBasePage.androiddriver.quit();
        }
        appiumStop();
    }

}
