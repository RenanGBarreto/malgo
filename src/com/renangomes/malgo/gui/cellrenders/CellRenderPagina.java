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

import com.renangomes.malgo.Main;
import com.renangomes.malgo.entidades.Pagina;
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
import javax.swing.Icon;
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
public class CellRenderPagina extends PanelTransparente implements ListCellRenderer {

    private Adapter binding;
    private final Border noFocusBorder;
    private Color messageColor;
    private Font statusLabelFont;
    private ImageIcon defaultBuddyIcon;
    private JLabel statusLabel;
    private JLabel nameLabel;
    private JLabel messageLabel2;
    private JLabel buddyLabel;
    private final Insets zeroInsets = new Insets(0, 0, 0, 0);
    private Color nameColor = Color.BLACK;
    private boolean naMemoria = true;

    public CellRenderPagina(boolean t) {
        this(new Adapter(null));
        naMemoria = t;
    }

    @Override
    public Component getListCellRendererComponent(
            JList jList, Object value_tmp, int index, boolean isSelected, boolean hasFocus) {
        Pagina value = (Pagina) value_tmp;
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
        statusLabel.setBackground(getBackground());
        nameLabel.setForeground(getForeground());

        Adapter adapter = getAdapter(value);

        if (adapter == null || adapter.value == null) {
            setToolTipText("Espaço Livre");
            statusLabel.setText("Espaço Livre");
            nameLabel.setText("");
            messageLabel2.setText("");

        } else {
            setToolTipText(adapter.getToolTipText());
            statusLabel.setText(adapter.getNumero());
            nameLabel.setText(adapter.getLinha1());
            messageLabel2.setText(adapter.getLinha2());
        }

        Icon buddyIcon;
        if (!naMemoria) {
            buddyIcon = new ImageIcon(getClass().getResource("/com/renangomes/malgo/gui/imgs/Hardware-HardDrive-icon32.png"));
        } else {
            buddyIcon = new ImageIcon(getClass().getResource("/com/renangomes/malgo/gui/imgs/Drives-RAM-Drive-icon32.png"));
        }
        statusLabel.setIcon(buddyIcon);
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

    public CellRenderPagina(Adapter binding) {

        super(new GridBagLayout());

        this.binding = binding;
        noFocusBorder = new EmptyBorder(1, 1, 1, 1);
        setBorder(noFocusBorder);
        messageColor = this.getForeground();
        statusLabel = new JLabel();
        nameLabel = new JLabel("Numero");
        nameLabel.setHorizontalTextPosition(JLabel.LEADING);
        nameLabel.setForeground(this.getForeground());
        messageLabel2 = new JLabel("");
        buddyLabel = new JLabel(defaultBuddyIcon);
        buddyLabel.setBorder(new LineBorder(Color.black));
        statusLabelFont = statusLabel.getFont().deriveFont(18.0f).deriveFont(Font.BOLD);
        nameLabel.setPreferredSize(new Dimension(45, 30));
        statusLabel.setFont(statusLabelFont);
        messageLabel2.setForeground(messageColor);
        GridBagConstraints c = new GridBagConstraints();
        GridBagLayout l = (GridBagLayout) getLayout();

        initGridBagConstraints(c);
        c.gridheight = 2;
        c.insets = new Insets(2, 2, 2, 0); // top, left, bottom, right;
        add(statusLabel, c);

        initGridBagConstraints(c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 2.0;
        c.insets = new Insets(-5, 10, 0, 0); // top, left, bottom, right;
        add(nameLabel, c);

        initGridBagConstraints(c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(-10, 10, 0, 0); // top, left, bottom, right;
        add(messageLabel2, c);

    }

    public CellRenderPagina() {
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

    public final Adapter getAdapter(Pagina value) {
        Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.setValue(value);
        }
        return adapter;
    }

    public static class Adapter {

        public Adapter(Pagina celula) {
            setValue(celula);
        }

        public enum Status {

            MODIFICADA, NAOMODIFICADA;
        };
        private Pagina value;

        public Pagina getValue() {
            return value;
        }

        public void setValue(Pagina value) {
            this.value = value;
        }

        public String getNumero() {

            return Integer.toString(value.getNumero());
        }

        public Status getStatus() {
            if (value.isModificada()) {
                return Status.MODIFICADA;
            }
            return Status.NAOMODIFICADA;
        }

        public String getLinha1() {
            if (value.isReferenciada()) {
                return "Referenciada: SIM";
            }
            return "Referenciada: NÃO";

        }

        public String getLinha2() {
            if (value.isModificada()) {
                return "Modificada: SIM";
            }
            return "Modificada: NÃO";

        }

        public String getToolTipText() {
            return "Numero: " + getNumero() + " - " + getLinha1() + " - " + getLinha2();
        }
    }
}
