package com.practiceJavaScriptExecutor;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.Base;

public class TestJSExecutorUtility extends Base {
	
	@Test
	public void testJsUtilitymethods() throws IOException, InterruptedException
	{
		WebDriver driver=launch("https://demo.nopcommerce.com/");
		
		//Draw Border around the element and take screenshot
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtility.drawBorder(logo, driver);
//		
//		String path=takeScreenshot(driver,"logo");
//		System.out.println(path);
//		
		//clickElement By JS
//		WebElement login=driver.findElement(By.linkText("Log in"));
//		JavaScriptUtility.clickElementByJs(login, driver);
		
		JavaScriptUtility.scrollPageDown(driver);
		Thread.sleep(1000);
		JavaScriptUtility.scrollPageUp(driver);
		JavaScriptUtility.refreshBrowserByJs(driver);
		JavaScriptUtility.generateAlert(driver,"Hello Raghuvaran");
		Thread.sleep(2000);
		driver.close();
		
	}

	
}
