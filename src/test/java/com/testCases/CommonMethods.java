package com.testCases;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.objectsRepo.ContentRepo;
import com.objectsRepo.LocatorsRepo;


public class CommonMethods extends BaseClass{
	
	public void loginSauceDemo() {

		try {
			LocatorsRepo object = new LocatorsRepo(driver);
			ContentRepo content = new ContentRepo();

			testReport.log(Status.PASS, "Sauce Demo app is launched and ready to be tested");
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

			Assert.assertTrue(object.homePageHeader.isDisplayed());
			System.out.println("Actual: " + object.homePageHeader.getText());
			Assert.assertTrue(object.homePageHeader.getText().equals(content.homePageHead));

			testReport.log(Status.PASS, "Sauce Demo app is logged in with Valid credentials");

		} catch (Exception e) {
			e.printStackTrace();
			testReport.log(Status.FAIL, "Test is failed");
			Assert.assertTrue(false);
		}
	}
	
	public String randomString(String stringType, int length) {
		
		String randomString = "";
		try {
			
			switch (stringType) {
			case "alphaNumeric":
				RandomStringGenerator alphaNumericGenerator = new RandomStringGenerator.Builder()
				.withinRange('0', 'z')
				.filteredBy(LETTERS, DIGITS)
				.build();
				randomString = alphaNumericGenerator.generate(length);
				break;

			case "numeric":
				RandomStringGenerator numberGenerator = new RandomStringGenerator.Builder()
				.withinRange('0', '9')
				.filteredBy(DIGITS)
				.build();
				randomString = numberGenerator.generate(length);
				break;

			case "alpha":
				RandomStringGenerator alphaGenerator = new RandomStringGenerator.Builder()
				.withinRange('a', 'z')
				.filteredBy(LETTERS)
				.build();
				randomString = alphaGenerator.generate(length);
				break;

			default:
				Assert.assertTrue(false, "Random StringType is not as expected.");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			testReport.log(Status.FAIL, "Failed");
		}

		return randomString;
	}

	@SuppressWarnings("deprecation")
	public void waitUntilElementVisible(WebElement element, int maximumSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, maximumSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public WebElement waitUntilElementClickable(WebElement element, int maximumSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, maximumSeconds);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

	public void clickElementUsingJSE(WebElement element) {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			Thread.sleep(500);
			System.out.println("Element is clicked via JSE  > " + element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jsSendKeys(WebElement webelement, String inputstring) {
		try {
			((JavascriptExecutor)driver)
			.executeScript("arguments[0].setAttribute('value', '" + inputstring + "')", webelement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollToElement(WebElement element) {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollUpOrDown(int value) {
		try {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0," + value + ")");
			System.out.println("ScrolledUpOrDownBy  > " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollLeftOrRight(int value) {
		try {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(" + value + ",0)");
			System.out.println("ScrolledUpOrDownBy  > " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitFor(int waitInSec) {
		try {
			Thread.sleep(waitInSec*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

}
