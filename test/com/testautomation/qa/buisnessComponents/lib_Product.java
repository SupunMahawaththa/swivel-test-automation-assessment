/**
 @author Supun Mahawaththa
 */
package com.testautomation.qa.buisnessComponents;

import com.testautomation.qa.base.TestBase;
import com.testautomation.qa.pages.pg_Product;

public class lib_Product extends TestBase {
	private String item_Name;

	public String GetItemName() {
		return item_Name;
	}

	public void NavigatingAItemFromTheProductList(String item_Number) throws InterruptedException {
		pg_Product product = new pg_Product();
		// Start of NavigatingAItemFromTheProductList
		writeToLog("Start of NavigatingAItemFromTheProductList");
		// Wait for Page is Loading
		explicitWait(3000, product.lnk_ProductListItem(item_Number));
		// Get and Store the a Item Name
		this.item_Name = getText(product.lnk_ProductListItem(item_Number));
		// Click on the item from the Product List page
		click(product.lnk_ProductListItem(item_Number));
		// Wait for Page is Loading
		pause(2000);
		// End of SelectingTheSecondItemFromTheProductListAndAddToCart
		writeToLog("End of NavigatingAItemFromTheProductList");
	}

}
