/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.Aut;
import com.lib.util.AuteurCRUD;
import com.lib.util.DataConnect;
import com.lib.util.UserCRUD;
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
public class AutView {
    private ArrayList<Aut> aut ;
    private Aut autsel;

    public Aut getAutsel() {
        return autsel;
    }

    public void setAutsel(Aut autsel) {
        this.autsel = autsel;
    }
    
    public AutView() {
        aut = AuteurCRUD.getAut();
    } 

    public ArrayList<Aut> getAut() {
        return aut;
    }

    public void setAut(ArrayList<Aut> aut) {
        this.aut = aut;
    }
    
    public void modif(Aut aut){
        try{
        Connection con = DataConnect.getConnection();
            String q = "UPDATE Utilisateur SET  nom_auteur = '"+aut.getNom()+"' pays = '"+aut.getPays()+"' date_nais = '"+aut.getDatenais()+"' WHERE id_auteur = " + aut.getId() ;
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
            Connection con = DataConnect.getConnection();
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
        Connection con = DataConnect.getConnection();
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
