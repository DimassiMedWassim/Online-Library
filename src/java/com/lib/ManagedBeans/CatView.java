/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.Cat;
import com.lib.util.CatCRUD;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author hidro
 */
@ManagedBean
@RequestScoped
public class CatView {
private ArrayList<Cat> cat ;    
    /**
     * Creates a new instance of CatView
     */
    public CatView() {
        cat = CatCRUD.getCat();
    }

    public ArrayList<Cat> getCat() {
        return cat;
    }

    public void setCat(ArrayList<Cat> cat) {
        this.cat = cat;
    }
    
}
