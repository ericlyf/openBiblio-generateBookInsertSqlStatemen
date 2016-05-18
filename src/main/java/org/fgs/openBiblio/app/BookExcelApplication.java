package org.fgs.openBiblio.app;

import java.io.IOException;
import java.util.Iterator;

import org.fgs.openBiblio.service.BookExcelService;
import org.fgs.openBiblio.service.IExcelService;
import org.fgs.openBiblio.sqlstatement.Book;

public class BookExcelApplication {

	public static void main(String[] args) throws IOException {
		String excelFilePath = "src/main/resources/fgslibrary.xls";
		IExcelService<Book> service = new BookExcelService();
		Iterator<String> insertSqlStatements = service.parse(excelFilePath);
		while(insertSqlStatements.hasNext()){
			System.out.println(insertSqlStatements.next());
		}

	}

}
