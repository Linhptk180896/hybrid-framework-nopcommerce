package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import userPageObjects.UserHomePageObject;
import userPageObjects.UserLoginPageObject;
import userPageObjects.UserRegisterPageObject;

public class Login extends BaseTest {
	WebDriver driver;
	String firstName, lastName, password, invalidPassword, invalidEmail, notFoundEmail, wrongPassword,existingEmail;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	
	
	@Parameters({"appUrl","browserName"})
	@BeforeClass
	public void BeforeClass(String appUrl, String browserName ) {
		driver = getBrowser(appUrl, browserName);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		firstName = "linh";
		lastName = "pham";
		password = "123456";
		existingEmail = "linhptk" +  getRandomNumber() + "@gmail.com";
		invalidEmail = "ggff@gfff@d.com";
		notFoundEmail = "linh" + getRandomNumber() + "@hotmail.com";
		wrongPassword ="32145600";
		
		log.info("Pre-condition - Step 01: Click to Register link");
		userRegisterPage = 	userHomePage.openRegisterPage();
		
		log.info("Register_03 - Step 02: Input to required fields");
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(existingEmail);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register_03 - Step 03: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register_03 - Step 04: Verify successful mesage displayed");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");
	
		 
		log.info("Register_03 - Step 05: Click to Logout button");
		userHomePage = userRegisterPage.clickToLogoutLink();
	}
	
	@Test
	public void Login_01_Emty_Data() {
		userLoginPage = userHomePage.openLoginPage();
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
		
	
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		userLoginPage = userHomePage.openLoginPage();
		userLoginPage.inputToEmailTextbox(invalidEmail);
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

		
		
	}
	
	@Test
	public void Login_03_Email_Not_Register() {
		userLoginPage = userHomePage.openLoginPage();
		userLoginPage.inputToEmailTextbox(notFoundEmail);
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
	}
	
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		userLoginPage = userHomePage.openLoginPage();
		userLoginPage.inputToEmailTextbox(existingEmail);
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
		}
	

	@Test
	public void Login_05_Existing_Email_Wrong_Password() {
		userLoginPage = userHomePage.openLoginPage();
		userLoginPage.inputToEmailTextbox(existingEmail);
		userLoginPage.inputToPasswordTextbox(wrongPassword);
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		

	}
	
	@Test
	public void Login_06_Existing_Email_Correct_Password() {
		userLoginPage = userHomePage.openLoginPage();
		userLoginPage.inputToEmailTextbox(existingEmail);
		userLoginPage.inputToPasswordTextbox(password);
		userLoginPage.clickToLoginButton();
		userHomePage = new UserHomePageObject(driver);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
	}	
}
