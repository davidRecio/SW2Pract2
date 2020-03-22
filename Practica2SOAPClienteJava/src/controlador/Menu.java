package controlador;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private Integer opcion = -1;
    private String respuesta;

    public void menu() {
        while (opcion != 0) {
            System.out.println("Elige una opcion, pulsa 0 para salir");
            System.out.println("1= Importar recetario, 2=Exportar recetario, 3=Exportar Receta, 4=Importar Receta, 5= crea el recetario, 6=crea recetas, 7=Lista recetas en caliente , 8=listar las recetas del recetario");
            System.out.println("9=XpathNode te muestra en forma de nodo el xml, 10=Xpath muestra el numero de recetas 11=XPath que muestra recetas cuyo precio <15");
            System.out.println("12=Xquery que dice cuales son las recetas viables para novatos, 13=Xquery que te lista la receta, 14=XQuery que busca las recetas cuyo valor es superior a 2 euros");
            System.out.println("15= crea un HTML a partir del xml donde lista las recetas,16=Validar DTD, 17=Validar XSD");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                case 1:
                    // Importar recetario
                    System.out.println("Introduce el nombre del fichero sin la extensión del recetario");
                    respuesta = scanner.nextLine();

                    break;
                case 2:
                    //Exportar recetario
                    System.out.println("Introduce el nombre del fichero sin la extensión del recetario");
                    respuesta = scanner.nextLine();

                    break;
                case 3:
                    System.out.println("En esta opcion creará el nombre del xml de la receta.");
                    System.out.println("Introduce el nombre de la receta a exportar");
                    respuesta = scanner.nextLine();

                    break;
                case 4:
                    // Importar Persona agenda
                    System.out.println("Introduce el nombre del fichero sin la extensión de la receta");
                    respuesta = scanner.nextLine();

                    break;
                case 5:

                    break;
                case 6:
                     //crear recetas

                    break;
                case 7:
                   // Listar recetas en caliente

                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("Introduce el nombre del fichero sin la extensión");
                    respuesta = scanner.nextLine();

                    break;

                case 10:
                    // Listar recetas en agenda
                    System.out.println("Introduce el nombre del XML a validar sin extension: ");
                    respuesta = scanner.nextLine();

                    break;
                default:
                    System.out.println("Error, introduzca un numero del cero al 17");

            }
        }
    }
}
