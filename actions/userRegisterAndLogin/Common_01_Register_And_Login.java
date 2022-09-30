package userRegisterAndLogin;

import java.util.Set;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import userPageObjects.UserHomePageObject;
import userPageObjects.UserLoginPageObject;
import userPageObjects.UserRegisterPageObject;

public class Common_01_Register_And_Login extends BaseTest{
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	String firstName, lastName;
	public static String email;
	public static String password;
	public static Set<Cookie> loggedCookies;
	
	
	@Parameters({"appUrl","browserName"})
	@BeforeTest
	public void BeforeTest(String appUrl, String browserName) {
		driver = getBrowser(appUrl, browserName);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		firstName = "Linh";
		lastName = "Pham";
		email = "linhptk" + getRandomNumber() + "@gmail.com";
		password = "123456";
		
		log.info("Pre-Condition - Step 01: Click to Register link");
		userRegisterPage = 	userHomePage.openRegisterPage();
		
		log.info("Pre-Condition - Step 02: Input to required fields");
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(email);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Pre-Condition  - Step 03: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Pre-Condition  - Step 04: Verify successful mesage displayed");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");
	
		 
		log.info("Pre-Condition - Step 05: Click to Logout button");
		userRegisterPage.clickToLogoutLink();
		
		userLoginPage = userHomePage.openLoginPage();
		userLoginPage.inputToEmailTextbox(email);
		userLoginPage.inputToPasswordTextbox(password);
		userHomePage = userLoginPage.clickToLoginButton();
		loggedCookies = userHomePage.getAllCookies(driver);
	}

}
