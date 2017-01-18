package pages;

import framework.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;

import static framework.Utils.isElementPresent;

public class TouchActionsPage extends AndroidBasePage{

    private String lastGestureTextViewID = "io.selendroid.testapp:id/last_gesture_text_view";
    private String gestureTypeTextViewID = "io.selendroid.testapp:id/gesture_type_text_view";


    @FindBy(id="io.selendroid.testapp:id/gesture_type_text_view")
    WebElement gestureTypeTextView;

    public boolean isTouchActionsPageOpened(){
        return androiddriver.findElementsById(lastGestureTextViewID).size() == 1;
    }

    public void tapOnScreen(){
        TouchAction action = new TouchAction(androiddriver);
        MobileElement element = (MobileElement) androiddriver.findElementsById(gestureTypeTextViewID).get(0);
        action.tap(element).perform();
    }

    public void doubleTapOnScreen(){
        TouchAction action = new TouchAction(androiddriver);
        MobileElement element = (MobileElement) androiddriver.findElementsById(gestureTypeTextViewID).get(0);
        action.tap(element).tap(element).perform();
    }

    public void swipeOnScreen(){
        androiddriver.swipe(100, 100, 100, 150, 100);
    }

    public void longPressOnScreen(){
        TouchAction action = new TouchAction(androiddriver);
        MobileElement gestureType = (MobileElement) androiddriver.findElementsById(gestureTypeTextViewID).get(0);
        action.longPress(gestureType, 2000).perform();
    }

    public void scrollOnScreen(){
        androiddriver.swipe(100, 100, 100, 200, 1000);
    }

    public boolean isShowedGestureTypeRight(String text){
        return gestureTypeTextView.getText().equals(text);
    }


}
