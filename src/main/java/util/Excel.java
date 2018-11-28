package util;

import domain.Person;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Excel {
    public static Workbook generateXLSX(ArrayList<Person> persons) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("HelloWorld");
        for (Integer i =0; i<persons.size(); i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(persons.get(i).getName());
            cell = row.createCell(1);
            cell.setCellValue(persons.get(i).getrNumber());
            cell = row.createCell(2);
            cell.setCellValue(persons.get(i).getGithubUrl());
        }
        sheet.autoSizeColumn(0);
        FileOutputStream fileOut = new FileOutputStream("helloWorldXLSX.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        return workbook;
    }

    public static Workbook generateXLS(ArrayList<Person> persons) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("HelloWorld");
        for (Integer i =0; i<persons.size(); i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(persons.get(i).getName());
            cell = row.createCell(1);
            cell.setCellValue(persons.get(i).getrNumber());
            cell = row.createCell(2);
            cell.setCellValue(persons.get(i).getGithubUrl());
        }
        sheet.autoSizeColumn(0);
        FileOutputStream fileOut = new FileOutputStream("helloWorldXLS.xls");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        return workbook;
    }
}
