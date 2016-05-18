package org.fgs.openBiblio.file;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.fgs.openBiblio.sqlstatement.Book;
import org.junit.Test;

public class BookExcelFileFormatReaderTest {

	@Test
	public void testLoadXLSFile() throws IOException {
		String filePathXls = "src/test/resources/xlsbook.xls";
		Iterator<Book> books = loadExcelFile(filePathXls);
		assertTrue(equal(books,mockBooks()));
	}
	
	private static <T> boolean equal(Iterator<T> oneIter, Iterator<T> twoIter){
		while(oneIter.hasNext() && twoIter.hasNext()){
			if(!oneIter.next().equals(twoIter.next())){
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testLoadXLSXFile() throws IOException {
		String filePathXlsx = "src/test/resources/xlsxbook.xlsx";
		Iterator<Book> books = loadExcelFile(filePathXlsx);
		assertTrue(equal(books,mockBooks()));
		
	}

	/**
	 * @param filePathXlsx
	 * @throws IOException
	 */
	private Iterator<Book> loadExcelFile(String filePathXlsx) throws IOException {
		IFileFormatReader<Book> reader = new BookExcelFileFormatReader();
		if(reader.canHandle(filePathXlsx)){
			reader.loadData();
			return reader.getRowObjects();
		};
		return Collections.emptyIterator();
	}
	
	private Iterator<Book> mockBooks(){
		Iterator<Book> books = mock(Iterator.class);
		when(books.hasNext()).thenReturn(true,false);
		Book book = createMockBook();
		when(books.next()).thenReturn(book);
		return books;
	}
	
	private Book createMockBook(){
		String bibid = "1";
		String author = "黃懺華 等著";
		String title = "佛教宗派源流";
		String title_remainder = "常春樹書坊";
		String call_nmbr1 = "B030.7";
		String barcodeNmbr = "566";
		Book book = mock(Book.class);
		when(book.getBibid()).thenReturn(bibid);
		when(book.getAuthor()).thenReturn(author);
		when(book.getTitle()).thenReturn(title);
		when(book.getTitle_remainder()).thenReturn(title_remainder);
		when(book.getCall_nmbr1()).thenReturn(call_nmbr1);
		when(book.getBarcodeNmbr()).thenReturn(barcodeNmbr);
		return book;
	}

}
