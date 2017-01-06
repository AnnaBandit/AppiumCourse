package pages;

import framework.AndroidBasePage;

public class WebPage extends AndroidBasePage{

    private String webViewLocationLabelID = "io.selendroid.testapp:id/webviewLocation";
    private String webdriverTestDataDropdown = "io.selendroid.testapp:id/spinner_webdriver_test_data";

    public boolean isWebViewOpened(){
        return androiddriver.findElementsById(webViewLocationLabelID).size() == 1;
    }
}
