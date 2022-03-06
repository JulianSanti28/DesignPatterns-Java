/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adapterpattern;

/**
 *
 * @author 57322
 */
public class AcousticGuitarAdapter {

    public void play() {
        System.out.print("Iniciando prototipo:" + this.getClass());

    }

    public void leaveGuitar() {
        System.out.print("Finalizando prototipo:" + this.getClass());
    }
}
