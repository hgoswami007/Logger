package hardikgoswami.pageObject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReprot {
	public static ExtentReports generateExtentReport() {
		// There are two class require for Extent report
//		1. Extentreport
//		2. ExtentSparkreport
		
		String reportPath = System.getProperty("user.dir")+"\\reports"+"\\testResult.html";
		ExtentSparkReporter sparkReport= new ExtentSparkReporter(reportPath);
		sparkReport.config().setReportName("Web Automation report");
		sparkReport.config().setDocumentTitle("Test Result");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(sparkReport);
		
		report.setSystemInfo("Automation Engineer", "Hardik Goswami");
		return report;
	}

}
