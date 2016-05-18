package org.fgs.openBiblio.file;

import org.apache.poi.ss.usermodel.Row;
import org.fgs.openBiblio.sqlstatement.Book;

public class BookExcelFileFormatReader extends ExcelFileFormatReader<Book> {

	@Override
	protected Book createRowObject(Row row) {
		return new Book(row);
	}

}
