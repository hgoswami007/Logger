package hardikgoswami.TestComponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import hardikgoswami.Abstract.AbstractData;
import hardikgoswami.pageObject.ExtentReprot;

public class Listerns extends ExtentReports implements ITestListener  {
	

	ExtentReports report = ExtentReprot.generateExtentReport();
	ExtentTest test;
	String filepath;
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test case Pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
		 filepath = AbstractData.getScreenshot(result.getMethod().getMethodName());
		 System.out.println(filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
		report.flush();
	}

}
