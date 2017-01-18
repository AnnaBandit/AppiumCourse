package pages;

import framework.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
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
        MobileElement element = (MobileElement) androiddriver.findElementsById(gestureTypeTextViewID).get(0);
        /*androiddriver.tap(1, element, 0);*/
        new TouchAction(androiddriver).press(element).release();
    }

    public void doubleTapOnScreen(){
        TouchAction action = new TouchAction(androiddriver);
        action.press(1,1).perform().release().press(0, 0).perform();

    }

    public void swipeOnScreen(){
        androiddriver.swipe(100, 100, 100, 130, 1000);
    }

    public void longPressOnScreen(){
        TouchAction action = new TouchAction(androiddriver);
        action.longPress(gestureTypeTextView).release().perform();
    }

    public void scrollOnScreen(){
        androiddriver.swipe(10, 10, 10, 30, 3000);
    }

    public boolean isShowedGestureTypeRight(String text){
        return gestureTypeTextView.getText().equals(text);
    }

}
