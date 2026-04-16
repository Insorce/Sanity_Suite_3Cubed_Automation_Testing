package Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.Baseclass;

public class ExtendReports implements ITestListener {

	 public ExtentSparkReporter sparkreporter; // Create the UI of the report 
	  public ExtentReports reports; //Common information will maintain in the  report
	  public ExtentTest test; // Script execution data will be enter into the report
	  
		public void onStart(ITestContext context) {
			// time stamp 
			String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
			File reportDirectory = new File(System.getProperty("user.dir")+"\\ExtentReports");
			if (!reportDirectory.exists()) {
				reportDirectory.mkdirs();
			}
			
			
		    // specify  folder location  into the script 
			
			sparkreporter = new ExtentSparkReporter(reportDirectory.getAbsolutePath()+"\\"+timestamp+"Report.html");
			// Set the Document title 
			sparkreporter.config().setDocumentTitle("Automation Testing");
			// Set the Report Title
			sparkreporter.config().setReportName("Sanity Build Test");
			// Set the document Theme 
			sparkreporter.config().setTheme(Theme.DARK);
			
			// ---- using Extentreports set the common info of the report 
			
			reports= new ExtentReports();
			
			// Attach the sparkreporter details into reports 
			reports.attachReporter(sparkreporter);
			// set the common info
			
			reports.setSystemInfo("Environment", "PBL");
			reports.setSystemInfo("TesterName", "Mahesh_QA");
			reports.setSystemInfo("OS", "windows");
			reports.flush();
			System.out.println("Extent report initialized at " + reportDirectory.getAbsolutePath());
			
			
		  }

		public void onTestSuccess(ITestResult result) {
		    test= reports.createTest(result.getName());
			test.log(Status.PASS, "Test is Passed ");
			reports.flush();
			
		  }
		
		public void onTestFailure(ITestResult result) {
		    test= reports.createTest(result.getName());
		    test.log(Status.FAIL, "Test is Faild - "+result.getName());
		    test.log(Status.FAIL, result.getThrowable());// what ever exceptions throws the system it will be collecting and print 
		    
		    try {
				String imagepath= captureFailureScreenshot(result);
				test.addScreenCaptureFromPath(imagepath);
			} catch (IOException e) {
				e.getMessage();
				e.printStackTrace();
			}
		    reports.flush();
		
		}
		
		public void onTestSkipped(ITestResult result) {
		    test= reports.createTest(result.getName());
		    test.log(Status.SKIP, "Test is skipped - "+ result.getName());
		    test.log(Status.SKIP, result.getThrowable());
		    reports.flush();
			
		  }
		
		
		public void onFinish(ITestContext context) {
		    
			reports.flush();
		  }
		
		private String captureFailureScreenshot(ITestResult result) throws IOException {
			WebDriver activeDriver = extractDriver(result);
			if (activeDriver == null) {
				try {
					return Baseclass.screenshot(result.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			File source = ((TakesScreenshot) activeDriver).getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir")+"\\ScreenShot\\"+timestamp+"_"+result.getName()+"_img.png";
			File targetFile = new File(dest);
			File parent = targetFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			FileUtils.copyFile(source, targetFile);
			return dest;
		}

		private WebDriver extractDriver(ITestResult result) {
			Object instance = result.getInstance();
			if (instance == null) {
				return null;
			}

			Class<?> current = instance.getClass();
			while (current != null) {
				try {
					Field driverField = current.getDeclaredField("driver");
					driverField.setAccessible(true);
					Object value = driverField.get(instance);
					if (value instanceof WebDriver) {
						return (WebDriver) value;
					}
				} catch (NoSuchFieldException e) {
					current = current.getSuperclass();
					continue;
				} catch (IllegalAccessException e) {
					return null;
				}
				current = current.getSuperclass();
			}

			return null;
		}
		
		
	
	
	
}
