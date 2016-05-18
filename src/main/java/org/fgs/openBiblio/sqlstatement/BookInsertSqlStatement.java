package org.fgs.openBiblio.sqlstatement;

public class BookInsertSqlStatement implements IInsertSqlStatement<Book> {
	private IInsertSqlStatement<IBiblio> biblio;
	private IInsertSqlStatement<IBiblioCopy> biblioCopy;

	public BookInsertSqlStatement(){
		this.biblio = new BiblioInsertSqlStatement();
		this.biblioCopy = new BiblioCopyInsertSqlStatement();
	
	}
	
	private String insertSqlStatementForBiblioCopy(IBiblioCopy biblioCopy){
		return this.biblioCopy.statement(biblioCopy);
	}
	
	private String insertSqlStatementForBiblio(IBiblio biblio){
		return this.biblio.statement(biblio);
	}

	public String statement(Book book) {
		StringBuilder statement = new StringBuilder();
		statement.append(insertSqlStatementForBiblio(book)).append("\n");
		statement.append(insertSqlStatementForBiblioCopy(book));
		return statement.toString();
	}


	public void setBiblio(IInsertSqlStatement<IBiblio> biblio) {
		this.biblio = biblio;
	}

	public void setBiblioCopy(IInsertSqlStatement<IBiblioCopy> biblioCopy) {
		this.biblioCopy = biblioCopy;
	}
	
	

}
