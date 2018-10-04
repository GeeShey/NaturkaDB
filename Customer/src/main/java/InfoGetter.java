//This class gets the variable "daysOverDue" along with the purchase ids from the sheet "supplyInfo"
//This class also gets the customer ids from the sheet "PurchaseInfo"
//Get the daysPending till supply from int[] daysPendingTillSupply()
//Get the purchase ids from int[] purchaseId()
//Get the customer ids from int[] getCustomerIds
//Get the stillSubscribed[] from boolean[] getStillSubscribed
//Note:
//		Sometimes a nullpointerException can be solved by clearing the contents of empty cells

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InfoGetter {
	public static String fileName, filePath;
	public static Sheet supplyInfoSheet;
	public static Workbook guru99Workbook;

	public InfoGetter(String fName, String fPath) {
		fileName = fName;
		filePath = fPath;
	}

	public static String sheetName = "SupplyInfo";

	public static int[] daysPendingTillSupply() throws IOException {
		initializer();
		int rowCount = (supplyInfoSheet.getLastRowNum() - supplyInfoSheet.getFirstRowNum());
		int daysOverdue[] = new int[rowCount];
		System.out.println("rows: " + rowCount);

		// storing the daysOverdue valuse in an int
		for (int i = 0; i < rowCount; i++) {

			daysOverdue[i] = (int) supplyInfoSheet.getRow(i + 1).getCell(4).getNumericCellValue();

			System.out.println(daysOverdue[i]);
		}

		return daysOverdue;

	}

	public static int[] purchaseId() throws IOException {

		initializer();
		int rowCount = (supplyInfoSheet.getLastRowNum() - supplyInfoSheet.getFirstRowNum());
		int purchase_id[] = new int[rowCount];
		System.out.println("rows: " + rowCount);

		// storing the daysOverdue valuse in an int
		for (int i = 0; i < rowCount; i++) {

			purchase_id[i] = (int) supplyInfoSheet.getRow(i + 1).getCell(0).getNumericCellValue();

			// System.out.println(purchase_id[i]);
		}

		return purchase_id;

	}

	public static void initializer() throws IOException {
		// testing purposes

		// Create an object of File class to open xlsx file

		File file = new File(filePath + "/" + fileName);
		System.out.println((filePath + "/" + fileName));

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		guru99Workbook = null;

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

		supplyInfoSheet = guru99Workbook.getSheet(sheetName);

	}

	public static int[] getCustomerIds() throws IOException {

		// gets the customer ids in the order they are written in the excel file(not in
		// accordance to the purchase ids)
		// assuming that the purchase ids are unique and in sequential order in the
		// sheet "PurchaseInfo"
		initializer();
		Sheet PurchaseInfoSheet = guru99Workbook.getSheet("PurchaseInfo");
		int customerIds[] = new int[PurchaseInfoSheet.getLastRowNum()];
		int rowCount = PurchaseInfoSheet.getLastRowNum();
		System.out.println("rows: " + rowCount);

		// storing the customer_ids values in an int
		for (int i = 0; i < rowCount; i++) {

			customerIds[i] = (int) PurchaseInfoSheet.getRow(i + 1).getCell(1).getNumericCellValue();

			// System.out.println(customerIds[i]);
		}

		return customerIds;

	}

	public static boolean[] getStillSubscribed() throws IOException {
		// gets the customer ids in the order they are written in the excel file(not in
		// accordance to the purchase ids)
		// assuming that the purchase ids are unique and in sequential order in the
		// sheet "PurchaseInfo"
		initializer();
		int rowCount = (supplyInfoSheet.getLastRowNum() - supplyInfoSheet.getFirstRowNum());
		boolean stillSubscribed[] = new boolean[rowCount];
		System.out.println("rows: " + rowCount);

		// storing the daysOverdue valuse in an int
		for (int i = 0; i < rowCount; i++) {

			stillSubscribed[i] = supplyInfoSheet.getRow(i + 1).getCell(5).getBooleanCellValue();

			// System.out.println(purchase_id[i]);
		}

		return stillSubscribed;

	}

}
