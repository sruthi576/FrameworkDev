package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driver.Driver;

public class Login_Pages extends Driver {

	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit'][@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement login_button;

	@FindBy(xpath = "//span[@class='_2YULOR']")
	WebElement alert_msg;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement close;

	public Login_Pages() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void username_Field(String username_Value) {
		username.sendKeys(username_Value);
	}

	public void password_Field(String password_Value) {
		password.sendKeys(password_Value);
	}

	public void password_Field() {
		password.clear();
	}

	public void login_Field() {
		login_button.click();
	}

	public void login_close_button() {
		close.click();
	}

	public boolean login_Field_Displayed() {
		return login_button.isDisplayed();
	}

	public String alert_Msg() {
		return alert_msg.getText();
	}
}
