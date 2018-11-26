package controller;

import db.ImageRepositoryInMemory;

public class HandlerFactory {
    public static AbstractRequestHandler getHandler(String action, ImageRepositoryInMemory imageRepo){
        switch (action){
            case "getMailForm":
                return new GetMailFormHandler(imageRepo);
            case "sendMail":
                return new SendMailHandler(imageRepo);
            case "downloadPdf":
                return new DownloadPdfHandler(imageRepo);
            case "getImagePage":
                return new GetImagePageHandler(imageRepo);
            case "uploadImage":
                return new UploadImageHandler(imageRepo);
            case "downloadImage":
                return new DownloadImageHandler(imageRepo);
            case "getFilesPage":
                return new GetFilesPageHandler(imageRepo);
            case "downloadExcel":
                return new DownloadExcelHandler(imageRepo);
        }
        return null;
    }
}
