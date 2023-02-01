package com.amazon.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ISuite;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;

    // intitialzation property file obj and load the file 
	public TestBase() {
		try {
			prop = new Properties();
			prop.load(new FileInputStream(new File(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\amazon\\qa\\property\\confi.properties")));
			System.out.println(prop.getProperty("BROWSER"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    // Select the browser 
	
	public static void intitialzation() {
		String browserName = prop.getProperty("BROWSER");
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else{
			
		}
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get(prop.getProperty("URL"));
	}
	@BeforeSuite
	public void setReport(){
		ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/amazon.html"));
			
			report= new ExtentReports();
			report.attachReporter(extent);
	}
	@AfterMethod
	public void flushReport(ITestResult result){
		report.flush();
	}

    
}
