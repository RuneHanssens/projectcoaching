package controller;

import db.ImageRepositoryInMemory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetImagePageHandler extends AbstractRequestHandler {
    public GetImagePageHandler(ImageRepositoryInMemory imageRepo) {
        super(imageRepo);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("keys", this.imageRepo.getAllKeys());
        if (this.imageRepo.getAllKeys().size() > 0){
            System.out.println(this.imageRepo.getAllKeys().get(0));
        }
        request.getRequestDispatcher("/imagePage.jsp").forward(request,response);
    }
}
