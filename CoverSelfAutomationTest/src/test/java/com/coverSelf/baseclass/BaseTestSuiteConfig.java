
package com.coverSelf.baseclass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.coverSelf.driver.DriverManagerFactory;
import com.coverSelf.driver.DriverTypes;
import com.coverSelf.utils.ConfigFileReader;

public class BaseTestSuiteConfig {

	public com.coverSelf.driver.DriverManager driverManager;
	public WebDriver driver;
	
	public static ConfigFileReader config;
	
	@BeforeSuite
	public void beforeSuite(ITestContext ctx) throws IOException{
		config = new ConfigFileReader();
		
	}

	@BeforeMethod
	public void beforeEveryTestStarts(ITestContext ctx,Method method) throws NoSuchMethodException{
		driverManager = DriverManagerFactory.getManager(DriverTypes.Chrome);
		driver = driverManager.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getKey("implicitWait")), TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(config.getKey("url"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
	}

	
	@AfterMethod()
	public void afterEveryTestEnds(ITestResult result, ITestContext ctx) throws MalformedURLException, IOException {
		
		
		driver.quit();
		
		 
	}

	public String createScreenshot() {
		UUID uuid = UUID.randomUUID();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(config.getKey("screenshotLocation") + uuid + ".png"));
		} catch (IOException e) {
			
		}
		return "./Screenshots/" + uuid + ".png";
	}
}
