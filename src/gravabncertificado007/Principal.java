/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravabncertificado007;

import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) throws InterruptedException {

        Caminhos caminhos = new Caminhos();
        PastasDestino pastasDestino = new PastasDestino();
        for (int x = 0;;) {

//    List<File> pdfs = PercorrerDiretorioLista.RetornandoListaCertificados(new File(caminhoarquivo), ".pdf");
            List<File> pdfs = PercorrerDiretorioLista.retornandoListaCertificados(new File(caminhos.getCaminhoBin()), ".pdf");

            pdfs.stream().forEach((pdf) -> {
                try {

                    CopiaArquivos copiarDoc = new CopiaArquivos();
                    //criação de pasta e copia e transferencia de arquivo pdf
                    String caminhoDestino = (pastasDestino.pastaDestinoBin(pdf.getAbsolutePath(), pdf.getName().substring(0, pdf.getName().length())));

                    copiarDoc.copiarDocBin(pdf.getAbsolutePath(), caminhoDestino);
                    copiarDoc.copiarDocBin(pdf.getAbsolutePath(), caminhoDestino);
                    

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);

                } catch (DocumentException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

            System.out.println("Execucao finalizada.... aguardando para comecar");
            Thread.sleep(400);
            System.out.println("Iniciando...");
        }

    }

}
