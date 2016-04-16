/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author hidro
 */
@ManagedBean
@Named(value = "nbrex")
@Dependent
public class Nbrex {
    private int nb;
    /**
     * Creates a new instance of bnr
     */
    public Nbrex() {
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }
    
}
