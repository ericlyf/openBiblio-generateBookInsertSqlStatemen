package org.fgs.openBiblio.sqlstatement;

public abstract class InsertSqlStatement<T> implements IInsertSqlStatement<T> {
	private static final String SPACE = " ";
	private static final String LEFT_BRACKET = "(";
	private static final String RIGHT_BRACKET = ") ";
	private static final String INSERT_INTO = "INSERT INTO ";
	private static final String VALUES = "VALUES ";
	private static final String FORMAT_VALUE = "'%s'";
	private static final String SPECIAL_MARK = "'";
	private static final String REPLACE_SPECIAL_MARK = "\\'";
	private static final String SQL_END = ";";
	
	public static IInsertSqlStatement<IBiblioCopy> biblioCopy() {
		return new BiblioCopyInsertSqlStatement();
	}
	
	public static IInsertSqlStatement<IBiblio> biblio() {
		return new BiblioInsertSqlStatement();
	}

	public String statement(T t) {
		StringBuilder insert = new StringBuilder(INSERT_INTO);
		insert.append(getTableName()).append(SPACE);
		insert.append(LEFT_BRACKET);
		insert.append(getColumns());
		insert.append(RIGHT_BRACKET);
		insert.append(VALUES);
		insert.append(LEFT_BRACKET);
		insert.append(getValues(t));
		insert.append(RIGHT_BRACKET);
		insert.append(SQL_END);
		return insert.toString();
	}
	
	protected abstract String getTableName();
	
	protected abstract String getColumns();
	
	protected abstract String getValues(T t);
	
	protected String formateValue(String value){
		String formatValue = value;
		if(value.contains(SPECIAL_MARK)){
			formatValue = value.replace(SPECIAL_MARK, REPLACE_SPECIAL_MARK);
		}
		return String.format(FORMAT_VALUE, formatValue);
	}
	

}
