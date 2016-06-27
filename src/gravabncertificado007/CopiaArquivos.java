/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravabncertificado007;

import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *
 * @author rafael.cunha
 */
public class CopiaArquivos  {

    public File copiarDocBin(String caminhoarquivo, String caminhodestino) throws FileNotFoundException, IOException, DocumentException {

        CarimboCertificado carimboCertificado= new CarimboCertificado();

        
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

        
        carimboCertificado.aplicaCarimboBin(caminhodestino, caminhoarquivo);
//        carimboCertificado.aplicaCariboGedi(caminhodestino, caminhoarquivo);

       return origem;

    }
    
    
        public File copiarDocGedi(String caminhoarquivo, String caminhodestino) throws FileNotFoundException, IOException, DocumentException {

        CarimboCertificado carimboCertificado= new CarimboCertificado();

        
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
        carimboCertificado.aplicaCariboGedi(caminhodestino, caminhoarquivo);

       return origem;

    }
}
