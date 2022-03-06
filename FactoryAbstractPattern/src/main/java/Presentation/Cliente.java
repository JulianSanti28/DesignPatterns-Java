/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Factory.VehicleFactory;
import Model.Car;
import Model.SUV;

/**
 *
 * @author 57322
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String vhCategory = "Non-Luxury"; // o se puede colocar Luxury
        String vhType = "Suv"; // o se puede colocar Car
        String searchResult = "";
        // Obtiene la fábrica concreta en vf
        VehicleFactory vf = VehicleFactory.getVehicleFactory(vhCategory);
        // Obtiene un Car de lujo o no lujo dependiendo de la fábrica y muestra en pantalla la
        //información
        Car c = vf.getCar();
        searchResult = "Name: " + c.getCarName() + " Features: "+ c.getCarFeatures();
        System.out.println(searchResult);
        // Obtiene un SUV de lujo o no lujo dependiendo de la fábrica y muestra en pantalla la
        //información
        SUV s = vf.getSUV();
        searchResult = "Name: " + s.getSUVName() + " Features: " + s.getSUVFeatures();
        System.out.println(searchResult);

    }

}
