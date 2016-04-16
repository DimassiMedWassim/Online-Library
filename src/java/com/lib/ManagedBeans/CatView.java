/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;


import com.lib.util.Cat;
import com.lib.util.CatCRUD;
import com.lib.util.DataConnect;
import com.mysql.jdbc.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
    public void modif(Cat cat){
        try{
        Connection con = DataConnect.getConnection();
            String q = "UPDATE Categorie SET  nom = '"+cat.getNom()+"' WHERE id_cat = " + cat.getId() ;
            System.out.println(q);
            Statement commande = con.createStatement();
            
            commande.executeUpdate(q);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"supprime","success"));
          }
          catch(Exception e){
              System.out.println("nooo");
          }
    }
    public void supp(Cat cat){
        try{
            Connection con = DataConnect.getConnection();
            String q = "delete from Categorie WHERE id_cat = " + cat.getId() ;
            System.out.println(q);
            Statement commande = con.createStatement();
            
            commande.executeUpdate(q);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"supprime","success"));
          }
          catch(Exception e){
              System.out.println("nooo");
          }
    }
    public void add(Cat cat){
        try{
        Connection con = DataConnect.getConnection();
            String q = "insert into Categorie (nom) values ('"+cat.getNom()+"')" ;
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
