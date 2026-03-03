package com.selenium.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeDay1 {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver wd = new ChromeDriver(options);
		wd.get("https://www.mol-it.com/");
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
		Actions actions = new Actions(wd);
		
//		By solutionsLinkLocator = By.xpath("//div[@class='custom_nav']//a[@href='/Solutions']");
//		WebElement solutionsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(solutionsLinkLocator));
//	
//		actions.moveToElement(solutionsLink).perform();
//		
//		By dataEngineeringLinkLocator = By.xpath("//a[@title='Data Engineering']");
//		WebElement dataEngineering = wait.until(ExpectedConditions.visibilityOfElementLocated(dataEngineeringLinkLocator));
//		dataEngineering.click();
		
		By menuButtonLocator = By.xpath("//div[@class='trigger_mobile_menu']");
		WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(menuButtonLocator));
		menuButton.click();
		
		By qualityPolicyLinkLocator = By.xpath("//div[@class='service_site']//a[@title='Quality Policy']");
		WebElement qualityPolicy = wait.until(ExpectedConditions.elementToBeClickable(qualityPolicyLinkLocator));
		qualityPolicy.click();
	}

}
