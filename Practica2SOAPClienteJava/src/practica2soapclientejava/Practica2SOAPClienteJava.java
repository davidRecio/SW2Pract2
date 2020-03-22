/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2soapclientejava;

import java.io.File;
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
    
        ArrayList<Receta> recetaArrayList = new ArrayList();
       ControladorWeb_Service controladorWeb_Service = new ControladorWeb_Service();
        ControladorWeb CWPort = controladorWeb_Service.getControladorWebPort();
        
        Receta receta = new Receta();
        ArrayList<String> ingrediente = new ArrayList();
        String sCarpAct = System.getProperty("user.dir");
        File carpeta = new File(sCarpAct);
        Recetario recetario = null;
        Ingrediente ing = new Ingrediente();
        ing.ingrediente = ingrediente;
        
        ingrediente.add("Cabra");
        ingrediente.add("Camello");
       
        receta.setIngrediente(ing);
        receta.setDificultad("Facil");
        receta.setNombre("Mejunje");
        receta.setPrecio(2.0);
        recetaArrayList.add(receta);
        
        String nombreFichero="prueba.xml";
        String nombreFichero2="pruebaReceta.xml";
        String nombreReceta="Mejunje";
        String ruta=carpeta.getPath();

        
        
        if (CWPort.crearReceta("Mejunje", "Facil", ingrediente, 2.00, recetaArrayList).isEmpty()) {
            System.out.println("error en la creacion de receta");
        } else {
            System.out.println("la creacion de receta es exitosa");
        }
//        recetario= CWPort.crearRecetario("libro1", recetaArrayList, 10.0);
//        if (recetario.getNombre()==null) {
//            System.out.println("error en la creacion de recetario");
//        } else {
//            System.out.println("la creacion de recetario es exitoso");
//        }
//
//              recetario=CWPort.importarRecetario(nombreFichero, ruta);
//              CWPort.exportarReceta(nombreFichero2, recetario,nombreReceta, ruta);
//              
//              receta=CWPort.importarReceta(nombreFichero2, ruta);
//              
//              //receta =CWPort.obtenerReceta("Mejunje", recetario);
//             System.out.println(receta.getIngrediente().getIngrediente());
          System.out.println(CWPort.validarXSD(ruta, "recetario1.xml"));
          
       
       // System.out.println(carpeta.getPath());
//             
     // CWPort.exportarRecetario(nombreFichero, recetario,carpeta.getPath());
   

    }

}
