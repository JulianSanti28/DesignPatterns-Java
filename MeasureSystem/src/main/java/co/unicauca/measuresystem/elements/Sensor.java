/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.measuresystem.elements;

/**
 *
 * @author ahurtado
 */
public abstract class  Sensor {
    //Atributos
    private int id;
    private String nombre;
    
    //Constructor
    private Sensor(){
        
    }

    public Sensor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    //Encapsulamiento
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Métodos
    public abstract float leer();
}
