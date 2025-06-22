package com.demo.utils;

import java.io.FileInputStream;
import java.util.Properties;


public class ConfigReader {

	
	private static Properties properties;
	
	static {
		try(FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("failed to load the config properties");
		}
	}
	
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
