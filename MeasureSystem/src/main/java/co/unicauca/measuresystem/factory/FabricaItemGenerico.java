/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.measuresystem.factory;

import co.unicauca.measuresystem.items.ItemMedicion;
import co.unicauca.measuresystem.items.ItemMedicionGenerico;

/**
 *
 * @author 57322
 */
public class FabricaItemGenerico extends FabricaItemMedicion {

    @Override
    public ItemMedicion getItem() {
        
        return new ItemMedicionGenerico();
    }


}
