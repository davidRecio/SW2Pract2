/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2soapclientejava;

import controlador.ControladorWeb;
import controlador.ControladorWeb_Service;
import controlador.Receta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
       
         Receta receta = new Receta();
         
         
         
            
            ControladorWeb_Service controladorWeb_Service = new ControladorWeb_Service();
           ControladorWeb controladorWebPort = controladorWeb_Service.getControladorWebPort();
           
//            Double result=controladorWebPort.addNumbers(num1, num2);
//            System.out.println("El resultado es "+result);
//            
//        } catch (IOException ex) {
//            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
