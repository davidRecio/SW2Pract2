/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2soapclientejava;

import java.util.ArrayList;



/**
 *
 * @author david
 */
public class Practica2SOAPClienteJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         ArrayList<Receta> recetaArrayList = new ArrayList();
       
         Receta receta = new Receta();
        ArrayList<String> ingrediente = new  ArrayList();
    
     
        ingrediente.add("Cabra");
         ingrediente.add("Camello");
        
         
         receta.setDificultad("Facil");
         receta.setNombre("Mejunje");
         receta.setPrecio(2.0);
         
         recetaArrayList.add(receta);
         
          ControladorWeb_Service controladorWeb_Service = new ControladorWeb_Service();
             ControladorWeb CWPort = controladorWeb_Service.getControladorWebPort();
            // System.out.println(CWPort.hello("hahaha"));
             Receta result =CWPort.obtenerReceta("Mejunje", recetaArrayList);
             System.out.println(result.getNombre());
        
    }
    
}
