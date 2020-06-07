package desafio.qa.core;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import desafio.qa.util.Browser;
import desafio.qa.util.Property;

public class CoreDriver {

	static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			try {
				if(Browser.CHROME.equals(Property.BROWSER_NAME)){
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--start-maximized");
					System.setProperty("webdriver.chrome.driver",getFileDriverPathChrome().getAbsolutePath());
					driver = new ChromeDriver(chromeOptions);
			
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return driver;
	}
	
	private static File getFileDriverPathChrome() throws Exception{
		File file = null;
		file = new File(Property.CHROME_DRIVE_PATH);
		return file;
	}
	
}
