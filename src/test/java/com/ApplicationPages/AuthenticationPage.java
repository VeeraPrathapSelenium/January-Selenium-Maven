package com.ApplicationPages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericMethods.GenericMethods;

public class AuthenticationPage extends GenericMethods{
	//----------------------- WebElements Create An Account --------------------
		@FindBy(how=How.XPATH,using="//input[@id='email_create']")
		public static WebElement Edi_EmailAddress;
		
		@FindBy(how=How.XPATH,using="//button[@id='SubmitCreate']")
		public static WebElement Btn_SubmitCreate;
		
		// ----------------------- Web Methods Implementation ----------------
		
		
		public static boolean validate_NewUser()
		{
		boolean status=true;
		
		try
		{
			status=waitForElement_Visible(Edi_EmailAddress);
			if(status)
			{
				String emailid=getData("Testdata", 1, "EmailId");
				
				String[] arr=emailid.split("@");
				SimpleDateFormat sdf=new SimpleDateFormat("HHmmss");
				
				emailid=arr[0]+"_"+sdf.format(new Date())+"@"+arr[1];
				
				status=clickandSendData("Email Address_Authentication", Edi_EmailAddress, emailid);
				
				if(status)
				{
					logEvent("pass", "Email Address is entered sucessfully");
					
					status=hoverAndClick("Create Account_Authentication", Btn_SubmitCreate);
					
					if(status)
					{
						logEvent("Pass", "Create account button is clicked sucessfully");
					}else
					{
						logEvent("fail", "Create account button is not clicked sucessfully");
					}
					
				}else
				{
					logEvent("fail", "Email Address is not entered sucessfully");
				}
				
			}else
			{
				logEvent("Fail", "Unable to identify the webelement Email address");
			}
			
			
		}catch(Exception e)
		
		{
			
		}
		return status;
		}
}
