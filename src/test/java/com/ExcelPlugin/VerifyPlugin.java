package com.ExcelPlugin;

import java.io.IOException;

public class VerifyPlugin extends ExcelPlugin{

	public static void main(String[] args) throws IOException {


		/*loadExcel();
		
		String data=getData("Testdata", "Tc_01", 2, "#Cars");
		
		System.out.println(data);*/
	
		String mydata="Hello123";
		
		int len=mydata.length();
		
		String replval=mydata.replaceAll("[^0-9]", "");
		
		System.out.println(replval);
		
		
	}
		
	}
