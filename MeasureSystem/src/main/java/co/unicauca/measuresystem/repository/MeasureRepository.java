/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.measuresystem.repository;

import co.unicauca.measuresystem.elements.Sensor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 57322
 */
public class MeasureRepository implements IMeasureRepository {

    /*Manejo de Archivo*/
    private File fichero;
    private BufferedWriter bw;
    private PrintWriter wr;
    private FileWriter f;

    public MeasureRepository() {
        initFileReport();
    }

    @Override
    public boolean save(Sensor s, float lectura, boolean estado) {
        try {
            f = new FileWriter("./reporte.txt", true);
            bw = new BufferedWriter(f);
            bw.write("Sensor: " + s.getNombre() + " " + "Lectura Obtenida: " + " " + lectura + " " + "ESTADO:" + " " + ((estado) ? "APROBADO" : "NO APROBADO"));
            bw.newLine();
        } catch (IOException ex) {
            Logger.getLogger(MeasureRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(MeasureRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    public void initFileReport() {
        try {
                fichero = new File("./reporte.txt");
                fichero.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(MeasureRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
