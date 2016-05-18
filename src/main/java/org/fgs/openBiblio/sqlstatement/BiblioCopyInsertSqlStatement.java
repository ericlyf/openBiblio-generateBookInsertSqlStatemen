package org.fgs.openBiblio.sqlstatement;

public class BiblioCopyInsertSqlStatement extends InsertSqlStatement<IBiblioCopy> {

	@Override
	protected String getTableName() {
		return "biblio_copy";
	}

	@Override
	protected String getColumns() {
		return "bibid,create_dt,barcode_nmbr,status_cd,status_begin_dt,renewal_count";
	}

	@Override
	protected String getValues(IBiblioCopy biblioCopy) {
		String values = biblioCopy.getBibid() + 
				"," +
				"'2016-03-22 11:29:02',"
				+ super.formateValue(biblioCopy.getBarcodeNmbr())
				+ ",'in','2016-03-22 11:29:32',0";

		return values;
	}

}
