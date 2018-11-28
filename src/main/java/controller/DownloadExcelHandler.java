package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import db.ImageRepositoryInMemory;
import db.Service;
import org.apache.poi.ss.usermodel.Workbook;
import util.Excel;
import util.Pdf;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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
        System.out.println("type1");
        final int ARBITARY_SIZE = 1048;
        Workbook excelFile = null;
        try {
            excelFile = Excel.generateXLSX(service.getAllPersons());
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.addHeader("Content-Disposition", "attachment; filename=helloWorld.xlsx");


        try(InputStream in = new FileInputStream("helloWorldXLSX.xlsx");
            OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[ARBITARY_SIZE];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }

    private void handleXLS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("type2");
        final int ARBITARY_SIZE = 1048;
        Workbook excelFile = null;
        try {
            excelFile = Excel.generateXLS(service.getAllPersons());
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment; filename=helloWorldXLS.xls");


        try(InputStream in = new FileInputStream("helloWorldXLS.xls");
            OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[ARBITARY_SIZE];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}
