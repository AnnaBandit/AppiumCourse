package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

public class AndroidBasePage {
    public static AppiumDriver androiddriver;
    public static Settings settings;
    public static JavascriptExecutor js = (JavascriptExecutor) androiddriver;

    public static <T extends AndroidBasePage> T initPage(Class<T> pageClass) {
        return PageFactory.initElements(androiddriver, pageClass);
    }


}
