/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 57322
 */
public class NonLuxuryCar implements Car {

    private String name;

    public NonLuxuryCar(String cName) {
        name = cName;
    }

    @Override
    public String getCarName() {
        return name;
    }

    @Override
    public String getCarFeatures() {
        return "Non-Luxury Car Features ";
    }

}
