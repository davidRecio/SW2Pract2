/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Recetarios.Receta;
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

    ArrayList<Receta> recetaArrayList = new ArrayList();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
       public void obtenerReceta(@WebParam(name = "arrayListRecetas") ArrayList<Receta> arrayListRecetas)  {
   for(Receta ele:recetaArrayList){
                         System.out.println(ele.getNombre());
                    }
   }
     
      
}
