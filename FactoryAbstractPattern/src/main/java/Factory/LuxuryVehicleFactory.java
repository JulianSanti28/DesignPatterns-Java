/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Model.Car;
import Model.SUV;

/**
 *
 * @author 57322
 */
public class LuxuryVehicleFactory extends VehicleFactory {

    public LuxuryVehicleFactory() {
    }

    @Override
    public Car getCar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SUV getSUV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
