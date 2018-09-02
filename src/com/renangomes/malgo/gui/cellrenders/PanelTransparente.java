package com.renangomes.malgo.gui.cellrenders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager2;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Renan Gomes
 */
public class PanelTransparente extends JPanel {

    Timer contador;
    private float opacity = 0.0f;
    private float limite = 0.8f;
    Thread t = new Thread() {

        public void run() {
            while (true) {
                try {
                    tempo();
                    sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    };

    public PanelTransparente() {
        super();
        setOpaque(false);
        t.start();
    }

    public PanelTransparente(LayoutManager2 layout) {
        super(layout);
        setOpaque(false);
        t.start();

    }

    public void tempo() {
        setOpacity((float) (getOpacity() + .03));
        if (getOpacity() > getLimite()) {
            setOpacity(0f);

        }
        repaint();
    }

//    public void actionPerformed(ActionEvent e) {
//            setOpacity((float) (getOpacity() + .03));
//            if(getOpacity() > getLimite()) {
//                setOpacity(getLimite());
//                contador.stop();
//                contador = null;
//            }
//            repaint();
//    }
    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent( g );
        g.setColor(new Color(0.2f, 0.2f, 0.5f, getOpacity()));
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    /**
     * @return the opacity
     */
    public float getOpacity() {
        return opacity;
    }

    /**
     * @param opacity the opacity to set
     */
    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    /**
     * @return the limite
     */
    public float getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(float limite) {
        this.limite = limite;
    }

    public void restartTime() {
        setOpacity(0f);
    }
}
