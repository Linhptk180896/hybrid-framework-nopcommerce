package commons;

public class BasePageUI {
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public final static String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//div[@class='date-picker-wrapper']//select[@name='%s']";
	public final static String DYNAMIC_OPTION_TEXT_SELECTED_IN_DROPDOWN = "xpath=//div[@class='date-picker-wrapper']//select[@name='%s']//option[text()='%s']";
	//DateOfBirthDay DateOfBirthMonth DateOfBirthYear
	public final static String INPUT_UPLOAD_FILE = "xpath=//input[@type='file']";
}
