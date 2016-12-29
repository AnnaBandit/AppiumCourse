import framework.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;

import static framework.AndroidBasePage.initPage;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class EnButtonTest extends BaseTest{

    private MainPage mainPage;
    private RegistrationPage regPage;

    @BeforeMethod
    public void openMainPage(){
        mainPage = initPage(MainPage.class);
        regPage = initPage(RegistrationPage.class);
    }

    @Test
    public void testEnButton(){
        mainPage.clickEnButton();
        assertTrue(mainPage.customPopupIsDisplayed());
        assertTrue(mainPage.agreeButtonIsDisplayed());
        assertTrue(mainPage.nonoButtonIsDisplayed());

        mainPage.clickNonoButton();
        assertFalse(mainPage.customPopupIsDisplayed());
    }

    @Test
    public void testRegistration(){
        mainPage.clickRegistrationButton();
        assertTrue(regPage.isRegisterUserVerifyButtonPresent());


    }
}
