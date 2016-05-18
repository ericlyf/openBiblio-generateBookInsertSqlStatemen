package org.fgs.openBiblio.sqlstatement;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;


public class BookInsertSqlStatementTest {

	@Test
	public void test() {
		Book book = createMockBook();
		IInsertSqlStatement<Book> insertStatement = new BookInsertSqlStatement();
		String statement = insertStatement.statement(book);
		
		assertTrue(result().equals(statement));
	}
	
	private Book createMockBook(){
		String bibid = "1";
		String author = "黃懺華 等著";
		String title = "佛教宗派源流";
		String title_remainder = "新時代出版社";
		String call_nmbr1 = "B030.7";
		String barcodeNmbr = "000013";
		Book book = mock(Book.class);
		when(book.getBibid()).thenReturn(bibid);
		when(book.getAuthor()).thenReturn(author);
		when(book.getTitle()).thenReturn(title);
		when(book.getTitle_remainder()).thenReturn(title_remainder);
		when(book.getCall_nmbr1()).thenReturn(call_nmbr1);
		when(book.getBarcodeNmbr()).thenReturn(barcodeNmbr);
		return book;
	}
	
	private String result() {
		StringBuilder result = new StringBuilder();
		result.append(expBiblioInsert()).append("\n");
		result.append(expBiblioCopyInsert());
		return result.toString();
	}
	
	private String expBiblioInsert(){
		StringBuilder builder = new StringBuilder("INSERT INTO biblio ");
		builder.append("(bibid,create_dt,last_change_dt,last_change_userid,material_cd,collection_cd,call_nmbr1,title,title_remainder,author,opac_flg) ");
		builder.append("VALUES ");
		builder.append("(1,'2016-03-22 11:28:44','2016-03-22 11:28:44',1,2,2,'B030.7','佛教宗派源流','新時代出版社','黃懺華 等著','Y') ;");
		return builder.toString();
		
	}
	
	private String expBiblioCopyInsert(){
		StringBuilder builder = new StringBuilder("INSERT INTO biblio_copy ");
		builder.append("(bibid,create_dt,barcode_nmbr,status_cd,status_begin_dt,renewal_count) ");
		builder.append("VALUES ");
		builder.append("(1,'2016-03-22 11:29:02','000013','in','2016-03-22 11:29:32',0) ;");
		return builder.toString();
		
	}

}
