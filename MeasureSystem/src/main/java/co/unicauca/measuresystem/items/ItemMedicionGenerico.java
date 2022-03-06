/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.measuresystem.items;

import co.unicauca.measuresystem.elements.Sensor;


/**
 *
 * @author ahurtado
 */
public class ItemMedicionGenerico extends ItemMedicion{



    @Override
    public void run() {
        super.procesarMedicion();
    }

    @Override
    protected boolean compararValores(Sensor sensor, float lectura) {
        return getMiAnalizer().comparar(sensor, lectura,0);
    }
}
