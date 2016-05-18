package org.fgs.openBiblio.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.fgs.openBiblio.file.BookExcelFileFormatReader;
import org.fgs.openBiblio.file.IFileFormatReader;
import org.fgs.openBiblio.sqlstatement.Book;
import org.fgs.openBiblio.sqlstatement.BookInsertSqlStatement;
import org.fgs.openBiblio.sqlstatement.IInsertSqlStatement;

public class BookExcelService implements IExcelService<Book> {
	private IFileFormatReader<Book> reader;
	private IInsertSqlStatement<Book> sqlStatement;
	
	public BookExcelService(){
		this.reader = new BookExcelFileFormatReader();
		this.sqlStatement = new BookInsertSqlStatement();
	}

	public void setFileFormatReader(IFileFormatReader<Book> reader) {
		this.reader = reader;
		
	}

	public void setInsertSqlStatement(IInsertSqlStatement<Book> sqlStatement) {
		this.sqlStatement = sqlStatement;
		
	}

	public Iterator<String> parse(String excelFilePath) throws IOException {
		if(reader.canHandle(excelFilePath)){
			reader.loadData();
			Iterator<Book> books = reader.getRowObjects();
			List<String> insertSqlStatements = new ArrayList<String>();
			while(books.hasNext()){
				String insertSqlStatement = sqlStatement.statement(books.next());
				insertSqlStatements.add(insertSqlStatement);
			}
			return insertSqlStatements.iterator();
		}
		return Collections.emptyIterator();
	}

}
