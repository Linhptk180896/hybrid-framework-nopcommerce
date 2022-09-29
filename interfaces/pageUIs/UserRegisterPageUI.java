package pageUIs;
//PageObject chứa các action của page
//PageUI sẽ chứa các loccator của các fields 
//Đặt tên: Tên biến locator (String, int...)  - Tên field - loại field
public class UserRegisterPageUI {
	
	public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "xpath=//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX =  "xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
	public static final String CONFIRM_PASSWORD = "xpath=//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "xpath=//button[@name='register-button']";
	
	
	
	public static final String FIRST_NAME_ERROR_MESSAGE = "xpath=//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "xpath=//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "xpath=//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='Password-error']";
	public static final String CONFRIM_PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='ConfirmPassword-error']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "xpath=//div[@class='message-error validation-summary-errors']//li";
	public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//div[@class='result']";
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
	
}
