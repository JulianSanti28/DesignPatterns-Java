/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.measuresystem.factory;

import co.unicauca.measuresystem.Actuador;
import co.unicauca.measuresystem.Analizador;
import co.unicauca.measuresystem.IRepositorio;
import co.unicauca.measuresystem.Sensor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 57322
 */
public abstract class ItemMedicion {

    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    private Actuador miActuador;
    private Analizador miAnalizer;
    private IRepositorio miRepositorio;
    private HashMap<Sensor, Float> lecturas = new HashMap<Sensor, Float>();
    private int sensoresCorrectos = 0;
    private boolean isCorrect;


    public abstract void run();

    public void procesarMedicion() {
        hacerLeerSensores();
        for (Map.Entry<Sensor, Float> s : this.lecturas.entrySet()) {
            almacenarInformacion(s.getKey(), s.getValue());
        }
        for (Map.Entry<Sensor, Float> s : this.lecturas.entrySet()) {
            if (compararValores(s.getKey(), s.getValue())) {
                this.sensoresCorrectos++;
            }
        }
        //Cuando se procesen los sensores
        this.isCorrect = ejecutarAcciones(this.sensores.size(), this.sensoresCorrectos);
    }

    protected HashMap<Sensor, Float> hacerLeerSensores() {
        for (Sensor s : this.sensores) {
            this.lecturas.put(s, s.leer());
        }
        return this.lecturas;
    }

    protected void almacenarInformacion(Sensor sensor, float lectura) {
    }

    protected boolean compararValores(Sensor sensor, float lectura) {
        return getMiAnalizer().comparar(sensor, lectura);
    }

    protected boolean ejecutarAcciones(int cantidadSensores, int sensoresCorrectos) {
        return getMiActuador().ejecutarAccion(cantidadSensores, sensoresCorrectos);
    }

    /**
     * @return the miSensor
     */
    public ArrayList<Sensor> getMiSensor() {
        return this.sensores;
    }

    /**
     * @param miSensor the miSensor to set
     */
    public void agregarSensor(Sensor miSensor) {
        this.sensores.add(miSensor);
    }

    /**
     * @return the miActuador
     */
    public Actuador getMiActuador() {
        return miActuador;
    }

    /**
     * @param miActuador the miActuador to set
     */
    public void setMiActuador(Actuador miActuador) {
        this.miActuador = miActuador;
    }

    /**
     * @return the miAnalizer
     */
    public Analizador getMiAnalizer() {
        return miAnalizer;
    }

    /**
     * @param miAnalizer the miAnalizer to set
     */
    public void setMiAnalizer(Analizador miAnalizer) {
        this.miAnalizer = miAnalizer;
    }

    /**
     * @return the miRepositorio
     */
    public IRepositorio getMiRepositorio() {
        return miRepositorio;
    }

    /**
     * @param miRepositorio the miRepositorio to set
     */
    public void setMiRepositorio(IRepositorio miRepositorio) {
        this.miRepositorio = miRepositorio;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    
    
}
