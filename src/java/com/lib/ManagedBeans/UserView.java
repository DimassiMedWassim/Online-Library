/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.DataConnect;
import com.lib.util.UserCRUD;
import com.lib.util.Users;
import com.mysql.jdbc.Connection;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author hidro
 */

    @ManagedBean(name = "userView")
@SessionScoped

public class UserView implements Serializable{

    
  
    private ArrayList<Users> uses;
     
    private ArrayList<Users> notValid;
      public UserView() {
        uses = UserCRUD.getAllUsers();
        notValid= UserCRUD.getNVUser();
    }

      public void valid(Users s){
          try {
      
            Connection con = DataConnect.getConnection();
            String q = "UPDATE Utilisateur SET valid = 1 WHERE id_uilisateur = " + s.getId() ;
            System.out.println(q);
            Statement commande = con.createStatement();
            System.out.println("sss");
            commande.executeUpdate(q);
                   System.out.println("lllolll");
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"user is now valid","success"));
            notValid= UserCRUD.getNVUser();
          }
          catch(Exception e){
              System.out.println("noool");
          }
      }
    public ArrayList<Users> getUses() {
        return uses;
    }

    public void setUses(ArrayList<Users> uses) {
        this.uses = uses;
    }

    public ArrayList<Users> getNotValid() {
        return notValid;
    }

    public void setNotValid(ArrayList<Users> notValid) {
        this.notValid = notValid;
    }   
}