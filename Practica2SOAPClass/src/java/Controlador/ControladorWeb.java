/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Recetarios.Receta;
import Recetarios.Recetario;
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
   Recetario recetario = new Recetario();
    CreadorObjetos co= new CreadorObjetos();
      Modelo modelo = new Modelo();
      Receta receta = new Receta();
   // ArrayList<Receta> recetaArrayList = new ArrayList();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "crearRecetario")
    public Recetario crearRecetario(@WebParam(name = "nombreRecetario") String nombreRecetario,
            @WebParam(name = "recetaArrayList") ArrayList<Receta> recetaArrayList,
            @WebParam(name = "precioRecetario") Double precioRecetario) {

    
        recetario = co.crearRecetarioWeb(nombreRecetario, recetaArrayList, precioRecetario);
         if(modelo.listarRecetarioWeb(recetario).equals("No existe el recetario")){
            Recetario vacio=new Recetario();
            return vacio;
        }else{
          return recetario;
        }
       
      
    }

    @WebMethod(operationName = "crearReceta")
    public ArrayList<Receta> crearReceta(@WebParam(name = "nombreReceta") String nombreReceta,
            @WebParam(name = "dificultadReceta") String dificultadReceta,
            @WebParam(name = "ingredientes") ArrayList<String> ingredientes,
            @WebParam(name = "precioReceta") Double precioReceta,
            @WebParam(name = "recetaArrayList") ArrayList<Receta> recetaArrayList) {

       
        receta = co.crearRecetaWeb(nombreReceta, dificultadReceta, ingredientes, precioReceta);
        recetaArrayList.add(receta);
      
        if(modelo.listarRecetaWeb(receta).equals("No existe la receta")){
            ArrayList<Receta> vacio=new ArrayList();
            return vacio;
        }else{
        return recetaArrayList;
        }
        
    }

    @WebMethod(operationName = "obtenerReceta")
    public Receta obtenerReceta(@WebParam(name = "nombreReceta") String nombreReceta, @WebParam(name = "recetario") Recetario recetario) {
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


}
