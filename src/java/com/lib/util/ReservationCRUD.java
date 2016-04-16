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
public class ReservationCRUD {
    
    
    public static ArrayList<Res> getRes(){
        ArrayList<Res> users = new ArrayList<Res>();
        try {
            Connection con = DataConnect.getConnection();
            String q = "select * from Reserver where date_retour is NULL";
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            while(rs.next()){
                System.out.println(rs.getString(1));
                Res user = new Res();
                user.setIdex(rs.getString(1));
                user.setIdut(rs.getString(2));
                user.setDateres(rs.getString(3));
                user.setDateprev(rs.getString(4));
                user.setDateretour(rs.getString(5));

                users.add(user);
            }
            return users;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
}
}
