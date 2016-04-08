/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
 


public class ImagesView {
     
    private List<String> images;
     
   
    public ImagesView() {
        ViewDocs docs = new ViewDocs();
        images = new ArrayList<String>();
        for(Doc doc : docs.getDocs()){
            images.add(doc.getImg());
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}
    

