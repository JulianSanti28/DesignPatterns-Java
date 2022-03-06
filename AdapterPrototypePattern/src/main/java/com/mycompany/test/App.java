/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

import com.mycompany.prototypepattern.Guitar;
import com.mycompany.prototypepattern.GuitarCache;

/**
 *
 * @author 57322
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Cargar Objetos a Clonar
        GuitarCache.loadCache(); 
        Guitar copy1 = GuitarCache.getGuitar("1");
        copy1.onGuitar();
        
        GuitarCache.loadCache(); 
        Guitar copy2 = GuitarCache.getGuitar("3");
        copy2.onGuitar();

    }

}
