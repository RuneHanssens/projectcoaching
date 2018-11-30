package controller;

import db.Service;
import domain.Person;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

public class DownloadExcelHandler extends AbstractRequestHandler{

    public DownloadExcelHandler(Service service) {
        super(service);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type.equals("1")) {
            handleXLSX(request,response);
        }else{
            handleXLS(request,response);
        }
    }

    private void handleXLSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.addHeader("Content-Disposition", "attachment; filename=names.xlsx");
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        writeNames(sheet);
        workbook.write(response.getOutputStream());
        workbook.close();
    }

    private void handleXLS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=names.xls");
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        writeNames(sheet);
        workbook.write(response.getOutputStream());
        workbook.close();
    }

    private void writeNames(Sheet sheet){
        ArrayList<Person> persons = service.getAllPersons();
        for (Integer i =0; i<persons.size(); i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(persons.get(i).getName());
            cell = row.createCell(1);
            cell.setCellValue(persons.get(i).getrNumber());
            cell = row.createCell(2);
            cell.setCellValue(persons.get(i).getGithubUrl());
        }
    }
}
