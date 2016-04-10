/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;
import com.lib.util.
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author hidro
 */
@Named(value = "userView")
@Dependent
public class UserView implements Serializable{

    /**
     * Creates a new instance of UserView
     */
    public UserView() {
    }
    private List<Users> uses;
     
    private List<Users> filteredCars;
    
    @PostConstruct
    public void init() {
        uses = service.createCars(10);
    }
     
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    public List<Users> getCars() {
        return uses;
    }

    public void setCars(List<Users> uses) {
        this.uses = uses;
    }

    public List<Users> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Users> filteredCars) {
        this.filteredCars = filteredCars;
    }
    
}
