/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.DataConnect;
import com.lib.util.SessionBean;
import com.lib.util.UserCRUD;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.mysql.jdbc.Connection;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wassim
 */
@ManagedBean
@RequestScoped
@Named(value = "doc")
public class Doc {

    private String id;
    private String id_au;
    private String id_cat;
    private String titre;
    private String auteur;
    private String categorie;
    private String img;
    private String dateSortie;
    private String langage;
    private String description;
    private boolean dispo;

    public String getId_au() {
        return id_au;
    }

    public void setId_au(String id_au) {
        this.id_au = id_au;
    }

    public String getId_cat() {
        return id_cat;
    }

    public void setId_cat(String id_cat) {
        this.id_cat = id_cat;
    }

    /**
     * Creates a new instance of Doc
     */
    public Doc() {

    }

    public Doc(String id, String titre, String auteur, String categorie, String img, String dateSortie, String langage, String description) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.img = img;
        this.dateSortie = dateSortie;
        this.langage = langage;
        this.description = description;
        this.dispo = checkDispo();
        System.out.println(dispo);
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

    public boolean checkDispo() {
        System.out.println("id:" + this.id);
        String q = "select count(*) FROM Exemplaire WHERE id_livre = " + id + " AND etat = 'dispo'";
        Connection con = DataConnect.getConnection();
        try {

            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            int nb = 0;

            while (rs.next()) {
                nb = rs.getInt(1);
            }
            if (nb > 0) {
                return true;
            }

        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return false;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void reserver() {
        String q1 = "select id_exemp FROM Exemplaire WHERE id_livre = " + this.id + " AND etat = 'dispo'";
        String q2 = "UPDATE Exemplaire set etat='reserve' where id_exemp='";

        HttpSession session = SessionBean.getSession();
        String id = (String) session.getAttribute("userID");
        String q3 = "insert into Reserver(`id_exemp`, `id_utilisateur`, `date_reserv`) values(";
        try {
            Connection con = DataConnect.getConnection();

            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q1);
            String idex = "";
            while (rs.next()) {
                idex = rs.getString(1);
            }

            int x = commande.executeUpdate(q2 + idex + "'");

            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String currentTime = sdf.format(dt);
            q3 += idex + "," + id + ",'"+currentTime+"')";
            System.out.println(q3);
            x = commande.executeUpdate(q3);
            addMessage("Document réservé");

        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
