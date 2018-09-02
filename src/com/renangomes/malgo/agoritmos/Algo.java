/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renangomes.malgo.agoritmos;

import com.renangomes.malgo.entidades.Pagina;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author RenanGomes
 */
public interface Algo {
    public int decide(Pagina[] men, ArrayList<Integer> cad, int pos);
    public void processar(Pagina[] men, ArrayList<Pagina> dis, ArrayList<Integer> cad, int pos);
    public JPanel getPanel();
    
}
