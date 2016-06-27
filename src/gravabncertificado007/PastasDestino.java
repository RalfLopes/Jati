/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravabncertificado007;

import java.io.File;

/**
 *
 * @author rafael.cunha
 */
public class PastasDestino  {

    public String pastaDestinoBin(String caminhoarquivo, String BN) {
        String caminhodestino = (caminhoarquivo.substring(0, caminhoarquivo.length() - BN.length()));
        File destinooriginal = new File(caminhodestino + "ORIGINAL\\");
        if (!destinooriginal.exists()) {
            destinooriginal.mkdir();
        }

        return caminhodestino = (caminhodestino + "ORIGINAL\\" + BN);

    }
    
    
    
}