/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AlgoritmoMRU.java
 *
 * Created on 24/11/2011, 12:29:54
 */
package com.renangomes.malgo.agoritmos;

import com.renangomes.malgo.entidades.Pagina;
import com.renangomes.malgo.gui.JanelaPrincipal;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author RenanGomes
 */
public class AlgoritmoMRU extends javax.swing.JPanel implements Algo {

    private int faltaDePagina = 0;
    private Pagina[] fila = null;

    /** Creates new form AlgoritmoNUR */
    public AlgoritmoMRU() {
        initComponents();
        setVisible(true);
        desc.setSelectionStart(0);
        desc.setSelectionEnd(0);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfFalta = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpFila = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel1.setText("Faltas de Página:");

        tfFalta.setEditable(false);
        tfFalta.setFont(new java.awt.Font("Verdana", 1, 18));
        tfFalta.setForeground(new java.awt.Color(204, 0, 0));
        tfFalta.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfFalta.setText("0");
        tfFalta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        desc.setContentType("text/html");
        desc.setEditable(false);
        desc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        desc.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body style=\"font-family:Verdana, Arial; margin:10px\">\r\n\n      \r\n<h3 style=\"margin-top:0px\" >Algoritmo de substituição de página MENOS RECENTE USADA (MRU)</h3>\n    <p style=\"text-align: justify\">\nÉ provável que páginas que não foram referenciadas nas últimas instruções não o sejam nas próximas instruções. Essa idéia é implementável, ou seja, quando ocorre uma falta de página, descartamos a página que há mais tempo não é usada. Embora possível, a implementação do MRU é onerosa. Para implementa-la integralmente, é necessário manter uma lista encadeada de todas as páginas na memória, com a página mais recentemente usada no início desta lista e a página menos recentemente usada no fim desta lista. A desvantagem é que esta lista encadeada deve ser atualizada a cada referência à memória. Encontrar uma página nessa lista, descartá-la e então movê-la para o início da lista é uma operação que consome muito tempo.  </p>\r\n  </body>\r\n</html>\r\n");
        jScrollPane1.setViewportView(desc);

        jLabel6.setText("Descrição do Algoritmo Segunda Chance:");

        jLabel2.setText("LISTA ORDENADA:");

        tpFila.setColumns(20);
        tpFila.setEditable(false);
        tpFila.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tpFila.setRows(5);
        jScrollPane2.setViewportView(tpFila);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFalta, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfFalta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane desc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField tfFalta;
    private javax.swing.JTextArea tpFila;
    // End of variables declaration//GEN-END:variables

    public Pagina getFromMen(Pagina[] men, Pagina p) {
        if (p == null) {
            return null;
        }
        for (Pagina pmen : men) {
            if (pmen != null && p.getNumero() == pmen.getNumero()) {
                return pmen;
            }

        }

        return null;
    }

    @Override
    public int decide(Pagina[] men, ArrayList<Integer> cad, int pos) {


        int seraRemovida = -1;
        if (fila[fila.length - 1] != null) {
           // rotacionar();
            seraRemovida = fila[0].getNumero();
        }



//        while (true) {
//            Pagina p = fila[fila.length - 1];

//            
//            
//            if (p == null) {
//                seraRemovida = 0;
//                break;
//            } else {
//                if (getFromMen(men, p).isReferenciada()) {
//                    getFromMen(men, p).setReferenciada(false);
//                    p.setReferenciada(false);
//                    rotacionar();
//                } else {
//                    seraRemovida = p.getNumero();
//                    break;
//                }
//            }
//
//        }

//
//        for (int b = fila.length - 1; b > 0; b--) {
//            fila[b] = fila[b - 1];
//        }

        fila[0] = new Pagina(cad.get(pos));


        for (int i = 0; i < men.length; i++) {
            if (men[i] == null) {
                return i;
            }
        }

        for (int i = 0; i < men.length; i++) {
            if (men[i].getNumero() == seraRemovida) {
                return i;
            }

        }

        return 0;
    }

    @Override
    public void processar(Pagina[] m, ArrayList<Pagina> dis, ArrayList<Integer> cad, int pos) {

        if (fila == null) {
            fila = new Pagina[JanelaPrincipal.janela.getEspacosMen()];
        }

        //Se a pagina estiver no disco, remove-a de lá
        boolean encontrada = false;
        Pagina tmp = null;
        for (Pagina p : dis) {
            if (p != null && p.getNumero() == cad.get(pos)) {
                tmp = p;
                encontrada = true;
            }
        }
        if (encontrada) {
            dis.remove(tmp);
        }
        //Se a página NAO estiver na memoria, incrementa o contador de falta de página
        boolean falta = true;
        for (Pagina p : m) {
            if (p != null && p.getNumero() == cad.get(pos)) {
                falta = false;
                colocanoInicio(p);
            }
        }
        if (falta) {
            faltaDePagina++;
            atualizaGUI();
        } else {
            atualizaGUIFila();
            return;
        }

        // Decide qual espaço será usado
        int aRemover = decide(m, cad, pos);

        // Se for um espaço ocupado, copia para o disco
        if (m[aRemover] != null && !dis.contains(m[aRemover])) {
            dis.add(m[aRemover]);
        }
        m[aRemover] = new Pagina(cad.get(pos));

        atualizaGUI();
        atualizaGUIFila();
    }

    @Override
    public JPanel getPanel() {
        try {
            atualizaGUI();
            atualizaGUIFila();
        } catch (Exception e) {
        }
        return this;
    }

    private void atualizaGUI() {
        tfFalta.setText(Integer.toString(faltaDePagina));
    }

    private void atualizaGUIFila() {
        for (int b = 0; b < fila.length; b++) {
            if (fila[b] != null) {
                if (b == 0) {
                    tpFila.setText(Integer.toString(fila[b].getNumero()));
                } else {
                    tpFila.setText(tpFila.getText() + " -> " + fila[b].getNumero());
                }
            }
        }
    }

    private void rotacionar() {
        Pagina ultima;
        if (fila[fila.length - 1] == null) {
            ultima = null;
        } else {
            ultima = new Pagina(fila[fila.length - 1].getNumero());

        }

        for (int b = fila.length - 1; b > 0; b--) {
            fila[b] = fila[b - 1];
        }

        fila[0] = ultima;

    }

    private void colocanoInicio(Pagina p) {
        if (p == null) {
            return;
        }
        Pagina p2 = null;
        int posicaoP = -1;
        for (int i = 0; i < fila.length; i++) {
            if (fila[i] == null) {
                continue;
            }
            if (fila[i].getNumero() == p.getNumero()) {
                posicaoP = i;
                p2 = fila[i];
                break;
            }
        }
        if (posicaoP >= 0) {
            for (int i = posicaoP - 1; i >= 0; i--) {
                fila[i + 1] = fila[i];
            }
            fila[0] = p2;
        }
    }
}
