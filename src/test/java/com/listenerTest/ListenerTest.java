package com.listenerTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerTest implements ITestListener{

	public void onTestStart(ITestResult result)
	{
	
	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("***************I am OnTestSuccessListener***********");		
	}

	public void onTestFailure(ITestResult result)
	{
		System.out.println("***************I am OnTestFailureListener***********");		
	}

	public void onTestSkipped(ITestResult result)
	{
		System.out.println("***************I am OnTestSkippedListener***********");		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context)
	{

	}
}
