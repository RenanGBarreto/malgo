/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renangomes.malgo.entidades;

/**
 *
 * @author RenanGomes
 */
public class Pagina {

    
    private boolean modificada = false;
    private boolean referenciada = false;
    private int numero = 0;
    
    public Pagina (int n){
        numero = n;
    }

    /**
     * @return the modificada
     */
    public boolean isModificada() {
        return modificada;
    }

    /**
     * @param modificada the modificada to set
     */
    public void setModificada(boolean modificada) {
        this.modificada = modificada;
    }

    /**
     * @return the referenciada
     */
    public boolean isReferenciada() {
        return referenciada;
    }

    /**
     * @param referenciada the referenciada to set
     */
    public void setReferenciada(boolean referenciada) {
        this.referenciada = referenciada;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
