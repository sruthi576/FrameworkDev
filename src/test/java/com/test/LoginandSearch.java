package com.test;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.driver.Driver;
import com.pages.Login_Pages;
import com.pages.Search_Pages;
import com.util.ReadPropertiesFile;

public class LoginandSearch extends Driver{
	Properties prop = ReadPropertiesFile.readPropertiesFile("config.properties");
	public Login_Pages login_pages;
	public Search_Pages search_pages;
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
	}
	
	@BeforeClass()
	public void initialization() {
		Driver.init("Chrome");
		Driver.driver.get(prop.getProperty("URL"));
		Driver.driver.manage().window().maximize();
	}
	
	@Test(priority =1,groups= {"Sanity","Regression"})
	public void login_Negative() throws InterruptedException {
		login_pages = new Login_Pages();
		login_pages.username_Field("santoshg53@gmail.com");
		login_pages.password_Field("nvjdnsjvnjfn");
		login_pages.login_Field();
		Thread.sleep(5000);
		Assert.assertEquals(login_pages.alert_Msg(), "Your username or password is incorrect");
	}
	
	@Test(priority =2,enabled =false)
	public void login_Positive() throws InterruptedException {
		login_pages = new Login_Pages();
		search_pages = new Search_Pages();
		login_pages.username_Field("santoshg53@gmail.com");
		//login_pages.password_Field();
		login_pages.password_Field("tendulkar@10");
		login_pages.login_Field();
		Thread.sleep(5000);
		boolean flag = search_pages.search_TextField();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority =3)
	public void search() throws InterruptedException {
		search_pages = new Search_Pages();
		login_pages = new Login_Pages();
		login_pages.login_close_button();
		search_pages.search_TextField("Mobiles");
		search_pages.search_Button();
		Thread.sleep(5000);
		String actualValue = search_pages.mobiles_Text_Field();
		
		Assert.assertEquals(actualValue, "Mobiles");
	}
	
	@AfterClass
	public void quit() {
		Driver.driver.quit();
	}

}
