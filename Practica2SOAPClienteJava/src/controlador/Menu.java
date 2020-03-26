package controlador;

import java.util.ArrayList;
import java.util.Scanner;
import practica2soapclientejava.Receta;
import practica2soapclientejava.Recetario;

/**
 *
 * @author david
 */
public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private Integer opcion = -1;
    private Modelo modelo = new Modelo();
    private String respuesta, respuesta2, respuesta4;

    public void menu() {
        modelo.start();
        while (opcion != 0) {
            System.out.println("-------------------------------------------------------------------Menú--------------------------------------------------------------------------------");
            System.out.println("Elige una opcion, pulsa 0 para salir");
            System.out.println("1= Importar recetario, 2=Exportar recetario, 3=Exportar Receta, 4=Importar Receta,");
            System.out.println("5= crea el recetario, 6=crea recetas, 7=Lista recetas no asignadas,");
            System.out.println("8=Lista la información de la receta escogida,9=Listas las recetas del recetario, 10=Valida fichero con XSD ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                case 1:
                    // Importar recetario
                    System.out.println("Introduce el nombre del fichero sin la extensión del recetario");
                    respuesta = scanner.nextLine();
                    modelo.importarRecetario(respuesta);
                    break;
                case 2:
                    //Exportar recetario
                    System.out.println("Introduce el nombre del fichero sin la extensión del recetario");
                    respuesta = scanner.nextLine();
                    modelo.exportarRecetario(respuesta);
                    break;
                case 3:
                    //exportar receta
                    System.out.println("En esta opcion creará el nombre del xml de la receta.");
                    System.out.println("Introduce el nombre de la receta a exportar");
                    respuesta = scanner.nextLine();

                    modelo.exportarReceta(respuesta + ".xml", respuesta);
                    break;
                case 4:
                    //importo receta
                    System.out.println("Introduce el nombre del fichero sin la extensión de la receta");
                    respuesta = scanner.nextLine();
                    modelo.importarReceta(respuesta);
                    break;
                case 5:
                    //crear recetario
                    System.out.println("En esta opcion creará el recetario con las recetas introucidas o importadas");
                    System.out.println("Introduce el nombre del recetario");
                    respuesta = scanner.nextLine();
                    System.out.println("Introduce el precio del recetario");
                    respuesta2 = scanner.nextLine();

                    if (modelo.crearRecetario(respuesta, Double.parseDouble(respuesta2)) == true) {
                        System.out.println("El recetario se creo con exito");
                    } else {
                        System.err.println("El fichero no se pudo crear ya que no creaste o importaste previamente recetas");
                    }

                    break;
                case 6:
                    //crear recetas
                    System.out.println("Introduce el nombre de la receta");
                    respuesta = scanner.nextLine();
                    System.out.println("Introduce la dificultad de la receta");
                    respuesta2 = scanner.nextLine();

                    System.out.println("Introduce el precio de la receta");
                    respuesta4 = scanner.nextLine();
                    modelo.crearReceta(respuesta, respuesta2, pedirIngredientes(), Double.parseDouble(respuesta4));

                    break;
                case 7:
                    // Listar recetas
                    if (listarRecetas(modelo.obtenerRecetaArrayList()) == false) {
                        System.err.println("No existen recetas");
                    }

                    break;
                case 8:
                    // Lista la receta escogida
                    System.out.println("Introduce el nombre de la receta");
                    respuesta = scanner.nextLine();
                    try {

                        listarReceta(modelo.obtenerRecetaRecetario(respuesta));

                    } catch (Exception e) {

                        try {
                            System.out.println("La receta " + respuesta + " esta sin asignar");
                            listarReceta(modelo.obtenerReceta(respuesta));
                        } catch (Exception a) {
                            System.err.println("No existe la receta " + respuesta + " en ningun lado");
                        }

                    }

                    break;
                case 9:
                    //listas las recetas del recetario
                    try {
                        listarRecetasRecetario(modelo.obtenerRecetario());
                    } catch (Exception e) {
                        System.err.println("No se cargo el recetario");
                    }

                    break;

                case 10:
                    // validar XSD
                    System.out.println("Introduce el nombre del XML a validar sin extension: ");
                    respuesta = scanner.nextLine();
                    System.out.println(modelo.validarXSD(respuesta));
                    break;
                default:
                    System.out.println("Error, introduzca un numero del cero al 11");

            }
        }

    }

    private ArrayList pedirIngredientes() {
        ArrayList<String> ingredientes = new ArrayList();
        System.out.println("Introduce los ingredientes, para finalizar introduce como ultimo ingrediente un 0");
        while (respuesta.equals("0") != true) {
            respuesta = scanner.nextLine();
            if (respuesta.equals("0") == false) {

                ingredientes.add(respuesta);
            }

        }
        return ingredientes;
    }

    private boolean listarRecetas(ArrayList<Receta> recetasArrayList) {
        if (recetasArrayList.isEmpty() == true) {
            return false;
        } else {
            System.out.println("tiene las siguientes recetas sin recetario: ");
            for (Receta receta : recetasArrayList) {
                System.out.println(receta.getNombre());
            }
            return true;
        }

    }

    private boolean listarRecetasRecetario(Recetario recetario) {
        if (recetario == null) {
            return false;
        } else {
            System.out.println("tiene las siguientes recetas: ");
            for (Receta receta : recetario.getRecetas().getRecetas()) {
                System.out.println(receta.getNombre());
            }
            return true;
        }

    }

    private boolean listarReceta(Receta receta) {
        if (receta.getNombre() == null) {
            return false;
        } else {
            System.out.println("Su nombre es: " + receta.getNombre());
            System.out.println("La dificultad es: " + receta.getDificultad());
            System.out.println("tiene los siguientes ingredientes: ");
            for (String ele : receta.getIngrediente().getIngrediente()) {
                System.out.println(ele);
            }
            System.out.println("Su precio es: " + receta.getPrecio());
            return true;
        }

    }

}
