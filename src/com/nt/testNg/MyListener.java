package com.nt.testNg;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListener extends TestListenerAdapter {
     ExtentSparkReporter sparkReport;
    ExtentReports reports;
    ExtentTest test;

	public void onStart(ITestContext context) {
		String path=System.getProperty("user.dir");
		sparkReport=new ExtentSparkReporter(path+"/reports/myreport.html");
		sparkReport.config().setDocumentTitle("AutomationReport");
		sparkReport.config().setReportName("FunctionalReport");
	    sparkReport.config().setTheme(Theme.DARK);
	   
	    reports=new ExtentReports();
	    reports.attachReporter(sparkReport);
	    reports.setSystemInfo("env","QA");
	    reports.setSystemInfo("os","windows");
	    reports.setSystemInfo("browser","chrome");
	    reports.setSystemInfo("tester","vasu");	
	}
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getName());
        
	}

	public void onTestSuccess(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.PASS,"Test Is Passesed::"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.FAIL,"Test Is Failed::"+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.SKIP,"Test Is SKIP::"+result.getName());
		
	}
	public void onFinish(ITestContext context) {
		reports.flush();
		
	}


}
