package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class DataParsing {

   public Object[][] parseExcel() throws IOException {

        FileInputStream file=new FileInputStream("C:\\Users\\2457784\\IdeaProjects\\Health_Index_Calculator\\TestData\\TestData.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheet("Sheet2");
        int rows=sheet.getLastRowNum();
        int cols=sheet.getRow(1).getLastCellNum();

        Object[][] dataObject=new Object[rows][cols];

       DataFormatter formatter=new DataFormatter();
        for(int i=1;i<=rows;i++){
            XSSFRow currRow=sheet.getRow(i);
            for(int j=0;j<cols;j++){
                XSSFCell cell=currRow.getCell(j);
                dataObject[i-1][j]=formatter.formatCellValue(cell);
            }
        }

        return dataObject;
    }
}
