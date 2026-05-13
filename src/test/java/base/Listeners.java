package base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utilities.ScreenShotBase;

public class Listeners extends ScreenShotBase implements ITestListener {
	// Added for extent report
	 private static Logger log = LogManager.getLogger(Listeners.class);
	 private static ExtentReports extentrep;
	 //private static ExtentTest extenttst;  //sequential
	 private static ThreadLocal<ExtentTest> extenttst = new ThreadLocal<>();  // for Parallel Execution
	 
	 public void onStart(ITestContext context)
	 {
		 ExtentSparkReporter spark  = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReport.html");
		 spark.config().setReportName("Web Application Test Report");
		 spark.config().setDocumentTitle("Test Results");
		 spark.config().setTheme(Theme.STANDARD);
		 spark.config().setTimeStampFormat("dd-MM-YYY HH:mm:ss");
		 extentrep = new ExtentReports();
		 extentrep.attachReporter(spark);
		 extentrep.setSystemInfo("Tester Name", "Srihari");
	     extentrep.setSystemInfo("Environment", "QA");
	 }
	
	public void onTestStart(ITestResult result)
	{
		Reporter.log("Test Case Started : "+ result.getName());
		ExtentTest test = extentrep.createTest( result.getMethod().getMethodName(),result.getMethod().getDescription());
	        extenttst.set(test);
	        extenttst.get().log(Status.INFO,"Test Started: " + result.getMethod().getMethodName());
		
		log.info("Test Case Started");
		// Added for extent report
		
	}
	

	@Override
	public void onTestSuccess(ITestResult result)
	{
		log.info("Test Case Success");
		String packageName = result.getTestClass().getRealClass().getPackage().getName();
        String className = result.getTestClass().getName();
        String methodName = result.getMethod().getMethodName();
		try {
			getScreenShot(packageName, className, methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttst.get().log(Status.PASS, "Test Passed");extenttst.get().assignCategory( result.getTestClass().getName());  // groups by class name
		Reporter.log("Test Case Success : "+ result.getStatus());
		// Added for extent report
		 
	}
	public void onTestFailure(ITestResult result)
	{
		log.info("Test Case Failure");
		String packageName = result.getTestClass().getRealClass().getPackage().getName();
        String className = result.getTestClass().getName();
        String methodName = result.getMethod().getMethodName();
		try {
			getScreenShot(packageName, className, methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Test Case Failure : "+ result.getStatus());
		// Added for extent report
		 extenttst.get().log(Status.FAIL,"Test Failed: " + result.getThrowable().getMessage());
		 extenttst.get().fail(result.getThrowable());
		 extenttst.get().assignCategory(result.getTestClass().getName());
	}
	
	  @Override
	    public void onTestSkipped(ITestResult result) {
		  extenttst.get().log(Status.SKIP,"Test Skipped: " + result.getThrowable().getMessage());
		  extenttst.get().skip(result.getThrowable());
	    }
	@Override
	public void onFinish(ITestContext context) {
		extentrep.flush();  // This writes the report file
	}

}
