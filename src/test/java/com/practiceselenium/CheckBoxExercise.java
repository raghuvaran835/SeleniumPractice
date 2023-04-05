package com.practiceselenium;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.google.gson.annotations.Until;

public class CheckBoxExercise extends Base{
	WebDriver driver;
	@Test
	public void checkBoxExercise()
	{
		driver=launch("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement cbox1=driver.findElement(By.id("checkBoxOption1"));
		cbox1.click();
		assertTrue(cbox1.isSelected());
		cbox1.click();
		assertFalse(cbox1.isSelected());
		List<WebElement> cboxes=driver.findElements(By.cssSelector("input[id*='checkBox']"));
		System.out.println(cboxes.size());
		driver.close();
	}
	//ClearTrip WebSite TestCase
	@Test
	public void clearTripExercise() throws InterruptedException
	{
		
		//Locators for clicking calendar
		By departsOn=By.xpath("//*[text()='Depart on']//following::button[1]/div");
		
		//Locator for clicking link
		By classOfTravelLink=By.xpath("//a[text()='Class of travel, Airline preference']");
		
		//Select box locators
		By adultSelectBox=By.xpath("//*[text()='Adults']//following-sibling::select");
		By ChildrenSelectBox=By.xpath("//*[text()='Children']//following-sibling::select");
		By infantSelectBox=By.xpath("//*[text()='Infants']//following-sibling::select");
		By searchFlight=By.xpath("//button[text()='Search flights']");
		
		//locator for getting calender month
		By monthText=By.xpath("//div[@class='DayPicker-wrapper'] //div[@class='DayPicker-Months']/div[1]/div/div");
		
		//Launching the website
		driver=launch("https://www.cleartrip.com/");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)","");
		driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[local-name()='svg' and @class=' c-pointer c-neutral-900']/*[local-name()='path']")).click();
		
		//Selecting date month on calendar
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement departDate=wait.until(ExpectedConditions.elementToBeClickable(departsOn));
		
		js.executeScript("arguments[0].click();",departDate);
		
		Thread.sleep(3000);
		
		WebElement rightArrow= driver.findElement(By.xpath("//div[@class='DayPicker-wrapper']/div/div[2] //*[name()='svg']/*[name()='g']"));
		
		String month=driver.findElement(monthText).getText();
		while(!month.contains("January"))
		{
			rightArrow.click();
			month=driver.findElement(monthText).getText();
		}
		
		List<WebElement> days=driver.findElements(By.xpath("//div[@class='DayPicker-wrapper']/div[2]/div/div[3]/div/div[@class='DayPicker-Day']/div/div"));
		boolean flag=false;
		for(WebElement day:days)
		{
			if(day.getText().contains("29"))
			{
				flag=true;
				day.click();
				break;
			}
		}
		if(flag)
		{
			System.out.println("day selected");
		}
		else {
			System.out.println("something went wrong when selecting date");
		}
		
		//End of Calender part
		Thread.sleep(2000);
		
		//Selecting Select Boxes
		Select adult=new Select(driver.findElement(adultSelectBox));
		adult.selectByValue("4");
		
		Select children=new Select(driver.findElement(ChildrenSelectBox));
		children.selectByValue("3");
		
		Select infant=new Select(driver.findElement(infantSelectBox));
		infant.selectByValue("1");
		
		//Clicking Link
		driver.findElement(classOfTravelLink).click();
		
		//clicking Search Flights
		
		driver.findElement(searchFlight).click();
		Thread.sleep(5000);
		
		String errorText=driver.findElement(By.xpath("//div[@class='container p-fixed z-20 w-100p b-0 mb-2']/div/div/div/span")).getText();
		System.out.println(errorText);
	}
	
	@Test
	public void waitDemo()
	{
		driver=launch("https://www.itgeared.com/demo/1506-ajax-loading.html");
		WebDriverWait wait=new WebDriverWait(driver, 6);
		driver.findElement(By.xpath("//div/a[2]")).click();
		WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']")));
		System.out.println(text.getText());
		
		
	}
	
	//qaclickAcademy.com test
	@Test
	public void qaclickAcademy()
	{
		driver=launch("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement ele=driver.findElement(By.xpath("//legend[contains(text(),'Checkbox Example')]//following-sibling::label[2]"));
		ele.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		String cboxText=ele.getText().trim();
		WebElement selectBox=driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		
		Select s=new Select(selectBox);
		s.selectByVisibleText(cboxText);
		driver.findElement(By.cssSelector("#name")).sendKeys(cboxText);
		
		driver.findElement(By.cssSelector("#alertbtn")).click();
		
		String alertText=driver.switchTo().alert().getText();
		System.out.println(alertText);
		assertTrue(alertText.contains(cboxText));
		
	}
	
	@AfterMethod
	public void driverQuit()
	{
		driver.quit();
	}

}
