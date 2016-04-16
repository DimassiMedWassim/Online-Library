/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.Aut;
import com.lib.util.DataConnect;
import com.lib.util.DocCRUD;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author wassim
 */
@ManagedBean
@RequestScoped
@Named(value = "viewDocs")

public class ViewDocs implements Serializable{
    private List<Doc> docs;
    private List<Doc> catDocs;

    public void setCatDocs(List<Doc> catDocs) {
        this.catDocs = catDocs;
    }

    public List<Doc> getCatDocs() {
        return catDocs;
    }
    /**
     * Creates a new instance of ViewDocs
     */
    public ViewDocs() {
        DocCRUD dc = new DocCRUD();
        docs = dc.getAllDocs();
        viewAll();
    }
    
    public void categories(String categorie){
        DocCRUD dc = new DocCRUD();
        this.catDocs = dc.getCategorieDocs(categorie);
    }
    
    public void viewAll(){
        DocCRUD dc = new DocCRUD();
        catDocs = dc.getAllDocs();
    }

    public List<Doc> getDocs() {
        return docs;
    }

    

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    
    
    public String search(){
        return "search";
    }
    public void addExemp(Doc doc,Nbrex nbr){
        com.mysql.jdbc.Connection con = DataConnect.getConnection();
        Statement commande;
        try {
            commande = con.createStatement();

        String q = "insert into Exemplaire (id_livre,etat) values ('"+doc.getId()+"','dispo')" ;
            for(int i=0;i<nbr.getNb();i++){

                commande.executeUpdate(q);}
        }
             catch (SQLException ex) {
                Logger.getLogger(ViewDocs.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    public void modif(Doc doc){
        try{
        com.mysql.jdbc.Connection con = DataConnect.getConnection();
            String q = "UPDATE Livre SET  titre = '"+doc.getTitre()+"', id_auteur = '"+doc.getId_au()+"', id_cat = '"+doc.getId_cat()+"', langage = '"+doc.getLangage()+"', date_sortie = '"+doc.getDateSortie()+"' WHERE id_livre = " + doc.getId() ;
            System.out.println(q);
            Statement commande = con.createStatement();
            
            commande.executeUpdate(q);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"supprime","success"));
          }
          catch(Exception e){
              System.out.println("nooo");
          }
    }
    public void supp(Doc doc){
        try{
            com.mysql.jdbc.Connection con = DataConnect.getConnection();
            String q = "delete from Livre WHERE id_livre = " + doc.getId() ;
            System.out.println(q);
            Statement commande = con.createStatement();
            
            commande.executeUpdate(q);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"supprime","success"));
          }
          catch(Exception e){
              System.out.println("nooo");
          }
    }
    public void add(Doc doc,Nbrex nbr){
        try{
        com.mysql.jdbc.Connection con = DataConnect.getConnection();
            String q = "insert into Livre (titre, id_auteur , id_cat, langage,date_sortie ) values ('"+doc.getTitre()+"','"+doc.getAuteur()+"','"+doc.getId_cat()+"','"+doc.getLangage()+"','"+doc.getDateSortie()+"')" ;
            System.out.println(q);
            Statement commande = con.createStatement();
            
            commande.executeUpdate(q);
            q = "insert into Exemplaire (id_livre,etat) values ('"+doc.getId()+"','dispo')" ;
            for(int i=0;i<nbr.getNb();i++){
                commande.executeUpdate(q);
            }
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"supprime","success"));
          }
          catch(Exception e){
              System.out.println("nooo");
          }
    }
    
}
