
package com.moneyhop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	static XSSFWorkbook wb = null;
	static XSSFSheet sh = null;
	static XSSFCellStyle my_style;
	static String description = "";
	static String className = "";
	static String fundName = "";
	static String remark = "";
	static String category = "";
	static String area = "";
	static String status = "";
	static String browserName = "";
	final static String ExcelReportPath = "./ExcelReport/AifMetricsAutomationReport.xlsx";
	final static String AifExcelData = "./AifExcelData/AifLoginData.xlsx";

	public Excel(String description, String className,String fundName, String remark, String category, String area, String status,
			String browserName) {
		Excel.description = description;
		Excel.className = className;
		Excel.fundName = fundName;
		Excel.remark = remark;
		Excel.category = category;
		Excel.area = area;
		Excel.status = status;
		Excel.browserName = browserName;
	}

	public void testdata(String description,String fundName, String acTyp, String remark, String expectedAction, String area,
			String status, String browserName, int sheetNbr) throws IOException {

		FileInputStream fis = new FileInputStream(new File(ExcelReportPath));

		wb = new XSSFWorkbook(fis);

		sh = wb.getSheetAt(sheetNbr);
		my_style = wb.createCellStyle();
		my_style.setFillForegroundColor(IndexedColors.RED.getIndex());
		my_style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// System.out.println(sh.getRow(0).getCell(0).getStringCellValue());

		System.out.println("sheet open");
		System.out.println("Status: " + status);
		System.out.println("Browser: " + browserName);

		// For Description

		int row = findRow(sh, description);
		System.out.println("Row number" + row);
		// row++;
		int col = 0;
		System.out.println("Row number = " + row);

		// @SuppressWarnings("unused")
		// String desc = null;

		if (browserName.equalsIgnoreCase("chrome")) {
			col = 6;

		} else if (browserName.equalsIgnoreCase("firefox")) {
			col = 7;

		} else if (browserName.equalsIgnoreCase("IE")) {
			col = 8;
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			col = 9;
		}

		System.out.println("Col-->" + col);

		if (row == 0) {
			int rown = sh.getLastRowNum();
			System.out.println("Last Row = " + rown);
			rown++;

			sh.createRow(rown);
			sh.getRow(rown).createCell(0).setCellValue(description);
			sh.getRow(rown).createCell(1).setCellValue(fundName);
			sh.getRow(rown).createCell(2).setCellValue(acTyp);
			sh.getRow(rown).createCell(4).setCellValue(expectedAction);
			sh.getRow(rown).createCell(5).setCellValue(area);
			sh.getRow(rown).createCell(col).setCellValue(status);

			// String temp = null;
			if (status.equals("Fail") || status.equals("fail")) {

				// Cell c = sh.getRow(rown).getCell(2);

				// sh.getRow(rown).getCell(col).setCellStyle(my_style);

				// temp = sh.getRow(row+1).getCell(2).getStringCellValue();

				System.out.println("Remark = " + remark);
				// if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
				sh.getRow(rown).createCell(3).setCellValue(browserName + ":" + remark + "...");
				// }
				// else{

				// temp = sh.getRow(row).getCell(2).getStringCellValue();
				// sh.getRow(row).createCell(2).setCellValue(temp + browser + ":" + remark +
				// "...");
				sh.getRow(rown).getCell(col).setCellStyle(my_style);

				// }
			}
		} else {

			System.out.println("Row value = " + row);

			sh.getRow(row).createCell(col).setCellValue(status);

			String temp = null;

			if (status.equals("Fail") || status.equals("fail")) {

				Cell c = sh.getRow(row).getCell(3);
				sh.getRow(row).getCell(col).setCellStyle(my_style);
				// temp = sh.getRow(row+1).getCell(2).getStringCellValue();

				if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
					sh.getRow(row).createCell(3).setCellValue(browserName + ":" + remark + "...");
				} else {

					temp = sh.getRow(row).getCell(3).getStringCellValue();
					sh.getRow(row).createCell(3).setCellValue(temp + browserName + ":" + remark + "...");
					sh.getRow(row).getCell(col).setCellStyle(my_style);

				}
			}
		}

		// For saving the excel sheet
		FileOutputStream fos = new FileOutputStream(new File(ExcelReportPath));
		wb.write(fos);

		fos.close();
	}

	private static int findRow(XSSFSheet sh, String cellContent) {
		for (Row row : sh) {
			for (Cell cell : row) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {

						System.out.println(cell.getRichStringCellValue().getString().trim());
						System.out.println(cellContent);
						return row.getRowNum();
					}
				}
			}
		}

		return 0;
	}

	public static Object readExcelFile(int indexSheet, int rowValue, int colValue, String file) throws IOException {
		String data = "";

		File filePath = new File(file);
		try {
			FileInputStream ReadFilePath = new FileInputStream(filePath);

			wb = new XSSFWorkbook(ReadFilePath);
			XSSFSheet sheet = wb.getSheetAt(indexSheet);

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						//System.out.print(cell.getNumericCellValue() + " | ");
						break;
					case Cell.CELL_TYPE_STRING:
						//System.out.print(cell.getStringCellValue() + " | ");
						break;
					}
				}
				System.out.println("");
			}

			data = sheet.getRow(rowValue).getCell(colValue).getStringCellValue();
			System.out.println("PKM----" + data);
			ReadFilePath.close();

		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		}catch(NullPointerException e){
		  
		}
		return data;
	}

	
	public static int getRowCount(int sheetIndex,String excelFile) {
		
		File filePath = new File(excelFile);

		FileInputStream ReadFilePath = null;
		try {
			ReadFilePath = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(ReadFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		return row;

	}
}