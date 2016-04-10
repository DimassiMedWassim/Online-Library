/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import java.util.Comparator;
import org.primefaces.model.SortOrder;

/**
 *
 * @author hidro
 */
public class LazyDocSort implements Comparator<Doc>{

    private String sortField;
     
    private SortOrder sortOrder;
     
    public LazyDocSort(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
 
    @Override
    public int compare(Doc car1, Doc car2) {
        try {
            Object value1 = Doc.class.getField(this.sortField).get(car1);
            Object value2 = Doc.class.getField(this.sortField).get(car2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
    
}
