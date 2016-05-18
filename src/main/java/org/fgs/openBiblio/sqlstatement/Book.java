package org.fgs.openBiblio.sqlstatement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Book implements IBiblio, IBiblioCopy {
	private final String bibid;
	private final String author;
	private final String title;
	private final String title_remainder;
	private final String call_nmbr1;
	private final String barcodeNmbr;

	public Book(Row row) {
		short startCellNum = row.getFirstCellNum();
		this.bibid = getCell(row,startCellNum++).getStringCellValue().trim();
		this.barcodeNmbr = getCell(row,startCellNum++).getStringCellValue().trim();
		this.title = getCell(row,startCellNum++).getStringCellValue().trim();
		this.author = getCell(row,startCellNum++).getStringCellValue().trim();
		this.title_remainder = getCell(row,startCellNum++).getStringCellValue().trim();
		this.call_nmbr1 = getCell(row,startCellNum++).getStringCellValue().trim();
	}
	
	private CustomeCell getCell(Row row, short cellNum){
		Cell cell = row.getCell(cellNum);
		return new CustomeCell(cell);
	}

	public String getBibid() {
		return bibid;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getTitle_remainder() {
		return title_remainder;
	}

	public String getCall_nmbr1() {
		return call_nmbr1;
	}

	public String getBarcodeNmbr() {
		return barcodeNmbr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((barcodeNmbr == null) ? 0 : barcodeNmbr.hashCode());
		result = prime * result + ((bibid == null) ? 0 : bibid.hashCode());
		result = prime * result
				+ ((call_nmbr1 == null) ? 0 : call_nmbr1.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((title_remainder == null) ? 0 : title_remainder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.getAuthor()))
			return false;
		if (barcodeNmbr == null) {
			if (other.barcodeNmbr != null)
				return false;
		} else if (!barcodeNmbr.equals(other.getBarcodeNmbr()))
			return false;
		if (bibid == null) {
			if (other.bibid != null)
				return false;
		} else if (!bibid.equals(other.getBibid()))
			return false;
		if (call_nmbr1 == null) {
			if (other.call_nmbr1 != null)
				return false;
		} else if (!call_nmbr1.equals(other.getCall_nmbr1()))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.getTitle()))
			return false;
		if (title_remainder == null) {
			if (other.title_remainder != null)
				return false;
		} else if (!title_remainder.equals(other.getTitle_remainder()))
			return false;
		return true;
	}
	
	private static class CustomeCell{
		private Cell cell;
		public CustomeCell(Cell cell){
			this.cell = cell;
			initStringCellType();
		}
		private void initStringCellType(){
			if(cell != null){
				cell.setCellType(Cell.CELL_TYPE_STRING);
			}
		}
		public String getStringCellValue(){
			return cell != null?cell.getStringCellValue():"";
		}
	}
}
