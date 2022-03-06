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
public abstract class Actuador {

    public abstract boolean ejecutarAccion(int cantidadSensores, int sensoresCorrectos);
    
}
