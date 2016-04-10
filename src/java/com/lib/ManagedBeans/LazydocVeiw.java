/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author hidro
 */
@Named(value = "lazydocVeiw")
@ViewScoped
public class LazydocVeiw implements Serializable {
private LazyDataModel<Doc> lazyModel;
     
    private Doc selectedDoc;
     
     
    @PostConstruct
    public void init() {
        lazyModel = new LazyDocModel();
    }
 
    public LazyDataModel<Doc> getLazyModel() {
        return lazyModel;
    }
 
    public Doc getSelectedDoc() {
        return selectedDoc;
    }
 
    public void setSelectedDoc(Doc selectedDoc) {
        this.selectedDoc = selectedDoc;
    }
     

     
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Doc Selected", ((Doc) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
