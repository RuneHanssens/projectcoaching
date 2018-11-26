package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import db.ImageRepositoryInMemory;
import org.apache.poi.ss.usermodel.Workbook;
import util.Excel;
import util.Pdf;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DownloadExcelHandler extends AbstractRequestHandler{

    public DownloadExcelHandler(ImageRepositoryInMemory imageRepo) {
        super(imageRepo);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int ARBITARY_SIZE = 1048;
        Workbook excelFile = null;
        try {
            excelFile = Excel.generateXLSX();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment; filename=helloWorld.xlsx");


        try(InputStream in = new FileInputStream("helloWorld.xlsx");
            OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[ARBITARY_SIZE];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}
