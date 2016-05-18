package org.fgs.openBiblio.sqlstatement;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class BiblioCopyInsertSqlStatementTest {

	@Test
	public void testInsert() {
		String bibid = "1";
		String barcodeNmbr = "000013";
		IBiblioCopy biblioCopy = mock(IBiblioCopy.class);
		when(biblioCopy.getBibid()).thenReturn(bibid);
		when(biblioCopy.getBarcodeNmbr()).thenReturn(barcodeNmbr);
		IInsertSqlStatement<IBiblioCopy> insertStatement = InsertSqlStatement.biblioCopy();
		String statement = insertStatement.statement(biblioCopy);
		assertTrue(statement.equals(expInsert()));
	}
	
	private String expInsert(){
		StringBuilder builder = new StringBuilder("INSERT INTO biblio_copy ");
		builder.append("(bibid,create_dt,barcode_nmbr,status_cd,status_begin_dt,renewal_count) ");
		builder.append("VALUES ");
		builder.append("(1,'2016-03-22 11:29:02','000013','in','2016-03-22 11:29:32',0) ;");
		return builder.toString();
		
	}
}
