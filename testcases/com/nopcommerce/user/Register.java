package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import userPageObjects.UserHomePageObject;
import userPageObjects.UserRegisterPageObject;

public class Register extends BaseTest{
	String firstName, lastName, password,emailAddress, invalidPassword;
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	
	
	
	@Parameters({"appUrl", "browserName"})
	@BeforeClass
	public void BeforeClass ( String appUrl, String browserName){
		driver = getBrowser(appUrl, browserName);
		log.info("Pre-Condition 01: Access NopCommerce site");
		userHomePage = PageGeneratorManager.getHomePageObject(driver);
		firstName = "linh";
		lastName = "pham";
		password = "123456";
		invalidPassword = "abc123";
		emailAddress = "linhptk" +  getRandomNumber() + "@gmail.com";
 }
	
	@Test
	public void Register_01_Emty_Data() {

		log.info("Register_01 - Step 01: Click on  Register link to navigate to Register Page ");
		userRegisterPage = userHomePage.openRegisterPage();
	
		log.info("Register_01 - Step 02: Click to Register Button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register_01 - Step 03: Verify First name error message displayed");
		Assert.assertEquals(userRegisterPage.getErrorMesssageAtFirstNameTextbox(),"First name is required.");
		log.info("Register_01 - Step 04: Verify Last name error message displayed");
		Assert.assertEquals(userRegisterPage.getErrorMesssageAtLastNameTextbox(),"Last name is required.");
		log.info("Register_01 - Step 05: Verify Email  error message displayed");
		Assert.assertEquals(userRegisterPage.getErrorMesssageAtEmailTextbox(),"Email is required.");
		log.info("Register_01 - Step 06: Verify Password  error message displayed");
		Assert.assertEquals(userRegisterPage.getErrorMesssageAtPasswordTextbox(),"Password is required.");
		log.info("Register_01 - Step 07: Verify Confirm Password error message displayed");
		Assert.assertEquals(userRegisterPage.getErrorMesssageAtConfirmPasswordTextbox(),"Password is required.");
		
	
	}
	
	@Test
	public void Register_02_Invalid_Email() {
		log.info("Register_02 - Step 01: Click to Register link");
		userRegisterPage = userHomePage.openRegisterPage();
	
		log.info("Register_02 - Step 02: Input to required fields");
		userRegisterPage.inputToFirstNameTextbox(firstName);
		log.info("Register_02 - Step 02: Input to required fields");
		userRegisterPage.inputToLastNameTextbox(lastName);
		log.info("Register_02 - Step 02: Input to required fields");
		userRegisterPage.inputToEmailTextbox("123#333.com");
		log.info("Register_02 - Step 02: Input to required fields");
		userRegisterPage.inputToPasswordTextbox(password);
		log.info("Register_02 - Step 02: Input to required fields");
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register_02 - Step 03: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register_02 - Step 04: Verify error mesage displayed");
		Assert.assertEquals(userRegisterPage.getErrorMesssageAtEmailTextbox(),"Wrong email");
		
	}
	
	@Test
	public void Register_03_Success() {
		log.info("Register_03 - Step 01: Click to Register link");
		userRegisterPage = 	userHomePage.openRegisterPage();
		
		log.info("Register_03 - Step 02: Input to required fields");
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register_03 - Step 03: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register_03 - Step 04: Verify successful mesage displayed");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");
	
		 
		log.info("Register_03 - Step 05: Click to Logout button");
		userRegisterPage.clickToLogoutLink();
		
	}
	
	@Test
	public void Register_04_Existing_Email() {
		log.info("Register_04 - Step 01: Click to Register link");
		userRegisterPage = userHomePage.openRegisterPage();
		
		log.info("Register_04 - Step 02: Input to required fields");
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register_04 - Step 03: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register_04 - Step 04: Verify existing error message displayed");
		Assert.assertEquals(userRegisterPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}
	

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		log.info("Register_05 - Step 01: Click to Register link");
		userRegisterPage = userHomePage.openRegisterPage();
		
		log.info("Register_05 - Step 02: Input to required fields");
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox("123");
		userRegisterPage.inputToConfirmPasswordTextbox("123");
		
		log.info("Register_05 - Step 03: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		
		Assert.assertEquals( userRegisterPage.getErrorMesssageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
		

	}
	
	@Test
	public void Register_06_Invalid_Confirm_Password() {
		log.info("Home Page - Step 01: Click to Register link");
		userRegisterPage = userHomePage.openRegisterPage();
	
		log.info("Register Page - Step 02: Input to required fields");
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(invalidPassword);
		
		log.info("Register_05 - Step 03: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register Page - Step 03: Input to required fields");
		Assert.assertEquals( userRegisterPage.getErrorMesssageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");

	}	
	
		
		
		
		
		
	 
 }

