/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravabncertificado007;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo.lima
 */
public class PercorrerDiretorioLista {

    public static List<File> retornandoListaCertificados(File pasta, String ext) {
        List<File> resultados = new ArrayList<>();
        String possivelcarimbado;
        for (File f : pasta.listFiles()) {
            if (f.isDirectory() && f.getName().endsWith("ORIGINAL") == false) {
                resultados.addAll(retornandoListaCertificados(f, ext));

            }
            else if (f.getName().endsWith(ext) && f.getName().endsWith("-C.pdf") == false) {
                possivelcarimbado = f.getParent() + "\\" + f.getName().substring(0, f.getName().length() - 4) + "-C" + f.getName().substring(f.getName().length() - 4, f.getName().length());
                File temcarimbado = new File(possivelcarimbado);
                resultados.add(f);
                System.out.println(f);
            }
           
            }

            return resultados;

        }

    }
