package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {

	public String readFile(String filepath) {
		String st = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath)); 
			while ((st = br.readLine()) != null)
				return st;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public void writeFile(String data, String filepath) {
		try {
			FileWriter writer = new FileWriter(filepath);  
			BufferedWriter buffer = new BufferedWriter(writer);  
			buffer.write(data);  
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	public static ArrayList<String> getData(String filepath, String sheetname, String data) {
			
		ArrayList<String> arraylist = new ArrayList<String>();
			try {			
				FileInputStream fis = new FileInputStream(filepath);
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				
				//This will give the number of sheets present in our workbook
				int sheets = workbook.getNumberOfSheets();
				
				//This will iterate each sheet one by one
				for(int i=0; i<sheets; i++) {
					if(workbook.getSheetName(i).equalsIgnoreCase(sheetname)) {
						XSSFSheet sheet = workbook.getSheetAt(i);
						
						//Identify column by scanning the entire 1st row
						//Iterate each and every row in that sheet
						Iterator<Row> rows = sheet.iterator();	//Sheet is a collection of rows
						Row firstrow = rows.next();
						Iterator<Cell> cells = firstrow.cellIterator();	//Row is a collection of cells
						int k=0;
						int column=0;
						//This will check if next cell is present but it will not move
						while(cells.hasNext()) {
							//This will move to next cell
							Cell value = cells.next();
							if(value.getStringCellValue().equalsIgnoreCase("Fields")){
								column = k;
							}
							k++;
						}
						System.out.println(column);
						
						//Once row is identified then scan entire column
						while(rows.hasNext()) {
							Row row = rows.next();
							if(row.getCell(column).getStringCellValue().equalsIgnoreCase(data)){
								//Once cell is grab pull all the data of the row
								Iterator<Cell> cell = row.cellIterator();
								while(cell.hasNext()) {
									Cell next = cell.next();
									
									//This condition has been given to take both kinds of data
									if(next.getCellTypeEnum()==CellType.STRING) {
										arraylist.add(next.getStringCellValue());
									}
									else if(next.getCellTypeEnum()==CellType.NUMERIC) {
										arraylist.add(NumberToTextConverter.toText(next.getNumericCellValue()));
									}
									else {
										//This will convert numeric value to string value
										arraylist.add(NumberToTextConverter.toText(next.getNumericCellValue()));
									}
								}
							}
						}
					}
				}
				workbook.close();
				return arraylist;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return arraylist;
	}

	public static void putData(String filepath, String sheetname, int rownum, int cellnum, String data) {
		try {
			File src = new File(filepath);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheetname);
			sh.getRow(rownum).createCell(cellnum).setCellValue(data);
			FileOutputStream fot = new FileOutputStream(src);
			wb.write(fot);
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
