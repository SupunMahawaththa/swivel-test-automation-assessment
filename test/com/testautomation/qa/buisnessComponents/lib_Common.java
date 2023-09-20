/**
 @author Supun Mahawaththa
 */
package com.testautomation.qa.buisnessComponents;

import com.testautomation.qa.base.TestBase;
import com.testautomation.qa.pages.pg_Common;

public class lib_Common extends TestBase {
	
	public void bc_SelectingACategoryAndSearchingAProduct(String Category, String search_Keyword) throws InterruptedException {
		pg_Common common = new pg_Common();
		// Start of bc_SelectingACategoryAndSearchingAProduc
		writeToLog("Start of bc_SelectingACategoryAndSearchingAProduct");
		// Select Category from the Category list
		select(common.dd_SearchDropdownBox, Category);
		// Search a Key Word
		type(common.ele_Search, search_Keyword);
		// Click on Search Button
		click(common.btn_Search);
		// End of bc_SelectingACategoryAndSearchingAProduct
		writeToLog("End of bc_SelectingACategoryAndSearchingAProduct");

	}
	
	public void bc_ApplyingFiltersForAProduct(String rating_Level, String language) throws InterruptedException {
		pg_Common common = new pg_Common();
		// Start of bc_ApplyingFiltersForAProduct
		writeToLog("Start of bc_ApplyingFiltersForAProduct");
		// Apply Customer Review Filter
		click(common.ele_FilterCustomerReviews(rating_Level));
		// Wait for Page Loading
		pause(2000);
		// Apply Language Filter
		click(common.ele_FilterLanguage(language));
		// End of bc_ApplyingFiltersForAProduct
		writeToLog("End of bc_ApplyingFiltersForAProduct");
	}
}


