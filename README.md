# openBiblio-generateBookInsertSqlStatemen
to generate insert sql statement from a excel for table biblio and biblio_copy, it can be extended to support the migration from the old system's data to openbiblio

1. import books:
-------------------------------
the book information is from the spread sheet:
the id, the qr code , the title, the author, the publisher , the call number
-------
716,	B0000795,	GREAT BOOKS OF THE WESTERN WOR,	 Robert Maynard Hutchins, Edit,	 Encyclopaedia Britannica	, GE808.8

----------------------------------------------------
two insert sql statment will be generate from above book information:
one for biblio, and one for biblio. 
----------------

2. it is easily extensilbe to generte different insert sql statment for different tables:
---------------------------------------------
abstract class InsertSqlStatement<T> , 
public interface IExcelService<T> , 
public abstract class ExcelFileFormatReader<T>



