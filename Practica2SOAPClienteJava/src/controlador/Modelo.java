package controlador;

import java.util.ArrayList;
import practica2soapclientejava.ControladorWeb;
import practica2soapclientejava.ControladorWeb_Service;
import practica2soapclientejava.Receta;
import practica2soapclientejava.Receta.Ingrediente;
import practica2soapclientejava.Recetario;

/**
 *
 * @author david
 */
public class Modelo {

    ControladorWeb_Service controladorWeb_Service = new ControladorWeb_Service();
    ControladorWeb CWPort = controladorWeb_Service.getControladorWebPort();

//Crear objetos
    protected void crearReceta(String Nombre, String Dificultad, ArrayList<String> ingredientes, Double Precio) {

        CWPort.crearRecetaSimple(crearRecetaWeb(Nombre, Dificultad, ingredientes, Precio));
        CWPort.addReceta();

    }

    protected boolean crearRecetario(String NombreRecetario,
            Double precioRecetario) {
        ArrayList<Receta> receta = new ArrayList();
        boolean valor = CWPort.crearRecetario(NombreRecetario, precioRecetario);
        CWPort.crearRecetaArrayList(receta);
        return valor;

    }
//obtener objetos

    protected Receta obtenerRecetaRecetario(String nombreReceta) {

        //ing.ingrediente = ingrediente;
        return CWPort.obtenerRecetaRecetario(nombreReceta);

    }

    protected Receta obtenerReceta(String nombreReceta) {
        ArrayList<Receta> recetas = obtenerRecetaArrayList();

        Receta resultado = new Receta();
        for (Receta ele : recetas) {

            if (ele.getNombre().equals(nombreReceta)) {
                resultado = ele;
                return resultado;
            }
        }
        resultado = null;
        return resultado;

    }

    protected Recetario obtenerRecetario() {

        return CWPort.obtenerRecetario();

    }

    protected ArrayList<Receta> obtenerRecetaArrayList() {

        return (ArrayList) CWPort.obtenerRecetaArrayList();

    }
////exportar e importar     

    protected void exportarRecetario(String nombreFichero) {
        CWPort.exportarRecetario(nombreFichero + ".xml");
    }

    protected void exportarReceta(String nombreFichero, String nombreReceta) {

        CWPort.exportarReceta(nombreFichero, nombreReceta);

    }

    protected void importarRecetario(String nombreFichero) {

        CWPort.importarRecetario(nombreFichero + ".xml");

    }

    protected void importarReceta(String nombreFichero) {

        CWPort.importarReceta(nombreFichero + ".xml");

    }

    //validar XSD
    protected String validarXSD(String nombreFichero) {
        return CWPort.validarXSD(nombreFichero + ".xml");
    }
//crea los ficheros

    void start() {
        CWPort.start();
    }
//crea estructura de la receta

    protected Receta crearRecetaWeb(String Nombre, String Dificultad, ArrayList<String> ingredientes, Double Precio) {
        Receta receta = new Receta();
        Ingrediente ing = new Ingrediente();
        ing.getIngrediente().addAll(ingredientes);
        receta.setNombre(Nombre);
        receta.setDificultad(Dificultad);
        receta.setIngrediente(ing);
        receta.setPrecio(Precio);
        System.out.println(receta.getNombre());
        return receta;
    }

}
