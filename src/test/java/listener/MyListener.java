package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.BasePage;


public class MyListener extends BaseTest implements ITestListener {
	
	BasePage page = new BasePage(driver);

	public void onTestStart(ITestResult result) {
		test= report.createTest(result.getName());		
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Tetscase is passed");
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Tetscase is failed");
		String path=page.captureScreenshot(result.getName());
		test.addScreenCaptureFromPath(path);
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Tetscase is Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {	
	}
	public void onStart(ITestContext context) {	
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	
	
}
