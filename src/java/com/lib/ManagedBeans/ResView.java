/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.DataConnect;
import com.lib.util.Res;
import com.lib.util.ReservationCRUD;
import com.lib.util.UserCRUD;
import com.mysql.jdbc.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
    public void retour(Res res){
        try{
        Connection con = DataConnect.getConnection();
            String q = "UPDATE Exemplaire SET etat = 'dispo' WHERE id_exemp = " + res.getIdex() ;
            System.out.println(q);
            Statement commande = con.createStatement();
            System.out.println("sss");
            commande.executeUpdate(q);
            q = "UPDATE Reserver SET date_retour ="+new Date().toString()+" WHERE id_exemp = " + res.getIdex()+" and id_utilisateur ="+ res.getIdut() ;
            commande.executeUpdate(q);
            System.out.println("lllolll");
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"user is now valid","success"));

          }
          catch(Exception e){
              System.out.println("noool");
          }
    }
    public void perdu(Res res){
        try{
        Connection con = DataConnect.getConnection();
            String q = "UPDATE Exemplaire SET etat = 'perdu' WHERE id_exemp = " + res.getIdex() ;
            System.out.println(q);
            Statement commande = con.createStatement();
            System.out.println("sss");
            commande.executeUpdate(q);
                   q = "UPDATE Reserver SET date_retour ="+new Date().toString()+" WHERE id_exemp = " + res.getIdex()+" and id_utilisateur ="+ res.getIdut() ;
            commande.executeUpdate(q);
                   System.out.println("lllolll");
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"user is now valid","success"));

          }
          catch(Exception e){
              System.out.println("noool");
          }
    }
}
