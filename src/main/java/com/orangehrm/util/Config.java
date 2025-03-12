package com.orangehrm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private static Properties prop=new Properties();
	
	static {
		try {
			FileInputStream fis=new FileInputStream(FilePaths.CONFIG_FILE.getPath());
			prop.load(fis);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	
	
	

}
