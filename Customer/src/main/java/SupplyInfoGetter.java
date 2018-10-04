

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SupplyInfoGetter {
	public static String fileName, filePath;
	public static Sheet supplyinfoSheet;

	public SupplyInfoGetter(String fName, String fPath) {
		// fileName="Workbook1.xlsx";
		// filePath="/Users/vediccoimbatore/Desktop";
	}

	public static String sheetName = "SupplyInfo";

	public static int[] daysPendingTillSupply() throws IOException {
		inializer();
		int rowCount = (supplyinfoSheet.getLastRowNum() - supplyinfoSheet.getFirstRowNum());
		int daysOverdue[] = new int[rowCount];
		System.out.println("rows: " + rowCount);

		// storing the daysOverdue valuse in an int
		for (int i = 0; i < rowCount; i++) {

			daysOverdue[i] = (int) supplyinfoSheet.getRow(i + 1).getCell(4).getNumericCellValue();

			// System.out.println(daysOverdue[i]);
		}

		return daysOverdue;

	}

	public static int[] purchaseId() throws IOException {

		inializer();
		int rowCount = (supplyinfoSheet.getLastRowNum() - supplyinfoSheet.getFirstRowNum());
		int purchase_id[] = new int[rowCount];
		System.out.println("rows: " + rowCount);

		// storing the daysOverdue valuse in an int
		for (int i = 0; i < rowCount; i++) {

			purchase_id[i] = (int) supplyinfoSheet.getRow(i + 1).getCell(0).getNumericCellValue();

			 //System.out.println(purchase_id[i]);
		}

		return purchase_id;

	}

	public static void inializer() throws IOException {
		// testing purposes
		fileName = "Workbook1.xlsx";
		filePath = "/Users/vediccoimbatore/Desktop";

		// Create an object of File class to open xlsx file

		File file = new File(filePath + "/" + fileName);
		System.out.println((filePath + "/" + fileName));

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			guru99Workbook = new XSSFWorkbook(inputStream);

		}

		// Check condition if the file is xls file

		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of XSSFWorkbook class

			guru99Workbook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name

		supplyinfoSheet = guru99Workbook.getSheet(sheetName);

	}

	public static void main(String[] args) throws IOException {

		purchaseId();

	}

}
