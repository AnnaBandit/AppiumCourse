import framework.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;
import pages.TouchActionsPage;
import pages.WebPage;

import static framework.AndroidBasePage.androiddriver;
import static framework.AndroidBasePage.initPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebContextTest extends BaseTest {

    private MainPage mainPage;
    private WebPage webPage;

    @BeforeSuite
    public void openMainPage(){
        mainPage = initPage(MainPage.class);
        webPage = initPage(WebPage.class);
    }

    @AfterMethod
    public void goToMainPage(){
        if (!mainPage.isMainPageOpened()){
            androiddriver.navigate().back();
        }
    }

    @Test
    public void testWebView(){
        mainPage.clickWebViewButton();
        assertTrue(webPage.isWebViewOpened());

        webPage.chooseFromTestDropdown("‘Say Hello’-Demo");
        assertEquals(webPage.getSelectedInDropdownText(), "'Say Hello'-Demo");
    }
}
