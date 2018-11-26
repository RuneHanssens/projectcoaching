package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.codec.Base64;
import db.ImageRepositoryInMemory;
import org.w3c.dom.DocumentFragment;
import util.Pdf;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownloadPdfHandler extends AbstractRequestHandler {
    public DownloadPdfHandler(ImageRepositoryInMemory imageRepo) {
        super(imageRepo);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int ARBITARY_SIZE = 1048;
        Document pdfFile = null;
        try {
            pdfFile = Pdf.generateFile();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=hello.pdf");


        try(InputStream in = new FileInputStream("hello.pdf");
            OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[ARBITARY_SIZE];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}
