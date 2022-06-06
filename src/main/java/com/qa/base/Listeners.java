package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.utility.ExtendReportUtility;
import com.qa.utility.ScreenshotsUtil;

public class Listeners extends Base implements ITestListener
{
	WebDriver driver;
	ExtentTest test;

	ExtentReports extent=ExtendReportUtility.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();


	@Override
	public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestStart(result);
	test =extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);

	}
	@Override
	public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test Passed");


	}
	@Override
	public void onTestFailure(ITestResult result) {
    //WebDriver driver = new ChromeDriver();
	this.driver=driver;
	// TODO Auto-generated method stub
	ITestListener.super.onTestFailure(result);
	//extentTest.get().log(Status.FAIL, "Test Failed");

	String testMethodName=result.getMethod().getMethodName();
	String screenshotPath=ScreenshotsUtil.screenshot(driver,testMethodName);
	extentTest.get().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	extentTest.get().fail(result.getThrowable());

	}
	@Override
	public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP, "Test Skipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestFailedWithTimeout(result);
	}
	@Override
	public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	ITestListener.super.onStart(context);
	}
	@Override
	public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	ITestListener.super.onFinish(context);
	extent.flush();
	}


}
