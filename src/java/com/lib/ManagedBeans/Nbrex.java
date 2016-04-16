/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import java.io.Serializable;

/**
 *
 * @author hidro
 */
public class Nbrex implements Serializable{
private int nb;

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    /**
     * Creates a new instance of Nbrex
     */
    public Nbrex() {
    }
    
}
