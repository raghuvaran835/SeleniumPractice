package com.practiceselenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.Base;

public class OpenLinksInNewTab extends Base{

	@Test
	public void openAllFooterlinksAndPrintTitle()
	{
		WebDriver driver=launch("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1800)");
		
		List<WebElement> footerLinks=driver.findElements(By.xpath("(//tr/td/ul)[1]/li/a"));
		for(WebElement fl:footerLinks)
		{
			String clickOnLinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			fl.sendKeys(clickOnLinkTab);
		}
		String ParentWindow=driver.getWindowHandle();
		Set<String> childWindows=driver.getWindowHandles();
		Iterator<String> it=childWindows.iterator();
		
		while(it.hasNext())
		{
			String w=it.next();
			if(!w.equals(ParentWindow))
			{
				driver.switchTo().window(w);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
	}
}
