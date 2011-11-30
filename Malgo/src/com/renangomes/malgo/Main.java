package com.renangomes.malgo;

import com.renangomes.malgo.gui.JanelaPrincipal;
import javax.swing.UIManager;

/**
 * Inicializa o Programa
 * @author RenanGomes
 */
public class Main {

    /**
     * Pronto inicial do programa
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        alteraLAF();
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JanelaPrincipal j = new JanelaPrincipal();
                JanelaPrincipal.janela = j;
               
            }
        });
    }

    /**
     * Altera o Look And Feel dando prioridade ao do Windows.
     */
    public static void alteraLAF() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex2) {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex3) {
                    java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex3) {
                    java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex3) {
                    java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex3) {
                    java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
    }
}
