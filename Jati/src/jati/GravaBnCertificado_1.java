/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gravabncertificado;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class GravaBnCertificado_1  {

  public static void main(String[] args) throws InterruptedException {
    int x = 0; 
    while(x==0){
    //String caminhoarquivo = "\\\\192.168.0.1\\arquivos\\Certificados";         
    //String caminhoarquivo = "\\\\192.168.0.1\\arquivos\\Certificados";
    //String caminhoarquivo = "D:\\Arquivos Geral\\Certificados\\";
        String caminhoarquivo = "C:\\rafael\\";
    //String tipoarquivo = caminhoarquivo.substring(caminhoarquivo.length() - 3,3);
    //String caminhoarquivo = "\\\\192.168.0.1\\arquivos\\Certificados\\CH\\12\\";
   
    List<File> pdfs = PercorrerDiretorioLista_1.RetornandoListaCertificados(new File(caminhoarquivo), ".pdf");
     
    pdfs.stream().forEach((pdf) -> {
        try {
            GerandoArquivoCarimbado_1.GerandoArquivoCarimbadoPDF(pdf.getAbsolutePath(), pdf.getName().substring(0, pdf.getName().length()));
                       
        } catch (IOException ex) {
            Logger.getLogger(GravaBnCertificado_1.class.getName()).log(Level.SEVERE, null, ex);
        }
      });
    /* DESABILITADO POR FALTA DE ESPACO
    List<File> jpg = PercorrerDiretorioLista.RetornandoListaCertificados(new File(caminhoarquivo), ".jpg");
     
    jpg.stream().forEach((pdf) -> {
          GerandoArquivoCarimbado.GerandoArquivoCarimbadoJPG(pdf.getAbsolutePath(), pdf.getName().substring(0, pdf.getName().length()));
      }); */
    System.out.println("Execucao finalizada.... aguardando para comecar");
    Thread.sleep(400);
    System.out.println("Iniciando...");
    }
   System.exit(0);
   
  }
         
  }

  
