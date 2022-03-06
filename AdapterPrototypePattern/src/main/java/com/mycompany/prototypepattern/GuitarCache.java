/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prototypepattern;

import com.mycompany.model.ElectricAcousticGuitar;
import com.mycompany.model.ElectricGuitar;
import java.util.HashMap;

/**
 *
 * @author 57322
 */
public class GuitarCache {

    private static HashMap<String, Guitar> GuitarMap = new HashMap<String, Guitar>();

    public static Guitar getGuitar(String guitarId) {
        Guitar cacheGuitar = GuitarMap.get(guitarId);
        return (Guitar) cacheGuitar.clone();
    }

    public static void loadCache() {
        ElectricGuitar e1 = new ElectricGuitar();
        e1.setId("1");
        GuitarMap.put(e1.getId(), e1);
        ElectricGuitar e2 = new ElectricGuitar();
        e2.setId("2");
        GuitarMap.put(e2.getId(), e2);
        ElectricAcousticGuitar ea1 = new ElectricAcousticGuitar();
        ea1.setId("3");
        GuitarMap.put(ea1.getId(), ea1);
        ElectricAcousticGuitar ea2 = new ElectricAcousticGuitar();
        ea2.setId("4");
        GuitarMap.put(ea2.getId(), ea2);

    }

}
