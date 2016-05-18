package org.fgs.openBiblio.sqlstatement;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class BiblioInsertSqlStatementTest {

	@Test
	public void testInsert() {
		String bibid = "1";
		String author = "黃懺華'' 等著";
		String title = "佛教宗派源流";
		String title_remainder = "新時代出版社";
		String call_nmbr1 = "B030.7";
		IBiblio biblio = mock(IBiblio.class);
		when(biblio.getBibid()).thenReturn(bibid);
		when(biblio.getAuthor()).thenReturn(author);
		when(biblio.getTitle()).thenReturn(title);
		when(biblio.getTitle_remainder()).thenReturn(title_remainder);
		when(biblio.getCall_nmbr1()).thenReturn(call_nmbr1);
		IInsertSqlStatement<IBiblio> statment = InsertSqlStatement.biblio();
		String insertStatment = statment.statement(biblio);
		String expInsertStatment = expInsert();
		assertTrue(insertStatment.equals(expInsertStatment));
		
	}
	
	private String expInsert(){
		StringBuilder builder = new StringBuilder("INSERT INTO biblio ");
		builder.append("(bibid,create_dt,last_change_dt,last_change_userid,material_cd,collection_cd,call_nmbr1,title,title_remainder,author,opac_flg) ");
		builder.append("VALUES ");
		builder.append("(1,'2016-03-22 11:28:44','2016-03-22 11:28:44',1,2,2,'B030.7','佛教宗派源流','新時代出版社','黃懺華\\'\\' 等著','Y') ;");
		return builder.toString();
		
	}

}
