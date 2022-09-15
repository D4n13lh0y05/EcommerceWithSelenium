package com.project.test;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

public class BaseTest {
	
	static WebDriver driver = null; 


  @BeforeSuite
  public static void beforeClass() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader("src/test/resources/config.properties"));
		System.setProperty("webdriver.gecko.driver",properties.getProperty("firefox_webriver_path"));
		driver = new FirefoxDriver();
		driver.get(properties.getProperty("url_base"));
  }
  
  @AfterSuite
  public void afterClass() {
	//driver.quit();
  }

}
