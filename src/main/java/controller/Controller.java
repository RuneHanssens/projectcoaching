package controller;

import db.ImageRepositoryInMemory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class Controller extends javax.servlet.http.HttpServlet {
    private ImageRepositoryInMemory imageRepo;

    public Controller() {
        this.imageRepo = new ImageRepositoryInMemory();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            System.out.println("Action is null going to index page");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            System.out.println("Action: " + action);
            HandlerFactory.getHandler(action, imageRepo).handleRequest(request,response);
        }
    }
}
