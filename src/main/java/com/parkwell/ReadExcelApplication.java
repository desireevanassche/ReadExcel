package com.parkwell;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReadExcelApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ReadExcelApplication.class, args);

		File myFile = new File("/Users/desireevanassche/dogz.xlsx");

		FileInputStream fis = new FileInputStream(myFile);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

		Iterator<Cell> cellIterator = row.cellIterator();
		
		while (cellIterator.hasNext()) { 
			Cell cell = cellIterator.next(); 
			
			switch(cell.getCellType()) {
			
			case Cell.CELL_TYPE_STRING: 
				System.out.println(cell.getStringCellValue() + "\t");
				break; 
				
			case Cell.CELL_TYPE_NUMERIC:
				System.out.println(cell.getNumericCellValue() + "\t");
			break; 
			
			case Cell.CELL_TYPE_BOOLEAN: 
				System.out.println(cell.getNumericCellValue() + "\t");
			}
		}
			System.out.println(" ");
		}
		}
	} 