package controller;

import db.ImageRepositoryInMemory;
import db.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetMailFormHandler extends AbstractRequestHandler {
    public GetMailFormHandler(Service service) {
        super(service);
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/mailForm.jsp").forward(request, response);
    }
}
