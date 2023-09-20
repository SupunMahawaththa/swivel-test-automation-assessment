/**
 @author Supun Mahawaththa
 */
package com.testautomation.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.qa.base.TestBase;

public class pg_ShoppingCart extends TestBase {

	// Go to Cart Button
	@FindBy(xpath = "(//a[normalize-space()='Go to Cart'])[2]")
	public WebElement btn_GoToCart;
	// Product Title Label
	@FindBy(xpath = "//h1[normalize-space()='Shopping Cart']/../../following-sibling::form/div/following-sibling::div/div/following-sibling::div[2]/div/following-sibling::div[3]/div/div[2]/ul/li/span/a/span/span")
	public WebElement lbl_ProductTitle;
	// Sub Total Label
	@FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/span")
	public WebElement lbl_SubTotal;
	// Quantity Label
	@FindBy(xpath = "(//span[@aria-label='Quantity']/../following-sibling::span)[2]")
	public WebElement lbl_Quantity;
	// Delete Link
	@FindBy(xpath = "//input[@value='Delete']")
	public WebElement lnk_Delete;
	
	public pg_ShoppingCart() {
			PageFactory.initElements(driver, this);
		}

}
