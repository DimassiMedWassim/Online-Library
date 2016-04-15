/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.Aut;
import com.lib.util.AuteurCRUD;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author hidro
 */
@ManagedBean
@RequestScoped
public class AutView {
    private ArrayList<Aut> aut ;    
    public AutView() {
        aut = AuteurCRUD.getAut();
    } 

    public ArrayList<Aut> getAut() {
        return aut;
    }

    public void setAut(ArrayList<Aut> aut) {
        this.aut = aut;
    }
    
}
