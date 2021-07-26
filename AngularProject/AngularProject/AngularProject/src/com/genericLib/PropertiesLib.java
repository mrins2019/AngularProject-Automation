package com.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLib {

	private final String filePath = "./appsettings.properties";

	/*This method returns the corresponding value of the provided key parameter as an input*/
	public String getPropertiesData(String key) throws Exception{
		Properties properties = new Properties();

		try {
			FileInputStream file = new FileInputStream(filePath);
			properties.load(file);
			if (properties.isEmpty()){
				throw new Exception("Unable to load the file, there is no file content...");
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return properties.getProperty(key);
	}
}

