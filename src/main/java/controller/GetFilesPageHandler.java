package controller;

import db.ImageRepositoryInMemory;
import db.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetFilesPageHandler extends AbstractRequestHandler {

    public GetFilesPageHandler(Service service) {
        super(service);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/filesPage.jsp").forward(request,response);
    }
}
