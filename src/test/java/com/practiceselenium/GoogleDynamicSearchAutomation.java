package com.practiceselenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.Base;

public class GoogleDynamicSearchAutomation extends Base{
	WebDriver driver;
	
	
	@Test
	public void googleDynamicSearchTest() throws InterruptedException
	{
		driver=launch("https://www.google.com/");
		driver.findElement(By.xpath("//input[@class='gLFyf' and @title='Search']")).sendKeys("Testing");
		Thread.sleep(1500);
		List<WebElement> autoSuggestions=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']/span"));
		
		for(WebElement suggestion:autoSuggestions)
		{
			System.out.println(suggestion.getText());
			if(suggestion.getText().contains("course"))
			{
				System.out.println(suggestion.getText());
				suggestion.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.quit();
	}
	
}
