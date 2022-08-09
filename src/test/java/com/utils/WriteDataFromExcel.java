package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String path = "./src/test/java/com/utils/TestDataCloned.xlsx";

		//		Get the Workbook file
		FileInputStream fs = new FileInputStream(path);

		// Open the file as Workbook
		Workbook wb = new XSSFWorkbook(fs);

		// Open the sheet
		Sheet sheet = wb.getSheetAt(0);

		// Write on existing cell
		sheet.getRow(12).getCell(1).setCellValue("HR");

		// Write on a new cell on the existing Row
		Row rowA = sheet.getRow(12);
		Cell cellA = rowA.createCell(2);
		cellA.setCellValue("Cell Value on Existing Row");
		//
		//		Write on a new cell on the existing Row
		Row rowB = sheet.createRow(13);
		Cell cellB = rowB.createCell(3);
		cellB.setCellValue("Cell Value on New Row");

		//		Add Employee Number for all Rows
		int lastRow = sheet.getLastRowNum();
		for(int i=0; i<=lastRow; i++){
			Row row = sheet.getRow(i);
			Cell cell = row.createCell(2);
			cell.setCellValue("Employee No: "+(i+1));
		}

		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
		System.out.println("Excel is updated with New Data");

	}

}
