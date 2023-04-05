package com.practiceselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
	
	@Test
	public void testMultipleUrl()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.google.com/");
//		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
//		System.out.println(driver.getPageSource());
		System.out.println(driver.findElement(By.cssSelector("#autosuggest")).getSize());
		driver.findElement(By.cssSelector("#autosuggest")).click();
	}

}
