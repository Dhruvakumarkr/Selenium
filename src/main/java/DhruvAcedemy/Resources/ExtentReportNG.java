package DhruvAcedemy.Resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	static ExtentReports extent;
	
	public static  ExtentReports getReportObject()
	{
		ExtentReports extent = new ExtentReports();
		
		
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	//	File file= new File("//reports//index.html");
//		ExtentSparkReporter reporter=new ExtentSparkReporter(file);

		reporter.config().setDocumentTitle("Web Automation Results");
//		reporter.config().enableOfflineMode(true);
		reporter.config().setReportName("Order Booking Results");
//		reporter.config().setTheme(Theme.DARK);
		reporter.config().enableOfflineMode(true);

		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Dhruv Gowda");
		extent.setSystemInfo("Test case", "E-Commerce");
		
		return extent;
		
		
	}
	
	
	
	
}
