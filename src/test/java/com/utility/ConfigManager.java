package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static String path = "config/config.properties";
	private static Properties prop = new Properties();
	private static String env;

	private ConfigManager() {

	}

	static {
		env = System.getProperty("env", "qa");
		env = env.trim().toLowerCase();
		
		switch (env) {

		case "dev" -> path = "config/config.dev.properties";
		case "qa" -> path = "config/config.qa.properties";
		case "uat" -> path = "config/config.uat.properties";
		default -> path = "config/config.qa.properties";

		}

		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

		if (input == null) {
			throw new RuntimeException("File not found in the following path" + path);
		}

		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String key) {

		return prop.getProperty(key.toUpperCase());
	}

}
