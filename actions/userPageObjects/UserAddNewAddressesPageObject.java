package userPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.UserAddNewAddressesPageUI;

public class UserAddNewAddressesPageObject extends BasePage {
	
	WebDriver driver;
	public UserAddNewAddressesPageObject(WebDriver driver) {
		this.driver= driver;
		
	}

	public void clickOnAddNewButton() {
		waitForElementClickable(driver, UserAddNewAddressesPageUI.ADDNEW_BUTTON);
		clickToElement(driver, UserAddNewAddressesPageUI.ADDNEW_BUTTON);
	}



	public void clickOnSaveButton() {
		waitForElementClickable(driver, UserAddNewAddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, UserAddNewAddressesPageUI.SAVE_BUTTON);
		
	}

	public String getTextInTextboxDefinedByClassName(String textboxClass) {
		waitForElementVisible(driver, UserAddNewAddressesPageUI.DYNAMIC_INFO_BY_CLASS, textboxClass);
		return getElementText(driver, UserAddNewAddressesPageUI.DYNAMIC_INFO_BY_CLASS, textboxClass);

		
	}

}
