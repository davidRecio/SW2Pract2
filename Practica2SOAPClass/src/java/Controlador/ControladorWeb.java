/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Recetarios.Receta;
import Recetarios.Recetario;
import java.io.File;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

// Hay que implementar las funciones del controlador 
/**
 *
 * @author darth
 */
@WebService(serviceName = "ControladorWeb")
public class ControladorWeb {
    private ArrayList<Receta> recetaArrayList = new ArrayList();
    private Recetario recetario = new Recetario();
    CreadorObjetos co = new CreadorObjetos();
    Modelo modelo = new Modelo();
    private Receta receta = new Receta();
    Marsalling mrs = new Marsalling();
    ValidarXSD vXSD = new ValidarXSD();
    String sCarpAct = System.getProperty("user.dir");
    File carpeta = new File(sCarpAct);
    String ruta = carpeta.getPath();

    
    /**
     * This is a sample web service operation
     */
    //se tienen q manejar desde aqui
 
    @WebMethod(operationName = "crearRecetario")
    public boolean crearRecetario(@WebParam(name = "nombreRecetario") String nombreRecetario,
            @WebParam(name = "recetaArrayList") ArrayList<Receta> recetaArrayList,
            @WebParam(name = "precioRecetario") Double precioRecetario) {

        recetario = co.crearRecetarioWeb(nombreRecetario, recetaArrayList, precioRecetario);
        if (modelo.listarRecetarioWeb(recetario).equals("No existe el recetario")) {
           
            return false;
        } else {
            return true;
        }

    }

    @WebMethod(operationName = "crearReceta")
    public boolean crearReceta(@WebParam(name = "nombreReceta") String nombreReceta,
            @WebParam(name = "dificultadReceta") String dificultadReceta,
            @WebParam(name = "ingredientes") ArrayList<String> ingredientes,
            @WebParam(name = "precioReceta") Double precioReceta) {

       receta = co.crearRecetaWeb(nombreReceta, dificultadReceta, ingredientes, precioReceta);
        recetaArrayList.add(receta);

        if (modelo.listarRecetaWeb(receta).equals("No existe la receta")) {
           
            return false;
        } else {
            return true;
        }

    }

 

    @WebMethod(operationName = "exportarRecetario")
    public void exportarRecetario(@WebParam(name = "nombreFichero") String nombreFichero) {
        mrs.crearXMLRecetario(nombreFichero, recetario, ruta);

    }

    @WebMethod(operationName = "importarRecetario")
    public void importarRecetario(@WebParam(name = "nombreFichero") String nombreFichero) {
     recetario = mrs.importarRecetario(nombreFichero, ruta);
 
    }

    @WebMethod(operationName = "exportarReceta")
    public void exportarReceta(@WebParam(name = "nombreFichero") String nombreFichero,
            @WebParam(name = "nombreReceta") String nombreReceta) {
        mrs.crearXMLReceta(nombreFichero, modelo.buscarReceta(nombreReceta, recetario), ruta);

    }

    @WebMethod(operationName = "importarReceta")
    public void importarReceta(@WebParam(name = "nombreFichero") String nombreFichero) {
         receta = mrs.importarReceta(nombreFichero, ruta);
      
    }

    @WebMethod(operationName = "validarXSD")
    public String validarXSD(@WebParam(name = "nombreFichero") String nombrefichero) {
        return "¿Es valido el xml con su xsd? " + vXSD.validarXSD(ruta + "/files/xsd/recetario.xsd", ruta + "/files/xml/" + nombrefichero);
    }
    //obtener elementos
    
       @WebMethod(operationName = "obtenerRecetaSinAsignar")
    public Receta obtenerRecetaSinAsignar(@WebParam(name = "nombreReceta") String nombreReceta) {
        Receta resultado = new Receta();
        
         for (Receta ele : recetaArrayList) {

            if (ele.getNombre().equals(nombreReceta)) {
                this.receta = ele;
                 return resultado;
            }
        }
        resultado = null;
        return resultado;
    }
      @WebMethod(operationName = "obtenerRecetaRecetario")
     public Receta obtenerRecetaRecetario(@WebParam(name = "nombreReceta") String nombreReceta) {
        Receta resultado = new Receta();
        for (Receta ele : recetario.getRecetas()) {

            if (ele.getNombre().equals(nombreReceta)) {
                resultado = ele;
                return resultado;
            }
        }
        resultado = null;
        return resultado;
    }
//getters y setters
 @WebMethod(operationName = "obtenerRecetaArrayList")
    public ArrayList<Receta> obtenerRecetaArrayList() {
        return recetaArrayList;
    }
 @WebMethod(operationName = "crearRecetaArrayList")
    public void crearRecetaArrayList(@WebParam(name = "recetaArrayList") ArrayList<Receta> recetaArrayList) {
        this.recetaArrayList = recetaArrayList;
    }
 @WebMethod(operationName = "obtenerRecetario")
    public Recetario obtenerRecetario() {
        return recetario;
    }
 @WebMethod(operationName = "crearRecetarioSimple")
    public void crearRecetarioSimple(@WebParam(name = "recetario")Recetario recetario) {
        this.recetario = recetario;
    }
 @WebMethod(operationName = "obtenerReceta")
    public Receta obtenerReceta() {
        return receta;
    }
 @WebMethod(operationName = "crearRecetaSimple")
    public void crearRecetaSimple(@WebParam(name = "receta")Receta receta) {
        this.receta = receta;
    }

  
     
     
}
