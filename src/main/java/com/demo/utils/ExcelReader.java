package com.demo.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        List<Object[]> dataList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#");  // Format to remove scientific notation

        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        for (Row row : sheet) {
            if (row.getRowNum() == 0 || isRowEmpty(row)) continue; // Skip header & empty rows

            List<Object> rowData = new ArrayList<>();
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                rowData.add(getCellValue(cell, j, df));
            }
            dataList.add(rowData.toArray());
        }

        workbook.close();
        return dataList.toArray(new Object[0][0]);
    }

    private static Object getCellValue(Cell cell, int colIndex, DecimalFormat df) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (colIndex == 7) { // Assuming mobile number is in the 8th column (index 7)
                    return df.format(cell.getNumericCellValue());
                }
                return cell.toString();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            default:
                return ""; // Handle blank cells
        }
    }

    private static boolean isRowEmpty(Row row) {
        for (Cell cell : row) {
            if (cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }
}
