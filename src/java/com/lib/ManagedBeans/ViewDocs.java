/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.Aut;
import com.lib.util.DataConnect;
import com.lib.util.DocCRUD;
import java.sql.Connection;
import java.sql.Statement;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
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

public class ViewDocs {
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
    public void modif(Aut aut){
        try{
        com.mysql.jdbc.Connection con = DataConnect.getConnection();
            String q = "UPDATE Auteur SET  nom_auteur = '"+aut.getNom()+"', pays = '"+aut.getPays()+"', date_nais = '"+aut.getDatenais()+"' WHERE id_auteur = " + aut.getId() ;
            System.out.println(q);
            Statement commande = con.createStatement();
            
            commande.executeUpdate(q);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"supprime","success"));
          }
          catch(Exception e){
              System.out.println("nooo");
          }
    }
    public void supp(Aut aut){
        try{
            com.mysql.jdbc.Connection con = DataConnect.getConnection();
            String q = "delete from Auteur WHERE id_auteur = " + aut.getId() ;
            System.out.println(q);
            Statement commande = con.createStatement();
            
            commande.executeUpdate(q);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"supprime","success"));
          }
          catch(Exception e){
              System.out.println("nooo");
          }
    }
    public void add(Aut aut){
        try{
        com.mysql.jdbc.Connection con = DataConnect.getConnection();
            String q = "insert into Auteur (nom_auteur, pays , date_nais ) values ('"+aut.getNom()+"','"+aut.getPays()+"','"+aut.getDatenais()+"')" ;
            System.out.println(q);
            Statement commande = con.createStatement();
            
            commande.executeUpdate(q);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"supprime","success"));
          }
          catch(Exception e){
              System.out.println("nooo");
          }
    }
    
}
