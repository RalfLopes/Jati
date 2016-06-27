package gravabncertificado007;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafael.cunha
 */
public  class CarimboCertificado {
    
     public void aplicaCarimboBin(String BN, String caminhoarquivo) throws DocumentException, IOException, RuntimeException {

        PdfReader.unethicalreading = true;
        //Cria o reader para o primeiro PDF

        PdfReader reader = new PdfReader(caminhoarquivo);
        Rectangle psize = reader.getPageSize(1);
        float width = psize.getWidth();
        float height = psize.getHeight();

        Document document = new Document(new Rectangle(width, height));

        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream(caminhoarquivo.substring(0, caminhoarquivo.length() - 4) + "-C.pdf"));

        document.open();

        int i = 0;
        BN = BN.substring(BN.length()-13, BN.length() - 4);
        PdfContentByte cb = writer.getDirectContent();
        while (i < reader.getNumberOfPages()) {
            i++;

            document.newPage();

            PdfContentByte under = writer.getDirectContentUnder();
            PdfImportedPage page1 = writer.getImportedPage(reader, i);
            cb.addTemplate(page1, 0, i * 0.2f);

            //CARIMBO DA BN
            BaseFont bf = BaseFont.createFont(BaseFont.COURIER_BOLD, BaseFont.CP1250, BaseFont.NOT_EMBEDDED);
            cb.beginText();
            cb.setFontAndSize(bf, 14);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " ________________", width / 6, 44, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " |               |", width / 6, 32, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " |               |", width / 6, 22, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " NR", width / 6, 28, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " " + BN, width / 6, 16, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " |               |", width / 6, 12, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " ________________", width / 6, 14, 0);
            cb.endText();

        }

        document.close();
        writer.close();
        reader.close();

    }
public void aplicaCariboGedi(String BN, String caminhoarquivo) throws DocumentException, IOException, RuntimeException {

        PdfReader.unethicalreading = true;
        //Cria o reader para o primeiro PDF

        PdfReader reader = new PdfReader(caminhoarquivo);
        Rectangle psize = reader.getPageSize(1);
        float width = psize.getWidth();
        float height = psize.getHeight();

        Document document = new Document(new Rectangle(width, height));

        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream(caminhoarquivo.substring(0, caminhoarquivo.length() - 4) + "-G.pdf"));

        document.open();

        int i = 0;
        BN = BN.substring(BN.length()-13, BN.length() - 4);
        PdfContentByte cb = writer.getDirectContent();
        while (i < reader.getNumberOfPages()) {
            i++;

            document.newPage();

            PdfContentByte under = writer.getDirectContentUnder();
            PdfImportedPage page1 = writer.getImportedPage(reader, i);
            cb.addTemplate(page1, 0, i * 0.2f);

              BaseFont bf = BaseFont.createFont(BaseFont.COURIER_BOLD, BaseFont.CP1250, BaseFont.NOT_EMBEDDED);
            cb.beginText();
            cb.setFontAndSize(bf, 14);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "  _________________  ", width / 6, 44, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " |                 |", width / 6, 32, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " |                 |", width / 6, 22, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " |Copia Controlada |", width / 6, 28, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " |                 |", width / 6, 16, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " |                 |", width / 6, 12, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, " |_________________|", width / 6, 14, 0);
            cb.endText();
        }

        document.close();
        writer.close();
        reader.close();

    }


}
