/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import practica2soapclientejava.ControladorWeb;
import practica2soapclientejava.ControladorWeb_Service;

import practica2soapclientejava.Receta;
import practica2soapclientejava.Receta.Ingrediente;
import practica2soapclientejava.Recetario;

/**
 *
 * @author david
 */
public class Modelo {

    ControladorWeb_Service controladorWeb_Service = new ControladorWeb_Service();
    ControladorWeb CWPort = controladorWeb_Service.getControladorWebPort();


    protected void crearReceta(String Nombre, String Dificultad,ArrayList<String> ingredientes, Double Precio) {
      
         CWPort.crearRecetaSimple(crearRecetaWeb(Nombre,Dificultad,ingredientes,Precio));
         CWPort.addReceta();
         
    }

    protected boolean crearRecetario(String NombreRecetario,
            Double precioRecetario) {

        return CWPort.crearRecetario(NombreRecetario, precioRecetario);
       
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
        return CWPort.validarXSD( nombreFichero+".xml");
    }
//crea los ficheros

    void start() {
       CWPort.start();
    }

    protected Receta crearRecetaWeb(String Nombre, String Dificultad,ArrayList<String> ingredientes, Double Precio ) {
        Receta receta = new Receta();
        Ingrediente ing = new Ingrediente();
       ing.getIngrediente().addAll(ingredientes);
        receta.setNombre(Nombre);
        receta.setDificultad(Dificultad);
        receta.setIngrediente(ing);
        receta.setPrecio(Precio);
        return receta;
    }

}
