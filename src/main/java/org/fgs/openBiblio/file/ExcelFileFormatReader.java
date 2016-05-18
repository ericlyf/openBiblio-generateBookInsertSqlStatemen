package org.fgs.openBiblio.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ExcelFileFormatReader<T> implements IFileFormatReader<T> {
	private String filePath = "";
	private List<T> objectList = Collections.emptyList();
	private final String EXCEL_XLS = "xls";
	private final String EXCEL_XLSX = "xlsx";

	public boolean canHandle(String filePath) {
		if(filePath.endsWith(EXCEL_XLS) || filePath.endsWith(EXCEL_XLSX)){
			this.filePath = filePath;
			return true;
		}else{
			this.filePath = null;
			return false;
		}
		
	}

	private Workbook loadWorkbook(InputStream in) throws IOException{
		// Using XSSF for xlsx format, for xls use HSSF
		if(filePath.endsWith(EXCEL_XLS)){
			return new HSSFWorkbook(in);
		}else if(filePath.endsWith(EXCEL_XLSX)){
			return new XSSFWorkbook(in);
		}else{
			throw new RuntimeException("the file is not surrpoted");
		}
	}
	public void loadData() throws IOException{
		objectList = new ArrayList<T>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			Workbook workbook = loadWorkbook(fis);
			int numberOfSheets = workbook.getNumberOfSheets();
			// looping over each workbook sheet
			for (int i = 0; i < numberOfSheets; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rowIterator = sheet.iterator();
				// iterating over each row
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					objectList.add(createRowObject(row));
				}
			}
		} finally {
			if (fis != null) {
				fis.close();
			}
		}

	}
	protected abstract T createRowObject(Row row);
		
	public Iterator<T> getRowObjects() {
		return objectList.iterator();
	}
}
