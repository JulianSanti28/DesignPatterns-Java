/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.prototypepattern.Guitar;

/**
 *
 * @author 57322
 */
public class ElectricGuitar extends Guitar{

    @Override
    public void onGuitar() {
        System.out.println("Iniciando prototipo:" + this.getClass() + " Con Id:" + this.getId());
    }

    @Override
    public void offGuitar() {
        System.out.println("Finalizando prototipo:" + this.getClass() + " Con Id:" + this.getId());
    }
    
}
