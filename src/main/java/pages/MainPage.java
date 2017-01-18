package pages;

import framework.AndroidBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import static framework.Utils.isElementPresent;
import static java.lang.Thread.sleep;

public class MainPage extends AndroidBasePage{

    private String messageID = "android:id/message";
    private String agreeButtonID = "android:id/button1";
    private String nonoButtonID = "android:id/button2";
    private String customPopupID = "android:id/parentPanel";
    private String waitingDialogID = "android:id/scrollView";
    private String visibleTextViewID = "io.selendroid.testapp:id/visibleTextView";
    private String focusedTextFieldID = "io.selendroid.testapp:id/focusedText";
    private String textFieldID ="io.selendroid.testapp:id/my_text_field";
    private String registrationButtonID = "io.selendroid.testapp:id/startUserRegistration";

    @FindBy(id="io.selendroid.testapp:id/buttonTest")
    WebElement enButton;

    @FindBy(id="android:id/parentPanel")
    WebElement customPopup;

    @FindBy(id="io.selendroid.testapp:id/startUserRegistration")
    WebElement registrationButton;

    @FindBy(id="io.selendroid.testapp:id/input_adds_check_box")
    WebElement acceptAddsCheckbox;

    @FindBy(id="io.selendroid.testapp:id/waitingButtonTest")
    WebElement showPogressBarButton;

    @FindBy(id="io.selendroid.testapp:id/visibleButtonTest")
    WebElement displayTextViewButton;

    @FindBy(id="io.selendroid.testapp:id/topLevelElementTest")
    WebElement displayAndFocusOnLayoutButton;

    @FindBy(id="io.selendroid.testapp:id/touchTest")
    WebElement touchActionsButton;

    @FindBy(id="io.selendroid.testapp:id/buttonStartWebview")
    WebElement webViewButton;

    public void clickEnButton(){
        enButton.click();
    }

    /*public boolean customPopupIsDisplayed(){
        return androiddriver.findElementsById(customPopupID).size() == 1;
    }*/

    public boolean customPopupIsDisplayed(){
        try{
            androiddriver.findElementById(customPopupID);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private WebElement getIAgreeButton(){
        return customPopup.findElement(By.id(agreeButtonID));
    }

    public boolean agreeButtonIsDisplayed(){
        return androiddriver.findElementsById(agreeButtonID).size() == 1;
        //return getIAgreeButton().isDisplayed();
    }

    private WebElement getNonoButton(){
        return customPopup.findElement(By.id(nonoButtonID));
    }

    public boolean nonoButtonIsDisplayed(){
        return androiddriver.findElementsById(nonoButtonID).size() == 1;
    }

    public void clickNonoButton(){
        getNonoButton().click();
    }

    private String getPopupMessage(){
        return customPopup.findElement(By.id(messageID)).getText();
    }

    public void clickRegistrationButton(){
        registrationButton.click();
    }

    public boolean isAcceptAddsChecked(){
        return acceptAddsCheckbox.getAttribute("checked").equals("true");
    }

    public void clickShowProgressBarButton(){
        showPogressBarButton.click();
    }

    public boolean isWaitingDialogPresent(){
        return androiddriver.findElementsById(waitingDialogID).size() == 1;
    }

    public void waitSeconds(int seconds) throws InterruptedException {
        sleep(1000*seconds);
    }

    public void clickTextViewButton(){
        displayTextViewButton.click();
    }

    public boolean checkDisplayTextViewIsNotEmpty(){
        MobileElement textView = (MobileElement) androiddriver.findElementsById(visibleTextViewID).get(0);
        return !textView.getText().equals("");
    }

    public void clickDisplayAndFocuseOnLayoutButton(){
        displayAndFocusOnLayoutButton.click();
    }

    public boolean isTextFieldOnFocus(){
        MobileElement textField = (MobileElement) androiddriver.findElementsById(textFieldID).get(0);
        return textField.getAttribute("focused").equals("true");
    }

    public boolean isFocusedTextFieldDisplayed(){
        return androiddriver.findElementsById(focusedTextFieldID).size() == 1;
    }

    public void clickTouchActionsButton(){
        touchActionsButton.click();
    }

    public boolean isMainPageOpened(){
        return androiddriver.findElementsById(registrationButtonID).size() == 1;
    }

    public void clickWebViewButton(){
        webViewButton.click();
    }


}
