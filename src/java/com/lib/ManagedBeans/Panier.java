/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.SessionBean;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
    
    public void addDoc(Doc doc){
         
        if(docs.contains(doc)){
            addMessage("Ce document existe déjà dans le panier");
        }else{
            docs.add(doc);
            addMessage("Document ajouté !!");
        }
        
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }
    
    public void deleteDoc(Doc doc){
        docs.remove(doc);
        addMessage("deleted");
    }
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void confirmAll(){
        for(Doc doc : docs){
            doc.reserver();
            deleteDoc(doc);
        }
        addMessage("Tous les documents sont réservés");
    }
}
