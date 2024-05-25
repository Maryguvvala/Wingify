package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Data_Fetching 
{
	public static String valid_username;
	public static String valid_pwd;
	

	public void fetch_data() throws EncryptedDocumentException, IOException 
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\KING\\eclipse-workspace\\Wingify_Assignment\\Get_Data\\excel_data.xlsx");
		Workbook wb = WorkbookFactory.create(f1);
		valid_username = wb.getSheet("login").getRow(0).getCell(1).getStringCellValue();
		valid_pwd = wb.getSheet("login").getRow(1).getCell(1).getStringCellValue();
		
	}
}
