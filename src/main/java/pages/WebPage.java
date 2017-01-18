package pages;

import framework.AndroidBasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebPage extends AndroidBasePage{

    private String webViewLocationLabelID = "io.selendroid.testapp:id/webviewLocation";
    private String webdriverTestDataDropdownID = "io.selendroid.testapp:id/spinner_webdriver_test_data";

    private String spinnerTextID = "android:id/text1";
    private String selectTestDataID = "android:id/select_dialog_listview";
    private String selectionsID = "android:id/text1";


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

    public void chooseFromTestDropdown(String testData){
        WebElement element = (WebElement) androiddriver.findElementsById(webdriverTestDataDropdownID).get(0);
        element.click();
        List<WebElement> selections = androiddriver.findElement(By.id(selectTestDataID)).findElements(By.id(selectionsID));
        for (WebElement el: selections){
            if (el.getText().equals(testData)){
                el.click();
            }
        }
    }

    public String getSelectedInDropdownText(){
        WebElement element = (WebElement) androiddriver.findElementsById(spinnerTextID).get(0);
        return element.getText();
    }

}
