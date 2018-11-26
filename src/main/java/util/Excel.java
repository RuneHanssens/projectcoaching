package util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Excel {
    public static Workbook generateXLSX() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("HelloWorld");
        ArrayList<String> persons = new ArrayList<>();
        persons.add("A");
        persons.add("B");
        persons.add("C");
        persons.add("D");
        persons.add("E");

        for (Integer i =0; i<persons.size(); i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(persons.get(i));
        }
        sheet.autoSizeColumn(0);
        FileOutputStream fileOut = new FileOutputStream("helloWorld.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        return workbook;
    }
}
