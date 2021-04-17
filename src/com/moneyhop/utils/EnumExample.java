package com.moneyhop.utils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class EnumExample {

  
    public static final String sBasePath = "C://user/desktop/";

  
    public enum SheetHeader {NAME, PLACE, ANIMAL, THING}

    public static void main(String[] args) {

     
        writeToExcel("Hitesh.xlsx", 0, SheetHeader.NAME, new String[]{"RCB", "Virat", "Ab", "Gayle"});

    }


    public static void writeToExcel(String fileName, int sheetNumber, SheetHeader sheetHeader, String[] data) {
        try {
            InputStream fis = new FileInputStream(sBasePath + fileName);
            @SuppressWarnings("resource")
			Workbook book = new HSSFWorkbook(fis);
            Sheet sheet = book.getSheetAt(sheetNumber);
            int cellId = sheetHeader.ordinal();
            int lRowNum = sheet.getLastRowNum();


            @SuppressWarnings("unused")
			int rowId = sheet.getRow(lRowNum).getCell(cellId).toString().equals("") ? cellId : lRowNum + 1;

  

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}