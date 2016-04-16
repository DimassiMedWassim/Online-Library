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
public class CatCRUD {
    
    public static ArrayList<Cat> getCat(){
        ArrayList<Cat> users = new ArrayList<Cat>();
        try {
            Connection con = DataConnect.getConnection();
            String q = "select * from Categorie";
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            while(rs.next()){
                System.out.println(rs.getString(1));
                Cat user = new Cat();
                user.setId(rs.getString(1));
                user.setNom(rs.getString(2));

                users.add(user);
            }
            return users;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }
}
