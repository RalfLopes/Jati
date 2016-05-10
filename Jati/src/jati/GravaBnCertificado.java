/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gravabncertificado;

import com.itextpdf.text.exceptions.InvalidPdfException;
import com.itextpdf.text.pdf.PdfShadingPattern;
import gravabncertificado.PercorrerDiretorioLista;
import jati.Caminhos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.FileObject;



public class GravaBnCertificado  {

  public static void main(String[] args) throws InterruptedException, InvalidPdfException, FileNotFoundException, IOException {
      
     Caminhos  caminhos= new Caminhos();
     
     GerandoArquivoCarimbado gera= new GerandoArquivoCarimbado();
     gera.GerandoArquivoCarimbadoPDF(caminhos.caminhoRafa,"");
     
//     
//    int x = 0; 
//    while(x==0){
//        
//        
//        File file= new File("");
//    List<File> pdfs = PercorrerDiretorioLista.RetornandoListaCertificados(new File(caminhos.caminhoRafa), ".pdf");
//     
//    pdfs.iterator();
//        PdfShadingPattern
//    pdfs.stream().forEach((pdf);
//        try {
//            gera.GerandoArquivoCarimbadoPDF(pdf.getAbsolutePath(),
//                    pdf.getName().substring(0, pdfs.getName().length()));
//                       
//        } catch (IOException ex) {
//            Logger.getLogger(GravaBnCertificado.class.getName()).log(Level.SEVERE, null, ex);
//        }
      
    /* DESABILITADO POR FALTA DE ESPACO
    List<File> jpg = PercorrerDiretorioLista.RetornandoListaCertificados(new File(caminhoarquivo), ".jpg");
     
    jpg.stream().forEach((pdf) -> {
          GerandoArquivoCarimbado.GerandoArquivoCarimbadoJPG(pdf.getAbsolutePath(), pdf.getName().substring(0, pdf.getName().length()));
//      }); */
//    System.out.println("Execucao finalizada.... aguardando para comecar");
//    Thread.sleep(400);
//    System.out.println("Iniciando...");
//    }
//   System.exit(0);
//   
//  }
                     
  }
}
  
