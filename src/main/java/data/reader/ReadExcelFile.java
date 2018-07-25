package data.reader;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelFile {
	public int i, j;
	public int rowCnt, colCnt;
	public XSSFWorkbook wBook;
	public XSSFSheet sheet;
	public Object[][] retData;

	@Test
	public Object[][] readExcel(String fileName) throws IOException
	{
		wBook = new XSSFWorkbook("./data/"+ fileName +".xlsx");
		sheet = wBook.getSheetAt(0);
		rowCnt = sheet.getLastRowNum();
		colCnt = sheet.getRow(0).getLastCellNum();
		retData = new Object[rowCnt][colCnt];
		for (i=1; i<=rowCnt; i++)
		{
			XSSFRow currentRow = sheet.getRow(i);
			for (j=0; j<colCnt; j++)
			{
				XSSFCell currentCell = currentRow.getCell(j);
				String cellValue = currentCell.getStringCellValue();
				System.out.println(cellValue);
				retData[i-1][j] = cellValue;
			}
		}
//		wBook.close();
		return retData;
	}
	
	@Test
	public void writeExcel(int colNum, String value)
	{
		sheet.getRow(i).createCell(colNum).setCellValue(value);
	}
}
