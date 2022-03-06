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
public class NonLuxurySUV implements SUV {

    private String name;

    public NonLuxurySUV(String sName) {
        name = sName;
    }

    @Override
    public String getSUVName() {
        return this.name;
    }

    @Override
    public String getSUVFeatures() {
        return "Non Luxury SUV Features";
    }

}
