
package Controlador;

import Recetarios.Receta;
import Recetarios.Recetario;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author david
 */
//"http://localhost:8080/Practica2SOAPClass/ControladorWeb"
public class Controlador {
    Marsalling mrs = new Marsalling();
    //ValidarXSD vXSD = new ValidarXSD();
    Modelo modelo = new Modelo();
    CreadorObjetos co= new CreadorObjetos();
    ArrayList<Receta> recetaArrayList = new ArrayList();
    Scanner scanner = new Scanner(System.in);
     
          Receta receta;
     Recetario recetario = new Recetario();
    public void exportarRecetario(String nombreFichero, Recetario recetario){
       mrs.crearXMLRecetario(nombreFichero, recetario);  
    }
     private void crearXMLReceta(String nombreReceta, String nombreFichero){
            mrs.crearXMLReceta(nombreFichero,modelo.buscarReceta(nombreReceta,recetario)); 
    }
    private Receta importarObjetoReceta(String nombreFichero){  
        Receta receta = mrs.importarObjetoReceta(nombreFichero);
        return receta;
    }
        private Recetario importarObjetoRecetario(String nombreFichero){  
        Recetario recetario = mrs.importarObjetoRecetario(nombreFichero);
        return recetario;
    }
    
  public Receta obtenerReceta(String nombreReceta, ArrayList<Receta> arrayListRecetas)  {
   Receta resultado= new Receta();
                         for(Receta ele:arrayListRecetas){
                               
                         if(ele.getNombre().equals(nombreReceta)){
                             resultado=ele;
                             return resultado;
                         }
                    }
                          resultado=null;
                         return resultado;
   }
//    public void obtenerReceta( ArrayList<Receta> arrayListRecetas)  {
//  
//                         for(Receta ele:arrayListRecetas){
//                               
//                         System.out.println(ele.getNombre());
//                    }
//   }
//   public void crearRecetario (){
//       recetario=co.crearRecetario(recetaArrayList);
//       modelo.listarRecetario(recetario);
//   }
   
//   public void obtenerRecetario() {
//        modelo.listarRecetario(recetario);
//   }
   
//   public void obtenerReceta() {
//   for(Receta ele:recetaArrayList){
//                         System.out.println(ele.getNombre());
//                    }
//   }
   
//   public void añadirReceta() {
//                    receta=co.crearReceta();
//                    recetaArrayList.add(receta);
//                    modelo.listarReceta(receta);
//   }
   
//   public void exportarRecetario() {
//       System.out.println("Introduce el nombre del fichero sin la extensión del recetario");
//      String respuesta;
//                     respuesta = scanner.nextLine();
//                     if(respuesta.equals("recetarioDTD")!= true){
//                      exportarRecetario(respuesta+ ".xml",recetario);
//                     }else{
//                         System.out.println("Ese nombre esta prohibido");
//                     }
//   }
   
//   public void exportarReceta() {
//         System.out.println("En esta opcion creará el nombre del xml de la receta.");
//         System.out.println("Introduce el nombre de la receta a exportar");
//          respuesta = scanner.nextLine();
//          
//          crearXMLReceta(respuesta,respuesta+".xml");
//                             
//          
//   }
   
//   public void importarRecetario() {
//       
//                    System.out.println("Introduce el nombre del fichero sin la extensión del recetario");
//                    respuesta = scanner.nextLine();
//                    recetario= importarObjetoRecetario(respuesta+".xml");
//                    recetaArrayList=recetario.getRecetas();
//                    modelo.listarRecetario(recetario);
//   }
   
//   public void importarReceta() {
//   
//                    System.out.println("Introduce el nombre del fichero sin la extensión de la receta");
//                    respuesta = scanner.nextLine();
//                    receta= importarObjetoReceta(respuesta+".xml");
//                    recetaArrayList.add(receta);
//                    modelo.listarReceta(receta);
//   
//   }
   
/*opcional*/
 
 //   public void validarXSD() {
//       // Listar recetas en agenda
//                      System.out.println("Introduce el nombre del XML a validar sin extension: ");
//                     respuesta = scanner.nextLine();
//                     System.out.println("¿Es valido el xml con su xsd? "+  vXSD.validarXSD("./files/xsd/recetario.xsd", "./files/xml/"+respuesta+".xml")); 
//   } 
       
}
