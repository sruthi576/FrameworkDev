package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	public static WebDriver driver;

	public static void init(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\executables\\firefoxdriver.exe");
			driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\executables\\edgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\executables\\IEdriver.exe");
			driver = new InternetExplorerDriver();
		}
	}

}

/// chrome , CHROME
// Firefox 2.x version default , 3.x