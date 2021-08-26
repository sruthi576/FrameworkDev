package com.test;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.driver.Driver;
import com.util.ReadPropertiesFile;

public class FrameworkTest {
	
	Properties prop = ReadPropertiesFile.readPropertiesFile("config.properties");
	
	@BeforeClass
	public void beforeClass() {
		Driver.init(prop.getProperty("Browser"));
		Driver.driver.get(prop.getProperty("URL"));
	}
	
	@Test
	public void test() {
		
	}
}
