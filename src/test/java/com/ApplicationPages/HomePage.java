package com.ApplicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericMethods.GenericMethods;

public class HomePage extends GenericMethods{

	//----------------------- WebElements of Menu Bar --------------------
	@FindBy(how=How.XPATH,using="//a[normalize-space(text())='Sign in']")
	public static WebElement Lnk_Signin;
	
	
	// ----------------------- Web Methods Implementation ----------------
	
	
	public static boolean click_Signin()
	{
		
		boolean status=true;
		
		status=waitForElement_Visible(Lnk_Signin);
		
		if(status)
		{
			status=hoverAndClick("Sigin_Homepage", Lnk_Signin);
			if(status)
			{
				logEvent("Pass", "Sigin link is clicked sucessfully");
			}else
			{
				logEvent("fail", "Unable to click on Sigin link");
			}
			
		}else
		{
			logEvent("fail", "Unable to find sigin link on home page");
		}
		
		return status;
	}
	
	
	
	
}
