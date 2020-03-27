/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.util.ArrayList;
import serviciosweb.Receta;

/**
 *
 * @author david
 */
public class Modelo {
     protected Receta crearRecetaEsructura(String nombreReceta,String dificultad, Double precio,ArrayList<String> ingredientes) {
     
        Receta receta = new Receta();
        receta.setNombre(nombreReceta);
        receta.setDificultad(dificultad);
        receta.setPrecio(precio);
        Receta.Ingrediente ing = new Receta.Ingrediente();
        ing.getIngrediente().addAll(ingredientes);
        receta.setIngrediente(ing);

        return receta;

    }
}
