package controller;

import db.ImageRepositoryInMemory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DownloadImageHandler extends AbstractRequestHandler{

    public DownloadImageHandler(ImageRepositoryInMemory imageRepo) {
        super(imageRepo);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = (String)request.getParameter("key");
        String path = "D:/School/5/Coaching/ProjectCoach/web/uploads/" + key;
        ServletContext context = request.getServletContext();
        String mimeType = context.getMimeType(path);
        File downloadFile = new File(path);
        FileInputStream inStream = new FileInputStream(downloadFile);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();
    }
}
