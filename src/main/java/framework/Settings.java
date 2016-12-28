package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {

    private static final String SELENIUM_PROPERTIES = "selenium.properties";
    private static final String ANDROID_ACTIVITY_LOAD_TIMEOUT = "android.activity.loadtimeout";
    private static final String APPIUM_SERVER_URL = "appium.server.url";
    private static final String ANDROID_APPLICATION_PATH="android.application.path";
    private static final String ANDROID_APPLICATION_NAME="android.application.name";
    private static final String ANDROID_DEVICE_NAME="android.device.name";
    private static final String DEBUG_MODE="debug.mode";
    private static final String DEBUG_USER_ID="debug.user.id";
    private static final String DEBUG_APPIUM_PORT="debug.appium.port";

    private Properties properties = new Properties();
    private String androidActivityLoadTimeout;
    private String appiumserverurl;
    private String AndroidApplicationPath;
    private String AndroidApplicationName;
    private String AndroidDeviceName;
    private String debugMode;
    private String debugUserId;
    private String debugAppiumPort;

    public Settings() {
        loadSettings();
    }

    private void loadSettings() {
        properties = loadPropertiesFile();
        androidActivityLoadTimeout = getPropertyOrThrowException(ANDROID_ACTIVITY_LOAD_TIMEOUT);
        appiumserverurl = getPropertyOrThrowException(APPIUM_SERVER_URL);
        AndroidApplicationPath = getPropertyOrThrowException(ANDROID_APPLICATION_PATH);
        AndroidApplicationName = getPropertyOrThrowException(ANDROID_APPLICATION_NAME);
        AndroidDeviceName = getPropertyOrThrowException(ANDROID_DEVICE_NAME);
        debugMode = getPropertyOrThrowException(DEBUG_MODE);
        debugAppiumPort = getPropertyOrThrowException(DEBUG_APPIUM_PORT);
    }

    private Properties loadPropertiesFile() {
        try {
            String filename = getPropertyOrNull(SELENIUM_PROPERTIES);
            if (filename == null) {
                filename = SELENIUM_PROPERTIES;
            }
            InputStream stream = getClass().getClassLoader().getResourceAsStream(filename);
            if (stream == null) {
                stream = new FileInputStream(new File(filename));
            }
            Properties result = new Properties();
            result.load(stream);
            return result;
        } catch (IOException e) {
            throw new UnknownPropertyException("Property file is not found");
        }
    }

    public String getPropertyOrNull(String name) {
        return getProperty(name, false);
    }

    public String getPropertyOrThrowException(String name) {
        return getProperty(name, true);
    }

    private String getProperty(String name, boolean forceExceptionIfNotDefined) {
        String result;
        if ((result = System.getProperty(name, null)) != null && result.length() > 0) {
            return result;
        } else if ((result = getPropertyFromPropertiesFile(name)) != null && result.length() > 0) {
            return result;
        } else if (forceExceptionIfNotDefined) {
            throw new UnknownPropertyException("Unknown property: [" + name + "]");
        }
        return result;
    }

    private String getPropertyFromPropertiesFile(String name) {
        Object result = properties.get(name);
        if (result == null) {
            return null;
        } else {
            return result.toString();
        }
    }


    public String getAppiumServerURL(){
        return appiumserverurl;
    }

    public String getAndroidAppPath(){
        return AndroidApplicationPath;
    }

    public String getAndroidAppName(){
        return AndroidApplicationName;
    }

    public String getAndroidDeviceName(){
        return AndroidDeviceName;
    }

    public int getAndroidActivityLoadTimeout(){
        return Integer.parseInt(androidActivityLoadTimeout);
    }

    public boolean getDebugMode(){
        if (debugMode.contains("true")) return true;
        return false;
    }

    public String getDebugUserId(){
        return debugUserId;
    }

    public String getAppiumDebugPort(){
        return debugAppiumPort;
    }

    public String getUserId(){
        return debugUserId;
    }
}

