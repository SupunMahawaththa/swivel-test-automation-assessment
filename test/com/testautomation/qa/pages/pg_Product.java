/**
 @author Supun Mahawaththa
 */
package com.testautomation.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.qa.base.TestBase;

public class pg_Product extends TestBase {
	// Product List Item
	public WebElement lnk_ProductListItem(String item_Number) {
		return driver.findElement(By.xpath("(//span[text()='Results']/../../../../../following-sibling::div/div/div/div/div/div/div/following-sibling::div/div/div/div[1]/h2/a/span)["+item_Number+"]"));
	}
	public pg_Product() {
		PageFactory.initElements(driver, this);
	}
}

