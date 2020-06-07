package desafio.qa.core;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class CoreBaseTest {
	
	public WebDriver driver;
	
	@After
	public void after(){
		if(driver != null){
		   driver.close();
		   driver.quit();
		}
		driver = null;
	}
	
	@Before
	public void before() throws MalformedURLException{
		driver = CoreDriver.getDriver();
	}
}
