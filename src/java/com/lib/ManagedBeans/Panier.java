/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author wassim
 */
@Named(value = "panier")

public class Panier {
    private List<Doc> docs;
    /**
     * Creates a new instance of Panier
     */
    public Panier() {
        docs = new ArrayList<Doc>();
    }
    
    public boolean addDoc(Doc doc){
        if(docs.add(doc)){
            return(true);
        }
        return false;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }
    
}
