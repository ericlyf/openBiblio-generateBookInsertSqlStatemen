package org.fgs.openBiblio.sqlstatement;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class BookTest {

	@Test
	public void testCreateBookByRow() {
		String bibid = "1";
		String barcodeNmbr = "000013";
		String title = "佛教宗派源流";
		String author = "黃懺華 等著";
		String title_remainder = "新時代出版社";
		String call_nmbr1 = "B030.7";
		Row row = mock(Row.class);
		short startCellNum = row.getFirstCellNum();
		Cell bibidCell = mock(Cell.class);
		when(bibidCell.getStringCellValue()).thenReturn(bibid);
		when(row.getCell(startCellNum++)).thenReturn(bibidCell);
		Cell barcodeNmbrCell = mock(Cell.class);
		when(barcodeNmbrCell.getStringCellValue()).thenReturn(barcodeNmbr);
		when(row.getCell(startCellNum++)).thenReturn(barcodeNmbrCell);
		Cell titleCell = mock(Cell.class);
		when(titleCell.getStringCellValue()).thenReturn(title);
		when(row.getCell(startCellNum++)).thenReturn(titleCell);
		Cell authorCell = mock(Cell.class);
		when(authorCell.getStringCellValue()).thenReturn(author);
		when(row.getCell(startCellNum++)).thenReturn(authorCell);
		Cell titleRecell = mock(Cell.class);
		when(titleRecell.getStringCellValue()).thenReturn(title_remainder);
		when(row.getCell(startCellNum++)).thenReturn(titleRecell);
		Cell callCell = mock(Cell.class);
		when(callCell.getStringCellValue()).thenReturn(call_nmbr1);
		when(row.getCell(startCellNum++)).thenReturn(callCell);
		
		Book book = new Book(row);
		
		boolean verifyBibid = bibid.equals(book.getBibid());
		boolean verifyBarcodeNmbr = barcodeNmbr.equals(book.getBarcodeNmbr());
		boolean verifyTitle = title.equals(book.getTitle());
		boolean verifyAuthor = author.equals(book.getAuthor());
		boolean verifyTitleRemainder = title_remainder.equals(book.getTitle_remainder());
		boolean verifyCallNmbr = call_nmbr1.equals(book.getCall_nmbr1());
		assertTrue(verifyBibid && verifyBarcodeNmbr && verifyTitle && verifyAuthor && verifyTitleRemainder && verifyCallNmbr);
		
	}

}
