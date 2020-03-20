/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2soapclientejava;

import java.util.ArrayList;
import practica2soapclientejava.Receta.Ingrediente;



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
        ArrayList<String> ingrediente2 = new  ArrayList();
    
     
        ingrediente2.add("Cabra");
         ingrediente2.add("Camello");
        Ingrediente ing=new Ingrediente();
        ing.ingrediente=ingrediente2;
         receta.setIngrediente(ing);
         receta.setDificultad("Facil");
         receta.setNombre("Mejunje");
         receta.setPrecio(2.0);
         
         recetaArrayList.add(receta);
         
          ControladorWeb_Service controladorWeb_Service = new ControladorWeb_Service();
             ControladorWeb CWPort = controladorWeb_Service.getControladorWebPort();
            // System.out.println(CWPort.hello("hahaha"));
             Receta result =CWPort.obtenerReceta("Mejunje", recetaArrayList);
             System.out.println(result.getIngrediente().getIngrediente());
        
    }
    
}
