package commons;

import java.io.File;

public class GlobalConstans {
	public static final int LONG_TIMEOUT = 30;
	public static final int SHORT_TIMEOUT = 5;
	public static final int RETRY_TEST_FAIL = 3;
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles"+ File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	

}
