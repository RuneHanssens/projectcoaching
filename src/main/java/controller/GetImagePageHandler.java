package controller;

import db.ImageRepositoryInMemory;
import db.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetImagePageHandler extends AbstractRequestHandler {
    public GetImagePageHandler(Service service) {
        super(service);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("keys", this.service.getAllImages());
        request.getRequestDispatcher("/imagePage.jsp").forward(request,response);
    }
}
