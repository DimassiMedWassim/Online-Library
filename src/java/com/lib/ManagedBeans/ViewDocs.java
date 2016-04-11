/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.DocCRUD;
import java.sql.Connection;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;

/**
 *
 * @author wassim
 */
@ManagedBean
@Named(value = "viewDocs")

public class ViewDocs {
    private List<Doc> docs;
    private List<Doc> ranDocs;
    private List<Doc> catDocs;

    public void setCatDocs(List<Doc> catDocs) {
        this.catDocs = catDocs;
    }

    public List<Doc> getCatDocs() {
        return catDocs;
    }
    /**
     * Creates a new instance of ViewDocs
     */
    public ViewDocs() {
        DocCRUD dc = new DocCRUD();
        docs = dc.getAllDocs();
        viewAll();
    }
    
    public void categories(String categorie){
        DocCRUD dc = new DocCRUD();
        this.catDocs = dc.getCategorieDocs(categorie);
    }
    
    public void viewAll(){
        DocCRUD dc = new DocCRUD();
        catDocs = dc.getAllDocs();
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public List<Doc> getRanDocs() {
        return ranDocs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    public void setRanDocs(List<Doc> ranDocs) {
        this.ranDocs = ranDocs;
    }
    
    
}
