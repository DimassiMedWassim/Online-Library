/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;


import java.util.Date;

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
    
    /**
     * Creates a new instance of Doc
     */
    public Doc() {

    }

public Doc(String id, String titre, String auteur, String categorie, String img, String dateSortie, String langage) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.img = img;
        this.dateSortie = dateSortie;
        this.langage = langage;
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
    
    
}
