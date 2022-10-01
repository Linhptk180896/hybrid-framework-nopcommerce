package commons;

public class BasePageUI {
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public final static String DYNAMIC_DROPDOWN_IN_CUSTOMER_INFO_PAGE_BY_NAME = "xpath=//div[@class='date-picker-wrapper']//select[@name='%s']";
	public final static String DYNAMIC_OPTION_TEXT_SELECTED_IN_CUSTOMER_INFO_PAGE = "xpath=//div[@class='date-picker-wrapper']//option[text()='%s']";
	//DateOfBirthDay DateOfBirthMonth DateOfBirthYear
	public final static String INPUT_UPLOAD_FILE = "xpath=//input[@type='file']";
//	public final static String DYNAMIC_TEXTBOX_IN_ADD_NEW_ADDRESS_PAGE_BY_CLASS_NAME = "xpath=//input[@id='Address_%s']";
	public final static String DYNAMIC_DROPDOWN_IN_ADD_NEW_ADDRESS_PAGE_BY_ID = "xpath=//select[@id='Address_%s']";
	public final static String DYNAMIC_OPTION_TEXT_IN_ADD_NEW_ADDRESS_PAGE = "xpath=//option[text()='%s']";
	public static final String 	MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String ADDRESSES_LINK ="xpath=//div[@class='master-wrapper-content']//a[text()='Addresses']";
	public static final String DYNAMIC_LINK_SELECTED ="xpath=//li[@class='customer-%s active']";
	public static final String DYNAMIC_PAGE_TITLE ="xpath=//div[@class='page-title']/h1[text()='My account - %s']";

}
