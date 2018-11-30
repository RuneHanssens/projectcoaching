package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import db.ImageRepositoryInMemory;
import db.Service;
import org.w3c.dom.DocumentFragment;
import util.Pdf;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownloadPdfHandler extends AbstractRequestHandler {
    public DownloadPdfHandler(Service service) {
        super(service);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get the text that will be added to the PDF
            String text = request.getParameter("text");
            if (text == null || text.trim().length() == 0) {
                text = "You didn't enter any text.";
            }
            // step 1
            Document document = new Document();
            // step 2
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            // step 3
            Pdf.generateFile(service.getAllPersons(), document);

            // setting some response headers

            // setting the content type
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename=helloworld.pdf");
            // the contentlength

            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
