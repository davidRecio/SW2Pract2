/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

/**
 *
 * @author david
 */
import java.util.ArrayList;
import serviciosweb.Receta.Ingrediente;
import serviciosweb.Receta;
import serviciosweb.Recetario;

import serviciosweb.ServicioWebRecetario;
import serviciosweb.ServicioWebRecetario_Service;
public class Modelo {
     ServicioWebRecetario_Service servicioWebRecetario_Service = new ServicioWebRecetario_Service();
    ServicioWebRecetario SWRPort = servicioWebRecetario_Service.getServicioWebRecetarioPort();
    
    
    private Recetario recetario = new Recetario();

    protected void crearRecetario(Recetario recetario) {
        SWRPort.crearRecetario(recetario);
       

    }

    protected void addReceta(Receta receta) {
      SWRPort.addReceta(receta);
        

    }

    protected void rmvReceta(String nombreReceta ) {
        SWRPort.rmvReceta(nombreReceta);
      //recetario.getRecetas().remove(posicion.intValue());

    }

    protected Receta obtenerReceta(String nombreReceta) {
     return  SWRPort.obtenerReceta(nombreReceta);

    }

    protected Recetario obtenerRecetario() {
        return SWRPort.obtenerRecetario();
    }
//crea los objetos segun sus estructuras
   protected Recetario crearRecetarioEsructura(String nombreRecetario, Double precio) {
        Recetario recetario = new Recetario();
        recetario.setNombre(nombreRecetario);
        recetario.setPrecio(precio);
        return recetario;

    }
    protected Receta crearRecetaEsructura(String nombreReceta,String dificultad, Double precio,ArrayList<String> ingredientes) {
     
        Receta receta = new Receta();
        receta.setNombre(nombreReceta);
        receta.setDificultad(dificultad);
        receta.setPrecio(precio);
        Ingrediente ing = new Ingrediente();
        ing.getIngrediente().addAll(ingredientes);
        receta.setIngrediente(ing);

        return receta;

    }

}
