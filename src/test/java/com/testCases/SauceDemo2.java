package com.testCases;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.objectsRepo.LocatorsRepo;
import com.utils.XlsReader;
import com.objectsRepo.ContentRepo;

public class SauceDemo2 extends BaseClass {

	@Test
	public void testForSauceDemo() {
		
		try {
			
			LocatorsRepo object = new LocatorsRepo(driver);
			ContentRepo content = new ContentRepo();
			CommonMethods common = new CommonMethods();
			System.out.println("driver Value: "+driver);
			/*
			 * System.out.println(common.randomString("alphaNumeric", 10));
			 * System.out.println(common.randomString("numeric", 40));
			 * System.out.println(common.randomString("alpha", 100));
			 */
			
			
			 XlsReader excelData = new
			 XlsReader("./src/test/java/com/utils/MasterTestData.xlsx");
			 System.out.println("value 1: "+excelData.getCellData("Employee Data", 0, 5));
			 System.out.println("value 2: "+excelData.getCellData("Employee Data", "Role",5)); 
			 System.out.println("value 3: "+excelData.getCellRowNum("Employee Data","Role", "UI Dev"));
			 System.out.println("value 4: "+excelData.getColumnCount("Employee Data"));
			 System.out.println("value 5: "+excelData.getRowCount("Employee Data"));
			 System.out.println("value 6: "+excelData.isSheetExist("Employee Data"));
			 System.out.println("value 7: "+excelData.isSheetExist("Employee Data1"));
//			 excelData.setCellData("Employee Data", "Role", 16, "Test");
			 System.out.println("value 8: "+excelData.getCellData("Employee Data", 1, 16)); 
//			 excelData.addColumn("Employee Data", "CreateColumnByScript");
//			 excelData.addSheet("CreateSheetByScript");
			 
			 loginSauceDemo();
			 
			System.out.println("Sauce Demo app is launched");
//			testReport.log(Status.PASS, "Sauce Demo app is launched and ready to be tested");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			testReport.log(Status.FAIL, "Test is failed");
			Assert.assertTrue(false);
		}
	}

}
