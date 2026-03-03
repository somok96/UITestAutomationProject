package com.utility;

import static com.constants.Browser.CHROME;
import static com.constants.Browser.EDGE;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;
import com.ui.test.LoginTest;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(LoginTest.class);

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser : " + browserName);

		if (browserName == CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == EDGE) {
			driver.set(new EdgeDriver());
		} else {
			logger.error("Browser Not Found...!!");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser : " + browserName);

		if (browserName == CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("disable-gpu");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}

		} else if (browserName == EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}
		} else {
			logger.error("Browser Not Found...!!");
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website : " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the Browser Window...");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding element with the locator : " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and now performing Click...");

		element.click();
	}

	public void enterText(By locator, String text) {

		logger.info("Finding element with the locator : " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and now enter Text.: " + text);

		element.sendKeys(text);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with the locator : " + locator);
		WebElement element = driver.get().findElement(locator);

		logger.info("Element Found and returning the visible Text : " + element.getText());
		return element.getText();
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name + timeStamp + ".png";
		;
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

	public void closeWebsite() {
		if (driver != null) {
			logger.info("Closing the browser...");
			driver.get().quit();
		}
	}
}
