package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.TestListener.class)
public class ViewEmptyCartTest extends TestBase {
	

	@Test(description = "Verify if the customer is able to see cart message when it's empty", groups = { "sanity",
			"regression" })
	public void emptyCartUITest() {

		Assert.assertEquals(homePage.goToCartPage().getEmptyCartText(), "Your shopping cart is empt.");

	}



}
