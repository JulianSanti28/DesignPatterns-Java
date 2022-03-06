/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.measuresystem.items;

import co.unicauca.measuresystem.elements.Actuador;
import co.unicauca.measuresystem.elements.Analizador;
import co.unicauca.measuresystem.elements.Sensor;
import co.unicauca.measuresystem.repository.Factory;
import co.unicauca.measuresystem.repository.IMeasureRepository;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author 57322
 */
public abstract class ItemMedicion {

    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();;
    private Actuador miActuador;
    private Analizador miAnalizer;
    private IMeasureRepository miRepositorio;
    private HashMap<Sensor, Float> lecturas = new HashMap<Sensor, Float>();;
    private int sensoresCorrectos = 0;
    private boolean isCorrect;

    public abstract void run();

    public void procesarMedicion() {
        if (this.getMiRepositorio() == null) {

            this.setMiRepositorio(Factory.getInstance().getRepository());
        }
        hacerLeerSensores();
        this.lecturas.entrySet().forEach(s -> {
            almacenarInformacion(s.getKey(), s.getValue());
        });
        this.lecturas.entrySet().forEach(s -> {
            if (compararValores(s.getKey(), s.getValue())) {
                this.miRepositorio.save(s.getKey(), s.getValue(), true);//Save report
                this.sensoresCorrectos++;
            } else {
                this.miRepositorio.save(s.getKey(), s.getValue(), false);//Save report
            }
        });
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

    protected abstract boolean compararValores(Sensor sensor, float lectura);

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
    public IMeasureRepository getMiRepositorio() {
        return miRepositorio;
    }

    /**
     * @param miRepositorio the miRepositorio to set
     */
    public void setMiRepositorio(IMeasureRepository miRepositorio) {
        this.miRepositorio = miRepositorio;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

}
