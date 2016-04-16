/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.util;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author hidro
 */
@ManagedBean
@Named(value = "res")
public class Res {
    private String idex,idut,dateres,dateprev,dateretour;

    public String getIdex() {
        return idex;
    }

    public void setIdex(String idex) {
        this.idex = idex;
    }

    public String getIdut() {
        return idut;
    }

    public void setIdut(String idut) {
        this.idut = idut;
    }

    public String getDateres() {
        return dateres;
    }

    public void setDateres(String dateres) {
        this.dateres = dateres;
    }

    public String getDateprev() {
        return dateprev;
    }

    public void setDateprev(String dateprev) {
        this.dateprev = dateprev;
    }

    public String getDateretour() {
        return dateretour;
    }

    public void setDateretour(String dateretour) {
        this.dateretour = dateretour;
    }
    
}
