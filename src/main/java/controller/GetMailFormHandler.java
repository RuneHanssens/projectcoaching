package controller;

import db.ImageRepositoryInMemory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetMailFormHandler extends AbstractRequestHandler {
    public GetMailFormHandler(ImageRepositoryInMemory imageRepo) {
        super(imageRepo);
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/mailForm.jsp").forward(request, response);
    }
}
