/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.util;

import com.lib.ManagedBeans.Doc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.lib.ManagedBeans.Doc;
import java.util.ArrayList;

/**
 *
 * @author wassim
 */
public class DocCRUD {

    public DocCRUD() {

    }

    public List<Doc> getAllDocs() {
        List<Doc> docs = new ArrayList<Doc>();
        try {
            Connection con = DataConnect.getConnection();
            String q = "select * from Livre";
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            while(rs.next()){
                Doc doc = new Doc();
                doc.setId(rs.getString(1));
                doc.setTitre(rs.getString(2));
                doc.setAuteur(this.getAuteur(rs.getString(3)));
                doc.setCategorie(this.getCategorie(rs.getString(4)));
                doc.setLangage(rs.getString(5));
                doc.setDateSortie(rs.getString(6));
                doc.setImg(rs.getString(7));
                doc.setDescription(rs.getString(8));
                
                docs.add(doc);
            }
            return docs;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }
    
    public String getAuteur(String id){
        try {
            Connection con = DataConnect.getConnection();
            String q = "select nom_auteur from Auteur where id_auteur='"+id+"'";
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            String auteur=null;
            while(rs.next()){
                auteur=rs.getString(1);
            }
            return auteur;

        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }
    
    public String getCategorie(String id){
        try {
            Connection con = DataConnect.getConnection();
            String q = "select nom from Categorie where id_cat='"+id+"'";
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            String cat=null;
            while(rs.next()){
                cat=rs.getString(1);
            }
            return cat;

        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }
    
    public List<String> getAllCategories(){
        try {
            Connection con = DataConnect.getConnection();
            String q = "select nom from Categorie";
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            List<String> cat = new ArrayList<String>();
            while(rs.next()){
                cat.add(rs.getString(1));
            }
            return cat;

        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    } 
    
    
    
    public List<Doc> getCategorieDocs(String cat){
        try {
            
            Connection con = DataConnect.getConnection();
            String q = "select * from Livre l, Categorie c where c.id_cat=l.id_cat and c.nom = '"+cat+"'";
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            List<Doc> docs = new ArrayList<Doc>() ;
            while(rs.next()){
                Doc doc = new Doc();
                doc.setId(rs.getString(1));
                doc.setTitre(rs.getString(2));
                doc.setAuteur(this.getAuteur(rs.getString(3)));
                doc.setCategorie(this.getCategorie(rs.getString(4)));
                doc.setLangage(rs.getString(5));
                doc.setDateSortie(rs.getString(6));
                doc.setImg(rs.getString(7));
                doc.setDescription(rs.getString(8));
                
                System.out.println(rs.getString(2));
                docs.add(doc);
            }
            return docs;

        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }
    
}
