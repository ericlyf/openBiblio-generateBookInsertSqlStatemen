package org.fgs.openBiblio.sqlstatement;

public class BiblioInsertSqlStatement extends InsertSqlStatement<IBiblio> {

	@Override
	protected String getTableName() {
		return "biblio";
	}

	@Override
	protected String getColumns() {
		String columns = "bibid,create_dt,last_change_dt,last_change_userid,material_cd,collection_cd,"
				+ "call_nmbr1,title,title_remainder,author,opac_flg";
		return columns;
	}

	@Override
	protected String getValues(IBiblio biblio) {
		String values = biblio.getBibid()
				+","
				+ "'2016-03-22 11:28:44','2016-03-22 11:28:44',1,2,2,"
				+ super.formateValue(biblio.getCall_nmbr1())
				+ ","
				+ super.formateValue(biblio.getTitle())
				+ ","
				+ super.formateValue(biblio.getTitle_remainder())
				+ ","
				+ super.formateValue(biblio.getAuthor())
				+ ",'Y'";
		return values;
	}

}
