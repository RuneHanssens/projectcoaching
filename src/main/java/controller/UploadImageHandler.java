package controller;

import db.ImageRepositoryInMemory;
import db.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadImageHandler extends AbstractRequestHandler{
    public UploadImageHandler(Service service) {
        super(service);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //File uploads = new File("D:\\School\\5\\Coaching\\ProjectCoach\\web\\uploads\\");
        //File uploads = new File(request.getServletContext().getRealPath("\\uploads\\"));
        Part filePart = request.getPart("file");
        String fileName = getSubmittedFileName(filePart);
        //File file = new File(uploads, fileName);
        File file = new File(fileName);

        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, file.toPath());
            service.addImage(fileName);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        response.sendRedirect("Controller?action=getImagePage");
    }

    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}
