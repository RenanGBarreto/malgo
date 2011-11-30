/** 
 * Leiloeiro - Sistema de Gerenciamento de Leilões
 * Aquivo: CellRenderLote.java
 * Autor: Renan Gomes Barreto
 * Data de Criação: 09:05:54 29/08/2011
 * Data de Modificação: 29/08/2011
 * Codificacao: UTF-8
 * Desenvolvedor: Software.Com.Vc - http://www.software.com.vc
 */
package com.renangomes.malgo.gui.cellrenders;

import com.renangomes.malgo.gui.JanelaPrincipal;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Classe que mostra uma celula do Lote na lista
 * @author Renan Gomes Barreto
 */
public class CellRenderCadeiaDeReferencias extends PanelTransparente implements ListCellRenderer {

    private Adapter binding;
    private final Border noFocusBorder;
    private final Font fonte = new Font(Font.MONOSPACED, Font.BOLD, 27);
    private JLabel label;
    private final Insets zeroInsets = new Insets(0, 0, 0, 0);

    @Override
    public Component getListCellRendererComponent(
            JList jList, Object value_tmp, int index, boolean isSelected, boolean hasFocus) {
        Integer value = (Integer) value_tmp;
        setComponentOrientation(jList.getComponentOrientation());
        setForeground(Color.BLACK);
        setOpaque(false);
        Border border = null;
        if (isSelected) {
            border = new LineBorder(Color.DARK_GRAY);
            setOpacity(0.3f);
        } else {
            setOpacity(0f);
            border = noFocusBorder;
        }

        setBorder(border);
        Adapter adapter = getAdapter(value);
        setToolTipText("Referência a página Nº " + adapter.getValue());
        label.setFont(fonte);

        label.setText(" " + Integer.toString(adapter.getValue()) + " ");

        if (index > JanelaPrincipal.posicaoCadeia) {
            label.setForeground(new Color(0,150,0));
        } else {
            if (index < JanelaPrincipal.posicaoCadeia) {
                label.setForeground(Color.GRAY);
            } else {
                label.setForeground(new Color(150,0,0));
            }
        }
        if (isSelected) {
            
        }
        return this;
    }

    private void initGridBagConstraints(GridBagConstraints c) {
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = zeroInsets;
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;
    }

    public CellRenderCadeiaDeReferencias(Adapter binding) {

        super(new GridBagLayout());

        this.binding = binding;
        noFocusBorder = new EmptyBorder(1, 1, 1, 1);
        setBorder(noFocusBorder);
        label = new JLabel();
        GridBagConstraints c = new GridBagConstraints();
        GridBagLayout l = (GridBagLayout) getLayout();

        initGridBagConstraints(c);
        c.gridheight = 2;
        c.insets = new Insets(2, 2, 2, 0); // top, left, bottom, right;
        add(label, c);

//        initGridBagConstraints(c);
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 2.0;
//        c.insets = new Insets(-5, 10, 0, 0); // top, left, bottom, right;
//        add(nameLabel, c);

//        initGridBagConstraints(c);
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1.0;
//        c.gridx = 1;
//        c.gridy = 1;
//        c.insets = new Insets(-10, 10, 0, 0); // top, left, bottom, right;
//        add(messageLabel2, c);

    }

    public CellRenderCadeiaDeReferencias() {
        this(new Adapter(null));
    }

    public Adapter getAdapter() {
        return binding;
    }

    public void setAdapter(Adapter binding) {
        if (binding == null) {
            throw new IllegalArgumentException("null binding");
        }
        this.binding = binding;
    }

    public final Adapter getAdapter(Integer value) {
        Adapter adapter = getAdapter();
        adapter.setValue(value);
        return adapter;
    }

    public static class Adapter {

        public Adapter(Integer celula) {
            this.value = celula;
        }
        private Integer value;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
