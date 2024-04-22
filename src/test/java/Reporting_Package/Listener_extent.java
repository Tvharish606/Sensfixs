package Reporting_Package;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Listener_extent implements ITestListener,ISuiteListener
{
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private WebDriver driver;

    @Override
    public void onStart(ISuite suite) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        htmlReporter.config().setDocumentTitle("TestNG Automation Report");
        htmlReporter.config().setReportName("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentSparkReporter extentSparkReporter =
                new ExtentSparkReporter("test-output/spark-report1.html");
        extent.attachReporter(extentSparkReporter);
        addSystemInfo("Tester", "Harish_RCB");
    }

    @Override
    public void onFinish(ISuite suite) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        if(driver instanceof TakesScreenshot)
        {
            TakesScreenshot screenshotDriver=(TakesScreenshot) driver;
            byte[] screenshot =screenshotDriver.getScreenshotAs(OutputType.BYTES);
            String Screenshotname=result.getName()+"_"+System.currentTimeMillis()+".png";
            String screenshotPath = "screenshots/" + Screenshotname;
            result.setAttribute("screenshot", screenshotPath);
        }
        test.get().fail(result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        test.get().warning("Test partially successful");
    }

    private void addSystemInfo(String key, String value)
    {
        extent.setSystemInfo(key, value);
    }
    public void Setdriver(WebDriver driver)
    {
        this.driver=driver;
    }
}
