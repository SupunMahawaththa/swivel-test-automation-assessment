/**
 * @author Supun Mahawaththa
 *
 */
package com.testautomation.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.qa.base.TestBase;

public class pg_ProductDetail extends TestBase {

	// Unit Price Label
	@FindBy(xpath = "(//div[@id='corePriceDisplay_desktop_feature_div']/style/following-sibling::div/span/following-sibling::span/span)[1] | //div[@id='corePrice_feature_div']/div/span/span/following-sibling::span")
	public WebElement lbl_UnitPrice;
	// Product Title 
	@FindBy(xpath = "//span[@id='productTitle']")
	public WebElement lbl_ProductTitle;
	// Product Quantity 
	@FindBy(xpath = "//select[@name='quantity']")
	public WebElement dd_ProductQuantity;
	// Add to Cart Button
	@FindBy(id = "add-to-cart-button")
	public WebElement btn_AddToCart;
	
	public pg_ProductDetail() {
		PageFactory.initElements(driver, this);
		
	}
}