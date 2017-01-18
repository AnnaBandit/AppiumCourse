package pages;

import framework.AndroidBasePage;
import javafx.scene.control.Spinner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebPage extends AndroidBasePage{

    private String webViewLocationLabelID = "io.selendroid.testapp:id/webviewLocation";
    private String webdriverTestDataDropdownID = "io.selendroid.testapp:id/spinner_webdriver_test_data";
    private String enterYourNameTextBoxID = "";

    /*@FindBy(id="io.selendroid.testapp:id/spinner_webdriver_test_data")
    WebElement spinner;*/


    public boolean isWebViewOpened(){
        return androiddriver.findElementsById(webViewLocationLabelID).size() == 1;
    }

    public boolean valueIsSelected(String value){
        return androiddriver.findElementById(webdriverTestDataDropdownID).findElement(By.id("android:id/text1")).getAttribute("text").equals(value);
    }

    public void selectFromTestDataDropdown(String value){
       // new Select(androiddriver.findElementById(webdriverTestDataDropdownID)).selectByVisibleText(value);
        androiddriver.findElementById(webdriverTestDataDropdownID).click();
        List<WebElement> list = androiddriver.findElementsById("android:id/text1");
        for (WebElement aList : list) {
            if (aList.getAttribute("text").equals(value)) {
                aList.click();
            }
        }
    }
}
