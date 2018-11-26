package controller;

import db.ImageRepositoryInMemory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetFilesPageHandler extends AbstractRequestHandler {

    public GetFilesPageHandler(ImageRepositoryInMemory imageRepo) {
        super(imageRepo);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/filesPage.jsp").forward(request,response);
    }
}
