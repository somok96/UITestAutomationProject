package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.ui.test.LoginTest;
import com.utility.BrowserUtility;
import com.utility.ConfigManager;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	
	private Logger logger = LoggerUtility.getLogger(LoginTest.class);
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");
	private static final By CART_BUTTON_LOCATOR = By.xpath("//a[@title=\"View my shopping cart\"]");
	

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		goToWebsite(ConfigManager.getProperty("BASE_URL"));
		maximizeWindow();
	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(ConfigManager.getProperty("BASE_URL"));
		maximizeWindow();
	}
	
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	public CartPage goToCartPage() {
		logger.info("Trying to perform click to go to Sign in Page");
		clickOn(CART_BUTTON_LOCATOR);
		CartPage cartPage = new CartPage(getDriver());
		return cartPage;
	}

}
