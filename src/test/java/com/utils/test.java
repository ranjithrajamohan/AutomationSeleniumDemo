package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.utils.XlsReader;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dateFor = "dd_MM_yyyy_HH_mm_ss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFor);
		Date date = new Date();
		System.out.println("Date: "+date);
		String dateAndTime = dateFormat.format(date);
		System.out.println("DateAndTime: " + dateAndTime);
		
		XlsReader excelData = new XlsReader("./src/test/java/MasterTestData.xlsx");
		System.out.println(excelData.getCellData("Employee Data", 0, 5));
		System.out.println(excelData.getCellData("Employee Data", "Role", 5));
		System.out.println(excelData.getCellRowNum("Employee Data", "Role", "UI Dev"));
		System.out.println(excelData.getColumnCount("Employee Data"));
		System.out.println(excelData.getRowCount("Employee Data"));
		System.out.println(excelData.isSheetExist("Employee Data"));
		System.out.println(excelData.isSheetExist("Employee Data1"));
		excelData.setCellData("Employee Data", "Role", 16, "Test");
		System.out.println(excelData.getCellData("Employee Data", 1, 16));
		excelData.addColumn("Employee Data", "CreateColumnByScript");
		excelData.addSheet("CreateSheetByScript");
		
		

	}

}
