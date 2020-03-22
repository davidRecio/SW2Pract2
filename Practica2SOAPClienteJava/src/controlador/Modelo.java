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
    private ArrayList<Receta> recetaArrayList = new ArrayList();
    ControladorWeb_Service controladorWeb_Service = new ControladorWeb_Service();
    ControladorWeb CWPort = controladorWeb_Service.getControladorWebPort();
    private Receta receta = null;
    ArrayList<String> ArrayIngrediente = new ArrayList();
    String sCarpAct = System.getProperty("user.dir");
    File carpeta = new File(sCarpAct);
    private Recetario recetario = null;
    Receta.Ingrediente ing = new Receta.Ingrediente();
    String ruta = carpeta.getPath();

    protected boolean crearReceta(String NombreReceta,
            String dificultadReceta,
            ArrayList<String> ArrayIngrediente,
            Double precioReceta) {

        //ing.ingrediente = ingrediente;
        recetaArrayList = (ArrayList) CWPort.crearReceta(NombreReceta, dificultadReceta, ArrayIngrediente, precioReceta, recetaArrayList);
        if (recetaArrayList.isEmpty()) {
            //System.out.println("error en la creacion de receta");
            return false;
        } else {
            //System.out.println("la creacion de receta es exitosa");
            return true;
        }

    }
    
     protected boolean crearRecetario(String NombreRecetario,
            Double precioRecetario) {

        //ing.ingrediente = ingrediente;
        recetario= CWPort.crearRecetario(NombreRecetario, recetaArrayList, precioRecetario);
        if (recetaArrayList.isEmpty()) {
            //System.out.println("error en la creacion de receta");
            return false;
        } else {
            //System.out.println("la creacion de receta es exitosa");
            return true;
        }
    }
      protected boolean obtenerRecetaRecetario(String nombreReceta) {

        //ing.ingrediente = ingrediente;
        receta =CWPort.obtenerReceta(nombreReceta, recetario); 
        if (receta==null) {
            //System.out.println("error en la creacion de receta");
            return false;
        } else {
            //System.out.println("la creacion de receta es exitosa");
            return true;
        }
    }
       protected boolean obtenerReceta(String nombreReceta) {

        //ing.ingrediente = ingrediente;
        for(Receta receta:recetaArrayList){
            
            if(receta.getNombre().equals(nombreReceta)){
                this.receta=receta;
                return true;
            }
        }
         return false;
        
    }
    
////exportar e importar     
    protected boolean exportarRecetario(String nombreFichero){
        try {
             CWPort.exportarRecetario(nombreFichero+".xml", recetario,ruta);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
 protected boolean exportarReceta(String nombreFichero, String nombreReceta){
        try {
             CWPort.exportarReceta(nombreFichero+".xml", recetario,nombreReceta, ruta);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
 
    protected boolean importarRecetario(String nombreFichero){
        try {
             recetario=CWPort.importarRecetario(nombreFichero+".xml", ruta);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
 protected boolean importarReceta(String nombreFichero){
        try {
            receta=CWPort.importarReceta(nombreFichero+".xml", ruta);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
 //validar XSD
 protected String validarXSD(String nombreFichero) {
        return CWPort.validarXSD(ruta, nombreFichero);
    }
//getter and setters
    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Recetario getRecetario() {
        return recetario;
    }

    public void setRecetario(Recetario recetario) {
        this.recetario = recetario;
    }

    public ArrayList<Receta> getRecetaArrayList() {
        return recetaArrayList;
    }

    public void setRecetaArrayList(ArrayList<Receta> recetaArrayList) {
        this.recetaArrayList = recetaArrayList;
    }

   
   
}
