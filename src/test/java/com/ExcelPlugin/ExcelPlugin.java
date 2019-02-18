package com.ExcelPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellAlignment;

import com.Listners.Listners;
import com.Reporting.Report;

public class ExcelPlugin extends Report{
	public static XSSFWorkbook workbook;
	
	public static void loadExcel() 
	{
		try
		{
			System.out.println("Loading excel File");
			
			File exlfile=new File(System.getProperty("user.dir")+"\\Testdata\\Testadata.xlsx");
			
			FileInputStream fis=new FileInputStream(exlfile);
			
			workbook=new XSSFWorkbook(fis);
			
			System.out.println("Excel File is loaded sucessfully");
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}

	public static int getRowCount(String sheetname)
	{
		return workbook.getSheet(sheetname).getPhysicalNumberOfRows()-1;
	}
	
	public static int getColumnCount(String sheetname)
	{
		return workbook.getSheet(sheetname).getRow(getRowCount(sheetname)).getPhysicalNumberOfCells();
	}
	
	public static int searchTestCase(String testcasename,int iter,String sheetname)
	{
		int rowfound=0;
		
		int totalcount_rows=getRowCount(sheetname);
		
		for(int i=0;i<=totalcount_rows;i++)
		{
			String tcname="";
			
			String itr="";
			
			// get testcase
			switch(workbook.getSheet(sheetname).getRow(i).getCell(0).getCellTypeEnum())
			{
			case STRING:
				tcname=workbook.getSheet(sheetname).getRow(i).getCell(0).getStringCellValue();
				break;
			case NUMERIC:
				tcname=Integer.toString((int)workbook.getSheet(sheetname).getRow(i).getCell(0).getNumericCellValue());
				break;
				
			}
			
			// get it
						switch(workbook.getSheet(sheetname).getRow(i).getCell(1).getCellTypeEnum())
						{
						case STRING:
							itr=workbook.getSheet(sheetname).getRow(i).getCell(1).getStringCellValue();
							break;
						case NUMERIC:
							itr=Integer.toString((int)workbook.getSheet(sheetname).getRow(i).getCell(1).getNumericCellValue());
							break;
							
						}
						
			if(tcname.equals(testcasename) && Integer.valueOf(itr)==iter)
			{
				rowfound=i;
				break;
			}
			
		}	
		
		return rowfound;
	}
	public static int searchColumn(String sheetname,String columnname)
	{
		int colfound=0;
		
		int totalcount_col=getColumnCount(sheetname);
		
		for(int i=0;i<=totalcount_col;i++)
		{
			
			
			String colname=workbook.getSheet(sheetname).getRow(0).getCell(i).getStringCellValue();
			
			
			if(colname.equals(columnname) )
			{
				colfound=i;
				break;
			}
			
		}	
		
		return colfound;
	}
	
	public static String getData(String sheetname,int itr,String columnname)
	{
		String data="";
		String testcase=Listners.CrntClass;
		int row=searchTestCase(testcase,itr,sheetname);
		
		int col=searchColumn(sheetname,columnname);
		
		switch(workbook.getSheet(sheetname).getRow(row).getCell(col).getCellTypeEnum())
		{
		case STRING:
			data=workbook.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
			break;
		case NUMERIC:
			data=Integer.toString((int)workbook.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue());
		}
		return data;
		
		
	}
	
	
	
	
}
