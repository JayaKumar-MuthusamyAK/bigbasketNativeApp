package com.bigbasket.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bigbasket.keywords.Keywords;
import com.bigbasket.testutils.TestUtils;

public class TC_001_SearchListingPageTestCases {
	
	@Test
	public void searchListingPageTestCases() throws Exception{
		
		if(!TestUtils.isTestcasesExecutable("searchListingPageTestCases", Keywords.xls)){
			throw new SkipException("Test case runmode is no");
		}
		
		Keywords k = Keywords.getInstance();
		k.executeKeywords("searchListingPageTestCases",null);
	}

	
}
