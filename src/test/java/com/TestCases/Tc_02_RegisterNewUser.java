package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ApplicationPages.AuthenticationPage;
import com.ApplicationPages.HomePage;
import com.GenericMethods.GenericMethods;

public class Tc_02_RegisterNewUser extends GenericMethods {


		
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
		status= homepage.click_Signin();
		
		if(status)
		{
			AuthenticationPage ap=PageFactory.initElements(driver, AuthenticationPage.class);
			ap.validate_NewUser();
		}
		 
		 
		 
		 
	 }else
	 {
		 logEvent("Pass", "Application is launched sucessfully");
	 }
	 
 
	 

	}
}
