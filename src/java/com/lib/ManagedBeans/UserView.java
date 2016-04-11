/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.UserCRUD;
import com.lib.util.Users;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author hidro
 */

    @ManagedBean(name = "customer")
@SessionScoped

public class UserView implements Serializable{

    /*
  
    private ArrayList<Users> uses;
     
    private ArrayList<Users> filteredCars;
      public UserView() {
                  UserCRUD d= new UserCRUD();
        uses = d.getAllUsers();
    }
    @PostConstruct
    public void init() {
        UserCRUD d= new UserCRUD();
        uses = d.getAllUsers();
    }

    public ArrayList<Users> getUses() {
         UserCRUD d= new UserCRUD();
        return d.getAllUsers();
    }

    public void setUses(ArrayList<Users> uses) {
        this.uses = uses;
    }
     
   



    public ArrayList<Users> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(ArrayList<Users> filteredCars) {
        this.filteredCars = filteredCars;
    }
*/
    private String categorie, description, nom;
    private int dispo,id;
// insert getter setter here

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }
    
    
public ArrayList<UserView> getMessages() {
        return UserCRUD.getAllUsers();
    }


public String reserver(UserView o){
    //LoginBean login= new LoginBean();
    System.out.println("*********************");
    
    
    /*if (login.getSessionnom()!=""){
        System.out.println("logiiiiiiiiiiiiiiiiiiin");
    boolean result = UserDAO.reserver(login.getSessionid(),o.id,o.nom);
    return "resources?faces-redirect=true";
    }
    else{
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
        return "login?faces-redirect=true";
    }*/
        return null;

}
}
