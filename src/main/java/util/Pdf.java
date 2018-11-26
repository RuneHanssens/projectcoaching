package util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Pdf {
    public static Document generateFile() throws FileNotFoundException, DocumentException {
        ArrayList<String> persons = new ArrayList<>();
        persons.add("A");
        persons.add("B");
        persons.add("C");
        persons.add("D");
        persons.add("E");
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("Hello.pdf"));
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        for (String name:persons) {
            Chunk chunk = new Chunk(name, font);
            chunk.append("\n ");
            document.add(chunk);
            Chunk newLine = Chunk.NEWLINE;
            document.add(newLine);
        }
        document.close();
        return document;
    }
}
