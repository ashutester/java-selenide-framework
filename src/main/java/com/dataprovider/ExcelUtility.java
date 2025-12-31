package com.dataprovider;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import java.io.IOException;

public class ExcelUtility {

    static XSSFWorkbook wb;
    public static Object[][] getData(String sheetName){
        try{
          wb = new XSSFWorkbook(System.getProperty("user.dir")+"/Testdata/TestData.xlsx");

        } catch (IOException e) {
            System.out.println("Could not read excel"+e.getMessage());
        }
        XSSFSheet sheet = wb.getSheet(sheetName);
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();
        Object [][] arr = new Object[rows][cols];
        for (int i=0;i<rows;i++)
            for (int j = 0; j < cols; j++) {
                arr[i][j] = getCellData(sheetName, i, j);
            }
    return arr;
    }
    public static String getCellData(String sheetName,int row, int column){
        XSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(column);
        CellType cellType = cell.getCellType();
        String data = "";
        if(cellType==CellType.STRING){
            data = cell.getStringCellValue();
        }
        if(cellType==CellType.BOOLEAN){
            boolean value = cell.getBooleanCellValue();
            data = String.valueOf(value);
        }
        if(cellType==CellType.NUMERIC){
            double value = cell.getNumericCellValue();
            data = String.valueOf(value);
        }
        if(cellType==CellType.BLANK){
            data = "";
        }
        return data;
    }
}
