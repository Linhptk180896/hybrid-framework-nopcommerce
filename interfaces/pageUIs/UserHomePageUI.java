package pageUIs;

// PageObject chứa các action của page
// PageUI sẽ chứa các loccator của các fields 
//Đặt tên: Tên biến locator (String, int...)  - Tên field - loại field
	public  class UserHomePageUI {
		//biến constants hằng số
	public static final String REGISTER_LINK = "css=a[class='ico-register']";
	public static final String 	LOGIN_LINK = "xpath=//a[text()='Log in']";
	public static final String 	MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String 	CLOSE_ICON_IN_LOGIN_COOKIE_MESSAGE = "xpath=//span[@class='close']";
}
