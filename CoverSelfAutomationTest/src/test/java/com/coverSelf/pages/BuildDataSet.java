package com.coverSelf.pages;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.coverSelf.locators.BuildDataSetAPIGenerator;
import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BuildDataSet implements BuildDataSetAPIGenerator{

	private WebDriver driver;
    private WebElement ele;
	public BuildDataSet(WebDriver driver) {
		this.driver = driver;
	}

	public void addAllData() {
		String rowsCount;
		int count;
		WebDriverWait wait=new WebDriverWait(driver,20);
		Actions act=new Actions(driver);
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input_name--0']")));
			driver.findElement(By.xpath("//input[@id='input_name--0']")).clear();
		    driver.findElement(By.xpath("//input[@id='input_name--0']")).sendKeys("Name");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Add Column']")));
		    if(driver.findElement(By.xpath("//p[text()='Add Column']")).isDisplayed()) {
		    	driver.findElement(By.xpath("//p[text()='Add Column']")).click();
		    	Assert.assertTrue(true,"Successfully Verified Add Column Button");
		    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input_name--1']")));
		    	if(driver.findElement(By.xpath("//input[@id='input_name--1']")).isDisplayed()) {
		    		driver.findElement(By.xpath("//input[@id='input_name--1']")).clear();
				    driver.findElement(By.xpath("//input[@id='input_name--1']")).sendKeys("OrderCount");
				    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='input-control-component__input'])[2]//input")));
				    ele=driver.findElement(By.xpath("(//div[@class='input-control-component__input'])[2]//input"));
				    act.moveToElement(ele).perform();
				    Thread.sleep(2000);
				    driver.findElement(By.xpath("((//div[@class='input-control-component__input'])[2]//i)[1]")).click();
				    Thread.sleep(2000);
				    driver.findElement(By.xpath("(//div[@class='input-control-component__input'])[2]//input")).sendKeys("Numbers");
				    Thread.sleep(4000);
				    driver.findElement(By.xpath("(//ul[@class='ant-cascader-menu']//li)[1]//span")).click();
				    Assert.assertTrue(true,"Successfully enter first data set");
				    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Add Column']")));
				    if(driver.findElement(By.xpath("//p[text()='Add Column']")).isDisplayed()) {
				    	driver.findElement(By.xpath("//p[text()='Add Column']")).click();
				    	Assert.assertTrue(true,"Successfully Verified Add Column Button");
				    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input_name--2']")));
				    	if(driver.findElement(By.xpath("//input[@id='input_name--2']")).isDisplayed()) {
				    		driver.findElement(By.xpath("//input[@id='input_name--2']")).clear();
						    driver.findElement(By.xpath("//input[@id='input_name--2']")).sendKeys("Email");
						    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='input-control-component__input'])[3]//input")));
						    ele=driver.findElement(By.xpath("(//div[@class='input-control-component__input'])[3]//input"));
						    act.moveToElement(ele).perform();
						    Thread.sleep(2000);
						    driver.findElement(By.xpath("((//div[@class='input-control-component__input'])[3]//i)[1]")).click();
						    Thread.sleep(2000);
						    driver.findElement(By.xpath("(//div[@class='input-control-component__input'])[3]//input")).sendKeys("Email");
						    Thread.sleep(4000);
						    driver.findElement(By.xpath("(//ul[@class='ant-cascader-menu'])[2]//li[1]//span")).click();
						    Assert.assertTrue(true,"Successfully enter 2nd data set");
						    if(driver.findElement(By.xpath("//p[text()='Add Column']")).isDisplayed()) {
						    	driver.findElement(By.xpath("//p[text()='Add Column']")).click();
						    	Assert.assertTrue(true,"Successfully Verified Add Column Button");
						    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input_name--3']")));
						    	if(driver.findElement(By.xpath("//input[@id='input_name--3']")).isDisplayed()) {
						    		driver.findElement(By.xpath("//input[@id='input_name--3']")).clear();
								    driver.findElement(By.xpath("//input[@id='input_name--3']")).sendKeys("ProductId");
								    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='input-control-component__input'])[4]//input")));
								    ele=driver.findElement(By.xpath("(//div[@class='input-control-component__input'])[4]//input"));
								    act.moveToElement(ele).perform();
								    Thread.sleep(2000);
								    driver.findElement(By.xpath("((//div[@class='input-control-component__input'])[4]//i)[1]")).click();
								    Thread.sleep(2000);
								    driver.findElement(By.xpath("(//div[@class='input-control-component__input'])[4]//input")).sendKeys("Product ID");
								    Thread.sleep(4000);
								    driver.findElement(By.xpath("(//ul[@class='ant-cascader-menu'])[3]//li[1]//span")).click();
								    Assert.assertTrue(true,"Successfully enter 3rd data set");
								    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input_api_name--0']")));
								    if(driver.findElement(By.xpath("//input[@id='input_api_name--0']")).isDisplayed()) {
								    	ele=driver.findElement(By.xpath("//input[@id='input_api_name--0']"));
								    	ele.clear();
								    	Thread.sleep(2000);
								    	ele.sendKeys("order");
								    	Thread.sleep(2000);
								    	if(driver.findElement(By.xpath("//input[@id='input_rows--0']")).isDisplayed()) {
								    		ele=driver.findElement(By.xpath("//input[@id='input_rows--0']"));
									    	ele.clear();
									    	Thread.sleep(2000);
									    	ele.sendKeys("5");
									    	rowsCount=driver.findElement(By.xpath("//input[@id='input_rows--0']")).getText();
									    	Thread.sleep(2000);
									    	List<WebElement> ls=driver.findElements(By.xpath("//div[@class='rt-tbody _HHjpm']"));
									    	for(int i=0;i<=ls.size();i++) {
									    		count++;
									    	}
									    	Thread.sleep(2000);
									    	Assert.assertEquals(rowsCount, count, "Sucessfully verified API rows count");
									    	Thread.sleep(2000);
									    	driver.findElement(By.xpath("//p[text()='Generate API']")).click();
		//API Url---------------------------------------------------------------------------------------------
									    	String urlLink=driver.findElement(By.xpath("(//div[@class='retool-grid-content'])[8]//code//a")).getText();
									    	RestAssured.baseURI = urlLink;
									        RequestSpecification httpRequest = RestAssured.given();
									        httpRequest.header("Content-Type", "application/json");
									        Response response = httpRequest.get("/");
									        Assert.assertEquals(200, response.getStatusCode(),"Status code verified successfully");
									        ResponseBody body = response.getBody();
									        String bodyStringValue = body.asString();
									        Assert.assertTrue(bodyStringValue.contains("Name"));
									        Assert.assertTrue(bodyStringValue.contains("OrderCount"));
									        Assert.assertTrue(bodyStringValue.contains("Email"));
									        Assert.assertTrue(bodyStringValue.contains("ProductId"));
									 //Write Json Response in order.json file------------------------------------------
									        String responseAsString = response.asString();
											byte[] responseAsStringByte = responseAsString.getBytes();
											File targetFileForString = new File("src/main/resources/order.json");
											Files.write(responseAsStringByte, targetFileForString);
											InputStream responseAsInputStream = response.asInputStream();
											byte[] responseAsInputStreamByte = new byte[responseAsInputStream.available()];
											responseAsInputStream.read(responseAsInputStreamByte);
											File targetFileForInputStream = new File("src/main/resources/order2.json");
											Files.write(responseAsInputStreamByte, targetFileForInputStream);
											byte[] responseAsByteArray = response.asByteArray();
											File targetFileForByteArray = new File("src/main/resources/orderArray.json");
											Files.write(responseAsByteArray, targetFileForByteArray);
								    	}else {
								    		Assert.fail("Unable to enter Row Numbers");
								    	}
								    }else {
								    	Assert.fail("Unable to enter API Name");
								    }
								    }else {
								    	Assert.fail("Unable to enter data");
								    }
						    	}else {
						    		Assert.fail("Unable to verify Add Column Button");	
						    	}
						    }else {
						    	Assert.fail("Unable to enter data");
						    }
				    	}else {
				    		Assert.fail("Unable to verify Add Column Button");
				    	}
		    	}else {
		    		Assert.fail("Unable to enter value");
		    	}
		    }else {
		    	Assert.fail("Unable to verify Add Column Button");
		    }
		}catch(Exception ex) {
			Assert.fail("Unable to enter column1 value");
		}
		
	}
}
