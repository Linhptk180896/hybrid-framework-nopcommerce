package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.UserRegisterPageUI;


//pageObject chứa các actions muốn thực hiện trong 1 page
public class UserRegisterPageObject extends BasePage{
 private WebDriver driver;
 
 	public UserRegisterPageObject(WebDriver driver) {
 		this.driver = driver;
 	}
 
//	@Step("Click register to navigate to register page ")
	public UserRegisterPageObject clickToRegisterButton() {
		waitForElementClickable(driver,UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
//		return new HomePageObject(driver) --> Không khởi tạo như này nữa mà gọi qua hàm ở PageGeneratorManager
		return PageGeneratorManager.getRegisterPage(driver);
	}

//	@Step("Click register to navigate to register page ")
	public String getErrorMesssageAtFirstNameTextbox() {
		waitForAllElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

//	@Step("Click register to navigate to register page ")
	public String getErrorMesssageAtLastNameTextbox() {
		waitForAllElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	
//	@Step("Click register to navigate to register page ")
	public String getErrorMesssageAtEmailTextbox() {
		waitForAllElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

//	@Step("Click register to navigate to register page ")
	public String getErrorMesssageAtPasswordTextbox() {
		waitForAllElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

//	@Step("Click register to navigate to register page ")
	public String getErrorMesssageAtConfirmPasswordTextbox() {
		waitForAllElementVisible(driver, UserRegisterPageUI.CONFRIM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFRIM_PASSWORD_ERROR_MESSAGE);
	}

	
//	@Step("Enter to firstName textbox with value is  {0} and {1}") --> khi hàm có nhiều tham số thì sẽ tự động thêm params theo thứ tự
//	@Step("Enter to firstName textbox with value is  {0} ")
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementClickable(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

//	@Step("Enter to lastName textbox with value is  {0} ")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementClickable(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}
	
//	@Step("Enter to emailAddress textbox with value is  {0} ")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementClickable(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}
	
//	@Step("Enter to password textbox with value is  {0} ")
	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

//	@Step("Enter to confirmPassword textbox with value is  {0} ")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementClickable(driver, UserRegisterPageUI.CONFIRM_PASSWORD);
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD, confirmPassword);
		
	}

//	@Step("Verify register success message is displayed ")	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
//	@Step("Click logout to navigate homepage")	
	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
//	@Step("Click ErrorExistingEmailMessage is displayed")	
	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}



	



	






	

}
