/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jati;

import com.itextpdf.text.exceptions.InvalidPdfException;
import jati.PercorrerDiretorioLista;
import jati.Caminhos;
import jati.GerandoArquivoCarimbado;
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
     
     
    
        
  
//    List<File> pdfs = PercorrerDiretorioLista.RetornandoListaCertificados(new File(caminhos.caminhoRafa), ".pdf");
//     File  teste = new File(caminhos.caminhoRafa);
//    pdfs.iterator();
//        
////    pdfs.stream().forEach((pdf);
//        try {
//         
//            gera.GerandoArquivoCarimbadoPDF(teste.getAbsolutePath(),
//                    teste.getName().substring(0, teste.getName().length()));
//                       
//        } catch (IOException ex) {
//            Logger.getLogger(GravaBnCertificado.class.getName()).log(Level.SEVERE, null, ex);
//        }
      
    /* DESABILITADO POR FALTA DE ESPACO
    List<File> jpg = PercorrerDiretorioLista.RetornandoListaCertificados(new File(caminhoarquivo), ".jpg");
     
    jpg.stream().forEach((pdf) -> {
          GerandoArquivoCarimbado.GerandoArquivoCarimbadoJPG(pdf.getAbsolutePath(), pdf.getName().substring(0, pdf.getName().length()));
      }); */
//    System.out.println("Execucao finalizada.... aguardando para comecar");
//    Thread.sleep(400);
//    System.out.println("Iniciando...");
//    }
  
   
  
  }              
  }

  
