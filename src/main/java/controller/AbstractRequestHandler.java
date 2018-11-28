package controller;

import db.ImageRepositoryInMemory;
import db.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractRequestHandler {
    protected Service service;
    public AbstractRequestHandler(Service service) {
        this.service = service;
    }

    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
