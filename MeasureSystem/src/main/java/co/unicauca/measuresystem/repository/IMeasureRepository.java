/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.measuresystem.repository;

import co.unicauca.measuresystem.elements.Sensor;

/**
 *
 * @author 57322
 */
public interface IMeasureRepository {
    boolean save(Sensor s, float lectura, boolean estado);
}
