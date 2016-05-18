package org.fgs.openBiblio.file;

import java.io.IOException;
import java.util.Iterator;

public interface IFileFormatReader<T> {

	boolean canHandle(String filePath);

	void loadData() throws IOException;

	Iterator<T> getRowObjects();

}
