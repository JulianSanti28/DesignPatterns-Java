/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.measuresystem.factory;

import co.unicauca.measuresystem.items.ItemMedicion;

public abstract class FabricaItemMedicion {

    public static final String ITEM_GENERICO = "generico";
    public static final String ITEM_PRECISO = "preciso";

    public abstract ItemMedicion getItem();

    public static FabricaItemMedicion getItemMedicionFactory(String type) {
        if (type.equals(FabricaItemMedicion.ITEM_GENERICO)) {
            return new FabricaItemGenerico();
        }
        if (type.equals(FabricaItemMedicion.ITEM_PRECISO)) {
            return new FabricaItemPreciso();
        }
        return null;
    }

}
