package com.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityMethods
{
	public static int i,rowCount;
	static XSSFRow row;
	static XSSFWorkbook wb;
	static XSSFSheet sh1;
	protected static String LName,FName,Gender,Address,ZipCode,City,PhoneNo,DDOB;
	protected static double DOB;
	
	public static void ReadExcel() throws IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\InfoCampus\\JavaSourceCode\\HealthCareApplication\\Patient_Details.xlsx");
		wb = new XSSFWorkbook(fis);
		sh1=wb.getSheetAt(0);
		rowCount=sh1.getLastRowNum();
		System.out.println("no.of rows is:"+rowCount);
		
		for(i=1;i<=rowCount;i++)
		{
			LName=sh1.getRow(i).getCell(0).getStringCellValue();
			FName=sh1.getRow(i).getCell(1).getStringCellValue();
			DOB=sh1.getRow(i).getCell(2).getNumericCellValue();
		//	DDOB=DOB.toString();
			Gender=sh1.getRow(i).getCell(3).getStringCellValue();	
			Address=sh1.getRow(i).getCell(0).getStringCellValue();
			ZipCode=sh1.getRow(i).getCell(1).getStringCellValue();
			City=sh1.getRow(i).getCell(2).getStringCellValue();
			PhoneNo=sh1.getRow(i).getCell(3).getStringCellValue();
		}
	}
}
