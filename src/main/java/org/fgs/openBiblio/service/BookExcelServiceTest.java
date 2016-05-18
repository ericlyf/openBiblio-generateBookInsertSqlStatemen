package org.fgs.openBiblio.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Iterator;

import org.fgs.openBiblio.file.IFileFormatReader;
import org.fgs.openBiblio.sqlstatement.Book;
import org.fgs.openBiblio.sqlstatement.IInsertSqlStatement;
import org.junit.Test;

public class BookExcelServiceTest {

	@Test
	public void test() throws IOException {
		String excelFilePath = "";
		IFileFormatReader<Book> reader = mock(IFileFormatReader.class);
		when(reader.canHandle(excelFilePath)).thenReturn(true);
		Iterator<Book> books = mock(Iterator.class);
		when(books.hasNext()).thenReturn(true,false);
		Book book = mock(Book.class);
		when(books.next()).thenReturn(book);
		when(reader.getRowObjects()).thenReturn(books);
		IInsertSqlStatement<Book> sqlStatement = mock(IInsertSqlStatement.class);
		String statement = "insert";
		when(sqlStatement.statement(book)).thenReturn(statement);
		
		IExcelService<Book> service = new BookExcelService();
		service.setFileFormatReader(reader);
		service.setInsertSqlStatement(sqlStatement);
		Iterator<String> insertBookSqlStatements = service.parse(excelFilePath);
		
		assertTrue( insertBookSqlStatements.next() == statement && insertBookSqlStatements.hasNext() == false);
	}

}
