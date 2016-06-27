/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jati;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.exceptions.InvalidPdfException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import jati.Caminhos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/**
 *
 * @author gustavo.lima
 */
public class GerandoArquivoCarimbado {

    static PdfReader reader;
    static float width = 0;
    static float height = 0;

    /**
     *
     * @param caminho
     * @param document
     * @return
     * @throws IOException
     * @throws com.itextpdf.text.DocumentException
     */
    public static PdfWriter alocaDoc(String caminho, Document document) throws IOException, DocumentException {
        
        // PDFWRITER = ESCRITOR-GERADOR DE PDF 
        // GETINSTANCE RECEBE O DOCUMENTO CRIADO 
        //NEW FILEOUTPUTSTREAM ALOCA O ARQUIVO PDF NO CAMINHO DESCRITO
        PdfWriter writer = PdfWriter.getInstance(montaraAquivo(caminho),
                new FileOutputStream(caminho.substring(0, caminho.length() - 4) + "-C.pdf"));

        return writer;
    }

    public static Document montaraAquivo(String caminho) {

        try {
            reader = new PdfReader(caminho);
            // n recebe o numero total de paginas

            //Tamanho da primeira Pagina
        
        
            //Cria Segundo PDF 
        } catch (IOException e) {
        }
        Document documento = new Document(PageSize.A4);
        return documento;

    }

    public static void GerandoArquivoCarimbadoPDF(String caminhoarquivo, String BN) throws InvalidPdfException, IOException {
        //Copiando arquivo informado.

        try {

            // Adicionado parametro para nao retornar erro quando o documento for protegido.
            PdfReader.unethicalreading = true;
            
            PdfWriter writer= PdfWriter.getInstance(montaraAquivo(caminhoarquivo),
                    new FileOutputStream(caminhoarquivo.substring(0,caminhoarquivo.length() - 4) + "-C.pdf"));
            // ABRE O DOCUMENTO CRIADO PARA MANUSEIO
            montaraAquivo(caminhoarquivo).open();
            
            
            //SUBSTRING RETIRA PARTE DO TEXTO ENTRE OS INDICES ESPECIFICADOS 
            //caminhoDestino RECEBE UM NOVO CAMINHO RESULTANTE DOS INDICES DE CAMINHO.LENGTH - BN.LENGTH
            // QUE FORMAM UMA NOVA STRING
            String caminhodestino = (caminhoarquivo.substring(0, caminhoarquivo.length() - BN.length()));

            File destinooriginal = new File(caminhodestino + "ORIGINAL\\");
            if (!destinooriginal.exists()) {
                destinooriginal.mkdir();
            }

            caminhodestino = (caminhodestino + "ORIGINAL\\" + BN);

            //TESTANDO NOVA FORMA DE COPIAR
            File origem = new File(caminhoarquivo);
            File destino = new File(caminhodestino);

            FileInputStream fis = new FileInputStream(origem);
            FileOutputStream fos = new FileOutputStream(destino);

            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();

            long transferFrom = outChannel.transferFrom(inChannel, 0, inChannel.size());

            fis.close();
            fos.close();
            inChannel.close();
            outChannel.close();

            // Thread.sleep(10);
            BN = BN.substring(0, BN.length() - 4);

            PdfContentByte cb = writer.getDirectContent();

            int i = 0;
            while (i < reader.getNumberOfPages()) {
                montaraAquivo(caminhodestino).newPage();

                i++;

                //PDFCONTETBYTE GERA UMA ESPECIE DE CODIGO DE BARRAS 
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

            montaraAquivo(caminhodestino).close();
            writer.close();
            reader.close();
            origem.delete();

        } catch (IOException | DocumentException ex) {
        }

    }
    /*
     public static void GerandoArquivoCarimbadoJPG(String caminhoarquivo, String BN){
     //Copiando arquivo informado.
     try {
     Image imagem = Image.getInstance(caminhoarquivo);
        
     float width = imagem.getWidth();
     float height =  imagem.getHeight();
  
     Document document = new Document(new Rectangle(width,height));
       
     PdfWriter writer = PdfWriter.getInstance(document,
     new FileOutputStream(caminhoarquivo.substring(0,caminhoarquivo.length() - 4) + "-C.pdf"));
      
     document.open();
    
     // Adiciona conteudo ao PDF Carimbado.
     PdfContentByte cb = writer.getDirectContent();
     int n = 1;
     int i = 0;
     int p = 0;
    
     while (i<n){
     document.newPage();
     p++;
     i++;
         
     document.add(imagem);
     PdfContentByte under = writer.getDirectContentUnder();
     //PdfImportedPage page1 = writer.getImportedPage(reader, i);
     //cb.addTemplate(page1, 0, i * 0.2f);
        
     // RETANGULO DESATIVADO
     /*drawRectangle(under, 100, 50);
     under.setRGBColorFill(255, 220, 220);
     under.rectangle(width /50, 5, 118, 40);
     under.fill();
         
        
     //CARIMBO DA BN
       
     BaseFont bf = BaseFont.createFont(BaseFont.COURIER_BOLD, BaseFont.CP1250, BaseFont.NOT_EMBEDDED);
     cb.beginText();
     cb.setFontAndSize(bf,14);
     cb.showTextAligned(PdfContentByte.ALIGN_CENTER," ________________", width /11, 44, 0);
     cb.showTextAligned(PdfContentByte.ALIGN_CENTER," |               |", width /11, 32, 0);
     cb.showTextAligned(PdfContentByte.ALIGN_CENTER," |               |", width /11, 22, 0);
     cb.showTextAligned(PdfContentByte.ALIGN_CENTER,"ORIGEM", width /11, 28, 0);
     cb.showTextAligned(PdfContentByte.ALIGN_CENTER," " + BN, width /11, 16, 0);
     cb.showTextAligned(PdfContentByte.ALIGN_CENTER," |               |", width /11, 12, 0);
     cb.showTextAligned(PdfContentByte.ALIGN_CENTER," ________________", width /11, 14, 0);
     cb.endText();
       
     }
    
    
     /* PdfContentByte under = writer.getDirectContentUnder();
    
     // Page 1: a rectangle
     drawRectangle(under, 20, 20);
     under.setRGBColorFill(0xFF, 0xD7, 0x00);
     under.rectangle(5, 5, 15, 15);
     under.fill(); 
     //document.newPage();
       
           
     document.close();
    
     } catch (IOException | DocumentException e) {
     System.out.println("COCOZINHO MOLE");
     }
     }
     public static void drawRectangle(PdfContentByte content, float width, float height) {
     content.saveState();
     PdfGState state = new PdfGState();
     state.setFillOpacity(0.9f);
     content.setGState(state);
     content.setRGBColorFill(0xFF, 0xFF, 0xFF);
     content.setLineWidth(3);
     content.rectangle(0, 0, width, height);
     content.fillStroke();
     content.restoreState();
     }

     */
}
