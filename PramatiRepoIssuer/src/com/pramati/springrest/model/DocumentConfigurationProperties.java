package com.pramati.springrest.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DocumentConfigurationProperties {

	final static Logger logger = Logger.getLogger(DocumentConfigurationProperties.class);

	public String getPropValues(String propFileName) throws IOException {
		InputStream inputStream = null;
		String returnPropertyValue = "";
		try {
			
			Properties prop = new Properties();
			//String propFileName = "config.properties";
			/*File file = new File("./resources/config.properties");
			FileReader fileReader = new FileReader(file);
			prop.load(fileReader);
			System.out.println(prop.getProperty("folderName"));*/
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			
			if (inputStream != null) {
				prop.load(inputStream);
				returnPropertyValue =prop.getProperty("folderName");
			} else {
				logger.error("Property file "+propFileName+" not found..");
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			
		} catch (FileNotFoundException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnPropertyValue;
	}

	/*public static String getPropertyValue(String key) {
		return configProp.getProperty(key);
	}*/
}