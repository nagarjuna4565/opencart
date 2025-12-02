package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBases.BaseClass;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String reportName;

    @Override
    public void onStart(ITestContext testContext) {

        // Timestamp for report name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportName = "Test-Report-" + timeStamp + ".html";  //time stamp

        // Create reports folder if not exists
        String reportDir = System.getProperty("user.dir") + File.separator + "reports";
        new File(reportDir).mkdirs();  

        // Final path of the report
        String reportPath = reportDir + File.separator + reportName;

        // Initialize Spark Reporter
        sparkReporter = new ExtentSparkReporter(reportPath);

        // Report Configuration
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing Report");
        sparkReporter.config().setTheme(Theme.DARK);

        // Initialize ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // System Info
        extent.setSystemInfo("Application", "OpenCart");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Naga");
        
        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);
        
        
        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();

        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        } else {
            extent.setSystemInfo("Groups", "No groups specified");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getName() + " got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());
 
        try {
            String imgPath = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
 
    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, result.getName() + " got skipped");
 
        if (result.getThrowable() != null) {
            test.log(Status.INFO, result.getThrowable().getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext testContext) {
     
        // Flush the report
        extent.flush();
     
        // Build the report path
        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + reportName;
     
        File extentReport = new File(pathOfExtentReport);
     
        try {
            // Open the Extent Report automatically after execution
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   

}
