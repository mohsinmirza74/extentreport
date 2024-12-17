package extentreport;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class basicextentreport {
	ExtentSparkReporter htmlRrporter;
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void StartReporter() {
		htmlRrporter=new ExtentSparkReporter("\"C:\\Users\\Mohsin QA\\Desktop\\Seleniumautomation framework\\codestudio\\test-output\\Demo Extent report");
		reports=new ExtentReports();
		reports.attachReporter(htmlRrporter);
		///add enviornment details
	reports.setSystemInfo("probook", "corei5");
	reports.setSystemInfo("window", "window10");
	reports.setSystemInfo("user", "mohsin");
	reports.setSystemInfo("Browser", "chrome");
	
	//////configration to change  look and feel
	htmlRrporter.config().setDocumentTitle("Extent Report Demo");
	htmlRrporter.config().setReportName("Test Report");
	htmlRrporter.config().setTheme(Theme.STANDARD);
	htmlRrporter.config().setTimeStampFormat("EEEE,  MMMM dd,yyyy, hh:mm a '('zzz')");
	}
	@Test
	public void launchbrowser() {
		test=reports.createTest("launch browser and url");
		Assert.assertTrue(true);
	}
	@Test
	public void verifytitle() {
		test=reports.createTest("verify title ");
		Assert.assertTrue(false);
	}
		@Test
		public void veriflogo() {
			test=reports.createTest("verify logo ");
			Assert.assertTrue(true);
}
		@Test
		public void verifEmail() {
			test=reports.createTest("verify Email");
			throw new SkipException("Skipping the test case exception");
		}
		@Test
		public void verifyusername() {
			test=reports.createTest("verify username");
			Assert.assertTrue(true);
		}
		@AfterMethod
		public void getTestResult(ITestResult result) {
			if (result.getStatus()==ITestResult.FAILURE) {
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "Fail", ExtentColor.RED));
			}
			else if (result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "pass", ExtentColor.GREEN));
			}
			else if (result.getStatus()==ITestResult.SKIP) {
				test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ "Skipped", ExtentColor.YELLOW));
			}
		}
		public void tearDown() {
			reports.flush();
		}
}
