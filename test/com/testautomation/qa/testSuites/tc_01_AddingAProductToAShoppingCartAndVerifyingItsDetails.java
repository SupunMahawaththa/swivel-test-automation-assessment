package com.testautomation.qa.testSuites;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testautomation.qa.base.TestBase;
import com.testautomation.qa.buisnessComponents.lib_Common;
import com.testautomation.qa.buisnessComponents.lib_Product;
import com.testautomation.qa.buisnessComponents.lib_ProductDetail;
import com.testautomation.qa.buisnessComponents.lib_ShoppingCart;

public class tc_01_AddingAProductToAShoppingCartAndVerifyingItsDetails extends TestBase {
	lib_Common lib_Common;
	lib_Product lib_Product;
	lib_ProductDetail lib_ProductDetail;
	lib_ShoppingCart lib_ShoppingCart;

	public String filePath = System.getProperty("user.dir") + "/dataTable/dataTable.xlsx";
	public String sheetName = "dt_01";

	public tc_01_AddingAProductToAShoppingCartAndVerifyingItsDetails() {
		super();
	}

	@DataProvider(name = "readExcel")
	public Object[][] readExcel() throws InvalidFormatException, IOException {

		return TestBase.readExcel(filePath, sheetName);
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		lib_Common = new lib_Common();
		lib_Product = new lib_Product();
		lib_ProductDetail = new lib_ProductDetail();
		lib_ShoppingCart = new lib_ShoppingCart();
	}

	@Test(dataProvider = "readExcel")
	public void AddingAProductToAShoppingCartAndVerifyingItsDetails(String category_Book, String keyword_Automation,
			String rating_LevelFourStar, String language_English, String item_Number, String quantity) throws InterruptedException {
		// Adding A Product To A Shopping Cart And Verifying Its Details
		// Start of tc_01_AddingAProductToAShoppingCartAndVerifyingItsDetails
		writeToLog("Start of tc_01_AddingAProductToAShoppingCartAndVerifyingItsDetails");
		// Selecting ‘Books’ from the Category list and Searching for the search term “Automation”
		lib_Common.bc_SelectingACategoryAndSearchingAProduct(category_Book, keyword_Automation);
		// Selecting Customer Reviews as “4 Stars & Up” and Selecting Language as “English"
		lib_Common.bc_ApplyingFiltersForAProduct(rating_LevelFourStar, language_English);
		// Navigating to second item from the product list
		lib_Product.NavigatingAItemFromTheProductList(item_Number);
		// Retrieve Item Name from the NavigatingAItemFromTheProductList
		String itemName = lib_Product.GetItemName();
		// Verifying Product Detail page informations and Adding Product to Cart
		lib_ProductDetail.AddingAItemToCart(quantity, itemName);
		// Retrieve Unit Price from the AddingAItemToCart
		String unitPrice = lib_ProductDetail.GetProductUntiPrice();
		// Verifying the Cart Details
		lib_ShoppingCart.VerifyingTheCartDetails(quantity, itemName, unitPrice);
		// End of tc_01_AddingAProductToAShoppingCartAndVerifyingItsDetails
		writeToLog("End of tc_01_AddingAProductToAShoppingCartAndVerifyingItsDetails");
	}

	@AfterMethod
	public void end() {
		driver.quit();
	}
}
