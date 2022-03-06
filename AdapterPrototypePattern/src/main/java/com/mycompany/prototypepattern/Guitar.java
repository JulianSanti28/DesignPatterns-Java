/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prototypepattern;

/**
 * Clase que podrá ser clonada
 *
 * @author JSMT
 */
public abstract class Guitar implements Cloneable {

    private String id;

    public String getId() {
        return id;
    }

    //Getters and setters
    public void setId(String id) {
        this.id = id;
    }

    //Métodos
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    public abstract void onGuitar();

    public abstract void offGuitar();
}
