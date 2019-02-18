package com.Listners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.ExcelPlugin.ExcelPlugin;
import com.Reporting.Report;





public class Listners implements ITestListener,IInvokedMethodListener{

	public static String CrntClass;
	
	
	@Override
	public void onFinish(ITestContext arg0) {

System.out.println("On finish");
		
		
	}

	@Override
	public void onStart(ITestContext arg0) {
// at suite level
		ExcelPlugin.loadExcel();
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		
		
		// @test
		
		CrntClass=arg0.getInstanceName().substring(arg0.getInstanceName().lastIndexOf(".")+1);
		
		System.out.println(CrntClass);
		Report.intializeReport();
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// after method
		System.out.println("after invocation");
		Report.flushReport();	
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// before method
		System.out.println("before invocation");
		Report.startReport();
		
	}

}
