package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {

    private final String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    // -----------------------------
    // 1. Get Row Count
    // -----------------------------
    public int getRowCount(String sheetName) throws IOException {
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            return sheet.getLastRowNum() + 1;
        }
    }

    // -----------------------------
    // 2. Get Column Count
    // -----------------------------
    public int getColumnCount(String sheetName) throws IOException {
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(0);

            if (row == null) return 0;

            return row.getLastCellNum();
        }
    }

    // -----------------------------
    // 3. Get Cell Data (String)
    // -----------------------------
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            if (row == null) return "";

            Cell cell = row.getCell(colNum);
            if (cell == null) return "";

            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        }
    }

    // -----------------------------
    // 4. Set Cell Data
    // -----------------------------
    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        fi.close(); // Close to open output stream safely

        XSSFSheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        if (row == null) row = sheet.createRow(rowNum);

        Cell cell = row.getCell(colNum);
        if (cell == null) cell = row.createCell(colNum);

        cell.setCellValue(data);

        try (FileOutputStream fo = new FileOutputStream(path)) {
            workbook.write(fo);
        }
        workbook.close();
    }

    // -----------------------------
    // 5. Set Cell Background Color
    // -----------------------------
    public void fillCellColor(String sheetName, int rowNum, int colNum, IndexedColors color) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        fi.close();

        XSSFSheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        if (row == null) row = sheet.createRow(rowNum);

        Cell cell = row.getCell(colNum);
        if (cell == null) cell = row.createCell(colNum);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(color.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        try (FileOutputStream fo = new FileOutputStream(path)) {
            workbook.write(fo);
        }
        workbook.close();
    }

    // -----------------------------
    // 6. Set Cell Text Color
    // -----------------------------
    public void setCellFontColor(String sheetName, int rowNum, int colNum, IndexedColors color) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        fi.close();

        XSSFSheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        if (row == null) row = sheet.createRow(rowNum);

        Cell cell = row.getCell(colNum);
        if (cell == null) cell = row.createCell(colNum);

        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setColor(color.getIndex());
        style.setFont(font);

        cell.setCellStyle(style);

        try (FileOutputStream fo = new FileOutputStream(path)) {
            workbook.write(fo);
        }
        workbook.close();
    }
}
