package com.crmfaa.qa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.sun.media.sound.InvalidFormatException;

public class TestUtil {
	
	public static long IMPLICT_WAIT =10;
	public static WebDriver driver;
	
	//created one String type variable and stored the path of file.
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\tiwar\\eclipse-workspace\\WebdriverTest\\src\\main\\java\\com"
			                                    +"\\crmfaa\\qa\\testdata\\CRMTestData.xlsx";
	//Apache POI predefined classes initialize with variable.
	static Workbook book;
	static Sheet sheet;
	
	//created one method with the returning type as two dimensional array.
	public static Object [][] getTestData(String sheetName){ 
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch (FileNotFoundException e){
			e.printStackTrace();		
		}
		try {
			//Apache POI predefined classes.
			book = new XSSFWorkbook(file);		//XSSFWorkbook(file); tried this but not issue not fixed.
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object [][] data =  new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i < sheet.getLastRowNum(); i++) {
			for (int k =0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data [i][k] = sheet.getRow(i+1).getCell(k).toString();
				
			}
		}
		
		return data;
	}
		//this is template method for taking screenshot and this method i am calling into WebEventListener class in case if some error comes.
		//public static void takeScreenshotAtEndOfTest() throws IOException {
			//File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//String currentDir = System.getProperty("user.dir");
			//FileUtils.copyFile(scrfile, new File(currentDir +"/screenshot/" +System.currentTimeMillis()+".png"));
			
		}



