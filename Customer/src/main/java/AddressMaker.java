//this class returns a string[] of customer addresses wrt the customer_ids passed

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//this class gets the customer ids and creates a string with the contact info for each customer ds
public class AddressMaker {
	
	public static String fileName, filePath;
	public static Sheet personalInfo;
	int[] customerIds;
	
	
	public static InfoGetter x = new InfoGetter(fileName,filePath);
	
	public AddressMaker(String fName, String fPath,int[] customer_ids) {
		fileName = fName;
		filePath = fPath;
		customerIds=customer_ids;
	}
	
	//returns customerAdresses in accordance to the given customer ids.	
	public static String[] getCustomerAddresses(int[] customer_id) throws IOException {
	    //customerIds=x.getCustomerIds();
		initializer();
		int rowCount = (personalInfo.getLastRowNum() - personalInfo.getFirstRowNum());
		String addresses[] = new String[customer_id.length];
		System.out.println("rows: " + rowCount);

		// checking if customer id matches and getting the address respectively
		
		for(int j =0;j<customer_id.length;j++){
			
			
		
		for (int i = 0; i < rowCount; i++) {
			if(customer_id[j]==(int)personalInfo.getRow(i + 1).getCell(0).getNumericCellValue()) {
				addresses[j] = (personalInfo.getRow(i + 1).getCell(1).getStringCellValue() + "\n"
						+ personalInfo.getRow(i + 1).getCell(2).getStringCellValue()	 + "\n"
						+ personalInfo.getRow(i + 1).getCell(3).getStringCellValue() + "\n"
						+ personalInfo.getRow(i + 1).getCell(4).getStringCellValue());
				System.out.println(customer_id[j]);
				System.out.println(addresses[j]);
				System.out.println("---------------"); 
				break;
				
			}
			


		}
		}
		

		return addresses;

	}
	
	public static void initializer() throws IOException {
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

		personalInfo = guru99Workbook.getSheet("PersonalInfo");

	}

}
