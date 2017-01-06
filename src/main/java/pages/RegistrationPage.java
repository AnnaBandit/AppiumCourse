package pages;

import framework.AndroidBasePage;
import io.appium.java_client.MobileElement;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static framework.Utils.isElementPresent;

public class RegistrationPage extends AndroidBasePage{

    private String welcomeMessageID = "";
    private String userNameInputID = "io.selendroid.testapp:id/inputUsername";
    private String emailInputID = "io.selendroid.testapp:id/inputEmail";
    private String passwordInputID = "io.selendroid.testapp:id/inputPassword";
    private String nameInputID = "io.selendroid.testapp:id/inputName";
    private String programmingLanguageDropdownID = "io.selendroid.testapp:id/input_preferedProgrammingLanguage";
    private String acceptAddsCheckboxID = "io.selendroid.testapp:id/input_adds";
    private String registerUserVerifyButtonID = "io.selendroid.testapp:id/btnRegisterUser";

    private String savedNameID = "io.selendroid.testapp:id/label_name_data";
    private String savedUsernameID = "io.selendroid.testapp:id/label_username_data";
    private String savedPasswordID = "io.selendroid.testapp:id/label_password_data";
    private String savedEmailID = "io.selendroid.testapp:id/label_email_data";
    private String savedProgrammingLanguageID = "io.selendroid.testapp:id/label_preferedProgrammingLanguage_data";
    private String savedAcceptAddsID = "io.selendroid.testapp:id/label_acceptAdds_data";
    private String registerUserButtonID = "io.selendroid.testapp:id/buttonRegisterUser";

    public boolean isRegistrationFormOpened(){
        return androiddriver.findElementsById(userNameInputID).size() == 1;
    }

    private void setUsername(String username){
        MobileElement userNameInput = (MobileElement) androiddriver.findElementsById(userNameInputID).get(0);
        userNameInput.clear();
        userNameInput.sendKeys(username);
    }

    private void setEmail(String email){
        MobileElement emailInput = (MobileElement) androiddriver.findElementsById(emailInputID).get(0);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    private void setPassword(String password){
        MobileElement passwordInput = (MobileElement) androiddriver.findElementsById(passwordInputID).get(0);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    private void setName(String name){
        MobileElement nameInput = (MobileElement) androiddriver.findElementsById(nameInputID).get(0);
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    private void selectProgrammingLanguageFromDropdown(String language){
        MobileElement programmingLanguageDropdown = (MobileElement) androiddriver.findElementsById(programmingLanguageDropdownID).get(0);
        programmingLanguageDropdown.click();
        androiddriver.findElement(By.name(language)).click();

    }

    private void clickAcceptAddsCheckbox(){
        MobileElement acceptAddsCheckbox = (MobileElement) androiddriver.findElementsById(acceptAddsCheckboxID).get(0);
        acceptAddsCheckbox.click();
    }

    public void clickRegisterUserButton(){
        MobileElement registerUserButton = (MobileElement) androiddriver.findElementsById(registerUserButtonID).get(0);
        registerUserButton.click();
    }

    private void clickRegisterUserVerifyButton(){
        MobileElement registerUserButton = (MobileElement) androiddriver.findElementsById(registerUserVerifyButtonID).get(0);
        registerUserButton.click();
    }

    public boolean isRegisterUserVerifyButtonPresent(){
        return isElementPresent(registerUserVerifyButtonID);
    }

    public void registerUser(User user){
        setUsername(user.getUsername());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setName(user.getName());
        selectProgrammingLanguageFromDropdown(user.getProgrammingLanguage());
        if (user.isAcceptAdds()) {
            clickAcceptAddsCheckbox();
        }
        clickRegisterUserVerifyButton();
    }

    public boolean nameIsSavedCorrectly(String name){
        MobileElement savedName = (MobileElement) androiddriver.findElementsById(savedNameID).get(0);
        return savedName.getText().equals(name);
    }

    public boolean usernameIsSavedCorrectly(String username){
        MobileElement savedUsername = (MobileElement) androiddriver.findElementsById(savedUsernameID).get(0);
        return savedUsername.getText().equals(username);
    }

    public boolean passwordIsSavedCorrectly(String password){
        MobileElement savedPassword = (MobileElement) androiddriver.findElementsById(savedPasswordID).get(0);
        return savedPassword.getText().equals(password);
    }

    public boolean emailIsSavedCorrectly(String email){
        MobileElement savedEmail = (MobileElement) androiddriver.findElementsById(savedEmailID).get(0);
        return savedEmail.getText().equals(email);
    }

    public boolean programmingLanguageIsSavedCorrectly(String programmingLanguage){
        MobileElement savedProgrammingLanguage = (MobileElement) androiddriver.findElementsById(savedProgrammingLanguageID).get(0);
        return savedProgrammingLanguage.getText().equals(programmingLanguage);
    }

    public boolean acceptAddsIsSavedCorrectly(boolean acceptAdds){
        MobileElement savedAcceptAdds = (MobileElement) androiddriver.findElementsById(savedAcceptAddsID).get(0);
        return  (Boolean.toString(acceptAdds)).equals(savedAcceptAdds.getText());
    }

}
