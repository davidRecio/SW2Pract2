/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Recetarios.Receta;
import Recetarios.Recetario;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Modelo {
  
    
   
    
    protected void listarReceta(Receta receta) {
        if (receta != null) {
            System.out.println("Este es el nombre de la receta elegida :" + receta.getNombre());
            System.out.println("Este es la dificultad de la receta elegida :" + receta.getDificultad());
            System.out.println("Estos son los ingredientes:");
            for (String elemeto : receta.getIngrediente()) {
                System.out.println(elemeto);
            }
            System.out.println("El precio de la receta es :" + receta.getPrecio());
        }

    }

    protected void listarRecetario(Recetario recetario) {
        if (recetario != null) {
            System.out.println("Este es el nombre del recetario :" + recetario.getNombre());
            System.out.println("Estos son sus recetas:");
            for (Receta elemeto : recetario.getRecetas()) {
                System.out.println(elemeto.getNombre());
            }
            System.out.println("El precio del recetario es :" + recetario.getPrecio());
        }

    }

    protected Receta buscarReceta(String nombreReceta, Recetario recetario) {
       
        for (Receta ele : recetario.getRecetas()) {
             
            if (ele.getNombre().equals(nombreReceta)) {
                return ele;
            }
        }
        System.out.println("No existe la receta");
        return null;
    }
    protected void crearHTML(ArrayList<String> array) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        int valor=0;
        try {
            fichero = new FileWriter("./files/html/recetarioHTML.html");
            pw = new PrintWriter(fichero);

            for (String ele : array) {
                
                pw.println(ele);
            }
            fichero.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected String listarRecetarioWeb(Recetario recetario) {
          String recetas="", result="";
          
          if (recetario != null) {
            for (Receta elemeto : recetario.getRecetas()) {
                 recetas=recetas +elemeto.getNombre()+ ",";
            }
            recetas=recetas.substring(0, recetas.length());
             result="Este es el nombre del recetario : " + recetario.getNombre()+ ", sus recetas son: "+recetas+" y el precio de este recetario es: "+recetario.getPrecio();
 
        }else{
          result="No existe el recetario";
          }
          return result;
    }

    protected String listarRecetaWeb(Receta receta) {
         String ingredientes="", result="";
        if (receta != null) {
                     for (String elemeto : receta.getIngrediente()) {
                   ingredientes=ingredientes +elemeto+ ",";
            }
             ingredientes=ingredientes.substring(0, ingredientes.length());
             
           result="Este es el nombre de la receta elegida :" + receta.getNombre()+ 
                   ", esta es la dificultad de la receta elegida : " + receta.getDificultad()+
                   ", estos son los ingredientes: "+ingredientes+" y el precio de la receta es :" + receta.getPrecio();
        }else{
            result="No existe la receta";
        }
        return result;
    }

}
