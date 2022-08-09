package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		// Path of the excel file
		FileInputStream fs = new FileInputStream("./src/test/java/com/utils/TestDataCloned.xlsx");
		
		// Creating Object for the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		// Creating Object for the Sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		XSSFCell value = sheet.getRow(0).getCell(0);
		System.out.println("Set 1: "+value);
//		or
		Row rowA = sheet.getRow(0);
		Cell cellA = rowA.getCell(0);
		System.out.println("Set 1: "+cellA);
		
		System.out.println("Set 2: "+sheet.getRow(1).getCell(1));
//		or
		Row rowB = sheet.getRow(1);
		Cell cellB = rowB.getCell(1);
		System.out.println("Set 2: "+cellB);
		
		System.out.println("Set 3: "+sheet.getRow(6).getCell(1));
//		or
		Row rowC = sheet.getRow(6);
		Cell cellC = rowC.getCell(1);
		System.out.println("Set 3: "+cellC);
		
		System.out.println("Read from Empty Cell: "+sheet.getRow(4).getCell(2));
		
		

	}

}
