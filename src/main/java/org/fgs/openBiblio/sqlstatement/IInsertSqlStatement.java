package org.fgs.openBiblio.sqlstatement;

public interface IInsertSqlStatement<T> {
	public String statement(T t);

}
