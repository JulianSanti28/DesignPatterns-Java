/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.measuresystem.items;

import co.unicauca.measuresystem.elements.Sensor;
import javax.swing.JOptionPane;

/**
 *
 * @author 57322
 */
public class ItemMedicionPreciso extends ItemMedicion {

    @Override
    public void run() {
        super.procesarMedicion();
    }

    @Override
    protected boolean compararValores(Sensor sensor, float lectura) {
        float valorAjuste = Integer.parseInt(JOptionPane.showInputDialog("Ajuste -> Sensor [" + sensor.getNombre() + "]"));
        return getMiAnalizer().comparar(sensor, lectura, valorAjuste);
    }
    
    
}
