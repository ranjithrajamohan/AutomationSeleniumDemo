package com.testCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.objectsRepo.ContentRepo;
import com.objectsRepo.LocatorsRepo;

public class BaseClass {

	String dateAndTime;
	ChromeOptions options;
	ExtentTest testReport;
	ChromeDriver driver;
	ExtentReports report;

	@BeforeTest
	public void initializeTest() throws InterruptedException {

		try {
			System.out.println("BeforeTest");

			// Chrome Browser initialization
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Chromedriver\\chromedriver.exe");

			getDateAndTime();
			reportInitialize();
			desiredCapabilities();

			// ChromeDriver initialization
			driver = new ChromeDriver(options);
			testReport.log(Status.INFO, "Test is Started");

			//Launch the URL
			driver.get("https://www.saucedemo.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get date and time of the run
	public void getDateAndTime() {
		try {
			String dateFor = "dd_MM_yyyy_HH_mm_ss";
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateFor);
			Date date = new Date();
			dateAndTime = dateFormat.format(date);
			System.out.println("DateAndTime: " + dateAndTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Setting up Extent Report
	public void reportInitialize() {
		try {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\reports\\TestReport_" + dateAndTime + ".html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			testReport = report.createTest("First Selenium Script",
					"This Test to launch Demo Page and do Basic Validation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Desired Capabilities
	public void desiredCapabilities() {
		try {
			options = new ChromeOptions();
			options.addArguments("start-maximized");
//			options.addExtensions(new File(System.getProperty("user.dir") + "\\chromeAdExt\\AdBlock.crx"));
//			options.addExtensions(new File(System.getProperty("user.dir") + "\\chromeAdExt\\Pop-up-blocker.crx"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// Login into Sauce Demo
	public void loginSauceDemo() {

		try {
			LocatorsRepo object = new LocatorsRepo(driver);
			ContentRepo content = new ContentRepo();

//			testReport.log(Status.PASS, "Sauce Demo app is launched and ready to be tested");
			String userName = object.userNameText.getText().trim();
			String user[] = userName.split("\\r?\\n");
			System.out.println("Username: " + userName);

			String password = object.passwordText.getText().trim();
			String pwd[] = password.split("\\r?\\n");
			System.out.println("Password: " + password);

//			object.userNameInputField.sendKeys(object.userNameText.getText().trim().split("\\r?\\n")[1]);
			object.userNameInputField.sendKeys(user[1]);
			object.passwordInputField.sendKeys(pwd[1]);
			object.loginButton.click();
			
//			Assert.assertEquals(object.containerList.size(), 0);

			Assert.assertTrue(object.homePageHeader.isDisplayed());
			System.out.println("Actual: " + object.homePageHeader.getText());
			Assert.assertTrue(object.homePageHeader.getText().equals(content.homePageHead));

//			testReport.log(Status.PASS, "Sauce Demo app is logged in with Valid credentials");

		} catch (Exception e) {
			e.printStackTrace();
			testReport.log(Status.FAIL, "Test is failed");
			Assert.assertTrue(false);
		}
	}

	@AfterTest
	public void endRun() {
		System.out.println("AfterTest");
		// Driver or report ends here
		driver.quit();
		report.flush();
	}

}
