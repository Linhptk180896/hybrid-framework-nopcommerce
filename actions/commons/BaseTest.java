package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest  {
	WebDriver driver;
	protected final Log log;
	public BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	public WebDriver getBrowser(String appUrl, String browserName) {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.get(appUrl);
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstans.LONG_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}

}
