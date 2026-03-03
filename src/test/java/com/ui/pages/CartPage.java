package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class CartPage extends BrowserUtility{
	
	private static final By EMPTY_CART_ALERT_LOCATOR = By.xpath("//p[contains(text(),\"Your shopping cart is empty.\")]");

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public String getEmptyCartText() {
		return getVisibleText(EMPTY_CART_ALERT_LOCATOR);
	}

}
