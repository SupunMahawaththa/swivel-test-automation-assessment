/**
 @author Supun Mahawaththa
 */
package com.testautomation.qa.buisnessComponents;

import com.testautomation.qa.base.TestBase;
import com.testautomation.qa.pages.pg_ShoppingCart;

public class lib_ShoppingCart extends TestBase {
	public void VerifyingTheCartDetails(String quantity, String itemName, String unitPrice) {
		pg_ShoppingCart shoppingCart= new pg_ShoppingCart();
		// Start of VerifyingTheCartDetails
		writeToLog("Start of VerifyingTheCartDetails");
		// Verify Item Name
		verifyText(shoppingCart.lbl_ProductTitle, itemName);
		// Verify Quantity
		verifyText(shoppingCart.lbl_Quantity, quantity);
		// Retrieve Unit Price Which Previously Stored
		String unitPriceWithDollar[] = unitPrice.split("\\$");
		String unitPriceWithOutDollar = unitPriceWithDollar[1];
		// Get the Sub Total
		 String SubTotal = String.valueOf(Float.valueOf(unitPriceWithOutDollar) * Float.valueOf(quantity));
		 // Concatenate Again $ to Total
		 String SubtotalWithDollar = "$"+ SubTotal;
		// Verify Total Price
		verifyText(shoppingCart.lbl_SubTotal, SubtotalWithDollar);
		// Clear the cart
		click(shoppingCart.lnk_Delete);
		// Verify the Total Amount is Equal to $0.00
		verifyText(shoppingCart.lbl_SubTotal, "$0.00");
		// End of End of VerifyingTheCartDetails
		writeToLog("End of VerifyingTheCartDetails");
	}
}
