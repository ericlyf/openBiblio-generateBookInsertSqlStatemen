package org.fgs.openBiblio.service;

import java.io.IOException;
import java.util.Iterator;

import org.fgs.openBiblio.file.IFileFormatReader;
import org.fgs.openBiblio.sqlstatement.IInsertSqlStatement;

public interface IExcelService<T> {

	void setFileFormatReader(IFileFormatReader<T> reader);

	void setInsertSqlStatement(IInsertSqlStatement<T> sqlStatement);

	Iterator<String> parse(String excelFilePath) throws IOException;

}
