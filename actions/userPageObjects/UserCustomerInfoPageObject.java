package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.BasePageUI;
import pageUIs.UserCustomerInfoPageUI;


// pageObject chứa các actions muốn thực hiện trong 1 page

public class UserCustomerInfoPageObject extends BasePage {
	private WebDriver driver;
	
	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoPageDisplayed() {
		waitForAllElementVisible(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_TITLE);
		isElementDisplayed(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_TITLE);
		return true;
	}

	public void selectFemaleGender(String gender) {
		waitForElementClickable(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_CHECKBOX, gender);
		checkToDefaultCheckboxOrRadio(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_CHECKBOX, gender);
		
	}


	
	public void clickOnSaveButton() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		
	}

	public boolean isFemaleCheckboxSelected(String gender) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_CHECKBOX, gender);
		return isElementSelected(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_CHECKBOX, gender);
	}







	


	
	
}

	

	


