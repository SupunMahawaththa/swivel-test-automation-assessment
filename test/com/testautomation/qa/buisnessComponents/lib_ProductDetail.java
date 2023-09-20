/**
 @author Supun Mahawaththa
 */
package com.testautomation.qa.buisnessComponents;

import com.testautomation.qa.base.TestBase;
import com.testautomation.qa.pages.pg_ProductDetail;
import com.testautomation.qa.pages.pg_ShoppingCart;

public class lib_ProductDetail extends TestBase {

	private String unit_Price;

	public String GetProductUntiPrice() {
		return unit_Price;
	}

	public void AddingAItemToCart(String quantity, String itemName) throws InterruptedException {
		pg_ProductDetail productDetail = new pg_ProductDetail();
		pg_ShoppingCart shoppingCart = new pg_ShoppingCart();
		// Start of AddingAItemToCart
		writeToLog("Start of AddingAItemToCart");
		// Wait Until Page is Loading
		explicitWait(3000, productDetail.btn_AddToCart);
		// Get and Store the Unit price
		this.unit_Price = jsGetText(productDetail.lbl_UnitPrice);
		// Verify whether the item name of the Product Detail page is same as the item name
		verifyText(productDetail.lbl_ProductTitle, itemName);
		// Set the Quantity
		select(productDetail.dd_ProductQuantity, quantity);
		// Click on Add to Cart Button
		click(productDetail.btn_AddToCart);
		// Wait Until Page is Loading
		pause(2000);
		// Click on Go to Cart Button
		click(shoppingCart.btn_GoToCart);
		// End of AddingAItemToCart
		writeToLog("End of AddingAItemToCart");
	}
	
}
