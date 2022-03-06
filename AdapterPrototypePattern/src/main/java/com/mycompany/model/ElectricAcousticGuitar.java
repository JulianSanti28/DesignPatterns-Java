/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.adapterpattern.AcousticGuitarAdapter;
import com.mycompany.prototypepattern.Guitar;

/**
 *
 * @author 57322
 */
public class ElectricAcousticGuitar extends Guitar {

    //Composición   
    AcousticGuitarAdapter guitarraAcustica = new AcousticGuitarAdapter();

    @Override
    public void onGuitar() {

        this.guitarraAcustica.play();
        System.out.println(" con Id:" + this.getId());
    }

    @Override
    public void offGuitar() {

        this.guitarraAcustica.leaveGuitar();
        System.out.println(" con Id:" + this.getId());
    }

}
