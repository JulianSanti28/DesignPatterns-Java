/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Model.Car;
import Model.NonLuxuryCar;
import Model.NonLuxurySUV;
import Model.SUV;

/**
 * @author 57322
 */
public class NonLuxuryVehicleFactory extends VehicleFactory {

    @Override
    public Car getCar() {
        
        return new NonLuxuryCar("N-L-C");
    }

    @Override
    public SUV getSUV() {
        return new NonLuxurySUV("N-L-S");
    }
    
}
