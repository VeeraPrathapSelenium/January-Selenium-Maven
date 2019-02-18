package com.Reporting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.GenericMethods.GenericMethods;
import com.Listners.Listners;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import freemarker.template.SimpleDate;

public class Report {
	
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	// step1:-- Initialize the test report
	
	public static void intializeReport()
	{
		extent=new ExtentReports(verifyResultFolderexist()+"\\"+Listners.CrntClass+".html");
		extent.addSystemInfo("QA","Prathap")
		.addSystemInfo("Sprint #","Sprint 2");
		
	}
// Step 2: Start the extent report
	
	public static void startReport() {
		test=extent.startTest(Listners.CrntClass);
	}

// Step 3: LogEvent
	
	
	public static void logEvent(String status,String Description)
	
	{
		
		switch (status.toLowerCase()) {
		case "pass":
			test.log(LogStatus.PASS, Description+test.addBase64ScreenShot(getScreenShot()));
			break;
			
		case "fail":
			test.log(LogStatus.FAIL, Description+test.addBase64ScreenShot(getScreenShot()));
			break;
		default:
			break;
		}
		
	}

// Step 4:Publish Result
	
	public static void flushReport()
	{
		extent.flush();
		extent.endTest(test);
		extent.close();
	}
	
	
	
	public static String verifyResultFolderexist()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
		
		 String resPath=System.getProperty("user.dir")+"\\Results\\"+sdf.format(new Date());
		 
		 File f=new File(resPath);
		 
		 if(!f.exists())
		 {
			 f.mkdirs();
		 }
		return resPath;
		
		
		
	}
	
	public static String getScreenShot()
	{
		TakesScreenshot sht=(TakesScreenshot) GenericMethods.driver;
		
		String screenshot=sht.getScreenshotAs(OutputType.BASE64);
		
		return "data:image/png;base64,"+screenshot;
		
	}
	

}
