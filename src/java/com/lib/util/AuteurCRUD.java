/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.util;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hidro
 */
public class AuteurCRUD {
    
    public static ArrayList<Aut> getAut(){
        ArrayList<Aut> users = new ArrayList<Aut>();
        try {
            Connection con = DataConnect.getConnection();
            String q = "select * from Auteur";
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            while(rs.next()){
                System.out.println(rs.getString(1));
                Aut user = new Aut();
                user.setId(rs.getString(1));
                user.setNom(rs.getString(2));
                user.setPays(rs.getString(3));
                user.setDatenais(rs.getString(4));

                users.add(user);
            }
            return users;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }
    public static String getAN(String id){
        try {
            Connection con = DataConnect.getConnection();
            String q = "select * from Auteur where id_auteur= "+id;
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            while(rs.next()){
                return rs.getString(2);
            }
            
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
        return null;
    }
}
