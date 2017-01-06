import framework.BaseTest;
import io.appium.java_client.android.AndroidKeyCode;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;
import pages.TouchActionsPage;

import java.sql.Driver;

import static framework.AndroidBasePage.androiddriver;
import static framework.AndroidBasePage.initPage;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class EnButtonTest extends BaseTest{

    private MainPage mainPage;
    private RegistrationPage regPage;
    private TouchActionsPage actionsPage;

    private User user = new User("TestUsername", "test@username.com", "1234qwer", "TestName", "Java", true);

    @BeforeSuite
    public void openMainPage(){
        mainPage = initPage(MainPage.class);
        regPage = initPage(RegistrationPage.class);
        actionsPage = initPage(TouchActionsPage.class);
    }

    @AfterMethod
    public void goToMainPage(){
        if (!mainPage.isMainPageOpened()){
            androiddriver.navigate().back();
        }
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

        regPage.registerUser(user);
        assertTrue(regPage.nameIsSavedCorrectly(user.getName()));
        assertTrue(regPage.usernameIsSavedCorrectly(user.getUsername()));
        assertTrue(regPage.emailIsSavedCorrectly(user.getEmail()));
        assertTrue(regPage.passwordIsSavedCorrectly(user.getPassword()));
        assertTrue(regPage.programmingLanguageIsSavedCorrectly(user.getProgrammingLanguage()));
        assertTrue(regPage.acceptAddsIsSavedCorrectly(user.isAcceptAdds()));

        regPage.clickRegisterUserButton();
        assertTrue(mainPage.isAcceptAddsChecked());
    }

    @Test
    public void testProgressBar() throws InterruptedException {
        mainPage.clickShowProgressBarButton();
        assertTrue(mainPage.isWaitingDialogPresent());

        mainPage.waitSeconds(12);
        assertFalse(mainPage.isWaitingDialogPresent());
        assertTrue(regPage.isRegistrationFormOpened());
    }

    @Test
    public void testTextView(){
        mainPage.clickTextViewButton();
        assertTrue(mainPage.checkDisplayTextViewIsNotEmpty());
    }

    @Test
    public void testFocus(){
        mainPage.clickDisplayAndFocuseOnLayoutButton();
        assertTrue(mainPage.isFocusedTextFieldDisplayed());
        assertFalse(mainPage.isTextFieldOnFocus());

        mainPage.clickDisplayAndFocuseOnLayoutButton();
        assertFalse(mainPage.isFocusedTextFieldDisplayed());
        assertTrue(mainPage.isTextFieldOnFocus());
    }

    @Test
    public void testTouchActions(){
        mainPage.clickTouchActionsButton();
        assertTrue(actionsPage.isTouchActionsPageOpened());

/*        actionsPage.tapOnScreen();
        assertTrue(actionsPage.isShowedGestureTypeRight("SINGLE TAP CONFIRMED"));

        actionsPage.doubleTapOnScreen();
        assertTrue(actionsPage.isShowedGestureTypeRight("ON DOUBLE TAP EVENT"));*/

        actionsPage.swipeOnScreen();
        assertTrue(actionsPage.isShowedGestureTypeRight("FLICK"));

        actionsPage.longPressOnScreen();
        assertTrue(actionsPage.isShowedGestureTypeRight("LONG PRESS"));

        actionsPage.scrollOnScreen();
        assertTrue(actionsPage.isShowedGestureTypeRight("SCROLL"));
    }
}
