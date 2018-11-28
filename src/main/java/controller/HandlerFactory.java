package controller;

import db.ImageRepositoryInMemory;
import db.Service;

public class HandlerFactory {
    public static AbstractRequestHandler getHandler(String action, Service service){
        switch (action){
            case "getMailForm":
                return new GetMailFormHandler(service);
            case "sendMail":
                return new SendMailHandler(service);
            case "downloadPdf":
                return new DownloadPdfHandler(service);
            case "getImagePage":
                return new GetImagePageHandler(service);
            case "uploadImage":
                return new UploadImageHandler(service);
            case "downloadImage":
                return new DownloadImageHandler(service);
            case "getFilesPage":
                return new GetFilesPageHandler(service);
            case "downloadExcel":
                return new DownloadExcelHandler(service);
        }
        return null;
    }
}
