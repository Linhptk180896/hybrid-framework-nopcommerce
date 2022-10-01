package commons;

import org.openqa.selenium.WebDriver;

import userPageObjects.UserAddNewAddressesPageObject;
import userPageObjects.UserCustomerInfoPageObject;
import userPageObjects.UserHomePageObject;
import userPageObjects.UserLoginPageObject;
import userPageObjects.UserRegisterPageObject;

public class PageGeneratorManager {


	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		
		return new UserRegisterPageObject(driver);
	}

	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	
	public static UserCustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver) ;
	}
	public static UserAddNewAddressesPageObject getAddNewAddressesPage(WebDriver driver) {
		return new UserAddNewAddressesPageObject(driver) ;
	}



	

}
