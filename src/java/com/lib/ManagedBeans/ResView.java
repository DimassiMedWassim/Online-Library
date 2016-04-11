/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.Res;
import com.lib.util.ReservationCRUD;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author hidro
 */
@ManagedBean(name = "resView")
@RequestScoped
public class ResView {
private ArrayList<Res> res ;    

    public ArrayList<Res> getRes() {
        return res;
    }

    public void setRes(ArrayList<Res> res) {
        this.res = res;
    }

    public ResView() {
        res = ReservationCRUD.getRes();
    } 
}
