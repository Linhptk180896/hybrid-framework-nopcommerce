package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	//Khai báo driver
	WebDriver driver;
	//Tạo constructor để new driver khi gọi hàm trong class LoginPageObject
 public UserLoginPageObject(WebDriver driver) {
	 this.driver = driver;
	 
 }

public String getErrorMessageAtEmailTextbox() {
	waitForAllElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
}
public void inputToEmailTextbox(String validEmail) {
	waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
	sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, validEmail);
	
}
public String getErrorMessageUnsuccessful() {
	waitForAllElementVisible(driver, UserLoginPageUI.EMAIL_UNSUCCESSFUL_MESSAGE);
	return getElementText(driver, UserLoginPageUI.EMAIL_UNSUCCESSFUL_MESSAGE);
}
public void inputToPasswordTextbox(String password) {
	waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
	sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	
}
public UserHomePageObject clickToLoginButton() {
	waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
	clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
	return PageGeneratorManager.getHomePage(driver);
}			
 
public UserHomePageObject LoginAsUser(String validEmail, String password) {
	inputToEmailTextbox(validEmail);
	inputToPasswordTextbox(password);
	return clickToLoginButton();
	
	
}


}
