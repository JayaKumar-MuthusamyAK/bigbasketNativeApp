package com.bigbasket.keywords;



import java.util.Hashtable;
import java.util.logging.Logger;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.apache.log4j.PropertyConfigurator;

import com.bigbasket.excelreader.Xls_Reader;
import com.bigbasket.testbase.TestBase;


public class Keywords extends TestBase{
	
	public static Xls_Reader xls = new Xls_Reader(
			System.getProperty("user.dir") + "/src/main/java/com/bigbasket/testdata/Test Suite1.xlsx");
	public static final Logger log = Logger.getLogger(Keywords.class.getName());
	
	public static Keywords keywords = null;

	CommonAppKeywords commonkeywords;
	ApplDepenededKeywords appdpendendKeywords;
	
	public void executeKeywords(String testcases, Hashtable<String, String> data) throws Exception {
		
		/*this.testCasesName=testcases;*/
		loadproperties();
		PropertyConfigurator.configure("log4j.properties");
		//System.out.println("Executable test cases is :" + testcases);
		logg("Executable test cases name is :" + testcases);
		String keyword = null;
		String objectkeys = null;
		String datakeys = null;

		commonkeywords= new CommonAppKeywords();
		appdpendendKeywords = new ApplDepenededKeywords();
		
		for (int rNum = 2; rNum <= xls.getRowCount("Test Steps"); rNum++) {
			if (testcases.equals(xls.getCellData("Test Steps", "TCID", rNum))) {
				keyword = xls.getCellData("Test Steps", "Keyword", rNum);
				objectkeys = xls.getCellData("Test Steps", "Object", rNum);
				datakeys = xls.getCellData("Test Steps", "Data", rNum);
				
				//System.out.println(keyword + "--" + objectkeys + "--" + datakeys);
				logg(keyword + "--" + objectkeys + "--" + datakeys);
				String result = null;
				
				
				switch(keyword) {
				
				case "choosePhone":
					result=  commonkeywords.choosePhone(datakeys);
					break;
				case "click":
					result = datakeys.isEmpty()?commonkeywords.click(objectkeys):appdpendendKeywords.click(datakeys); 
					break;
				case "waitForElementPresent":
					result = commonkeywords.waitForElementPresent(objectkeys);
					break;
				case "type":
					result = commonkeywords.type(objectkeys,datakeys);
					break;
				case "addProduct":
					result = commonkeywords.addProduct(objectkeys,datakeys);
					break;
				default:
					logg("Method is not Matching");
					break;
				}
				
					
			}
		}
	}
			
			public void logg(String data){
				
				System.out.println(data);
				log.info(data);
			}
			
			public static Keywords getInstance(){
				
				if(keywords==null)
					try{
						keywords = new Keywords();
					}catch(Exception e){
						e.getMessage();
					}
				return keywords;
				
			}
	
}
