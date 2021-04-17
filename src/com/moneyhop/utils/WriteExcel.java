package com.moneyhop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	int loop = 0;
	public String excelPathWrite = "E:\\Aifmetrics-Workspace\\Aifmetrics\\ExcelReport\\ProdDumpData.xlsx";
	public String destination = "E:\\Aifmetrics-Workspace\\Aifmetrics\\ExcelReport\\" + System.currentTimeMillis()
			+ "ProdDumpData.xlsx";

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	int writeRowIndex;

	public WriteExcel() throws IOException {

		/* FileUtils.copyFile(new File(excelPathWrite), new File(destination)); */
		File src = new File(excelPathWrite);
		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);

	}

	public int createRow(int SheetIndex, int getSheetAt, boolean resetIndex) throws IOException {

		sheet = workbook.getSheetAt(SheetIndex);

		if (resetIndex) {

			writeRowIndex = workbook.getSheetAt(getSheetAt).getFirstRowNum();

		} else {
			
			writeRowIndex = workbook.getSheetAt(getSheetAt).getLastRowNum();

		}

		writeRowIndex++;
		sheet.createRow(writeRowIndex);

		return writeRowIndex;

	}

	public void xlsFistRow(int SheetIndex, int getSheetAt) throws IOException {

		File src = new File(excelPathWrite);

		FileInputStream fis = new FileInputStream(src);

		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(SheetIndex);

		writeRowIndex = workbook.getSheetAt(getSheetAt).getFirstRowNum();
		writeRowIndex++;
		sheet.createRow(writeRowIndex);

	}

	public void xlsOutput() {

		try {

			FileOutputStream out = new FileOutputStream(new File(excelPathWrite));
			workbook.write(out);
			out.close();
			System.out.println("data has been updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeDashBoard(String aum, String nav, String XIRR, String BENCHMARK) throws IOException {

		createRow(0, 0, false);

		sheet.getRow(writeRowIndex).createCell(0).setCellValue(aum);
		sheet.getRow(writeRowIndex).createCell(1).setCellValue(nav);
		sheet.getRow(writeRowIndex).createCell(2).setCellValue(XIRR);
		sheet.getRow(writeRowIndex).createCell(3).setCellValue(BENCHMARK);

		xlsOutput();
	}

	public void writePerformance(String Units, String nav, String currentValue, String Return, String TVPI)
			throws IOException {

		createRow(1, 1, false);
		sheet.getRow(writeRowIndex).createCell(0).setCellValue(Units);
		sheet.getRow(writeRowIndex).createCell(1).setCellValue(nav);
		sheet.getRow(writeRowIndex).createCell(2).setCellValue(currentValue);
		sheet.getRow(writeRowIndex).createCell(3).setCellValue(Return);
		sheet.getRow(writeRowIndex).createCell(4).setCellValue(TVPI);

		xlsOutput();
	}

	public void longOnlywritePerformance(String inceptionDate, String nav, String currentAUM, String Benchmark)
			throws IOException {

		createRow(6, 6, false);
		sheet.getRow(writeRowIndex).createCell(0).setCellValue(inceptionDate);
		sheet.getRow(writeRowIndex).createCell(1).setCellValue(nav);
		sheet.getRow(writeRowIndex).createCell(2).setCellValue(currentAUM);
		sheet.getRow(writeRowIndex).createCell(3).setCellValue(Benchmark);
		xlsOutput();
	}

	public void longOnlywritePerformanceREtrns(String addComputeVal) throws IOException {

		createRow(7, 7, false);
		sheet.getRow(writeRowIndex).createCell(0).setCellValue(addComputeVal);
		xlsOutput();
	}

	public void longOnlywritePerformanceREtrnsval(String addComputeVal, int loopCount) throws IOException {

		sheet = workbook.getSheetAt(7);
		sheet.getRow(loopCount).createCell(1).setCellValue(addComputeVal);

		xlsOutput();
	}

	public void longOnlywritePerformanceREtrnsBenchmark(String addVal, int loopCount) throws IOException {

		sheet = workbook.getSheetAt(7);
		sheet.getRow(loopCount).createCell(2).setCellValue(addVal);

		xlsOutput();
	}

	public void longOnlywritePerformanceMeasures(String addVal) throws IOException {

		createRow(8, 8, false);
		sheet.getRow(writeRowIndex).createCell(0).setCellValue(addVal);

		xlsOutput();
	}

	public void longOnlywritePerformanceFund(String addVal, int loopCount) throws IOException {

		sheet = workbook.getSheetAt(8);
		sheet.getRow(loopCount).createCell(1).setCellValue(addVal);

		xlsOutput();
	}
	


	public void writePerformanceSummary(String totalCommitment, String totalVal, String unfunded, String distributor,
			String growth, String funded, String residualVal) throws IOException {

		createRow(2, 2, false);
		sheet.getRow(writeRowIndex).createCell(0).setCellValue(totalCommitment);
		sheet.getRow(writeRowIndex).createCell(1).setCellValue(totalVal);
		sheet.getRow(writeRowIndex).createCell(2).setCellValue(unfunded);
		sheet.getRow(writeRowIndex).createCell(3).setCellValue(distributor);
		sheet.getRow(writeRowIndex).createCell(4).setCellValue(growth);
		sheet.getRow(writeRowIndex).createCell(5).setCellValue(funded);
		sheet.getRow(writeRowIndex).createCell(6).setCellValue(residualVal);

		xlsOutput();
	}

	public void writeVDPortFolioCompanyName(String Company) throws IOException {

		createRow(3, 3, false);
		sheet.getRow(writeRowIndex).createCell(0).setCellValue(Company);

		xlsOutput();
	}

	public void writeVDPortFolioDebt(String debt, int companyCount) throws IOException {
		sheet = workbook.getSheetAt(3);
		sheet.getRow(companyCount).createCell(1).setCellValue(debt);

		xlsOutput();
	}

	public void writeStatementInvestor(String investor, String email) throws IOException {

		createRow(4, 4, false);
		sheet.getRow(writeRowIndex).createCell(0).setCellValue(investor);
		sheet.getRow(writeRowIndex).createCell(1).setCellValue(email);

		xlsOutput();
	}

	public void writeStatementInvestorVal(String capitalCommitment, String fundedcommitment, String unfundedCommitment,
			String Distribution) throws IOException {

		sheet = workbook.getSheetAt(4);
		sheet.getRow(writeRowIndex).createCell(2).setCellValue(capitalCommitment);
		sheet.getRow(writeRowIndex).createCell(3).setCellValue(fundedcommitment);
		sheet.getRow(writeRowIndex).createCell(4).setCellValue(unfundedCommitment);
		sheet.getRow(writeRowIndex).createCell(5).setCellValue(Distribution);

		xlsOutput();
	}

	public void writeVCPortFolioCompanyName(String Company) throws IOException {

		createRow(5, 5, false);
		sheet.getRow(writeRowIndex).createCell(0).setCellValue(Company);

		xlsOutput();
	}

	public void writeVCPortFolioDebt(String debt, int companyCount) throws IOException {

		sheet = workbook.getSheetAt(5);
		sheet.getRow(companyCount).createCell(1).setCellValue(debt);

		xlsOutput();
	}

	public void createrowWrite(int sheetAt, int cellNo, String val) throws IOException {

		createRow(sheetAt, sheetAt, false);
		sheet.getRow(writeRowIndex).createCell(cellNo).setCellValue(val);

		xlsOutput();
	}

	public void increaceRowWrite(int sheetAt, int cellNo, String val, int companyCount) throws IOException {

		sheet = workbook.getSheetAt(sheetAt);
		sheet.getRow(companyCount).createCell(cellNo).setCellValue(val);

		xlsOutput();
	}

}
