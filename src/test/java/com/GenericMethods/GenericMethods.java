package com.GenericMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ExcelPlugin.ExcelPlugin;

public class GenericMethods extends ExcelPlugin{
	public static WebDriver driver;
	/*
	 * Method Name := launchApplication
	 * 
	 * Input Parameter := browser type,Url
	 * 
	 * Designer :=
	 * 
	 */
	
	public static boolean launchApp(String browsertype,String url)
	{boolean status=true;
	
	try
	{
	
		switch(browsertype.toLowerCase())
		{
		case "ff":
			System.out.println("Launching FireFox Browser");
			driver=new FirefoxDriver();
			
			break;
		case "chrome":
			System.out.println("Launching Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

			driver=new ChromeDriver();
			break;
		
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Launching Browser is completed");
		
	}
	catch(Exception e)
	{
		e.getMessage();
	}
	return status;
	
	}
	
	/*
	 * Method Name := closeApplication
	 * 
	 * Input Parameter :=
	 * 
	 * Designer :=
	 * 
	 */
	
	public static void closeApp()
	{
	driver.close();
	}
	
	
	/*
	 * Method Name := clickandSendData
	 * 
	 * Input Parameter :=
	 * 
	 * Designer :=
	 * 
	 */
	
	public static boolean clickandSendData(String Fieldname,WebElement element,String data)
	{
	boolean status=true;
	String Pagename = null;
	String crntFieldname=null;
		try
		{
			String arr[]=Fieldname.split("_");
			crntFieldname=arr[0];
			
			Pagename=arr[1];
			
			System.out.println("Entering data for the field : "+crntFieldname +" With the data as "+ data+" on the page " +Pagename);
			element.click();
			element.clear();
			element.sendKeys(data);
			System.out.println("Entering data for the field : "+crntFieldname +" With the data as "+ data+" on the page " +Pagename+ "  is completed");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Unable to identify the field : "+crntFieldname +" on the page " +Pagename);
			status=false;
		}
		return status;
		
		
	}

	
	/*
	 * Method Name := selectDropDown
	 * 
	 * Input Parameter :=
	 * 
	 * Designer :=
	 * 
	 */
	
	public static boolean selectDropDown(String Fieldname,WebElement element,String data)
	{
	boolean status=true;
	String Pagename = null;
	String crntFieldname=null;
		try
		{
			String arr[]=Fieldname.split("_");
			crntFieldname=arr[0];
			
			Pagename=arr[1];
			
			System.out.println("Clicking the field : "+crntFieldname +" on the page " +Pagename);
			
			// Drop Downs will selected using Select Class
			
			Select select=new Select(element);
			/* Selet the option
			 * 		- Select By Value
			 * 		- Select By visible text
			 * 		- Select By index			
			 */
				
			select.selectByVisibleText(data);
			
			System.out.println("Selecting the option for the field : "+Fieldname +" With the data as "+ data+" on the page " +Pagename+ "  is completed");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Unable to identify the field : "+Fieldname +" on the page " +Pagename);
			status=false;
		}
		return status;
		
		
	}

	
	/*
	 * Method Name := hoverAndClick
	 * 
	 * Input Parameter :=
	 * 
	 * Designer :=
	 * 
	 */
	
	public static boolean hoverAndClick(String Fieldname,WebElement element)
	{
	boolean status=true;
	String Pagename = null;
	String crntFieldname=null;
		try
		{
			String arr[]=Fieldname.split("_");
			crntFieldname=arr[0];
			
			Pagename=arr[1];
			
			System.out.println("Hovering on the field : "+crntFieldname +" on the page " +Pagename);
			
			// User Actions class to hover on the webelement
			
			Actions action=new Actions(driver);
			action.moveToElement(element).click(element).build().perform();
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Unable to identify the field : "+Fieldname +" on the page " +Pagename);
			status=false;
		}
		return status;
		
		
	}

	/*
	 * Method Name := JavaScriptExecutor
	 * 
	 * Input Parameter :=
	 * 
	 * Designer :=
	 * 
	 */
	public static void forceClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	
	public static boolean waitForElement_Visible(WebElement element)
	{
		boolean status=true;
		
		try
		{
			new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e)
		{
			status=false;
			
		}return status;
	}
	
	
}
