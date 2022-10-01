package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import userPageObjects.UserAddNewAddressesPageObject;
import userPageObjects.UserCustomerInfoPageObject;
import userPageObjects.UserHomePageObject;
import userPageObjects.UserLoginPageObject;
import userRegisterAndLogin.Common_01_Register_And_Login;

public class MyAccount extends BaseTest {
	WebDriver driver;
	String cityStateZip, fullName, province, country, faxNumber, phoneNumber, zipCode, address2, address1, city, firstNameTextbox, newFirstName, newLastName, gender, dateOfBirth, monthOfBirth, yearOfBirth, newEmail,newCompanyName;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserCustomerInfoPageObject userCustomerInfoPage;
	UserAddNewAddressesPageObject userAddNewAddressesPage;
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
		userCustomerInfoPage = userHomePage.openMyAccountPage(driver);
		
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
		fullName = newFirstName +" " + newLastName;
		
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
	@Test
	public void MyAccount_02_Update_Addresses_Info_Successfully() {
		city ="Ha Noi";
		address1 ="Address 1";
		address2 ="Address 2";
		zipCode ="zipCode123";
		phoneNumber = "123456789";
		faxNumber = "AAA123";
		country ="United States";
		province ="Alaska";	
		cityStateZip = city + "," + province + "," + zipCode;
		
		log.info("Step 01 - Open Addresses page");
		userAddNewAddressesPage = userCustomerInfoPage.openAddNewAddressPage(driver);
		
		log.info("Step 02 - Click on Add new button");
		userAddNewAddressesPage.clickOnAddNewButton();
		
		log.info("Step 03 - Verify Customer Address Page is selected");
		Assert.assertTrue(userAddNewAddressesPage.isPageTitleDisplayed(driver, "Addresses"));
		
		log.info("Step 04 - Input first name with value =  " + newFirstName);
		userAddNewAddressesPage.inputToTextboxDefinedByID(driver, newFirstName, "Address_FirstName" );
		
		log.info("Step 04 - Input last name with value =  " + newLastName);
		userAddNewAddressesPage.inputToTextboxDefinedByID(driver, newLastName, "Address_LastName");
		
		log.info("Step 04 - Input email with value =  " + newEmail);
		userAddNewAddressesPage.inputToTextboxDefinedByID(driver, newEmail, "Address_Email");
		
		log.info("Step 04 - Input company with value =  " + newCompanyName);
		userAddNewAddressesPage.inputToTextboxDefinedByID(driver, newCompanyName, "Address_Company");
		
		log.info("Step 04 - Select country with value =  " + country);
		userAddNewAddressesPage.selectCountryAndProvinceInAddNewAddressPage(driver, country,"Address.CountryId");
		
		log.info("Step 04 - Select province with value =  " + province);
		userAddNewAddressesPage.selectCountryAndProvinceInAddNewAddressPage(driver, province,"Address_StateProvinceId");
		
		log.info("Step 04 - Input city with value =  " + city);
		userAddNewAddressesPage.inputToTextboxDefinedByID(driver, city, "Address_City");
		
		log.info("Step 04 - Input addtess1  with value =  " + address1);
		userAddNewAddressesPage.inputToTextboxDefinedByID(driver, address1, "Address_Address1");
		
		log.info("Step 04 - Input addtess2  with value =  " + address2);
		userAddNewAddressesPage.inputToTextboxDefinedByID(driver, address2, "Address_Address2");
		
		log.info("Step 04 - Input zipCode  with value =  " + zipCode);
		userAddNewAddressesPage.inputToTextboxDefinedByID(driver, zipCode, "Address_ZipPostalCode");
		
		log.info("Step 04 - Select phone number  with value =  " + phoneNumber);
		userAddNewAddressesPage.inputToTextboxDefinedByID(driver, phoneNumber, "Address_PhoneNumber");
		
		log.info("Step 04 - Select fax number  with value =  " + faxNumber);
		userAddNewAddressesPage.inputToTextboxDefinedByID(driver, faxNumber, "Address_FaxNumber");
		
		log.info("Step 04 - Click on button Save");
		userAddNewAddressesPage.clickOnSaveButton();
		
		log.info("Step 04 - Verify full name is display = " + fullName);
		Assert.assertEquals(userAddNewAddressesPage.getTextInTextboxDefinedByClassName("name"), fullName);
		
		
		log.info("Step 04 - Verify email is display = " + newEmail);
		Assert.assertEquals(userAddNewAddressesPage.getTextInTextboxDefinedByClassName("email"), newEmail);
		
		log.info("Step 04 - Verify company is display = " + newCompanyName);
		Assert.assertEquals(userAddNewAddressesPage.getTextInTextboxDefinedByClassName("phone"), newCompanyName);
		
		log.info("Step 04 - Verify country is display = " + country);
		Assert.assertEquals(userAddNewAddressesPage.getTextInTextboxDefinedByClassName("country"), country);
		
		
		
		log.info("Step 04 - Verify city is display = " + city);
		Assert.assertEquals(userAddNewAddressesPage.getTextInTextboxDefinedByClassName("city"), city);
		
		log.info("Step 04 - Verify address1 is display = " + address1);
		Assert.assertEquals(userAddNewAddressesPage.getTextInTextboxDefinedByClassName("address1"), address1);
		
		log.info("Step 04 - Verify address2 is display = " + address2);
		Assert.assertEquals(userAddNewAddressesPage.getTextInTextboxDefinedByClassName("address2"), address2);
		
		log.info("Step 04 - Verify zip code is display = " + zipCode);
		Assert.assertEquals(userAddNewAddressesPage.getTextInTextboxDefinedByClassName("city-state-zip"), cityStateZip);
		
		log.info("Step 04 - Verify phone is display = " + phoneNumber);
		Assert.assertEquals(userAddNewAddressesPage.getTextInTextboxDefinedByClassName("phone"), phoneNumber);
		
		log.info("Step 04 - Verify fax is display = " + faxNumber);
		Assert.assertEquals(userAddNewAddressesPage.getTextInTextboxDefinedByClassName("fax"), faxNumber);
		
		
	
		
		
		
		
	}

}
