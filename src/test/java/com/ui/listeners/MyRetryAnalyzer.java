package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.utility.ConfigManager;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(ConfigManager.getProperty("MAX_NUMBER_OF_ATTEMPT"));
	private int currentAttempt = 1;

	@Override
	public boolean retry(ITestResult result) {
		
		while(currentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}

}
