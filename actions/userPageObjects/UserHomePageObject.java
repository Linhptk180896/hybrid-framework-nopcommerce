package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.BasePageUI;
import commons.PageGeneratorManager;
import pageUIs.UserHomePageUI;



public class UserHomePageObject extends BasePage {
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		System.out.println("Driver at constructor : " + driver.toString());

		this.driver = driver;
	}
	
	
	public UserRegisterPageObject openRegisterPage() {
	System.out.println("Driver at Wait element: " + driver.toString());
	waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
	clickToElement(driver, UserHomePageUI.REGISTER_LINK);
	return  PageGeneratorManager.getRegisterPage(driver);
	
	}

	

	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	
	

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver,BasePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, BasePageUI.MY_ACCOUNT_LINK);
		 
	}




	public void clickOnCloseIconLoginCookieMessage() {
		waitForElementClickable(driver, UserHomePageUI.CLOSE_ICON_IN_LOGIN_COOKIE_MESSAGE);
		clickToElement(driver, UserHomePageUI.CLOSE_ICON_IN_LOGIN_COOKIE_MESSAGE);
	}


	}

	

	


