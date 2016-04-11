/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.DataConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 *
 * @author wassim
 */
public class Doc {

    private String id;
    private String titre;
    private String auteur;
    private String categorie;
    private String img;
    private String dateSortie;
    private String langage;
    private String description;
    
    /**
     * Creates a new instance of Doc
     */
    public Doc() {

    }

    public Doc(String id, String titre, String auteur, String categorie, String img, String dateSortie, String langage,String description) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.img = img;
        this.dateSortie = dateSortie;
        this.langage = langage;
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getImg() {
        return img;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public String getLangage() {
        return langage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }
    
    public boolean isDispo(){
        String q = "select count( * ) FROM Exemplaire WHERE id_livre = '" +id+"' AND etat = 'dispo'";
        try {
            Connection con = DataConnect.getConnection();
            
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            int nb = 0;
            while(rs.next()){
                nb=rs.getInt(1);
            }
            if(nb>0){
                return true;
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return false;
    }
    
    public void reserver(){
        String q1 ="select id_exemp FROM Exemplaire WHERE id_livre = '" +id+"' AND etat = 'dispo'";
        String q2="UPDATE Exemplaire set etat='reserve' where id_exemp='";
        try {
            Connection con = DataConnect.getConnection();
            
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q1);
            String idex="";
            while(rs.next()){
                idex=rs.getString(1);
            }
            int x = commande.executeUpdate(q2+idex+"'");
            

        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
    }
    
}
