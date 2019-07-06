package example;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	private WebDriver driver;		
	@Test				
	public void testEasy() {
		System.out.println("No Test");
		driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page"));
		System.out.println("Yes Test");
	}	
	@BeforeTest
	public void beforeTest() {
		System.out.println("No Before Test");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
	
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false); 
		options.setExperimentalOption("prefs", prefs);
	
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//DriverFiles//chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();		
		System.out.println("Yes Before Test");	
	    }		
	@AfterTest
	public void afterTest() {
		System.out.println("No After Test");
		driver.quit();
		System.out.println("Yes After Test");
	}		
}
