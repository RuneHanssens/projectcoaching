package util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import domain.Person;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Pdf {
    public static Document generateFile(ArrayList<Person> persons, Document document) throws FileNotFoundException, DocumentException {
        PdfWriter.getInstance(document, new FileOutputStream("Hello.pdf"));
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        for (Person person:persons) {
            Paragraph paragraph = new Paragraph(person.getName() + ", " + person.getrNumber() + ", " + person.getGithubUrl(),font);
            document.add(paragraph);
            Chunk newLine = Chunk.NEWLINE;
            document.add(newLine);
        }
        document.close();
        return document;
    }
}
