/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.measuresystem;

import co.unicauca.measuresystem.factory.ItemMedicion;


/**
 *
 * @author ahurtado
 */
public class ItemMedicionGenerico extends ItemMedicion{



    @Override
    public void run() {
        System.out.println("INICIANDO MEDICIÓN CON GENÉRICA ...");
        super.procesarMedicion();
    }

}
