package com.moneyhop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	int writeRowIndex;

	int loop = 0;
	public String excelPathWrite = "E:\\Aifmetrics-Workspace\\Aifmetrics\\ExcelReport\\ProdDumpData.xlsx";
	public String destination = "E:\\Aifmetrics-Workspace\\Aifmetrics\\ExcelReport\\" + System.currentTimeMillis()
			+ "ProdDumpData.xlsx";

	public Xls_Reader() throws IOException {

		/* FileUtils.copyFile(new File(excelPathWrite), new File(destination)); */
		File src = new File(excelPathWrite);
		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);

	}

	public XSSFSheet getSheetAt(int sheetnbr) {
		return sheet = workbook.getSheetAt(sheetnbr);
	}

	
	public int getlastrRowno(int sheetnbr) {
		int lstnbr= workbook.getSheetAt(sheetnbr).getLastRowNum();
		return lstnbr;
	}
}