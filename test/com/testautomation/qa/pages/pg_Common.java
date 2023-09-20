/**
 @author Supun Mahawaththa
 */
package com.testautomation.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.qa.base.TestBase;

public class pg_Common extends TestBase {
	// Object Repository for Common Page:
	// Search Dropdown
	@FindBy(id = "searchDropdownBox")
	public WebElement dd_SearchDropdownBox;
	// Search Bar
	@FindBy(xpath = "//input[@placeholder='Search Amazon']")
	public WebElement ele_Search;
	// Search Button
	@FindBy(id = "nav-search-submit-button")
	public WebElement btn_Search;
	// Customer Reviews Filter
	public WebElement ele_FilterCustomerReviews(String txt_RatingLevel) {
		return driver.findElement(By.xpath("//span[text()='Customer Reviews']/../following-sibling::ul/span/li/span/a/section[@aria-label='" + txt_RatingLevel + "']"));
	}
	// Language Filter
	public WebElement ele_FilterLanguage(String txt_Language) {
		return driver.findElement(By.xpath("//span[text()='Language']/../following-sibling::ul/span/li/span/a/div/following-sibling::span[text()='" + txt_Language + "']"));
	}
	
	public pg_Common() {

		PageFactory.initElements(driver, this);

	}

}