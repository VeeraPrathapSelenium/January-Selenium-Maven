package com.TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ApplicationPages.HomePage;
import com.GenericMethods.GenericMethods;







public class Tc_01_ValidateSigin_Page extends GenericMethods {


		
	@Test
	public static void TestSignIn() {
		
		String browser=getData("Testdata", 1, "Browser");
		String url=getData("Testdata", 1, "Url");	
		
		boolean status=true;
		
	 status=launchApp(browser, url);
	 if(status)
	 {
		 logEvent("Pass", "Application is launched sucessfully");
		 
		 // click on the sigin link
		 
		 HomePage homepage=PageFactory.initElements(driver, HomePage.class);
		 homepage.click_Signin();
		 
		 
		 
		 
	 }else
	 {
		 logEvent("Pass", "Application is launched sucessfully");
	 }
	 
 
	 

	}

}
