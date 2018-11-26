package controller;

import db.ImageRepositoryInMemory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractRequestHandler {
    protected ImageRepositoryInMemory imageRepo;
    public AbstractRequestHandler(ImageRepositoryInMemory imageRepo) {
        this.imageRepo = imageRepo;
    }

    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
