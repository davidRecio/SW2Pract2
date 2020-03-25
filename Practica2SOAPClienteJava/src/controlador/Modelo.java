/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.util.ArrayList;
import practica2soapclientejava.ControladorWeb;
import practica2soapclientejava.ControladorWeb_Service;

import practica2soapclientejava.Receta;
import practica2soapclientejava.Recetario;

/**
 *
 * @author david
 */
public class Modelo {

    ControladorWeb_Service controladorWeb_Service = new ControladorWeb_Service();
    ControladorWeb CWPort = controladorWeb_Service.getControladorWebPort();


    protected boolean crearReceta(String NombreReceta,
            String dificultadReceta,
            ArrayList<String> ArrayIngrediente,
            Double precioReceta) {

        //ing.ingrediente = ingrediente;
        return CWPort.crearReceta(NombreReceta, dificultadReceta, ArrayIngrediente, precioReceta);
        

    }

    protected boolean crearRecetario(String NombreRecetario,
            Double precioRecetario) {

        return CWPort.crearRecetario(NombreRecetario, CWPort.obtenerRecetaArrayList(), precioRecetario);
       
    }

    protected Receta obtenerRecetaRecetario(String nombreReceta) {

        //ing.ingrediente = ingrediente;
       return CWPort.obtenerRecetaRecetario(nombreReceta);
      
     
    }

    protected Receta obtenerReceta(String nombreReceta) {
        return CWPort.obtenerRecetaSinAsignar(nombreReceta);
        //ing.ingrediente = ingrediente;
      

    }

////exportar e importar     
    protected void exportarRecetario(String nombreFichero) { 
            CWPort.exportarRecetario(nombreFichero + ".xml");
    }

    protected void exportarReceta(String nombreFichero, String nombreReceta) {
        
            CWPort.exportarReceta(nombreFichero, nombreReceta);
       
    }

    protected void importarRecetario(String nombreFichero) {
    
           CWPort.importarRecetario(nombreFichero+ ".xml");
        
    }

    protected void importarReceta(String nombreFichero) {
      
             CWPort.importarReceta(nombreFichero + ".xml");
        

    }
protected Recetario obtenerRecetario() {
      
             
       return CWPort.obtenerRecetario();

    }
  
protected ArrayList<Receta> obtenerRecetaArrayList() {
      
             
       return (ArrayList)CWPort.obtenerRecetaArrayList();

    }
    //validar XSD
    protected String validarXSD(String nombreFichero) {
        return CWPort.validarXSD( nombreFichero);
    }
//getter and setters

    void start() {
       CWPort.start();
    }

   

}
