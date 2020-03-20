/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import Controlador.Controlador;
import Recetarios.Receta;
import Recetarios.Recetario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Practica2SOAPClienteJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
//        try {
       ArrayList<Receta> recetaArrayList = new ArrayList();
       
         Receta receta = new Receta();
        ArrayList<String> ingrediente = new  ArrayList();
        ingrediente.add("Cabra");
         ingrediente.add("Camello");
        receta.setIngrediente(ingrediente);
         receta.setDificultad("Facil");
         receta.setNombre("Mejunje");
         receta.setPrecio(2.0);
         
         recetaArrayList.add(receta);
         System.out.println(recetaArrayList.get(0).getNombre());
         
         
         
   
        Controlador control = new Controlador();
       Receta resultado= control.obtenerReceta("Mejunje",recetaArrayList);
       resultado.getNombre();
       
       Recetario recetario = new Recetario();
       recetario.setNombre("libro1");
       recetario.setRecetas(recetaArrayList);
       recetario.setPrecio(10.0);
//            Double result=controladorWebPort.addNumbers(num1, num2);
//            System.out.println("El resultado es "+result);
//            
//        } catch (IOException ex) {
//            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
//        }
       control.exportarRecetario("prueba.xml", recetario);
    }
    
}
