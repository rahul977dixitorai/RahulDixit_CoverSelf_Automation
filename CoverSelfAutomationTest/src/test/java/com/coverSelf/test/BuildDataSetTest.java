package com.coverSelf.test;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.coverSelf.baseclass.BaseTestSuiteConfig;
import com.coverSelf.pages.BuildDataSet;

public class BuildDataSetTest extends BaseTestSuiteConfig{
 
	@Test(priority=0,description="User is able to Fill Data Set")
	public void selectFillDataSetTest(Method method) throws InterruptedException {
		BuildDataSet bd=new BuildDataSet(driver);
		Thread.sleep(2000);
		bd.addAllData();
	}
}
