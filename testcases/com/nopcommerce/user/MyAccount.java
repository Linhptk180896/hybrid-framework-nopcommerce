package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import userPageObjects.UserCustomerInfoPageObject;
import userPageObjects.UserHomePageObject;
import userPageObjects.UserLoginPageObject;
import userRegisterAndLogin.Common_01_Register_And_Login;

public class MyAccount extends BaseTest {
	WebDriver driver;
	String firstNameTextbox, newFirstName, newLastName, gender, dateOfBirth, monthOfBirth, yearOfBirth, newEmail,newCompanyName;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserCustomerInfoPageObject userCustomerInfoPage;
	@Parameters({"appUrl", "browserName"})
	@BeforeClass
	public void BeforeClass(String appUrl, String browserName ) {
		driver = getBrowser(appUrl, browserName);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		log.info("Pre-Conditon - Step 01: Set cookies");
		userLoginPage = userHomePage.openLoginPage();
		userLoginPage.setCookies(driver, Common_01_Register_And_Login.loggedCookies);
		log.info("Pre-Conditon - Step 02: Refresh current Page");
		userLoginPage.refreshCurrentPage(driver);
		log.info("Pre-Conditon - Step 03: Navigate to Homepage");
		userHomePage = userLoginPage.openHomePageByCookie();
		log.info("Login - Step 04: Verify My Account Link is displayed");
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed()); 
		
		log.info("Login - Step 06: Click on close button in login coookie message");
		 userHomePage.clickOnCloseIconLoginCookieMessage();
		
		log.info("Login - Step 06: Navigate to My Account - Customer Info page");
		userCustomerInfoPage = userHomePage.openMyAccountPage();
		
	}
	
	@Test
	public void MyAccount_01_Update_Customer_Info_Successfully() {
		
		newFirstName = "linhEdit";
		newLastName = "phamEdit";
		gender = "Female";
		newEmail = "linhptkEdit" + getRandomNumber() + "@gmail.com";
		newCompanyName = "companyNameEdit";
		dateOfBirth ="18";
		monthOfBirth = "August";
		yearOfBirth ="1996";
		
		log.info("Step 01: Select Gender" + gender);
		userCustomerInfoPage.selectFemaleGender(gender);
		
		log.info("Step 01: Edit first name with data: " + newFirstName);
		userCustomerInfoPage.inputToTextboxDefinedByID(driver, newFirstName, "FirstName" );
		
		log.info("Step 01: Edit last name with data: " + newLastName);
		userCustomerInfoPage.inputToTextboxDefinedByID(driver, newLastName, "LastName" );
		
		log.info("Step 01: Select Day = " + dateOfBirth );
		userCustomerInfoPage.selectOptionInDropdownDefinedByName(driver, dateOfBirth, "DateOfBirthDay" );
		
		log.info("Step 01: Select Month = " + monthOfBirth );
		userCustomerInfoPage.selectOptionInDropdownDefinedByName(driver, monthOfBirth, "DateOfBirthMonth" );

		log.info("Step 01: Select Year = " + yearOfBirth );
		userCustomerInfoPage.selectOptionInDropdownDefinedByName(driver, yearOfBirth, "DateOfBirthYear" );

		log.info("Step 01: Edit email with new email: " + newEmail );
		userCustomerInfoPage.inputToTextboxDefinedByID(driver, newEmail, "Email" );

		log.info("Step 01: Edit company name with data: " + newCompanyName );
		userCustomerInfoPage.inputToTextboxDefinedByID(driver, newCompanyName, "Company" );

		log.info("Step 01: Click on Save button" );
		userCustomerInfoPage.clickOnSaveButton();
		
		log.info("Step 01: Verify Female gender is selected " );
		Assert.assertTrue(userCustomerInfoPage.isFemaleCheckboxSelected(gender));
		
		log.info("Step 01: Verify new first name is displayed = " + newFirstName );
		Assert.assertEquals(userCustomerInfoPage.getTextInTextboxDefinedByID(driver,"defaultValue", "FirstName"), newFirstName);

		log.info("Step 01: Verify new last  name is displayed = " + newLastName );
		Assert.assertEquals(userCustomerInfoPage.getTextInTextboxDefinedByID(driver,"defaultValue", "LastName"),newLastName);

		log.info("Step 01: Verify new date of birth is displayed = " + dateOfBirth );
		Assert.assertTrue(userCustomerInfoPage.isNewDateOfBirthDisplayed(driver,"DateOfBirthDay",dateOfBirth ));

		log.info("Step 01: Verify new month of birth is displayed = " + monthOfBirth );
		Assert.assertTrue(userCustomerInfoPage.isNewDateOfBirthDisplayed(driver,"DateOfBirthMonth",monthOfBirth ));

		log.info("Step 01: Verify new year of birth is displayed = " + yearOfBirth );
		Assert.assertTrue(userCustomerInfoPage.isNewDateOfBirthDisplayed(driver,"DateOfBirthYear",yearOfBirth ));

		log.info("Step 01: Verify new email is displayed = " + newEmail );
		Assert.assertEquals(userCustomerInfoPage.getTextInTextboxDefinedByID(driver,"defaultValue", "Email"),newEmail);

		log.info("Step 01: Verify new company name is displayed = " + newCompanyName );
		Assert.assertEquals(userCustomerInfoPage.getTextInTextboxDefinedByID(driver,"defaultValue", "Company" ),newCompanyName);

		
		
	}

}
