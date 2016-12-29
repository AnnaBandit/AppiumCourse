package pages;

import framework.AndroidBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.Utils.isElementPresent;

public class MainPage extends AndroidBasePage{

    private String messageID = "android:id/message";
    private String agreeButtonID = "android:id/button1";
    private String nonoButtonID = "android:id/button2";
    private String customPopupID = "android:id/parentPanel";

    @FindBy(id="io.selendroid.testapp:id/buttonTest")
    WebElement enButton;

    @FindBy(id="android:id/parentPanel")
    WebElement customPopup;

    @FindBy(id="io.selendroid.testapp:id/startUserRegistration")
    WebElement registrationButton;

    public void clickEnButton(){
        enButton.click();
    }

    public boolean customPopupIsDisplayed(){
        //return androiddriver.findElementsById(customPopupID).size()==0;
        return isElementPresent(customPopupID);
    }

    private WebElement getIAgreeButton(){
        return customPopup.findElement(By.id(agreeButtonID));
    }

    public boolean agreeButtonIsDisplayed(){
        return isElementPresent(agreeButtonID);
        //return getIAgreeButton().isDisplayed();
    }

    private WebElement getNonoButton(){
        return customPopup.findElement(By.id(nonoButtonID));
    }

    public boolean nonoButtonIsDisplayed(){
        //return getNonoButton().isDisplayed();
        return isElementPresent(nonoButtonID);
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
}
