package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driver.Driver;

public class Search_Pages extends Driver{
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement search_field;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement search_button;
	
	@FindBy(xpath = "//a[@title='Mobiles']")
	WebElement mobiles_Text;
	
	public Search_Pages() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void search_TextField(String search_value) {
		search_field.sendKeys(search_value);
	}
	
	public boolean search_TextField() {
		return search_field.isDisplayed();
	}
	
	public void search_Button() {
		search_button.click();
	}
	
	public String mobiles_Text_Field() {
		return mobiles_Text.getText();
	}
}
