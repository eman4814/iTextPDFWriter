
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Computer
 */
public class ColoredBackground {

    public static final String DEST = "results/tables/colored_background.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ColoredBackground().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table;
        PdfPCell cell;
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
        table = new PdfPTable(10);
        //adding table headers
        for (int th = 0; th < 10; th++) {
            cell = new PdfPCell(new Phrase("TH", font));
            if (th % 2 == 0) {
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            } else {
                cell.setBackgroundColor(BaseColor.DARK_GRAY);
            }
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
        //extracting data from the JTable and inserting it to PdfPTable
        for (int rows = 0; rows < 100; rows++) {
            for (int cols = 0; cols < 10; cols++) {
                table.addCell(rows+1+" Hello");
            }
        }
        document.add(table);
        document.close();
    }
}
