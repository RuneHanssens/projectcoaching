package controller;

import db.Service;
import util.Mail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SendMailHandler extends AbstractRequestHandler {
    public SendMailHandler(Service service) {
        super(service);
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mail.send(request.getParameter("email"));
    }
}
